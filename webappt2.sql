DROP DATABASE IF EXISTS webappt2;
CREATE DATABASE webappt2;
USE webappt2;

CREATE TABLE proveedores (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_proveedor VARCHAR(100) NOT NULL,
    direccion VARCHAR(200),
    apoderado_legal VARCHAR(100)
);

CREATE TABLE productos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_producto VARCHAR(100) NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    proveedor_id BIGINT,
    FOREIGN KEY (proveedor_id) REFERENCES proveedores(id)
);

INSERT INTO proveedores (nombre_proveedor, direccion, apoderado_legal) VALUES
('Distribuidora Norte SAC', 'Av. Los Olivos 123, Lima', 'Juan Pérez García'),
('Importaciones del Sur EIRL', 'Jr. Comercio 456, Arequipa', 'María Torres López'),
('Proveedores Unidos SA', 'Calle Industrial 789, Callao', 'Carlos Mendoza Ruiz');

INSERT INTO productos (nombre_producto, cantidad, precio_unitario, proveedor_id) VALUES
('Laptop HP Pavilion', 15, 2500.00, 1),
('Mouse Logitech', 50, 35.00, 1),
('Teclado Mecánico', 30, 150.00, 2),
('Monitor Samsung 24"', 20, 800.00, 2),
('Impresora Epson', 10, 450.00, 3),
('Webcam HD', 25, 120.00, 3);