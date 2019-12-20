package com.netcracker.ivanmerkush.backend.model;

import com.netcracker.ivanmerkush.backend.entity.PostEntity;

import java.util.List;

public class PageModel {
    private int totalElements;
    private List<PostEntity> page;

    public PageModel() {

    }

    public PageModel(int totalElements, List<PostEntity> page) {
        this.totalElements = totalElements;
        this.page = page;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public List<PostEntity> getPage() {
        return page;
    }

    public void setPage(List<PostEntity> page) {
        this.page = page;
    }
}
