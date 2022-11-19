package pe.com.midocvirtual.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import pe.com.midocvirtual.backend.dto.ClienteFrecuente;
import pe.com.midocvirtual.backend.entities.Cliente;
import pe.com.midocvirtual.backend.repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteServices {
    public List<Cliente> getClientes();
    public Cliente getClienteByDni(String dni);
    public Cliente addCliente(Cliente cliente);
    public List<Object> clientesFrecuentes(Long idFarmacia);
}
