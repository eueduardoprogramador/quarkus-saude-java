package br.inf.ids.educacao.rest;

import br.inf.ids.educacao.models.Consulta;
import br.inf.ids.educacao.resources.ConsultaResource;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/consulta")
public class ConsultaRest {

    @Inject
    ConsultaResource ConsultaResource;

    @POST
    @Path("/cadastrarConsulta")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Consulta cadastrarConsulta(Consulta Consulta) {
        return ConsultaResource.cadastrarConsulta(Consulta);
    }


    @GET
    @Path("/numeroConsulta")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Consulta buscarPorNumeroConsulta(@PathParam("numeroConsulta")Long numeroConsulta){
        return ConsultaResource.buscarPorNumeroConsulta(numeroConsulta);
    }


    @PUT
    @Path("/atualizarConsulta")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarConsulta(Consulta Consulta){
        ConsultaResource.atualizarConsulta(Consulta);
    }

    @DELETE
    @Path("/deletarconsulta/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarconsulta(@PathParam("numeroConsulta")Long numeroConsulta){
        ConsultaResource.deletarConsulta(numeroConsulta);
    }

}
