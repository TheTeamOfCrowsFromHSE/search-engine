package com.example.searchengine.controllers;

import com.example.searchengine.SearchLogic;
import com.example.searchengine.meilisearch.MeiliSearch;
import com.example.searchengine.search.SearchDTO;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SearchController {

    @PostMapping("/search")
    ObjectNode newSearchDTO(@RequestBody SearchDTO newSearchDTO) {
        SearchLogic searchLogic = new SearchLogic(newSearchDTO);
        MeiliSearch meiliSearch = new MeiliSearch(searchLogic.getWords());
        return meiliSearch.getJSON();
    }
}
