package dev.bernilai;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "src/main/resources/text";
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return;
        }

        Map<String, Integer> wordCounts = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        scanner.close();

        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCounts.entrySet());

        Collections.sort(wordList, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        System.out.println("Top 10 most frequent words:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : wordList) {
            if (count < 10) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                count++;
            } else {
                break;
            }
        }
    }
}
