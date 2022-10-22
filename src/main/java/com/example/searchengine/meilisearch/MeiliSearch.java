package com.example.searchengine.meilisearch;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.meilisearch.sdk.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MeiliSearch {

    private static List<String> words;

    private static ObjectNode json;

    public ObjectNode getJSON() {
        return json;
    }

    public MeiliSearch(List<String> words) {
        this.words = words;
    }
    public static ArrayList<String> fileName = new ArrayList<String>(){
        {
            add("1.json");
            //add("2.json");
        }
    };

    private static Client client = new Client(new Config("http://127.0.0.1:7700", "masterKey"));

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < fileName.size(); ++i) {
            String moviesJson = Files.readString(Path.of(fileName.get(0)));
            Index index = client.index("test");
            index.addDocuments(moviesJson);
            for (int j = 0; j < words.size(); ++j) {
                json.put(index.search(words.get(j)).toString(), words.size());
            }
        }
    }
}