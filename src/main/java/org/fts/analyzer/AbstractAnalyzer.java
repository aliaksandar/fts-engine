package org.fts.analyzer;

import org.fts.character.filter.CharacterFilter;
import org.fts.token.filter.TokenFilter;
import org.fts.tokenizer.Tokenizer;

import java.util.List;

/**
 * Abstract analyzer defines the logic analyzers work.
 * It's sort of a chain of responsibilities in such order - character filters, then tokenizer, then
 * token filters.
 */
public abstract class AbstractAnalyzer implements Analyzer {

    private final List<CharacterFilter> characterFilters;
    private final Tokenizer tokenizer;
    private final List<TokenFilter> tokenFilters;

    public AbstractAnalyzer(
            List<CharacterFilter> characterFilters,
            Tokenizer tokenizer,
            List<TokenFilter> tokenFilters) {

        this.characterFilters = characterFilters;
        this.tokenizer = tokenizer;
        this.tokenFilters = tokenFilters;
    }

    @Override
    public List<String> analyze(String value) {
        // Filter characters
        for (CharacterFilter filter : characterFilters) {
            value = filter.filterCharacters(value);
        }

        // Tokenize
        List<String> tokens = tokenizer.tokenize(value);

        // Apply token filters
        for (TokenFilter tokenFilter : tokenFilters) {
            tokens = tokenFilter.filterTokens(tokens);
        }
        return tokens;
    }
}
