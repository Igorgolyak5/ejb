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
    private List<Catalog> catalogList;

    @PostConstruct
    private void initializeBean(){
        catalogList = new ArrayList<>();
        Catalog publics = new Catalog();
        publics.setName("Публичный");
        publics.setId(1l);
        Catalog privates = new Catalog();
        privates.setName("Закрытый");
        privates.setId(2l);
        catalogList.add(publics);
        catalogList.add(privates);
    }

    public List<Book> getBooksFromCatalog(Catalog catalog) {
        for(Catalog result: catalogList) {
            if (result.equals(catalog)) {
                return result.getBookList();
            }
        }

        return null;
    }

    public Book addBook(Book book, Catalog catalog) {
        for(int i=0;i<catalogList.size();i++){
            if(catalogList.get(i).equals(catalog)) {
                book.setId(bookId);
                book.setCatalog(catalogList.get(i));
                bookId++;
                catalogList.get(i).addBook(book);
                return book;
            }
        }
        return null;
    }

    public Book updateBook(Book book, Catalog catalog) {
        if(book.getCatalog().equals(catalog)) {
            for (int i = 0; i < catalogList.size(); i++) {
                Catalog result = catalogList.get(i);
                if (catalogList.get(i).equals(catalog)) {
                    for (int j = 0; j < result.getBookList().size(); j++) {
                        if (result.getBookList().get(i).equals(book)) {
                            book.setCatalog(result);
                            result.getBookList().set(i, book);
                            return book;
                        }
                    }
                }
            }
        } else {
            removeBookFromCatalog(book, catalog);
            addBook(book, book.getCatalog());
            return book;
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

    public List<Book> getAllBooks(){
        List<Book> result = new ArrayList<>();
        for(Catalog catalog: catalogList){
            result.addAll(catalog.getBookList());
        }

        return result;
    }

    public Book getBookById(long id){
        List<Book> result = getAllBooks();
        for(Book book: result){
            if(book.getId() == id)
                return book;
        }

        return null;
    }

    public List<Catalog> getCatalogList(){return catalogList;}
}
