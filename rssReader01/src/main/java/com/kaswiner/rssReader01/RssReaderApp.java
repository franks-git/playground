package com.kaswiner.rssReader01;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.rometools.modules.mediarss.MediaEntryModule;
import com.rometools.modules.mediarss.MediaModule;
import com.rometools.modules.mediarss.MediaModuleImpl;
import com.rometools.modules.mediarss.types.MediaContent;
import com.rometools.modules.mediarss.types.MediaGroup;
import com.rometools.modules.mediarss.types.Metadata;
import com.rometools.modules.mediarss.types.Reference;
import com.rometools.modules.mediarss.types.Thumbnail;
import com.rometools.modules.mediarss.types.UrlReference;
import com.rometools.rome.feed.module.Module;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.rometools.utils.Lists;


public class RssReaderApp {

	public static void main(String[] args) {
        
		try {
			Path pathBbc = Paths.get(System.class.getResource("/bbc-rss.xml").toURI());
			Path pathCnet = Paths.get(System.class.getResource("/cnet-rss-news.xml").toURI());
			Path pathCnn = Paths.get(System.class.getResource("/cnn-rss-topstories.xml").toURI());

			SyndFeedInput input = new SyndFeedInput();
			SyndFeed bbcFeed = input.build(new XmlReader(pathBbc.toFile()));
			SyndFeed cnetFeed = input.build(new XmlReader(pathCnet.toFile()));
			SyndFeed cnnFeed = input.build(new XmlReader(pathCnn.toFile()));

			cnnFeed.getModules().add(cnnFeed.getModule(MediaModule.URI));
			
			
			// CNN
			for (SyndEntry syndEntry : cnetFeed.getEntries()) {
				String title = syndEntry.getTitle();
				String description = syndEntry.getDescription().getValue();

				MediaEntryModule mediaEntryModule = (MediaEntryModule) syndEntry.getModule(MediaModule.URI);
				Metadata metaData = mediaEntryModule.getMetadata();
				String urlThumbnail = null;
				if (metaData != null) {
					Thumbnail[] thumbnails = metaData.getThumbnail();
					urlThumbnail = thumbnails[0].getUrl().toASCIIString();
					
				} else {
				
					MediaGroup[] mediaGroups = mediaEntryModule.getMediaGroups();
					MediaContent[] mediaContents = mediaGroups[0].getContents();
					UrlReference urlRef = (UrlReference) mediaContents[0].getReference(); 
					String imageUri = urlRef.getUrl().toString();
				}
				
				
			}
			
			// BBC
			for (SyndEntry syndEntry : bbcFeed.getEntries()) {
				
				String title = syndEntry.getTitle();
				String description = syndEntry.getDescription().getValue();
				String link = syndEntry.getLink();

				Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");
				//List<Element> thumbnailsElement = syndEntry.getModule("").select("media:thumbnail");
				

				List<Header> headers = new ArrayList<Header>();

				try (CloseableHttpClient client = HttpClientBuilder.create().setDefaultHeaders(headers).build()) {

					//HttpUriRequest request = RequestBuilder.get().setUri(link).build();
					//HttpResponse response = client.execute(request);
					//String html = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
					
					//
					String html = new String(Files.readAllBytes(Paths.get(System.class.getResource("/bbc-news01.html").toURI())));

					Document htmlDocument = Jsoup.parse(html);
					
					List<Element> metaElements = htmlDocument.select("meta");
					
					for (Element element : metaElements) {
						List<Element> thumbnailsElement = element.select("media:thumbnail");
						
						System.out.println(thumbnailsElement.get(0).text());  
					}

				} catch (Exception e) {
					e.printStackTrace();
					
				}

			}

			cnetFeed.getEntries().stream().forEach(entry -> System.out.println(entry.getUri() + "-" + entry.getLink()));

			System.out.println(cnnFeed);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
