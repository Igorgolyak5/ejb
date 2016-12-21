package com.ejb.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Igor on 17.12.16.
 */
public class Catalog implements Serializable{

    private Long id;
    private String name;
    @JsonIgnore
    private List<Book> bookList = new ArrayList<>();

    public Catalog(){}
    public Catalog(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBook(Book book){
        bookList.add(book);
    }

    public void removeBook(Book requestBook){
        for (Iterator<Book> iterator = bookList.iterator(); iterator.hasNext();) {
            Book book = iterator.next();
            if (book.getName().equals(requestBook.getName())
                    && book.getAuthor().equals(requestBook.getAuthor())) {
                // Remove the current element from the iterator and the list.
                iterator.remove();
            }
        }
    }

    public void removeBooks(){
        bookList = null;
    }

    public boolean equals(Object object){
        if (this == object)
            return true;
        if(object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        Catalog catalog = (Catalog)object;
        if(id != catalog.getId()) {
            return false;
        }
        return true;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId(){return id;}
}
