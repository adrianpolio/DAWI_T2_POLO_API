package edu.cibertec.dawi_t2_polo_api.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre_proveedor", nullable = false, length = 100)
    private String nombreProveedor;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "apoderado_legal", length = 100)
    private String apoderadoLegal;

}