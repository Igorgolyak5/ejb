package com.ejb.provider;

import com.ejb.exception.BookNotFoundException;
import com.ejb.exception.CatalogNotFoundException;
import com.ejb.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by Igor on 22.12.16.
 */
public class BookNotFoundExHandler implements ExceptionMapper<BookNotFoundException> {

    @Override
    public Response toResponse(BookNotFoundException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorMessage(exception.getMessage())
                ).type(MediaType.APPLICATION_JSON).build();
    }
}
