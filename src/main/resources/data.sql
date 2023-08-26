DROP TABLE IF EXISTS ODONTOLOGO,PACIENTE,TURNO,DOMICILIO;
CREATE TABLE ODONTOLOGO
(
    id        SERIAL PRIMARY KEY,
    nombre    VARCHAR(255),
    apellido  VARCHAR(255),
    matricula VARCHAR(255)
);

CREATE TABLE PACIENTE
(
    id         SERIAL PRIMARY KEY,
    nombre     VARCHAR(255),
    apellido   VARCHAR(255),
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

CREATE TABLE DOMICILIO
(
    id          SERIAL PRIMARY KEY,
    calle       VARCHAR(255),
    numero      VARCHAR(255),
    localidad   VARCHAR(255),
    provincia   VARCHAR(255),
    paciente_id int,
    FOREIGN KEY (paciente_id) REFERENCES PACIENTE (id) ON DELETE CASCADE
);