package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.midocvirtual.backend.entities.Farmacia;

public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
}