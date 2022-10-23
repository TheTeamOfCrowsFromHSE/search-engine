package com.example.searchengine.controllers;

import com.example.searchengine.SearchLogic;
import com.example.searchengine.meilisearch.MeiliSearch;
import com.example.searchengine.search.SearchDTO;
import com.meilisearch.sdk.model.SearchResult;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/indexes/movies/search")
//    ResponseEntity<List<HashMap<String, Object>>> newSearchDTO(@RequestParam(value = "q") String q) throws Exception {
      ResponseEntity<SearchResult> newSearchDTO(@RequestBody() SearchDTO searchDTO) throws Exception {
        return ResponseEntity.ok(MeiliSearch.client.index("movies").search(searchDTO.getQ()));
//        SearchDTO searchDTO = new SearchDTO(q);
//        SearchLogic searchLogic = new SearchLogic(searchDTO);
//        MeiliSearch meiliSearch = new MeiliSearch(searchLogic.getWords());
//        System.out.println(q);
//        return ResponseEntity.ok(meiliSearch.json);
    }

}
