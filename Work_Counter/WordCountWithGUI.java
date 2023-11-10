package dev.InnocentUdo.Work_Counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class WordCountWithGUI {
    private JTextArea textArea;
    private JLabel totalWordCountLabel;
    private JLabel uniqueWordCountLabel;
    private JTextArea wordFrequencyArea;
    private JButton countButton;

    public WordCountWithGUI() {
        JFrame frame = new JFrame("Word Count Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        JScrollPane textScrollPane = new JScrollPane(textArea);
        frame.add(textScrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        countButton = new JButton("Count Words");
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });
        buttonPanel.add(countButton);

        totalWordCountLabel = new JLabel("Total word count: ");
        uniqueWordCountLabel = new JLabel("Unique word count (excluding common words): ");
        wordFrequencyArea = new JTextArea(10, 20);
        JScrollPane wordFrequencyScrollPane = new JScrollPane(wordFrequencyArea);

        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(totalWordCountLabel, BorderLayout.WEST);
        frame.add(uniqueWordCountLabel, BorderLayout.NORTH);
        frame.add(wordFrequencyScrollPane, BorderLayout.EAST);

        frame.setVisible(true);
    }

    private void countWords() {
        String input = textArea.getText();
        int totalWordCount = countWords(input);
        int uniqueWordCount = countUniqueWords(input);
        Map<String, Integer> wordFrequency = getWordFrequency(input);

        totalWordCountLabel.setText("Total word count: " + totalWordCount);
        uniqueWordCountLabel.setText("Unique word count (excluding common words): " + uniqueWordCount);

        StringBuilder frequencyText = new StringBuilder("Word Frequency Statistics:\n");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            frequencyText.append(entry.getKey()).append(": ").append(entry.getValue()).append(" times\n");
        }
        wordFrequencyArea.setText(frequencyText.toString());
    }

    public int countWords(String text) {
        String[] words = text.split("[\\s.,;!?]+");
        return words.length;
    }

    public int countUniqueWords(String text) {
        String[] words = text.split("[\\s.,;!?]+");
        Map<String, Integer> wordMap = new HashMap<>();
        String[] ignoredWords = {"the", "and", "in", "to", "of", "a", "is"};

        for (String word : words) {
            String cleanWord = word.toLowerCase().trim();
            if (!isIgnoredWord(cleanWord, ignoredWords)) {
                wordMap.put(cleanWord, wordMap.getOrDefault(cleanWord, 0) + 1);
            }
        }

        return wordMap.size();
    }

    public Map<String, Integer> getWordFrequency(String text) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCountWithGUI();
            }
        });
    }
}


