create sequence seq_rg_paciente;
CREATE TABLE rg_Paciente(
    registro BIGINT PRIMARY KEY,
    nome VARCHAR(99) NOT NULL,
    cpf VARCHAR(99) not null,
    dataNasc VARCHAR(99)
);

create sequence seq_consulta;

CREATE TABLE Consulta(
    numeroCOnsulta BIGINT PRIMARY KEY,
    exames VARCHAR(200),
    diagnosticos VARCHAR(200),
    medicamentos VARCHAR(200)
);

CREATE TABLE Triagem(
    id BIGINT PRIMARY KEY,
    peso FLOAT,
    altura FLOAT,
    pressao FLOAT
);