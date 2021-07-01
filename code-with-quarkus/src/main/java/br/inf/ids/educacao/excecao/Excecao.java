package br.inf.ids.educacao.excecao;

public class Excecao extends RuntimeException{

    public Excecao(Object registro){
        super("Paciente não encontrado " + registro);
    }
}
