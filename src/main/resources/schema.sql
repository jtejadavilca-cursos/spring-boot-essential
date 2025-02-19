CREATE TABLE reunion (
    id BIGSERIAL PRIMARY KEY,
    asunto VARCHAR(128) NOT NULL,
    fecha DATETIME NOT NULL
);

CREATE TABLE persona(
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(128) NOT NULL,
    apellidos VARCHAR(128) NOT NULL
);

CREATE TABLE asistente (
    reunion_id BIGSERIAL NOT NULL,
    persona_id BIGSERIAL NOT NULL,
    PRIMARY KEY (reunion_id, persona_id),
    FOREIGN KEY (reunion_id) REFERENCES reunion(id),
    FOREIGN KEY (persona_id) REFERENCES persona(id)
);