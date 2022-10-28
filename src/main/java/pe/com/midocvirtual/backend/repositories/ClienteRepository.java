package pe.com.midocvirtual.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.midocvirtual.backend.entities.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findByDni(String dni);
    //@Query(value = "select c.id,c.apellido,c.nombre,c.dni,o.cantidad from clientes c join\n" +
     //       "(select * from (select o.cliente_id,count(o.cliente_id) 'cantidad' from ordenes o \n" +
     //       "group by o.cliente_id order by count(o.cliente_id) desc) s limit 30) o on c.id=o.cliente_id",nativeQuery = true)
    @Query("select o.cliente.id,o.cliente.dni,o.cliente.nombre,o.cliente.apellido,count(o.id),sum(o.total) " +
            "from Orden o " +
            "group by o.cliente.id,o.cliente.dni,o.cliente.nombre,o.cliente.apellido " +
            "order by count(o.id) desc")
    public List<Object> getClientesFrecuentes();
}