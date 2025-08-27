package Collectors;

import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "hello world hello java java java";
        String[] words = text.split(" ");

        Map<String, Integer> wordCount = Arrays.stream(words)
            .collect(Collectors.toMap(
                word -> word,
                word -> 1,
                Integer::sum
            ));

        System.out.println(wordCount);
    }
}