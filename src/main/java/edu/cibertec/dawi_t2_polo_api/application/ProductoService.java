package edu.cibertec.dawi_t2_polo_api.application;

import edu.cibertec.dawi_t2_polo_api.api.*;
import edu.cibertec.dawi_t2_polo_api.domain.Producto;
import edu.cibertec.dawi_t2_polo_api.infrastructure.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public boolean eliminarProducto(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        if (producto.isPresent()) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<ProductoProveedorDTO> listarProductosPorProveedor(String criterio, String valor) {
        List<Producto> productos;

        switch (criterio.toLowerCase()) {
            case "id":
                productos = productoRepository.findByProveedorId(Long.parseLong(valor));
                break;
            case "nombre_proveedor":
                productos = productoRepository.findByProveedorNombre(valor);
                break;
            case "direccion":
                productos = productoRepository.findByProveedorDireccion(valor);
                break;
            case "apoderado_legal":
                productos = productoRepository.findByProveedorApoderado(valor);
                break;
            default:
                throw new IllegalArgumentException("Criterio no válido: " + criterio);
        }

        return productos.stream()
                .map(p -> new ProductoProveedorDTO(
                        p.getNombreProducto(),
                        p.getCantidad(),
                        p.getPrecioUnitario(),
                        p.getProveedor().getNombreProveedor(),
                        p.getProveedor().getDireccion(),
                        p.getProveedor().getApoderadoLegal()
                ))
                .collect(Collectors.toList());
    }
}