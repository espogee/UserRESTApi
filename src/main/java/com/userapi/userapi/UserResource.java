package com.userapi.userapi;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


/**
 * REST Web Service
 * http://localhost:8080/UserApi/webapi/users
 */

@Path("/users")
@Produces("application/json")
@Consumes("application/json")
public class UserResource {
    @EJB private UserDAO users;

    //Get all users in database
    @GET
    @Path("/")
    public Response list() {
        return Response.ok(users.allUsers()).build();
    }

    //Get a single user by id
    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") int id) {
        return Response.ok(users.getUser(id)).build();
    }

    //Create a new user
    @POST
    @Path("/")
    public Response create(@QueryParam("firstName") String firstName,
                           @QueryParam("lastName") String lastName,
                           @QueryParam("birthday") String birthday,
                           @QueryParam("email") String email,
                           @QueryParam("password") String password) {
        int newId = users.createUser(firstName, lastName, birthday, email, password);
        return Response.ok().entity("{\"User\": "+ newId + "} created successfully").build();
    }


    //Update a user in database
    @PUT
    @Path("/{id}")
    public Response update(@QueryParam("firstName") String firstName,
                           @QueryParam("lastName") String lastName,
                           @QueryParam("birthday") String birthday,
                           @QueryParam("email") String email,
                           @QueryParam("password") String password,
                           @PathParam("id") int id) {
        users.updateUser(firstName, lastName, birthday, email, password, id);
        return Response.ok().entity("{\"User\": "+ id + "} updated successfully").build();
    }

    //Delete a user in database
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        users.deleteUser(id);
        return Response.ok().entity("{\"User\": "+ id + "} deleted successfully").build();
    }

}