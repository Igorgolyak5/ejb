package com.ejb.service;

import com.ejb.model.Book;
import com.ejb.model.Catalog;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Igor on 17.12.16.
 */
@Remote
public interface CatalogRemote {
    List<Book> getBooksFromCatalog(Catalog catalog);
    Book addBook(Book book, Catalog catalog);
    Book removeBookFromCatalog(Book book, Catalog catalog);
    Book updateBook(Book book, Catalog catalog);
    List<Catalog> getCatalogList();
    List<Book> getAllBooks();
    Book getBookById(long id);
}
