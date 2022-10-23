package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.com.midocvirtual.backend.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}