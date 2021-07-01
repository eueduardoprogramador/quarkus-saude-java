package br.inf.ids.educacao.rest;


import br.inf.ids.educacao.models.Triagem;
import br.inf.ids.educacao.resources.TriagemResource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
@Path("/triagem")
public class TriagemRest {


    @Inject
    TriagemResource TriagemResource;

    @POST
    @Path("/registrarTriagem")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Triagem cadastrarTriagem(Triagem Triagem){
        return TriagemResource.cadastrarTriagem(Triagem);
    }


    @GET
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Triagem buscarPacientePorId(@PathParam("id") Long id){
        return TriagemResource.buscarTriagemPorId(id);
    }

    @PUT
    @Path("/atualizarTriagem")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarTriagem(Triagem Triagem){
        TriagemResource.atualizarTriagem(Triagem);
    }

    @DELETE
    @Path("/deletarTriagem/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarTriagemPorId(@PathParam("id") Long id){
        TriagemResource.DeletarTriagemPorId(id);
    }
}




