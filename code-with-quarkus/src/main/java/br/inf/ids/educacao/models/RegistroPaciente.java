package br.inf.ids.educacao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name= "rg_Paciente")
public class RegistroPaciente implements Serializable {
    @Id
    @Column(name = "registro")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rg_paciente")
    @SequenceGenerator(name = "seq_rg_paciente", sequenceName = "seq_rg_paciente", allocationSize = 1)
    private Long registro;
    private String nome;
    private String cpf;
    private String dataNasc;
    @JsonIgnore
    @OneToMany( mappedBy = "registro")
    private List<Consulta> consultas = new ArrayList<>();

    public RegistroPaciente(){
    }

    public RegistroPaciente(Long registro, String nome, String cpf, String dataNasc) {
        this.registro = registro;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

    public Long getRegistro() {
        return registro;
    }

    public void setRegistro(Long registro) {
        this.registro = registro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroPaciente that = (RegistroPaciente) o;
        return Objects.equals(registro, that.registro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registro);
    }
}
