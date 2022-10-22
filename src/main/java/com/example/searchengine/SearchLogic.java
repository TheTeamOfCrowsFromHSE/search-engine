package com.example.searchengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchLogic {
    public static List<String> searchRequestDivision(String sentence) {
        List<String> dividedSentence = Arrays.asList(sentence.split(" "));
        for (int i = 0; i < dividedSentence.size(); i++) {
            if (dividedSentence.get(i).length() < 3) dividedSentence.remove(i);
        }
        return dividedSentence;
    }

    public static List<String> searchSampling(List<String> dividedSentence) {
        List<String> wordsSampling = new ArrayList<>();
        for (int i = 0; i < dividedSentence.size() - 1; i++) {
            for (int j = i + 1; j < dividedSentence.size(); j++) {
                wordsSampling.add(dividedSentence.get(i) + " " + dividedSentence.get(j));
            }
        }
        for (int i = 0; i < dividedSentence.size(); i++) {
            wordsSampling.add(dividedSentence.get(i));
        }
        return wordsSampling;
    }
}
