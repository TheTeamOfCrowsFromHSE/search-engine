package com.example.searchengine.meilisearch;

import com.meilisearch.sdk.model.SearchResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OurSearchResult extends SearchResult {
    @Override
    public ArrayList<HashMap<String, Object>> getHits() {
        return hits;
    }

    ArrayList<HashMap<String, Object>> hits;

    public OurSearchResult(ArrayList<HashMap<String, Object>> list) {
        super();
        this.hits = list;
    }


    public String toString() {
        return "SearchResult(hits=" + this.getHits() + ", offset=" + this.getOffset() + ", limit=" + this.getLimit() + ", nbHits=" + this.getNbHits() + ", exhaustiveNbHits=" + this.isExhaustiveNbHits() + ", facetsDistribution=" + this.getFacetsDistribution() + ", exhaustiveFacetsCount=" + this.isExhaustiveFacetsCount() + ", processingTimeMs=" + this.getProcessingTimeMs() + ", query=" + this.getQuery() + ")";
    }
}
