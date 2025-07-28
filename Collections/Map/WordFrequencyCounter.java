package Map;


import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("E:\\BRAJLAB\\Java Programs\\Collections\\Map\\sample.txt"));

        Map<String, Integer> wordCount = new HashMap<>();

        String line;
        while ((line = br.readLine()) != null) {
    
            line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();


            String[] words = line.split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}