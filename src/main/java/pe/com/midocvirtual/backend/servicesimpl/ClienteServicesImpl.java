package pe.com.midocvirtual.backend.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.midocvirtual.backend.entities.Cliente;
import pe.com.midocvirtual.backend.exceptions.ResourceNotFoundException;
import pe.com.midocvirtual.backend.repositories.ClienteRepository;
import pe.com.midocvirtual.backend.services.ClienteServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class ClienteServicesImpl implements ClienteServices {

    @Autowired
    private ClienteRepository repo;
    public List<Cliente> getClientes() {
        List<Cliente> clientes=repo.findAll();
        for (Cliente cliente:clientes){
            cliente.setOrdenes(null);
        }
        return clientes;
    }
    public Cliente getClienteByDni(String dni) {
        Cliente cliente = repo.findByDni(dni);
        cliente.setOrdenes(null);
        return cliente;
    }
    public Cliente addCliente(Cliente cliente) {
        return repo.save(cliente);
    }
    public List<Object> clientesFrecuentes(Long idFarmacia) {
        List<Object>clientesFrecuentes;
        clientesFrecuentes = repo.getClientesFrecuentes(idFarmacia).stream().limit(30).collect(Collectors.toList());
        return clientesFrecuentes;
    }
}
