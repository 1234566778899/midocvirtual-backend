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
import pe.com.midocvirtual.backend.services.FarmaciaServices;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class FarmaciaController {
    @Autowired
    private FarmaciaServices repo;
    @GetMapping("/farmacias")
    public ResponseEntity<List<Farmacia>> getFarmacias(){
        List<Farmacia> farmacias=repo.getFarmacias();
        if (farmacias.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Farmacia>>(farmacias,HttpStatus.OK);
    }
    @GetMapping("/farmacias/{id}")
    public ResponseEntity <Farmacia> getFarmacia(@PathVariable Long id){
        Farmacia farmacia= repo.getFarmacia(id);
        return new ResponseEntity<Farmacia>(farmacia,HttpStatus.OK);
    }
    @GetMapping("/farmacias/correo/{correo}")
    public ResponseEntity <Farmacia> getFarmaciaByCorreo(@PathVariable String correo){
        Farmacia farmacia= repo.findFarmaciaByCorreo(correo);
        return new ResponseEntity<Farmacia>(farmacia,HttpStatus.OK);
    }
    @PostMapping("/farmacias")
    public ResponseEntity <Farmacia> addFarmacia(@RequestBody Farmacia farmacia){
        Farmacia farmacia1=repo.addFarmacia(farmacia);
        return new ResponseEntity<Farmacia>(farmacia1,HttpStatus.CREATED);
    }
    @PutMapping("/farmacias")
    public ResponseEntity <Farmacia> updateFarmacia(@RequestBody Farmacia farmacia){
        Farmacia farmacia1=repo.aditFarmacia(farmacia);
        return new ResponseEntity<Farmacia>(farmacia1,HttpStatus.OK);
    }
}
