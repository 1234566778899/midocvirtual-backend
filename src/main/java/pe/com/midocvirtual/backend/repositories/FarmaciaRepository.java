package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.midocvirtual.backend.entities.Farmacia;

import java.util.List;
import java.util.Objects;

public interface FarmaciaRepository extends JpaRepository<Farmacia, Long> {
    Farmacia findByCorreo(String correo);
}