package org.fts.character.filter.xss;

import org.fts.character.filter.CharacterFilter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XssCharacterFilterTest {

    private final CharacterFilter xssFilter = new XssCharacterFilter();

    @Test
    void scriptTagIsRemoved() {
        assertEquals(
                "Hey!",
                xssFilter.filterCharacters("<script>alert(1)</script>Hey!")
        );
    }

    @Test
    void scriptTagWithAttributesIsRemoved() {
        assertEquals(
                "Hey!",
                xssFilter.filterCharacters("<script src=\"bla-bla\" type=\"wow\">alert(1)</script>Hey!")
        );
    }

    @Test
    void nullQueryIsReturnedAsIs() {
        assertNull(
                xssFilter.filterCharacters(null)
        );
    }

    @Test
    void emptyStringIsReturnedAsIs() {
        assertEquals(
                "",
                xssFilter.filterCharacters("")
        );
    }
}