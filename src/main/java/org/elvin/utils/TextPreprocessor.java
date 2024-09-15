package org.elvin.utils;

import weka.core.tokenizers.WordTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextPreprocessor {
    // Define regex patterns for non-alphabetic characters
    private static final Pattern NON_ALPHABETIC = Pattern.compile("[^a-zA-Z\\s]");
    private static final List<String> stopWords = List.of(Constants.stopwords);

    public static String preprocess(String text) {
        if (text == null) {
            return "";
        }

        // Convert to lowercase
        text = text.toLowerCase();

        // Remove non-alphabetic characters
        text = NON_ALPHABETIC.matcher(text).replaceAll("");

        // Tokenize
        WordTokenizer tokenizer = new WordTokenizer();
        tokenizer.tokenize(text);
        List<String> tokens = new ArrayList<>();
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextElement());
        }

        List<String> filteredTokens = tokens.stream()
                .filter(token -> !stopWords.contains(token))
                .collect(Collectors.toList());

        // Join tokens back into a single string
        return String.join(" ", filteredTokens);
    }
}
