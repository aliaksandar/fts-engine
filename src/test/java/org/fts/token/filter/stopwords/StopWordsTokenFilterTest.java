package org.fts.token.filter.stopwords;

import org.fts.token.filter.TokenFilter;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class StopWordsTokenFilterTest {

    private final TokenFilter stopWordsFilter = new StopWordsTokenFilter();

    @Test
    void articlesAreRemoved() {
        assertThat(
                stopWordsFilter.filterTokens(asList("a", "the", "and", "an", "articles")),
                contains("and", "articles")
        );
    }

    @Test
    void prepositionsAreRemoved() {
        assertThat(
                stopWordsFilter.filterTokens(asList("prepositions", "are", "and", "is", "removed")),
                contains("prepositions", "and", "removed")
        );
    }

    @Test
    void modalVerbsAreRemoved() {
        assertThat(
                stopWordsFilter.filterTokens(asList("modals", "should", "could", "can", "may", "removed")),
                contains("modals", "removed")
        );
    }

    @Test
    void emptyTokensAreReturnedAsIs() {
        assertThat(
                stopWordsFilter.filterTokens(emptyList()),
                is(empty())
        );
    }
}