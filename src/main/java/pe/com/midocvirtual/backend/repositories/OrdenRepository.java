package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.entities.Orden;

import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
    @Query("select o from Orden o where o.farmacia.id=?1")
    List<Orden> findAllByFarmaciaId(Long idFarmacia);
}