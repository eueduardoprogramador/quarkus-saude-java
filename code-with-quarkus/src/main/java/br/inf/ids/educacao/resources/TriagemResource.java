package br.inf.ids.educacao.resources;
import br.inf.ids.educacao.excecao.Excecao;
import br.inf.ids.educacao.models.RegistroPaciente;
import br.inf.ids.educacao.models.Triagem;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RequestScoped
public class TriagemResource {


    @Inject
    EntityManager entityManager;
    public Triagem cadastrarTriagem(Triagem Triagem){
        entityManager.persist(Triagem);
        entityManager.flush();
        return Triagem;
    }



    public Triagem buscarTriagemPorId(Long id){
        Triagem Triagem;
        Triagem = entityManager.find(Triagem.class, id);
        return Triagem;
    }

    public void atualizarTriagem(Triagem Triagem){
        entityManager.merge(Triagem);
        entityManager.flush();

        }

    public void DeletarTriagemPorId (Long id){
        try {
            Triagem triagem = buscarTriagemPorId(id);
            entityManager.remove(triagem);
            entityManager.flush();
        }catch (IllegalArgumentException e){
            throw new Excecao(id);
        }
    }
    }

