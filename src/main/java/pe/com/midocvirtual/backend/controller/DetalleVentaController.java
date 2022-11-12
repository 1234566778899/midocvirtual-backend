package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.DetalleVenta;
import pe.com.midocvirtual.backend.repositories.DetalleVentaRepository;
import pe.com.midocvirtual.backend.services.DetalleServices;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class DetalleVentaController {
    @Autowired
    private DetalleServices repo;
    @PostMapping("/detalleVenta")
    public ResponseEntity<List<DetalleVenta>> addDetalleventa(@RequestBody List<DetalleVenta> detalleVenta){
        List<DetalleVenta> lista=repo.addDetalleOrden(detalleVenta);
        return new ResponseEntity<List<DetalleVenta>>(lista, HttpStatus.CREATED);
    }
}
