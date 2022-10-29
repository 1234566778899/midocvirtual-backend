package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.entities.Consulta;

import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query("select c from Consulta c order by c.fecha desc")
    List<Consulta> findAllOrderByFechaDesc();
}