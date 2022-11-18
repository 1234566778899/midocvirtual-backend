package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.entities.Correo;

public interface CorreoRepository extends JpaRepository<Correo, Long> {
    @Query(value = "select*from correos c where c.destino=?1 order by c.fecha desc Limit 0,1",nativeQuery = true)
    Correo getCodigoByEmail(String correo);
}