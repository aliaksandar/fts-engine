package org.fts.character.filter;

/**
 * Removes unwanted characters in initial query string.
 * Unwanted characters are HTML tags.
 */
public interface CharacterFilter {

    /**
     * Filters-out characters that are considered to be useless.
     *
     * @param query initial query. We want to remove unwanted characters in this query.
     * @return query with unwanted characters removed.
     */
    String filterCharacters(String query);
}
