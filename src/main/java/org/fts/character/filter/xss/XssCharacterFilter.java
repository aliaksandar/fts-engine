package org.fts.character.filter.xss;

import org.fts.character.filter.CharacterFilter;

/**
 * Removes JS scripts from initial query.
 */
public class XssCharacterFilter implements CharacterFilter {

    @Override
    public String filterCharacters(String query) {

        return query != null
                ? query.replaceAll("<\\s*script[^>]*>(.*?)<\\s*/\\s*script>", "")
                : null;
    }
}
