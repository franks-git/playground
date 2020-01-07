package com.kaswiner.textSearch01;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import com.kaswiner.textSearch01.service.IndexerService;

public class TextSearch01App {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = System.class.getResourceAsStream("/indexer.properties");
		Properties prop = new Properties();
		
		prop.load(inputStream);

		String stringDocumentsPath = prop.getProperty("indexer.documents.path");
		Path documentsPath = Paths.get(stringDocumentsPath);
		
		String stringIndexPath = prop.getProperty("indexer.index.path");
		Path indexPath = Paths.get(stringIndexPath);
		
		
		IndexerService indexerService = new IndexerService();
		indexerService.indexDirectory(documentsPath, indexPath);

	}

}
