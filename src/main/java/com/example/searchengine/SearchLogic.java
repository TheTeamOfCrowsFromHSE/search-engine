package com.example.searchengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchLogic {
    public static List<String> searchRequestDivision(String sentence) {
        List<String> dividedSentence = new ArrayList<>(Arrays.asList(sentence.split(" ")));
        for (int i = 0; i < dividedSentence.size(); i++) {
            if (dividedSentence.get(i).length() < 3) dividedSentence.remove(i);
        }
        return dividedSentence;
    }
}
