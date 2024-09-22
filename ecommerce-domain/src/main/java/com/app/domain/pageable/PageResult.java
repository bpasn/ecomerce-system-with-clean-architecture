package com.app.domain.pageable;

import java.util.List;

public class PageResult<T> {
    private List<T> content;
    private int page;
    private int size;
    private long totalElement;
    private int totalPage;


    PageResult(){}

    
    public PageResult(List<T> content, int page, int size, long totalElement, int totalPage) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElement = totalElement;
        this.totalPage = totalPage;
    }


    public List<T> getContent() {
        return content;
    }


    public void setContent(List<T> content) {
        this.content = content;
    }


    public int getPage() {
        return page;
    }


    public void setPage(int page) {
        this.page = page;
    }


    public int getSize() {
        return size;
    }


    public void setSize(int size) {
        this.size = size;
    }


    public long getTotalElement() {
        return totalElement;
    }


    public void setTotalElement(long totalElement) {
        this.totalElement = totalElement;
    }


    public int getTotalPage() {
        return totalPage;
    }


    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    
}
