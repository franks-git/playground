package com.kaswiner.htmlXmlParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

public class XmlParser {

	public void parse() throws IOException, URISyntaxException {
		
		String rss = new String(Files.readAllBytes( Paths.get( System.class.getResource("/rss-cnet.xml").toURI())));

		Document feed = Jsoup.parse(rss, "", Parser.xmlParser());
		
		List<Element> elements = feed.select("item");
		
		for (Element element : elements) {
			List<Element> thumbnailsElement = element.select("media:thumbnail");
			
			System.out.println(thumbnailsElement.get(0).text());  
		}
		
		

	}

}
