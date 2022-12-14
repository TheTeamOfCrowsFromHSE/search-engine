package com.example.searchengine;

import com.example.searchengine.search.SearchDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class SearchLogic {
    private List<String> words;

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public SearchLogic(SearchDTO searchDTO) {
        words = searchRequestDivision(searchDTO.getQ());
        words = searchSampling(words);
    }

    public static List<String> searchRequestDivision(String sentence) {
        String numPattern = "[0-9]+[\\\\.]?[0-9]*";
        List<String> dividedSentence = new ArrayList<String>(Arrays.asList(sentence.split(" ")));
        for (int i = 0; i < dividedSentence.size(); i++) {
            if (dividedSentence.get(i).length() < 3 && !Pattern.matches(numPattern, dividedSentence.get(i))) {
                dividedSentence.remove(i);
            }
        }
        return dividedSentence;
    }

    public static List<String> searchSampling(List<String> dividedSentence) {
        String numPattern = "[0-9]+[\\\\.]?[0-9]*";
        List<String> wordsSampling = new ArrayList<>();
        for (int i = 0; i < dividedSentence.size() - 1; i++) {
            for (int j = i + 1; j < dividedSentence.size(); j++) {
                wordsSampling.add(dividedSentence.get(i) + " " + dividedSentence.get(j));
            }
        }
        for (int i = 0; i < dividedSentence.size(); i++) {
            if (!Pattern.matches(numPattern, dividedSentence.get(i)))
                wordsSampling.add(dividedSentence.get(i));
        }
        return wordsSampling;
    }
}
