package com.didi.pk.learn.es;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author pengkai
 * @date 2019-09-22
 */
public class Indexer {

    private IndexWriter writer;

    public Indexer(String indexDir) throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get(indexDir));
        writer = new IndexWriter(directory,new IndexWriterConfig());
    }

    public void close() throws IOException {
        writer.close();
    }

    public int index(String dataDir, FileFilter fileFilter) throws IOException {
        File[] files = new File(dataDir).listFiles();
        for(File f:files){
            if(f.isDirectory() || f.isHidden() || (fileFilter!=null && !fileFilter.accept(f))) continue;
            indexDocument(f);
        }

        return writer.numRamDocs();
    }

    private void indexDocument(File file) throws IOException {
        Document doc = getDocument(file);
        writer.addDocument(doc);
    }

    private Document getDocument(File f) throws IOException {
        Document document = new Document();
        document.add(new TextField("content",new FileReader(f)));
        document.add(new StringField("title",f.getName(), Field.Store.YES));
        document.add(new StringField("fullPath",f.getCanonicalPath(), Field.Store.YES));

        return document;
    }
}
