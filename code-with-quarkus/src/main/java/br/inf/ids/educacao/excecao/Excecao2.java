package br.inf.ids.educacao.excecao;

public class Excecao2 extends RuntimeException{

    public Excecao2(Object numeroConsulta){
        super("Paciente não encontrado " + numeroConsulta);
    }
}
