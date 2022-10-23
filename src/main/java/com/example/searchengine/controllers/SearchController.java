package com.example.searchengine.controllers;

import com.example.searchengine.SearchLogic;
import com.example.searchengine.meilisearch.MeiliSearch;
import com.example.searchengine.search.SearchDTO;
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

    @GetMapping("/search") ResponseEntity<List<HashMap<String, Object>>> newSearchDTO(@RequestParam(value = "text") String text) throws Exception {
        if (!text.isEmpty()) {
            SearchDTO searchDTO = new SearchDTO(text);
            SearchLogic searchLogic = new SearchLogic(searchDTO);
            MeiliSearch meiliSearch = new MeiliSearch(searchLogic.getWords());
            return ResponseEntity.ok(meiliSearch.json);
        }
        return ResponseEntity.ok(new ArrayList<>());
    }
}
