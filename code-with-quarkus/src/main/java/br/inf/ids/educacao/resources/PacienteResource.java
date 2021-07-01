package br.inf.ids.educacao.resources;

import br.inf.ids.educacao.excecao.Excecao;
import br.inf.ids.educacao.models.RegistroPaciente;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RequestScoped
public class PacienteResource {

    @Inject
    EntityManager entityManager;
    public RegistroPaciente cadastrarPaciente(RegistroPaciente registroPaciente){
        entityManager.persist(registroPaciente);
        entityManager.flush();
        return registroPaciente;
    }


    public RegistroPaciente buscarPacientePorRegistro(Long registro){
        RegistroPaciente RegistroPaciente;
        RegistroPaciente = entityManager.find(RegistroPaciente.class, registro);
        return RegistroPaciente;
    }

    public void atualizarPaciente(RegistroPaciente RegistroPaciente){
        entityManager.merge(RegistroPaciente);
        entityManager.flush();
    }

    public void deletarPacientePorRegistro(Long registro){
        try {
            RegistroPaciente RegistroPaciente = buscarPacientePorRegistro(registro);
            entityManager.remove(RegistroPaciente);
            entityManager.flush();
        }catch (IllegalArgumentException e){
            throw new Excecao(registro);
        }
    }
}
