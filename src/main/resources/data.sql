DROP TABLE IF EXISTS ODONTOLOGO,PACIENTE,TURNO;
CREATE TABLE ODONTOLOGO
(
    id        SERIAL PRIMARY KEY,
    matricula VARCHAR(255),
    nombre    VARCHAR(255),
    apellido  VARCHAR(255)
);

CREATE TABLE PACIENTE
(
    id         SERIAL PRIMARY KEY,
    nombre     VARCHAR(255),
    apellido   VARCHAR(255),
    domicilio  VARCHAR(255),
    dni        VARCHAR(255),
    fecha_alta VARCHAR(255)
);

CREATE TABLE TURNO
(
    id            SERIAL PRIMARY KEY,
    paciente_id   int,
    odontologo_id int,
    fecha_hora    VARCHAR(255),
    FOREIGN KEY (paciente_id) REFERENCES PACIENTE (id),
    FOREIGN KEY (odontologo_id) REFERENCES ODONTOLOGO (id)
);