
package com.androidmodule.gutenbergapp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("opensearch:Query")
    @Expose
    private OpenSearchQuery openSearchQuery;
    @SerializedName("opensearch:totalResults")
    @Expose
    private String openSearchTotalResults;
    @SerializedName("opensearch:startIndex")
    @Expose
    private String openSearchStartIndex;
    @SerializedName("opensearch:itemsPerPage")
    @Expose
    private String openSearchItemsPerPage;
    @SerializedName("albummatches")
    @Expose
    private AlbumMatches albumMatches;


    public OpenSearchQuery getOpenSearchQuery() {
        return openSearchQuery;
    }

    public void setOpenSearchQuery(OpenSearchQuery openSearchQuery) {
        this.openSearchQuery = openSearchQuery;
    }

    public String getOpenSearchTotalResults() {
        return openSearchTotalResults;
    }

    public void setOpenSearchTotalResults(String openSearchTotalResults) {
        this.openSearchTotalResults = openSearchTotalResults;
    }

    public String getOpenSearchStartIndex() {
        return openSearchStartIndex;
    }

    public void setOpenSearchStartIndex(String openSearchStartIndex) {
        this.openSearchStartIndex = openSearchStartIndex;
    }

    public String getOpenSearchItemsPerPage() {
        return openSearchItemsPerPage;
    }

    public void setOpenSearchItemsPerPage(String openSearchItemsPerPage) {
        this.openSearchItemsPerPage = openSearchItemsPerPage;
    }

    public AlbumMatches getAlbumMatches() {
        return albumMatches;
    }

    public void setAlbumMatches(AlbumMatches albumMatches) {
        this.albumMatches = albumMatches;
    }
}
