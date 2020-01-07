package com.kaswiner.htmlParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlParserApp {

	public static void main(String[] args) {
		
		String html = "<html><head><title>TITLE</title></head><body><p>Document's body. This is just for tests purposes.</p></body></html>";

		Document document = Jsoup.parse(html);
		

	}

}
