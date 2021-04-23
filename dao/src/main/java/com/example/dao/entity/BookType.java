package com.example.dao.entity;

public class BookType {
    private Integer id;

    private String booktypename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBooktypename() {
        return booktypename;
    }

    public void setBooktypename(String booktypename) {
        this.booktypename = booktypename == null ? null : booktypename.trim();
    }
}