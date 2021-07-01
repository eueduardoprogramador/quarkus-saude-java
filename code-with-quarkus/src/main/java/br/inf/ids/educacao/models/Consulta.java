package br.inf.ids.educacao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="Consulta")
public class Consulta implements Serializable {
    @Id
    @Column(name = "numeroCOnsulta")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rg_paciente")
    @SequenceGenerator(name = "seq_rg_paciente", sequenceName = "seq_rg_paciente", allocationSize = 1)
    private Long numeroConsulta;
    private String exames;
    private String diagnosticos;
    private String medicamentos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "registropacienteid")
    private RegistroPaciente registro;

    public Consulta(){
    }

    public Consulta(String exames, String diagnosticos, String medicamentos, RegistroPaciente registro) {
        this.exames = exames;
        this.diagnosticos = diagnosticos;
        this.medicamentos = medicamentos;
        this.registro = registro;
    }

    public Long getNumeroConsulta() {
        return numeroConsulta;
    }

    public void setNumeroConsulta(Long numeroConsulta) {
        this.numeroConsulta = numeroConsulta;
    }

    public String getExames() {
        return exames;
    }

    public void setExames(String exames) {
        this.exames = exames;
    }

    public String getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(String diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public RegistroPaciente getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroPaciente registro) {
        this.registro = registro;
    }

}
