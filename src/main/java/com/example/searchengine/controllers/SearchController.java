package com.example.searchengine.controllers;

import com.example.searchengine.SearchLogic;
import com.example.searchengine.meilisearch.MeiliSearch;
import com.example.searchengine.search.SearchDTO;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SearchController {

    @PostMapping(value = "/search", produces = "application/json")
    List<HashMap<String, Object>> newSearchDTO(@RequestBody SearchDTO newSearchDTO)throws Exception {
        SearchLogic searchLogic = new SearchLogic(newSearchDTO);
        MeiliSearch meiliSearch = new MeiliSearch(searchLogic.getWords());
        return meiliSearch.getJSON();
    }
}
