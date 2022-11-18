package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.entities.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByDni(String dni);
    @Query("select o.cliente.id,o.cliente.dni,o.cliente.nombre,o.cliente.apellido,count(o.id),sum(o.total)\n" +
            "from Orden o where o.farmacia.id=?1 \n" +
            "group by o.cliente.id,o.cliente.dni,o.cliente.nombre,o.cliente.apellido \n" +
            "order by count(o.id) desc")
    List<Object> getClientesFrecuentes(Long idFarmacia);
}