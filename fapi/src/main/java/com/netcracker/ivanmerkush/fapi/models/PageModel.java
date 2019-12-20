package com.netcracker.ivanmerkush.fapi.models;

import java.util.List;

public class PageModel {
    private int totalElements;
    private List<Post> page;

    public PageModel() {

    }

    public PageModel(int totalElements, List<Post> page) {
        this.totalElements = totalElements;
        this.page = page;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public List<Post> getPage() {
        return page;
    }

    public void setPage(List<Post> page) {
        this.page = page;
    }
}
