package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.midocvirtual.backend.entities.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}