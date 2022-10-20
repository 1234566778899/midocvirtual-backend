package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.midocvirtual.backend.entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}