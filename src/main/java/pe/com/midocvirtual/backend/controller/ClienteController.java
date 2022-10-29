package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Cliente;
import pe.com.midocvirtual.backend.repositories.ClienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api")
public class ClienteController {
    @Autowired
    private ClienteRepository repo;
    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        List<Cliente> clientes=repo.findAll();
        for (Cliente cliente:clientes){
            cliente.setOrdenes(null);
        }
        return clientes;
    }
    @GetMapping("/clientes/{dniCliente}")
    public Cliente getCliente(@PathVariable String dniCliente){
        Cliente cliente=repo.findByDni(dniCliente);
        cliente.setOrdenes(null);
        return cliente;
    }
    @GetMapping("/clientes/frecuentes")
    public List<Object> findClientesFrecuentes(){

        return repo.getClientesFrecuentes().stream().limit(30).collect(Collectors.toList());
    }
    @PostMapping("/clientes")
    public Cliente addCliente(@RequestBody Cliente cliente){

        return repo.save(cliente);
    }
}
