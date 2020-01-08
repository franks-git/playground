package com.kaswiner.htmlXmlParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class HtmlParser {

	public void parse() throws IOException, URISyntaxException {
		String html = "<html><head><title>TITLE</title></head><body><p>Document's body. This is just for tests purposes.</p></body></html>";
		
		Document feed = Jsoup.parse(html);
		
		List<Element> elements = feed.select("item");
		
		for (Element element : elements) {
			List<Element> thumbnailsElement = element.select("media:thumbnail");
			
			System.out.println(thumbnailsElement.get(0).text());  
		}
	}
}
