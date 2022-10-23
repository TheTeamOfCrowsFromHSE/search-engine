package com.example.searchengine.controllers;

import com.example.searchengine.SearchLogic;
import com.example.searchengine.meilisearch.MeiliSearch;
import com.example.searchengine.meilisearch.OurSearchResult;
import com.example.searchengine.search.SearchDTO;
import com.meilisearch.sdk.model.SearchResult;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class SearchController {

//    @RequestMapping(method = RequestMethod.GET, value = "/search")
//    public String search(@ModelAttribute RequestObject request) {
//        return searchService.search(request);
//    }

//    @GetMapping("/search")
//    ResponseEntity<List<HashMap<String, Object>>> newSearchDTO(@ModelAttribute @RequestBody SearchDTO newSearchDTO) throws Exception {
//        System.out.println(newSearchDTO);
//        SearchLogic searchLogic = new SearchLogic(newSearchDTO);
//        MeiliSearch meiliSearch = new MeiliSearch(searchLogic.getWords());
//        return ResponseEntity.ok(meiliSearch.json);
//    }

//    @PostMapping("/indexes/movies/search")
//    ResponseEntity<SearchResult> newSearchDTO(@RequestBody() SearchDTO searchDTO) throws Exception {
//            return ResponseEntity.ok(MeiliSearch.client.index("movies").search(searchDTO.getQ()));
//    }


    @PostMapping("/indexes/movies/search")
    ResponseEntity<OurSearchResult> newSearchDTO(@RequestBody() SearchDTO searchDTO) throws Exception {
        ArrayList<HashMap<String, Object>> array = new ArrayList<>();
        if (!searchDTO.getQ().isEmpty()) {
            SearchLogic searchLogic = new SearchLogic(searchDTO);
            MeiliSearch meiliSearch = new MeiliSearch(searchLogic.getWords());
            array.addAll(meiliSearch.json);
        }
        OurSearchResult sr = new OurSearchResult(array);
        return ResponseEntity.ok(sr);
    }

}
