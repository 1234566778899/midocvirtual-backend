package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.midocvirtual.backend.entities.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}