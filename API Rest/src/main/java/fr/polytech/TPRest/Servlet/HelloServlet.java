package fr.polytech.TPRest.Servlet;


import java.io.*;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloServlet extends HttpServlet {

	public static List<pokemon> pokemons = new ArrayList<>();
	static {
		pokemons.add(new pokemon("pikachu",25));
		pokemons.add(new pokemon("salameche",150));
		pokemons.add(new pokemon("dracofeu",255222));
		pokemons.add(new pokemon("coucou",25888888));
		pokemons.add(new pokemon("pigeon",1));
		pokemons.add(new pokemon("the best",257));
	}
    @GET
    @Path("sayHello")
    public String sayHello() {
        return "hello";
    }
    
    @GET
    @Path("bonjour")
    public String bonjour() {
    	return "bonjou";
    }

    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(person person) {
    	return Response.ok().entity(person).cookie(new NewCookie("person", person.toString())).build();
    }
    
    @GET
    @Path("get")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson() {
    	person perso1 = new person("florent2", "lespinasse2");
    	return Response.ok().entity(perso1).cookie(new NewCookie("person", perso1.toString())).build();
    }
    
    @POST
    @Path("addPokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPokemon(pokemon Poke1) {
    	pokemons.add(Poke1);
    	return Response.ok().entity(Poke1).cookie(new NewCookie("person", Poke1.toString())).build();
    }
    
    @GET
    @Path("countPokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response countPokemon() {
    	Integer nb_pokemon = pokemons.size();
    	String poke = nb_pokemon.toString();
    	return Response.ok().entity(poke).cookie(new NewCookie("nb_pokemon", poke)).build();
    }
    
    @PUT
    @Path("editPokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPokemon(String nom, int niveau) {
    	for( pokemon poke : pokemons) {
    		if(poke.getNom().equals(nom)) {
    			poke.setNiveau(niveau);
    			return Response.ok().entity(poke).cookie(new NewCookie("pokemon", poke.toString())).build();
    		}
    	}
    	return Response.ok("pokemon non trouvé").build();
    }
    
    @DELETE
    @Path("delPokemon")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delPokemon(String nom) {
    	for(pokemon poke : pokemons) {
    		if(poke.getNom().equals(nom)) {
    			return Response.ok().entity(pokemons).cookie(new NewCookie("pokemons", pokemons.toString())).build();
    		}
    	}
    	return Response.ok("pokemon non trouvé").build();
    }
}
