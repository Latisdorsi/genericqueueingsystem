/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.sql.SQLException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Jerico Manapsal
 */
@Path("counter")
public class CounterResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CounterResource
     */
    public CounterResource() {
    }

    /**
     * Retrieves representation of an instance of main.CounterResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     */
    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseStatus createCounter(final ParamsCreateCounter params) throws SQLException {
        return Controller.DB.createCounter(params);
    }

    /**
     * Retrieves representation of an instance of main.CounterResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     */
    @Path("/edit")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseStatus editCounter(final ParamsEditCounter params) throws SQLException {
        return Controller.DB.editCounter(params);
    }

    /**
     * Retrieves representation of an instance of main.CounterResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     */
    @Path("/delete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseStatus deleteCounter(final ParamsIDSession params) throws SQLException {
        return Controller.DB.deleteCounter(params);
    }
}
