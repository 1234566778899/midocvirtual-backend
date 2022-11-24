package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.entities.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByDni(String dni);
    @Query(value = "select c.id,c.dni,c.nombre,c.apellido,count(o.id) as cantidad,sum(o.total) as monto from clientes c\n" +
            "join ordenes o on c.id=o.cliente_id where o.farmacia_id=?1\n" +
            "group by c.id,c.dni,c.nombre,c.apellido\n" +
            "order by count(o.id) desc limit 30",nativeQuery = true)
    List<Object> getClientesFrecuentes(Long idFarmacia);
}