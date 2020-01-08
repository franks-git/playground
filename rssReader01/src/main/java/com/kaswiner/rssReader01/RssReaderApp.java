package com.kaswiner.rssReader01;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class RssReaderApp {

	public static void main(String[] args) {
        
		try {
			Path pathCnet = Paths.get(System.class.getResource("/cnet-rss-news.xml").toURI());
			Path pathCnn = Paths.get(System.class.getResource("/cnn-rss-topstories.xml").toURI());

			SyndFeedInput input = new SyndFeedInput();
			SyndFeed cnetFeed = input.build(new XmlReader(pathCnet.toFile()));
			SyndFeed cnnFeed = input.build(new XmlReader(pathCnn.toFile()));

			cnetFeed.getEntries().stream().forEach(entry -> System.out.println(entry.getUri() + "-" + entry.getLink()));

			System.out.println(cnnFeed);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
