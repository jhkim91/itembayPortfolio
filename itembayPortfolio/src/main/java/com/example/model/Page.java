package com.example.model;

/**
 * Created by iskim on 2016. 9. 28..
 */
public class Page {
    public static final int DEFAULT_PER_PAGE = 10;
    private static final int SIDE_PAGE_COUNT = 3;

    private int currentPage;
    private int perPage;
    private int offset;
    private int end;
    private int totalCount;
    private int totalPage;
    private String className;
    private String path;

    public Page(int currentPage) {
        this.currentPage = currentPage;
        this.perPage = DEFAULT_PER_PAGE;
        this.totalCount = 1;

        init();
    }

    public Page(int currentPage, int totalCount) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.perPage = DEFAULT_PER_PAGE;

        init();
    }

    public Page(int currentPage, int totalCount, int perPage) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.perPage = perPage;

        init();
    }

    private void init() {
        this.offset = (currentPage - 1) * perPage;
        this.end = this.offset + perPage;

        if (totalCount % this.perPage == 0) {
            this.totalPage = (totalCount / this.perPage);
        } else {
            this.totalPage = (totalCount / this.perPage) + 1;
        }
    }

    public static int getDefaultPerPage() {
        return DEFAULT_PER_PAGE;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getBeginPage(){
        if(this.totalPage <= DEFAULT_PER_PAGE || this.currentPage <= SIDE_PAGE_COUNT){
            return 1;
        }else{
            return this.currentPage - SIDE_PAGE_COUNT;
        }
    }
    public int getEndPage(){
        if(this.totalPage <= DEFAULT_PER_PAGE){
            return this.totalPage;
        }else if(this.totalPage - this.currentPage <= SIDE_PAGE_COUNT){
            return this.totalPage;
        }else{
            return this.currentPage + SIDE_PAGE_COUNT;
        }
    }

    public int getFirstItemNo() {
        return this.totalCount - ((this.currentPage - 1) * this.perPage);
    }
}
