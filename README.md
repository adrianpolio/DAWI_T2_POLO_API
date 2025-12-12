## DAWI_T2_POLO_API

__Pregunta 1__: webappt2.sql
```sql
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

```

__Pregunta 2__: 
listarProductos
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/7522a7d0-d4c8-47e1-8e54-b1f5d50876e6" />
listarProveedores
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/525e9ef8-d61a-4ac8-bf26-6800471e92ae" />
agregarProductos
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/33b53285-3d5a-4d8c-ad4e-b5ac1e364552" />
eliminarProductos
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/a509dce9-a4a1-4bb8-9ab9-d11f661e2ffa" />

__Pregunta 3__: 
listarProductosPorProveedor

http://localhost:8080/api/productos/por-proveedor?criterio=id&valor=1
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/2073113d-a577-429d-ac45-3dbd2b86a537" />

http://localhost:8080/api/productos/por-proveedor?criterio=apoderado_legal&valor=Juan
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/752feef0-69d0-492b-a1fa-51f5e32440df" />

http://localhost:8080/api/productos/por-proveedor?criterio=direccion&valor=Lima
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/4ca0e068-ac20-401b-b29e-7a7e2e6d47a1" />

http://localhost:8080/api/productos/por-proveedor?criterio=nombre_proveedor&valor=Norte
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/7202a8fb-ce1c-465d-8685-f92ec4bffa01" />


__Extra__:
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/b27ab731-a677-4781-b208-149c8b2a4356" />

