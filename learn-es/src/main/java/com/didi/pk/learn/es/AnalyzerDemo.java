package com.didi.pk.learn.es;

import com.didi.pk.learn.es.util.AnalyzerUtil;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.query.QueryAutoStopWordAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

import java.io.IOException;

/**
 * @author pengkai
 * @date 2019-09-26
 */
public class AnalyzerDemo {
    private static final String[] examples = {"The quick brown fox jumped over the dog","XY&Z Corporation - xyz@example.com"};

    private static final Analyzer[] analyzers = new Analyzer[]{
            new StandardAnalyzer(),
            new KeywordAnalyzer(),
            new SimpleAnalyzer(),
            new StopAnalyzer(CharArraySet.EMPTY_SET),
    };
    public static void main(String[] args) throws IOException {
        for (String str:examples){
            analyze(str);
        }
    }

    private static void analyze(String text) throws IOException {
        for(Analyzer analyzer:analyzers){
            String name = analyzer.getClass().getSimpleName();
            AnalyzerUtil.displayTokens(analyzer,text);
            System.out.println();
        }
    }
}
