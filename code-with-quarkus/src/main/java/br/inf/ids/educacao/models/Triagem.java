package br.inf.ids.educacao.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name= "Triagem")
public class Triagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double peso;
    private Double altura;
    private Double pressao;
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private RegistroPaciente registro;

    public Triagem() {
    }


    public Triagem(Long id, RegistroPaciente registro, Double peso, Double altura, Double pressao) {
        this.id = id;
        this.registro = registro;
        this.peso = peso;
        this.altura = altura;
        this.pressao = pressao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegistroPaciente getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroPaciente registro) {
        this.registro = registro;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPressao() {
        return pressao;
    }

    public void setPressao(Double pressao) {
        this.pressao = pressao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


