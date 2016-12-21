package com.ejb.provider;

import com.ejb.exception.CatalogNotFoundException;
import com.ejb.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Igor on 19.12.16.
 */
@Provider
public class CatalogNotFoundExHandler implements ExceptionMapper<CatalogNotFoundException> {
    @Override
    public Response toResponse(CatalogNotFoundException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorMessage(exception.getMessage())
                ).type(MediaType.APPLICATION_JSON).build();
    }
}
