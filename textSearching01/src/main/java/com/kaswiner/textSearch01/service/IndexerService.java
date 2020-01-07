package com.kaswiner.textSearch01.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class IndexerService {
	
	public void indexDirectory(Path documentsPath, Path indexPath) throws IOException {
		boolean create = true;
		Directory indexDirectory = FSDirectory.open(indexPath);
		
		Analyzer analyzer = new StandardAnalyzer();
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer);

		if (create) {
			// Create a new index in the directory, removing any
			// previously indexed documents:
			iwc.setOpenMode(OpenMode.CREATE);
		} else {
			// Add new documents to an existing index:
			iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
		}

		try (IndexWriter writer = new IndexWriter(indexDirectory, iwc)) {
		
			Files.walk(documentsPath, FileVisitOption.FOLLOW_LINKS).forEach(p->{
				if (!Files.isDirectory(p)) {
					try {
						this.indexFile(writer, p);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
	
		}
		
	}

	public void indexFile(IndexWriter writer, Path path) throws IOException {
		
		try (InputStream fis = Files.newInputStream(path)) {
	        Document doc = new Document();
	            
	        // Add the path of the file as a field named "path".  Use a
	        // field that is indexed (i.e. searchable), but don't tokenize 
            // the field into separate words and don't index term frequency
	        // or positional information:
	        Field pathField = new StringField("path", path.toString(), Field.Store.YES);
	        doc.add(pathField);
	      
            // Add the contents of the file to a field named "contents".  Specify a Reader,
	        // so that the text of the file is tokenized and indexed, but not stored.
	        // Note that FileReader expects the file to be in UTF-8 encoding.
	        // If that's not the case searching for special characters will fail.
	        doc.add(new TextField("contents", new BufferedReader(new InputStreamReader(fis, StandardCharsets.UTF_8))));
	
	        if (writer.getConfig().getOpenMode() == OpenMode.CREATE) {
	    	    // New index, so we just add the document (no old document can be there):
	    	    System.out.println("adding " + path);
	    	    writer.addDocument(doc);
	        } else {
	            // Existing index (an old copy of this document may have been indexed) so 
                // we use updateDocument instead to replace the old one matching the exact 
                // path, if present:
	    	    System.out.println("updating " + path);
	    	    writer.updateDocument(new Term("path", path.toString()), doc);
	        }
		}
	}
}
