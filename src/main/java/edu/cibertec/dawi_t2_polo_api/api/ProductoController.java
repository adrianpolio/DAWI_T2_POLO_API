package edu.cibertec.dawi_t2_polo_api.api;

import edu.cibertec.dawi_t2_polo_api.api.ApiResponse;
import edu.cibertec.dawi_t2_polo_api.api.ProductoProveedorDTO;
import edu.cibertec.dawi_t2_polo_api.domain.Producto;
import edu.cibertec.dawi_t2_polo_api.application.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Producto>>> listarProductos() {
        try {
            List<Producto> productos = productoService.listarProductos();
            ApiResponse<List<Producto>> response = new ApiResponse<>(
                    true,
                    "Productos listados exitosamente",
                    productos
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<List<Producto>> response = new ApiResponse<>(
                    false,
                    "Error al listar productos: " + e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Producto>> agregarProducto(@RequestBody Producto producto) {
        try {
            Producto nuevoProducto = productoService.agregarProducto(producto);
            ApiResponse<Producto> response = new ApiResponse<>(
                    true,
                    "Producto agregado exitosamente",
                    nuevoProducto
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            ApiResponse<Producto> response = new ApiResponse<>(
                    false,
                    "Error al agregar producto: " + e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> eliminarProducto(@PathVariable Long id) {
        try {
            boolean eliminado = productoService.eliminarProducto(id);
            if (eliminado) {
                ApiResponse<Void> response = new ApiResponse<>(
                        true,
                        "Producto eliminado exitosamente"
                );
                return ResponseEntity.ok(response);
            } else {
                ApiResponse<Void> response = new ApiResponse<>(
                        false,
                        "Producto no encontrado con ID: " + id
                );
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            ApiResponse<Void> response = new ApiResponse<>(
                    false,
                    "Error al eliminar producto: " + e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/por-proveedor")
    public ResponseEntity<ApiResponse<List<ProductoProveedorDTO>>> listarProductosPorProveedor(
            @RequestParam String criterio,
            @RequestParam String valor) {
        try {
            List<ProductoProveedorDTO> productos = productoService.listarProductosPorProveedor(criterio, valor);
            ApiResponse<List<ProductoProveedorDTO>> response = new ApiResponse<>(
                    true,
                    "Productos por proveedor listados exitosamente",
                    productos
            );
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            ApiResponse<List<ProductoProveedorDTO>> response = new ApiResponse<>(
                    false,
                    e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } catch (Exception e) {
            ApiResponse<List<ProductoProveedorDTO>> response = new ApiResponse<>(
                    false,
                    "Error al listar productos: " + e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}