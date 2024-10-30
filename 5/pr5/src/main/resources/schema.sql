CREATE TABLE IF NOT EXISTS usuarios(
    id SERIAL PRIMARY KEY,
    nombre varchar(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS productos(
    id SERIAL PRIMARY KEY,
    nombre varchar(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

CREATE TABLE IF NOT EXISTS pedidos(
    id SERIAL PRIMARY KEY,
    id_usuario INTEGER REFERENCES usuarios(id),
    id_producto INTEGER REFERENCES productos(id),
    cantidad INTEGER NOT NULL 
);