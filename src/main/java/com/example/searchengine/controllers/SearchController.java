package com.example.searchengine.controllers;

import com.example.searchengine.SearchLogic;
import com.example.searchengine.meilisearch.MeiliSearch;
import com.example.searchengine.meilisearch.OurSearchResult;
import com.example.searchengine.search.SearchDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SearchController {
    @PostMapping("/indexes/movies/search")
    ResponseEntity<OurSearchResult> newSearchDTO(@RequestBody() SearchDTO searchDTO) throws Exception {
        SearchLogic searchLogic = new SearchLogic(searchDTO);
        MeiliSearch meiliSearch = new MeiliSearch(searchLogic.getWords(), searchDTO.getQ().isEmpty());
        OurSearchResult searchResult = new OurSearchResult(meiliSearch.json);
        return ResponseEntity.ok(searchResult);
    }
}
