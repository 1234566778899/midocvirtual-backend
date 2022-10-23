package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Farmacia;
import pe.com.midocvirtual.backend.entities.Producto;
import pe.com.midocvirtual.backend.repositories.FarmaciaRepository;
import pe.com.midocvirtual.backend.repositories.ProductoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class FarmaciaController {
    @Autowired
    private FarmaciaRepository repo;
    @GetMapping("/farmacias")
    public List<Farmacia> getFarmacias(){
        List<Farmacia> farmacias=repo.findAll();
        for (Farmacia farmacia:farmacias){
            farmacia.setCompras(null);
            farmacia.setStocks(null);
            farmacia.setOrdenes(null);
        }
        return farmacias;
    }
    @GetMapping("/farmacias/{id}")
    public Optional<Farmacia> getFarmacia(@PathVariable Long id){
        return repo.findById(id);
    }
}
