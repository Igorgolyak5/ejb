package com.ejb.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Igor on 17.12.16.
 */
public class Book implements Serializable{

    private Long id;
    private String name;
    private String author;
    private Date releaseDate;
    private Catalog catalog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean equals(Object object){
        if (this == object)
            return true;
        if(object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        Book book = (Book)object;
        if(!id.equals(book.getId()))
            return false;
        return true;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
