package org.fts.tokenizer.space;

import org.fts.tokenizer.Tokenizer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;

/**
 * Splits initial query string by spaces - " ".
 */
public class SpaceTokenizer implements Tokenizer {

    public List<String> tokenize(String query) {

        return ofNullable(query)
                .map(String::trim)
                .map(q -> q.split("\\s+"))
                .map(Arrays::stream)
                .orElse(Stream.empty())
                .filter(token -> token != null && !token.isEmpty())
                .collect(Collectors.toList());
    }
}
