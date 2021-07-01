package br.inf.ids.educacao.resources;

import br.inf.ids.educacao.excecao.ConsultaException;
import br.inf.ids.educacao.models.Consulta;
import br.inf.ids.educacao.models.RegistroPaciente;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RequestScoped
public class ConsultaResource {

    @Inject
    EntityManager entityManager;
    public Consulta cadastrarConsulta(Consulta consulta){
        entityManager.persist(consulta);
        entityManager.flush();
        return consulta;
    }



    public Consulta buscarPorNumeroConsulta(Long numeroConsulta){
        Consulta Consulta;
        Consulta = entityManager.find(Consulta.class, numeroConsulta);
        return Consulta;
    }



    public void atualizarConsulta(Consulta consulta){
        entityManager.merge(consulta);
        entityManager.flush();
    }

    public void deletarConsulta (Long numeroConsulta){
        try {
            Consulta consulta = buscarPorNumeroConsulta(numeroConsulta);
            entityManager.remove(consulta);
            entityManager.flush();
        }catch (IllegalArgumentException e){
            throw new ConsultaException(numeroConsulta);
        }
    }
}
