package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Farmacia;
import pe.com.midocvirtual.backend.entities.Producto;
import pe.com.midocvirtual.backend.exceptions.ResourceNotFoundException;
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
    public ResponseEntity<List<Farmacia>> getFarmacias(){
        List<Farmacia> farmacias=repo.findAll();
        if (farmacias.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Farmacia farmacia:farmacias){
            farmacia.setStocks(null);
            farmacia.setOrdenes(null);
        }
        return new ResponseEntity<List<Farmacia>>(farmacias,HttpStatus.OK);
    }
    @GetMapping("/farmacias/{id}")
    public ResponseEntity <Optional<Farmacia>> getFarmacia(@PathVariable Long id){
        Optional<Farmacia> farmacia= Optional.ofNullable(repo.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("No se encontró la farmacia con id: " + id)));;
        farmacia.get().setOrdenes(null);
        farmacia.get().setStocks(null);
        return new ResponseEntity<Optional<Farmacia>>(farmacia,HttpStatus.OK);
    }
    @PostMapping("/farmacias")
    public ResponseEntity <Farmacia> addFarmacia(@RequestBody Farmacia farmacia){
        Farmacia farmacia1=repo.save(farmacia);
        farmacia1.setOrdenes(null);
        farmacia.setStocks(null);
        return new ResponseEntity<Farmacia>(farmacia1,HttpStatus.CREATED);
    }
    @PutMapping("/farmacias")
    public ResponseEntity <Farmacia> updateFarmacia(@RequestBody Farmacia farmacia){
        Farmacia farmacia1=repo.save(farmacia);
        farmacia1.setStocks(null);
        farmacia1.setOrdenes(null);
        return new ResponseEntity<Farmacia>(farmacia1,HttpStatus.OK);
    }
}
