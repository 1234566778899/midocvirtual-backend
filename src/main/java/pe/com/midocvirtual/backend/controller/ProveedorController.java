package pe.com.midocvirtual.backend.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Proveedor;
import pe.com.midocvirtual.backend.repositories.ProveedorRepository;

import javax.persistence.Entity;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class ProveedorController {
    @Autowired
    private ProveedorRepository repo;
    @GetMapping("/proveedores")
    public List<Proveedor> getProveedores(){
        List<Proveedor> proveedors=repo.findAll();
        for (Proveedor proveedor:proveedors){
            proveedor.setProductos(null);
        }
        return proveedors;
    }
    @PostMapping("/proveedores")
    public Proveedor addProveedor(@RequestBody Proveedor proveedor){
        Proveedor proveedor1=repo.save(proveedor);
        proveedor1.setProductos(null);
        return proveedor1;
    }
    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<HttpStatus> deleteProveedor(@PathVariable Long id){
        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
