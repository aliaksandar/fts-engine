package org.fts.analyzer.simple;

import org.fts.analyzer.AbstractAnalyzer;
import org.fts.character.filter.xss.XssCharacterFilter;
import org.fts.token.filter.curse.CurseTokenFilter;
import org.fts.token.filter.stopwords.StopWordsTokenFilter;
import org.fts.tokenizer.space.SpaceTokenizer;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

/**
 * Simple analyzer breaks down a string (query or indexing field).
 * Contains XSS character filter, Space tokenizer, Curse and Stop Words token filters.
 */
public final class SimpleAnalyzer extends AbstractAnalyzer {

    public SimpleAnalyzer() {
        super(
                singletonList(new XssCharacterFilter()),
                new SpaceTokenizer(),
                asList(new CurseTokenFilter(), new StopWordsTokenFilter())
        );
    }
}
