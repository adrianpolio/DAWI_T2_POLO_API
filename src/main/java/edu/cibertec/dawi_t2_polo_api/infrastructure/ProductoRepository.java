package edu.cibertec.dawi_t2_polo_api.infrastructure;

import edu.cibertec.dawi_t2_polo_api.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Consulta para P3 "listar productos "por proveedor"
    @Query("SELECT p FROM Producto p WHERE p.proveedor.id = :proveedorId")
    List<Producto> findByProveedorId(@Param("proveedorId") Long proveedorId);

    @Query("SELECT p FROM Producto p WHERE p.proveedor.nombreProveedor LIKE %:nombre%")
    List<Producto> findByProveedorNombre(@Param("nombre") String nombre);

    @Query("SELECT p FROM Producto p WHERE p.proveedor.direccion LIKE %:direccion%")
    List<Producto> findByProveedorDireccion(@Param("direccion") String direccion);

    @Query("SELECT p FROM Producto p WHERE p.proveedor.apoderadoLegal LIKE %:apoderado%")
    List<Producto> findByProveedorApoderado(@Param("apoderado") String apoderado);
}