package pe.com.midocvirtual.backend.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return repo.findAll();
    }
}
