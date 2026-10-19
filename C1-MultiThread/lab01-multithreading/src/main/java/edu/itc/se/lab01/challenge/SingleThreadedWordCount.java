package edu.itc.se.lab01.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Single-threaded reference implementation of the word-frequency analyser.
 * Used as a baseline oracle for correctness verification in JUnit tests.
 */
public class SingleThreadedWordCount {

    private static final Pattern NON_LETTERS = Pattern.compile("[^\\p{L}]+");

    /**
     * Walks {@code dir} sequentially, counting words in all regular files.
     *
     * @param dir Directory to analyze
     * @return Map of word to total occurrence count
     * @throws IOException If an I/O error occurs walking the directory
     */
    public static Map<String, Long> count(Path dir) throws IOException {
        Map<String, Long> counts = new HashMap<>();
        try (Stream<Path> stream = Files.walk(dir)) {
            stream.filter(Files::isRegularFile)
                  .sorted()
                  .forEach(file -> countFile(file, counts));
        }
        return counts;
    }

    private static void countFile(Path file, Map<String, Long> counts) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = NON_LETTERS.split(line);
                for (String token : tokens) {
                    if (!token.isEmpty()) {
                        String word = token.toLowerCase();
                        counts.merge(word, 1L, Long::sum);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed reading file: " + file, e);
        }
    }
}
