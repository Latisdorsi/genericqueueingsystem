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
    public ResponseStatus joinQueue(final ParamsCounterSession params) throws SQLException {
        return Controller.DB.joinQueue(params);
    }

    /**
     * Retrieves representation of an instance of main.QueueResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     */
    @Path("/join/branch")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseStatus joinQueueByBrand(final ParamsFindBranches params) throws SQLException {
        return Controller.DB.joinQueueByBrand(params);
    }

    /**
     * Retrieves representation of an instance of main.QueueResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     */
    @Path("/join/category")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseStatus joinQueueByCategory(final ParamsFindBranches params) throws SQLException {
        return Controller.DB.joinQueueByCategory(params);
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
    public ResponseStatus leaveQueue(final ParamsCounterSession params) throws SQLException {
        return Controller.DB.leaveQueue(params);
    }

    /**
     * Retrieves representation of an instance of main.QueueResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     */
    @Path("/currentqueue")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseCurrentQueue getCurrentQueue(final ParamsSession params) throws SQLException {
        return Controller.DB.getCurrentQueue(params);
    }
}
