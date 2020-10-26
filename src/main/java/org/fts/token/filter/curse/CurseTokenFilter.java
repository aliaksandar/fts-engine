package org.fts.token.filter.curse;

import org.fts.token.filter.TokenFilter;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * This token filter removes curse words.<br>
 * This class has 18+ content. If you are under the age of 18, code review is prohibited.
 */
public class CurseTokenFilter implements TokenFilter {

    // Well, it's never "shoot" nor "duck" ;)
    private static final List<String> CURSES = Arrays.asList("shoot", "duck");

    @Override
    public List<String> filterTokens(List<String> sourceTokens) {
        return sourceTokens.stream()
                .filter(this::filterCursesWithIgnoredCase)
                .collect(toList());
    }

    private boolean filterCursesWithIgnoredCase(String token) {
        return !CURSES.contains(token.toLowerCase());
    }
}
