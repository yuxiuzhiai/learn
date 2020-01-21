package com.didi.pk.learn.es.util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

/**
 * @author pengkai
 * @date 2019-09-26
 */
public class AnalyzerUtil {
    public static void displayTokens(Analyzer analyzer,String text) throws IOException {
        displayTokens(analyzer.tokenStream("content",text));
    }

    public static void displayTokens(TokenStream tokenStream) throws IOException {
        CharTermAttribute attribute = tokenStream.addAttribute(CharTermAttribute.class);
        while (tokenStream.incrementToken()){
            System.out.println("["+attribute.toString()+"]");
        }
    }
}
