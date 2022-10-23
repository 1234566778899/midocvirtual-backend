package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.midocvirtual.backend.entities.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
}