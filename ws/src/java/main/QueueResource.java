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
@Path("queue")
public class QueueResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of QueueResource
     */
    public QueueResource() {
    }

    /**
     * Retrieves representation of an instance of main.QueueResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     */
    @Path("/join")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse joinQueue(final BranchSession params) throws SQLException {
        return Controller.DB.joinQueue(params);
    }

    /**
     * Retrieves representation of an instance of main.QueueResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     */
    @Path("/leave")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse leaveQueue(final BranchSession params) throws SQLException {
        return Controller.DB.leaveQueue(params);
    }

    /**
     * Retrieves representation of an instance of main.QueueResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     */
    @Path("/get")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Serving getServingNumber(final BranchSession params) throws SQLException {
        return Controller.DB.getServingNumber(params);
    }

    /**
     * Retrieves representation of an instance of main.QueueResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     */
    @Path("/complete")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse serveComplete(final BranchSession params) throws SQLException {
        return Controller.DB.serveComplete(params);
    }

    /**
     * Retrieves representation of an instance of main.QueueResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     */
    @Path("/next")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse serveNext(final BranchSession params) throws SQLException {
        return Controller.DB.serveNext(params);
    }
}
