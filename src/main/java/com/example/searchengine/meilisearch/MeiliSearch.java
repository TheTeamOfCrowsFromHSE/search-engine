package com.example.searchengine.meilisearch;

import com.meilisearch.sdk.Client;
import com.meilisearch.sdk.Config;
import com.meilisearch.sdk.Index;

import java.util.Map.Entry;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

@Entity
public class MeiliSearch {

    public static Client client = new Client(new Config("http://127.0.0.1:7700", "masterkey"));
    private static List<String> words;

    private boolean requestIsEmpty;

    public List<HashMap<String, Object>> json;
    private Long id;

    public static String fileName = "src/main/java/com/example/searchengine/meilisearch/movies.json";

    public MeiliSearch() {}

    public MeiliSearch(List<String> words, boolean requestIsEmpty) throws Exception {
        Path filePath = Path.of(fileName);
//        String moviesJson = Files.readString(filePath);
//        Index index = client.index("movies");
//        index.addDocuments(moviesJson);

        if (!requestIsEmpty) {
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
        } else {
            json = client.index("movies").search("").getHits();



        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}