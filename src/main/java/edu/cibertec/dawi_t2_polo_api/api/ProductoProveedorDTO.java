package edu.cibertec.dawi_t2_polo_api.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoProveedorDTO {
    private String nombreProducto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private String nombreProveedor;
    private String direccion;
    private String apoderadoLegal;
}