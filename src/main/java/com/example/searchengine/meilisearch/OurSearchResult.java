package com.example.searchengine.meilisearch;

import com.meilisearch.sdk.model.SearchResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OurSearchResult extends SearchResult {
    private ArrayList<HashMap<String, Object>> hits;

    public OurSearchResult(List<HashMap<String, Object>> json) {
        super();
        ArrayList<HashMap<String, Object>> array = new ArrayList<>();
        array.addAll(json);
        this.hits = array;
    }

    @Override
    public ArrayList<HashMap<String, Object>> getHits() {
        return hits;
    }

    public String toString() {
        return "SearchResult(hits=" + this.getHits() + ", offset=" + this.getOffset() + ", limit=" + this.getLimit() + ", nbHits=" + this.getNbHits() + ", exhaustiveNbHits=" + this.isExhaustiveNbHits() + ", facetsDistribution=" + this.getFacetsDistribution() + ", exhaustiveFacetsCount=" + this.isExhaustiveFacetsCount() + ", processingTimeMs=" + this.getProcessingTimeMs() + ", query=" + this.getQuery() + ")";
    }
}
