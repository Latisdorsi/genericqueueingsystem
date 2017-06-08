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
    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public LoginResponse login(final Login params) throws SQLException, StatusException {
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
    public StatusResponse logout(final Session params) throws SQLException, StatusException {
        return Controller.DB.logout(params);
    }

    /**
     * Retrieves representation of an instance of main.AccountResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws main.StatusException
     */
    @Path("/edit")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse editAccount(final EditAccount params) throws SQLException, StatusException {
        return Controller.DB.editAccount(params);
    }

    /**
     * Retrieves representation of an instance of main.AccountResource
     * @param params
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws main.StatusException
     */
    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StatusResponse createAccount(final CreateAccount params) throws SQLException, StatusException {
        return Controller.DB.createAccount(params);
    }
}
