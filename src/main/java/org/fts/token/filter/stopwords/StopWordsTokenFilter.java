package org.fts.token.filter.stopwords;

import org.fts.token.filter.TokenFilter;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

/**
 * Removes commonly used English words such as articles, modal verbs,
 */
public class StopWordsTokenFilter implements TokenFilter {

    private static final Set<String> STOP_WORDS = new HashSet<>();

    static {
        // Articles
        STOP_WORDS.add("a");
        STOP_WORDS.add("an");
        STOP_WORDS.add("the");

        // Prepositions
        STOP_WORDS.add("is");
        STOP_WORDS.add("are");

        // Modal verbs
        STOP_WORDS.add("should");
        STOP_WORDS.add("could");
        STOP_WORDS.add("can");
        STOP_WORDS.add("may");

    }

    @Override
    public List<String> filterTokens(List<String> sourceTokens) {
        return sourceTokens.stream()
                .filter(o -> !STOP_WORDS.contains(o))
                .collect(toList());
    }
}
