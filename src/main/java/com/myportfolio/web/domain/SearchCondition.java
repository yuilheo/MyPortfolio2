package com.myportfolio.web.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
    private Integer pageSize = 10;
//    private Integer offset = 0;
    private String keyword= "";
    private String option = "";
    private Integer page = 1;

    public SearchCondition(){}

    public SearchCondition(Integer page,Integer pageSize,String keyword, String option) {
        this.pageSize = pageSize;
        this.keyword = keyword;
        this.option = option;
        this.page = page;
    }





    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return (page-1)*pageSize;
    }

//    public void setOffset(Integer offset) {
//        this.offset = offset;
//    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "pageSize=" + pageSize +
                ", keyword='" + keyword + '\'' +
                ", option='" + option + '\'' +
                ", page=" + page +
                '}';
    }
    public String getQueryString(Integer page) {
        return UriComponentsBuilder.newInstance()
                .queryParam("page",     page)
                .queryParam("pageSize", pageSize)
                .queryParam("option",   option)
                .queryParam("keyword",  keyword)
                .build().toString();
    }
    public String getQueryString(){
        return getQueryString(page);

    }

    }
