package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.com.midocvirtual.backend.entities.Farmacia;
import pe.com.midocvirtual.backend.entities.Producto;
import pe.com.midocvirtual.backend.exceptions.ResourceNotFoundException;
import pe.com.midocvirtual.backend.repositories.FarmaciaRepository;
import pe.com.midocvirtual.backend.repositories.ProductoRepository;
import pe.com.midocvirtual.backend.services.FarmaciaServices;
import pe.com.midocvirtual.backend.utilities.Util;

import java.io.IOException;
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
        if(farmacia.getPhoto()!=null) {
            byte[] img = Util.decompressZLib(farmacia.getPhoto());
            farmacia.setPhoto(img);
        }
        return new ResponseEntity<Farmacia>(farmacia,HttpStatus.OK);
    }

    @GetMapping("/farmacias/correo/{correo}")
    public ResponseEntity <Farmacia> getFarmaciaByCorreo(@PathVariable String correo){
        Farmacia farmacia= repo.findFarmaciaByCorreo(correo);
        return new ResponseEntity<Farmacia>(farmacia,HttpStatus.OK);
    }
    @PostMapping("/farmacias")
    public ResponseEntity <Farmacia> addFarmacia(@RequestBody Farmacia farmacia) throws IOException {
        return new ResponseEntity<Farmacia>(repo.addFarmacia(farmacia),HttpStatus.CREATED);
    }
    @PutMapping("/farmacias/{id}")
    public ResponseEntity<Farmacia> updateFarmacia(@PathVariable Long id, @RequestBody Farmacia farmacia){
        return new ResponseEntity<>(repo.editFarmacia(id,farmacia),HttpStatus.CREATED);
    }
    @PutMapping("/farmacias/photo/{id}")
    public ResponseEntity <Farmacia> updatePhoto(@PathVariable Long id,
                                                 @RequestParam("photo") MultipartFile photo)throws IOException{

       return new ResponseEntity<>(repo.editPhoto(id,photo),HttpStatus.CREATED);
    }
}
