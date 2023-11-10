package dev.InnocentUdo.Work_Counter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=======> Word Count Program <=======\n");
        System.out.println("Enter text or provide a file to count the words:");
        String input = scanner.nextLine();

        int totalWordCount = countWords(input);
        System.out.println("Total word count: " + totalWordCount);

        String[] ignoredWords = {"the", "and", "in", "to", "of", "a", "is"};
        int uniqueWordCount = countUniqueWords(input, ignoredWords);
        System.out.println("Unique word count (excluding common words): " + uniqueWordCount);

        Map<String, Integer> wordFrequency = getWordFrequency(input);
        System.out.println("Word Frequency Statistics:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }

        scanner.close();
    }

    public static int countWords(String text) {
        String[] words = text.split("[\\s.,;!?]+");
        return words.length;
    }

    public static int countUniqueWords(String text, String[] ignoredWords) {
        String[] words = text.split("[\\s.,;!?]+");
        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            String cleanWord = word.toLowerCase().trim();
            if (!isIgnoredWord(cleanWord, ignoredWords)) {
                wordMap.put(cleanWord, wordMap.getOrDefault(cleanWord, 0) + 1);
            }
        }
        return wordMap.size();
    }

    public static Map<String, Integer> getWordFrequency(String text) {
        String[] words = text.split("[\\s.,;!?]+");
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            String cleanWord = word.toLowerCase().trim();
            wordFrequency.put(cleanWord, wordFrequency.getOrDefault(cleanWord, 0) + 1);
        }
        return wordFrequency;
    }

    public static boolean isIgnoredWord(String word, String[] ignoredWords) {
        for (String ignored : ignoredWords) {
            if (ignored.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
