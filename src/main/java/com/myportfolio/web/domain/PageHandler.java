package com.myportfolio.web.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class PageHandler {
    private int t_cnt;

    private SearchCondition sc;
    private int n_size = 10;
    private int t_page;

    private int b_page;
    private int e_page;
    private boolean showPrev;
    private boolean showNext;

    public int getT_cnt() {
        return t_cnt;
    }

    public void setT_cnt(int t_cnt) {
        this.t_cnt = t_cnt;
    }



    public int getN_size() {
        return n_size;
    }

    public void setN_size(int n_size) {
        this.n_size = n_size;
    }

    public int getT_page() {
        return t_page;
    }

    public void setT_page(int t_page) {
        this.t_page = t_page;
    }



    public int getB_page() {
        return b_page;
    }

    public void setB_page(int b_page) {
        this.b_page = b_page;
    }

    public int getE_page() {
        return e_page;
    }

    public void setE_page(int e_page) {
        this.e_page = e_page;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public SearchCondition getSc() {
        return sc;
    }


    public void setSc(SearchCondition sc) {
        this.sc = sc;
    }

    public PageHandler(int t_cnt, SearchCondition sc){
        this.t_cnt = t_cnt;
        this.sc = sc;

        doPaging(t_cnt,sc);

    }

    public void doPaging(int t_cnt,SearchCondition sc){
        this.t_cnt = t_cnt;

        t_page = (int)Math.ceil((double)t_cnt / sc.getPageSize());
        b_page = (sc.getPage()-1)/n_size * n_size + 1 ;
        e_page = Math.min(b_page +  n_size-1, t_page);
        showPrev = b_page != 1;
        showNext = e_page != t_page;
    }
    void print(){
        System.out.println("page = " + sc.getPage());
        System.out.print(showPrev ? "[prev] " : "");
        for(int i = b_page ; i <= e_page ; i++){
            System.out.print(i + "");
        }
        System.out.print(showNext?"Next" : "");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "t_cnt=" + t_cnt +
                ", sc=" + sc +
                ", n_size=" + n_size +
                ", t_page=" + t_page +
                ", b_page=" + b_page +
                ", e_page=" + e_page +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}
