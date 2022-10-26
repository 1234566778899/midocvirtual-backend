package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.entities.Orden;

import java.util.Date;
import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
    @Query("select o from Orden o where o.farmacia.id=?1 order by o.fecha desc")
    List<Orden> findAllByFarmaciaId(Long idFarmacia);
    @Query("select SUM(o.total) from Orden o where o.fecha>=?1 and o.fecha<=?2")
    Double totalIngresosEntreFechas(Date inicio,Date fin);
    @Query("select count(o.id) from Orden o where o.fecha>=?1 and o.fecha<=?2")
    Double cantidadVentasEntreFechas(Date inicio,Date fin);
}