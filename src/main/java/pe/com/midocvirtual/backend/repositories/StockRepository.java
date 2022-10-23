package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.entities.Stock;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    @Query("select s from Stock s where s.farmacia.id=?1")
    List<Stock> findAllByFarmaciaId(Long id);
}