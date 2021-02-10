package fr.polytech.TPRest.Servlet;

import fr.polytech.TPRest.Servlet.DBManager.MonstresManager;

import javax.servlet.http.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/hello")
public class HelloServlet extends HttpServlet {

    private static List<Monstres> monsters;
    static{
        monsters = new ArrayList<>();
    }

    @POST
    @Path("/monstres")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Monstres createMonstres(Monstres monstres)
    {
        MonstresManager mm = new MonstresManager();
        return mm.create(monstres);
    }
    
    @PUT
    @Path("/monstres")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Monstres updateMonstres(Monstres monstres)
    {
        MonstresManager mm = new MonstresManager();
        return mm.update(monstres);
    }

    @GET
    @Path("/monstres")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Monstres> getMonstres(){
        MonstresManager mm = new MonstresManager();
        return mm.getAll();
    }
    @DELETE
    @Path("/monstres")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePokemon(Monstres monstres) {
        MonstresManager pm = new MonstresManager();
        return pm.delete(monstres);
    }
}