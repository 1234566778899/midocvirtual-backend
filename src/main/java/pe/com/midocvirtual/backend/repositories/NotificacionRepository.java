package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.entities.Notificacion;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    @Query("select n from Notificacion n where n.farmaciaId=?1 and n.visto=0 order by n.fecha desc")
    List<Notificacion> getNotificaciones(Long idFarmacia);
}