package com.ejb.model;

import java.io.Serializable;

/**
 * Created by Igor on 19.12.16.
 */
public class CatalogContainer implements Serializable {

    private Book book;
    private Catalog catalog;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }
}
