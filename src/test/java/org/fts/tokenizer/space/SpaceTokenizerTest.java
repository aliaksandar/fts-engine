package org.fts.tokenizer.space;

import org.fts.tokenizer.Tokenizer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SpaceTokenizerTest {

    private final Tokenizer spaceTokenizer = new SpaceTokenizer();

    @Test
    void stringWithoutSpacesIsNotSplitted() {
        assertThat(
                spaceTokenizer.tokenize("stringWithoutSpaces"),
                contains("stringWithoutSpaces")
        );
    }

    @Test
    void stringWithASpaceIsSplittedInTwo() {
        assertThat(
                spaceTokenizer.tokenize("two strings"),
                contains("two", "strings")
        );
    }

    @Test
    void multipleSpacesAreIgnored() {
        assertThat(
                spaceTokenizer.tokenize("another    three  strings"),
                contains("another", "three", "strings")
        );
    }

    @Test
    void spacesAreTrimmed() {
        assertThat(
                spaceTokenizer.tokenize("   again a string "),
                contains("again", "a", "string")
        );
    }

    @Test
    void nullStringReturnsEmptyList() {
        assertThat(
                spaceTokenizer.tokenize(null),
                is(empty())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "   "})
    void emptyStringReturnsEmptyList(String query) {
        assertThat(
                spaceTokenizer.tokenize(query),
                is(empty())
        );
    }

    @Test
    void stringIsSplittedByTabs() {
        assertThat(
                spaceTokenizer.tokenize("tabbed\tstring"),
                contains("tabbed", "string")
        );
    }
}