package com.kaswiner.rssReader01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

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

			
			// BBC
			for (SyndEntry syndEntry : bbcFeed.getEntries()) {
				String title = syndEntry.getTitle();
				String description = syndEntry.getDescription().getValue();
				String link = syndEntry.getLink();

				try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

					HttpGet request = new HttpGet(link);
					HttpResponse response = client.execute(request);

					String html = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
					
					Document feed = Jsoup.parse(html);
					
					List<Element> elements = feed.select("item");
					
					for (Element element : elements) {
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
