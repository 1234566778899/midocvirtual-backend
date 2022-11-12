package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.dto.ReporteSemanalDTO;
import pe.com.midocvirtual.backend.entities.Orden;

import java.util.Date;
import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
    @Query("select o from Orden o where o.farmacia.id=?1 order by o.fecha desc")
    List<Orden> findAllByFarmaciaId(Long idFarmacia);
    @Query(value = "select sum(o.total) as total,count(o.id) as cantidad from ordenes o \n" +
            "where o.farmacia_id=1 and o.fecha>=?2 and o.fecha<=?3",nativeQuery = true)
    Object IngresosEntreFechas(Long idFarmacia,Date inicio,Date fin);
    @Query("select o from Orden o where datediff(now(),o.fecha)<=3 and o.farmacia.id=?1 order by o.fecha desc")
    List<Orden> findAllUltimos3Dias(Long idFarmacia);
    @Query( "select o.fecha as fecha,sum(o.total) as total from Orden o \n" +
            "where o.farmacia.id=?1 and o.fecha>=?2 and o.fecha<=?3 group by o.fecha")
    List<Object> getOrdenesReporteSemanal(Long idFarmacia, Date inicio, Date fin);
}