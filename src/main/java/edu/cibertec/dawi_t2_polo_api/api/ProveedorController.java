package edu.cibertec.dawi_t2_polo_api.api;

import edu.cibertec.dawi_t2_polo_api.api.ApiResponse;
import edu.cibertec.dawi_t2_polo_api.domain.Proveedor;
import edu.cibertec.dawi_t2_polo_api.application.ProveedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Proveedor>>> listarProveedores() {
        try {
            List<Proveedor> proveedores = proveedorService.listarProveedores();
            ApiResponse<List<Proveedor>> response = new ApiResponse<>(
                    true,
                    "Proveedores listados exitosamente",
                    proveedores
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<List<Proveedor>> response = new ApiResponse<>(
                    false,
                    "Error al listar proveedores: " + e.getMessage(),
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
