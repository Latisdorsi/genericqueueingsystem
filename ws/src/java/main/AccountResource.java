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
@Path("account")
public class AccountResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AccountResource
     */
    public AccountResource() {
    }

    /**
     * Retrieves representation of an instance of main.AccountResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws main.StatusException
     */
    @Path("/create/customer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse createCustomer(final ParamsCreateCustomer params) throws SQLException, StatusException {
        return Controller.DB.createCustomer(params);
    }

    /**
     * Retrieves representation of an instance of main.AccountResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws main.StatusException
     */
    @Path("/create/manager")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse createManager(final ParamsAccountInfo params) throws SQLException, StatusException {
        return Controller.DB.createManager(params);
    }

    /**
     * Retrieves representation of an instance of main.AccountResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws main.StatusException
     */
    @Path("/edit/customer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse editCustomer(final ParamsAccountInfo params) throws SQLException, StatusException {
        return Controller.DB.editCustomer(params);
    }

    /**
     * Retrieves representation of an instance of main.AccountResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws main.StatusException
     */
    @Path("/edit/manager")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse editManager(final ParamsAccountInfo params) throws SQLException, StatusException {
        return Controller.DB.editManager(params);
    }

    /**
     * Retrieves representation of an instance of main.AccountResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws main.StatusException
     */
    @Path("/delete/customer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse deleteCustomer(final ParamsDeleteAccount params) throws SQLException, StatusException {
        return Controller.DB.deleteCustomer(params);
    }

    /**
     * Retrieves representation of an instance of main.AccountResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws main.StatusException
     */
    @Path("/delete/manager")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse deleteManager(final ParamsDeleteAccount params) throws SQLException, StatusException {
        return Controller.DB.deleteManager(params);
    }

    /**
     * Retrieves representation of an instance of main.AccountResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws main.StatusException
     */
    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseLogin login(final ParamsLogin params) throws SQLException, StatusException {
        return Controller.DB.login(params);
    }

    /**
     * Retrieves representation of an instance of main.AccountResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws main.StatusException
     */
    @Path("/logout")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse logout(final ParamsSession params) throws SQLException, StatusException {
        return Controller.DB.logout(params);
    }
}
