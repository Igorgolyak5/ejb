package com.ejb.service;

import com.ejb.model.Book;
import com.ejb.model.Catalog;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Igor on 18.12.16.
 */
@Singleton
public class CatalogService implements CatalogRemote {

    private long bookId = 0;
    private long catalogId = 0;
    private List<Catalog> catalogList;

    @PostConstruct
    private void initializeBean(){
        catalogList = new ArrayList<>();
    }

    public List<Book> getBooksFromCatalog(Catalog catalog) {
        for(int i=0;i<catalogList.size();i++) {
            if (catalogList.get(i).equals(catalog)) {
                return catalogList.get(i).getBookList();
            }
        }

        return null;
    }

    public Book addBook(Book book, Catalog catalog) {
        for(int i=0;i<catalogList.size();i++){
            if(catalogList.get(i).equals(catalog)) {
                book.setId(bookId);
                bookId++;
                catalogList.get(i).addBook(book);
                return book;
            }
        }
        return null;
    }

    public Book updateBook(Book book, Catalog catalog) {
        for(int i=0;i<catalogList.size();i++) {
            Catalog result = catalogList.get(i);
            if (catalogList.get(i).equals(catalog)) {
                for(int j=0;j<result.getBookList().size();j++){
                    if(result.getBookList().get(i).equals(book)){
                        result.getBookList().set(i, book);
                        return book;
                    }
                }
            }
        }
        return null;
    }

    public Book removeBookFromCatalog(Book book, Catalog catalog) {
        for(int i=0;i<catalogList.size();i++){
            if(catalogList.get(i).equals(catalog)){
                catalogList.get(i).removeBook(book);
                return book;
            }
        }
        return null;
    }

    public Catalog addCatalog(Catalog catalog){
        catalog.setId(catalogId);
        catalogList.add(catalog);
        catalogId++;
        return catalog;
    }

    public Catalog removeCatalog(Catalog catalog) {
        for (Iterator<Catalog> iterator = catalogList.iterator(); iterator.hasNext();) {
            Catalog result = iterator.next();
            if (result.equals(catalog)) {
                iterator.remove();
                return catalog;
            }
        }
        return null;
    }

    public List<Catalog> getCatalogList(){return catalogList;}
}
