package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Compra;
import pe.com.midocvirtual.backend.repositories.CompraRepository;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CompraController {
    @Autowired
    private CompraRepository repo;

    @GetMapping("/compras")
    public List<Compra> getCompras(){
        List<Compra> compras=repo.findAll();
        for (Compra compra:compras){
            compra.getProducto().setStocks(null);
            compra.setFarmacia(null);
        }
        return compras;
    }
    @PostMapping("/compras")
    public Compra save(@RequestBody Compra compra){
        return repo.save(compra);
    }
}
