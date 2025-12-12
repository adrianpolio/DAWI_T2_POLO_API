package edu.cibertec.dawi_t2_polo_api.infrastructure;

import edu.cibertec.dawi_t2_polo_api.domain.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}