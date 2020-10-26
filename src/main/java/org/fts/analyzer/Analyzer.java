package org.fts.analyzer;

import java.util.List;

/**
 * Analyzer is used to analyze queries and fields before they are executed (queries) and indexed (fields).
 * The order the analyzer works should (usually) be:<br>
 * 1. Character filters;<br>
 * 2. Tokenizer;<br>
 * 3. Token filters.<br>
 *
 */
public interface Analyzer {

    /**
     * Analyze a string (field value or query) through an analyzer.
     * This method returns an ordered list of tokens to be be provided as a search query
     * or indexed to a storage.
     *
     * @param value field value or search query
     * @return a list of tokens
     */
    List<String> analyze(String value);
}
