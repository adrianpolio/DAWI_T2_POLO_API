package edu.cibertec.dawi_t2_polo_api.application;

import edu.cibertec.dawi_t2_polo_api.domain.Proveedor;
import edu.cibertec.dawi_t2_polo_api.infrastructure.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }
}