package org.fts.token.filter;

import java.util.List;

/**
 * Token filter allows to filter-out unwanted tokens such as articles, curse words etc.
 */
public interface TokenFilter {

    /**
     *
     * @param sourceTokens tokens receidev after a tokenizer or a token filter.
     * @return list of tokens that do not contain unwanted tokens
     */
    List<String> filterTokens(List<String> sourceTokens);
}
