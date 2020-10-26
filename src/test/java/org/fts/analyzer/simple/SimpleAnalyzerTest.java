package org.fts.analyzer.simple;

import org.fts.analyzer.Analyzer;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SimpleAnalyzerTest {

    private final Analyzer simpleAnalyzer = new SimpleAnalyzer();

    @Test
    void mostCommonCaseIsProcessedCorrectly() {
        assertThat(
                simpleAnalyzer.analyze("This is duck test"),
                contains("This", "test")
        );
    }

    @Test
    void nullStringReturnsEmptyListOfTokens() {
        assertThat(
                simpleAnalyzer.analyze(null),
                is(empty())
        );
    }

    @Test
    void emptyStringReturnsEmptyListOfTokens() {
        assertThat(
                simpleAnalyzer.analyze(""),
                is(empty())
        );
    }

    @Test
    void allWrongStringReturnsEmptyTokensList() {
        assertThat(
                simpleAnalyzer.analyze("<script>alert(123123)</script> is a duck"),
                is(empty())
        );
    }
}