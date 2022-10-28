package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.entities.DetalleVenta;

import java.util.List;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
    @Query("select d from DetalleVenta d where d.orden.farmacia.id=?1")
    List<DetalleVenta> findAllByFarmaciaId(Long idFarmacia);
}