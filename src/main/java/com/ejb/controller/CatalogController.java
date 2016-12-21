package com.ejb.controller;

import com.ejb.exception.CatalogNotFoundException;
import com.ejb.model.Book;
import com.ejb.model.Catalog;
import com.ejb.model.CatalogContainer;
import com.ejb.service.CatalogRemote;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

/**
 * Created by Igor on 18.12.16.
 */
@Singleton
@Path("/")
@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
@Consumes(MediaType.APPLICATION_JSON)
public class CatalogController {

    @EJB
    CatalogRemote catalogService;

    @POST @Path("/add/{nameCatalog}")
    public Catalog addCatalog(@PathParam("nameCatalog") String name){
        return catalogService.addCatalog(new Catalog(name));
    }

    @POST @Path("remove")
    public Response removeCatalog(Catalog catalog) throws CatalogNotFoundException {
        Catalog result = catalogService.removeCatalog(catalog);
        if(result == null)
            throw new CatalogNotFoundException("Catalog was not found");

        return Response.ok().entity(result).build();
    }

    @GET
    public Collection<Catalog> getCatalogs(){
        return catalogService.getCatalogList();
    }

    @POST @Path("book/add")
    public Response addBook(CatalogContainer catalogContainer) throws CatalogNotFoundException {
        Book result = catalogService.addBook(catalogContainer.getBook(), catalogContainer.getCatalog());
        if(result == null)
            throw new CatalogNotFoundException("Catalog was not found");

        return Response.ok().entity(result).build();
    }

    @POST @Path("book/remove")
    public Response removeBookByName(CatalogContainer catalogContainer) throws CatalogNotFoundException {
        Book result = catalogService.removeBookFromCatalog(catalogContainer.getBook(), catalogContainer.getCatalog());
        if(result == null)
            throw new CatalogNotFoundException("Catalog was not found");

        return Response.ok().entity(result).build();
    }

    @GET @Path("book")
    public Response getBooks(@QueryParam("catalogId") long id) throws CatalogNotFoundException {
        Catalog catalog = new Catalog();
        catalog.setId(id);
        List<Book> result = catalogService.getBooksFromCatalog(catalog);
        if(result == null)
            throw new CatalogNotFoundException("Catalog was not found");

        return Response.ok().entity(result).build();
    }

    @POST @Path("book/update")
    public Response updateBook(CatalogContainer catalogContainer) throws CatalogNotFoundException {
        Book result = catalogService.updateBook(catalogContainer.getBook(),catalogContainer.getCatalog());
        if(result == null)
            throw new CatalogNotFoundException("book or catalog was not found");

        return Response.ok().entity(result).build();
    }
}
