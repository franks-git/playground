package com.kaswiner.rssReader01;

import java.net.URL;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class RssReaderApp {

	public static void main(String[] args) {
        
		try {
		URL feedUrl = new URL("https://www.cnet.com/rss/news/");

        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));
        
        feed.getEntries().stream().forEach(entry -> System.out.println(entry.getUri() + "-" + entry.getLink()));

        System.out.println(feed);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
