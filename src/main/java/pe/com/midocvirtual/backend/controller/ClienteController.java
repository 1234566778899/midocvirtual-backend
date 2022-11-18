package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Cliente;
import pe.com.midocvirtual.backend.entities.Farmacia;
import pe.com.midocvirtual.backend.exceptions.ResourceNotFoundException;
import pe.com.midocvirtual.backend.repositories.ClienteRepository;
import pe.com.midocvirtual.backend.services.ClienteServices;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api")
public class ClienteController {
    @Autowired
    private ClienteServices repo;
    @GetMapping("/clientes")
    public ResponseEntity <List<Cliente>> getClientes(){
        List<Cliente> clientes=repo.getClientes();
        if (clientes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }
    @GetMapping("/clientes/{dniCliente}")
    public ResponseEntity<Optional<Cliente>> getCliente(@PathVariable String dniCliente){
        Optional <Cliente> cliente = Optional.ofNullable(Optional.ofNullable(repo.getClienteByDni(dniCliente)).
                orElseThrow(() -> new ResourceNotFoundException("No existen clientes con DNI=" + dniCliente)));;
        return new ResponseEntity<Optional<Cliente>>(cliente,HttpStatus.OK);
    }
    @GetMapping("/clientes/frecuentes/{idFarmacia}")
    public ResponseEntity <List<Object>> findClientesFrecuentes(@PathVariable Long idFarmacia){
        List<Object> _clientesFrecuentes = repo.clientesFrecuentes(idFarmacia);
        return new ResponseEntity <List<Object>>(_clientesFrecuentes,HttpStatus.OK);
    }
    @PostMapping("/clientes")
    public ResponseEntity <Cliente> addCliente(@RequestBody Cliente cliente){
        Cliente newCliente = repo.addCliente(cliente);
        return new ResponseEntity <Cliente>(newCliente,HttpStatus.CREATED);
    }
}
