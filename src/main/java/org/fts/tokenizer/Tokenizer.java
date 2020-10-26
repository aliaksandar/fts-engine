package org.fts.tokenizer;

import java.util.List;

public interface Tokenizer {

    /**
     * A tokenizer parses a query after character filter to a list of tokens.<br>
     * There can be different tokenizers, such as space tokenizer, special symbols tokenizer.<br><br>
     *
     * But there never can be more than one tokenizer.
     *
     * @param query a string representation of a char-filtered query.
     * @return a list of tokens. The order of tokens should (?) correspond to its order in
     * initial query.
     */
    List<String> tokenize(String query);
}
