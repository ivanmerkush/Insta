package com.netcracker.ivanmerkush.fapi.models;

import java.util.List;

public class PageViewModel {
    private int totalElements;
    private List<PostViewModel> page;

    public PageViewModel() {

    }

    public PageViewModel(int totalElements, List<PostViewModel> page) {
        this.totalElements = totalElements;
        this.page = page;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public List<PostViewModel> getPage() {
        return page;
    }

    public void setPage(List<PostViewModel> page) {
        this.page = page;
    }
}
