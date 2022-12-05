package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.entities.Orden;

import java.util.Date;
import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
    @Query("select o from Orden o where o.farmacia.id=?1 order by o.fecha desc")
    List<Orden> findAllByFarmaciaId(Long idFarmacia);
    @Query(value = "select sum(o.total) as total,count(o.id) as cantidad from ordenes o \n" +
            "where o.farmacia_id=?1 and o.fecha>=?2 and o.fecha<=?3",nativeQuery = true)
    Object IngresosEntreFechas(Long idFarmacia,Date inicio,Date fin);
    @Query( "select o.fecha as fecha,sum(o.total) as total from Orden o \n" +
            "where o.farmacia.id=?1 and o.fecha>=?2 and o.fecha<=?3 group by o.fecha order by o.fecha asc")
    List<Object> getOrdenesReporteSemanal(Long idFarmacia, Date inicio, Date fin);
    @Query("select month(o.fecha) as mes,sum(o.total) as total from Orden o \n" +
            "where o.farmacia.id=?1 and o.fecha>=?2 and o.fecha<=?3 group by month(o.fecha) order by o.fecha asc")
    List<Object> getGananciasMensuales(Long idFarmacia,Date inicio,Date fin);
    @Query(value = "select d.producto_id,p.nombre,p.presentacion,sum(cantidad) as cantidad \n" +
            "from detalle_venta d \n" +
            "join ordenes o on d.orden_id=o.id \n" +
            "join productos p on p.id=d.producto_id\n" +
            "where o.farmacia_id=?1\n" +
            "group by d.producto_id,p.nombre,p.presentacion order by cantidad desc limit 5",nativeQuery = true)
    List<Object> getProductoMasVendidos(Long idFarmacia);
}