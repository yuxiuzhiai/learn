package com.didi.pk.learn.es;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author pengkai
 * @date 2019-09-22
 */
public class Main {
    public static void main(String[] args) throws IOException, ParseException {
//        Indexer indexer = new Indexer("/Users/didi/workspace/study/learn/learn-es/index");
//        indexer.index("/Users/didi/workspace/study/learn/learn-es/data", file -> file.getName().endsWith(".txt"));
//        indexer.close();
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(FSDirectory.open(Paths.get("/Users/didi/workspace/study/learn/learn-es/index"))));
        QueryParser parser = new QueryParser("content", new StandardAnalyzer());
        Query query = parser.parse("万古愁");

        TopDocs tds = searcher.search(query, 10);
        for (ScoreDoc sd : tds.scoreDocs) {
            Document doc = searcher.doc(sd.doc);
            System.out.println(doc);
        }
    }
}
