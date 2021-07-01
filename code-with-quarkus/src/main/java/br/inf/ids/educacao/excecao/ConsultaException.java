package br.inf.ids.educacao.excecao;

public class ConsultaException extends RuntimeException{

    public ConsultaException(Object idconsulta){
        super("Id da consulta não encontrado: " + idconsulta);
    }
}
