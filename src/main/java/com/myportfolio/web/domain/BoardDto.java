package com.myportfolio.web.domain;

import java.util.Date;
import java.util.Objects;

public class BoardDto {
    private Integer bno;
    private String title;
    private String content;
    private String writer;
    private String b_id;
    private int v_cnt;
    private int c_cnt;
    private Date reg_date;
    public BoardDto(){}
    public BoardDto(String title, String content, String writer, String b_id) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.b_id = b_id;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getB_id() {
        return b_id;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public int getV_cnt() {
        return v_cnt;
    }

    public void setV_cnt(int v_cnt) {
        this.v_cnt = v_cnt;
    }

    public int getC_cnt() {
        return c_cnt;
    }

    public void setC_cnt(int c_cnt) {
        this.c_cnt = c_cnt;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDto boardDto = (BoardDto) o;
        return Objects.equals(bno, boardDto.bno) && Objects.equals(title, boardDto.title) && Objects.equals(content, boardDto.content) && Objects.equals(writer, boardDto.writer) && Objects.equals(b_id, boardDto.b_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bno, title, content, writer, b_id);
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", b_id='" + b_id + '\'' +
                ", v_cnt=" + v_cnt +
                ", c_cnt=" + c_cnt +
                ", reg_date=" + reg_date +
                '}';
    }
}
