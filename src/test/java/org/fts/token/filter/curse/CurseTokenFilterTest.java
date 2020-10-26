package org.fts.token.filter.curse;

import org.fts.token.filter.TokenFilter;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CurseTokenFilterTest {

    private final TokenFilter curseTokenFilter = new CurseTokenFilter();

    @Test
    void classicalCursesAreRemoved() {
        assertThat(
                curseTokenFilter.filterTokens(asList("this", "is", "shoot", "as", "duck")),
                contains("this", "is", "as")
        );
    }

    @Test
    void emptyListIsReturnedWhenAllTokensAreCurses() {
        assertThat(
                curseTokenFilter.filterTokens(asList("duck", "shoot")),
                is(empty())
        );
    }

    @Test
    void caseIsIgnored() {
        assertThat(
                curseTokenFilter.filterTokens(asList("DuCK", "is", "obscene")),
                contains("is", "obscene")
        );
    }

    @Test
    void caseIsPreservedForNonFilteredTokens() {
        assertThat(
                curseTokenFilter.filterTokens(asList("Shoot", "Is", "Obscene", "TOO")),
                contains("Is", "Obscene", "TOO")
        );
    }
}