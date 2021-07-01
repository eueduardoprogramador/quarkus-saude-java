package br.inf.ids.educacao.rest;

import br.inf.ids.educacao.models.RegistroPaciente;
import br.inf.ids.educacao.resources.PacienteResource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/paciente")
public class PacienteRest {

    @Inject
    PacienteResource pacienteResource;

    @POST
    @Path("/registrarPaciente")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public RegistroPaciente cadastrarAluno(RegistroPaciente registroPaciente){
        return pacienteResource.cadastrarPaciente(registroPaciente);
    }


    @GET
    @Path("/{registro}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public RegistroPaciente buscarPacientePorRegistro(@PathParam("registro") Long registro){
        return pacienteResource.buscarPacientePorRegistro(registro);
    }

    @PUT
    @Path("/atualizarPaciente/{registro}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void atualizarPaciente(RegistroPaciente RegistroPaciente){
        pacienteResource.atualizarPaciente(RegistroPaciente);
    }

    @DELETE
    @Path("/deletarPaciente/{registro}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarPacientePorRegistro(@PathParam("registro") Long registro){
        pacienteResource.deletarPacientePorRegistro(registro);
    }
}

