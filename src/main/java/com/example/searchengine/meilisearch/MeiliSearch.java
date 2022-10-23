package com.example.searchengine.meilisearch;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.meilisearch.sdk.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MeiliSearch {

    private static Client client = new Client(new Config("http://127.0.0.1:7700", "masterKey"));
    private static List<String> words;

//    private ObjectNode json;

    private List<HashMap<String, Object>> json;

    public List<HashMap<String, Object>> getJSON() {
        return json;
    }

    public MeiliSearch(List<String> words) throws Exception {
//        this.words = words;
//        ObjectMapper mapper = new ObjectMapper();
//        json = mapper.createObjectNode();
//        ArrayNode hits = json.putArray("hits");
//        words.stream()
//            .map(x -> {
//                try {
//                    return client.index("test").search(x).getHits();
//                } catch (Exception e) {
//                    throw new RuntimeException();
//                }
//            })
//            .flatMap(Collection::stream)
//            .map(mapper::<JsonNode>valueToTree)
//            .forEach(hits::add);

        this.words = words;
        json = words.stream()
                .map(x -> {
                    try {
                        return client.index("movies").search(x).getHits();
                    } catch (Exception e) {
                        throw new RuntimeException();
                    }
                })
                .flatMap(Collection::stream)
                .toList();
    }
    public static ArrayList<String> fileName = new ArrayList<String>(){
        {
            add("src/main/resources/movies.json");
            //add("2.json");
        }
    };


//    public void main() throws Exception {
//        for (int i = 0; i < fileName.size(); ++i) {
//            String moviesJson = Files.readString(Path.of(fileName.get(i)));
//            Index index = client.index("movies");
//            index.addDocuments(moviesJson);
//            for (int j = 0; j < words.size(); ++j) {
//                json.put(index.search(words.get(j)).toString(), words.size());
//            }
//        }
//    }
}