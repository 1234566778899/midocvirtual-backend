package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.DetalleVenta;
import pe.com.midocvirtual.backend.repositories.DetalleVentaRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaRepository repo;
    @PostMapping("/detalleVenta")
    public List<DetalleVenta> addDetalleventa(@RequestBody List<DetalleVenta> detalleVenta){
        return repo.saveAll(detalleVenta);
    }
}
