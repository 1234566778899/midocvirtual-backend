package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.entities.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query("select s.producto from Stock s where s.farmacia.id=?1")
    List<Producto> findAllInStockByFarmaciaId(Long idFarmacia);
}