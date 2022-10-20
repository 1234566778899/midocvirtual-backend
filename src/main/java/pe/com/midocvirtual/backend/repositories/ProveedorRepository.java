package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.midocvirtual.backend.entities.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}