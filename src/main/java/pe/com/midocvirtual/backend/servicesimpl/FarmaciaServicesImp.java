package pe.com.midocvirtual.backend.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pe.com.midocvirtual.backend.entities.Farmacia;
import pe.com.midocvirtual.backend.exceptions.ResourceNotFoundException;
import pe.com.midocvirtual.backend.repositories.FarmaciaRepository;
import pe.com.midocvirtual.backend.services.FarmaciaServices;
import pe.com.midocvirtual.backend.utilities.Util;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public class FarmaciaServicesImp implements FarmaciaServices {
    @Autowired
    private FarmaciaRepository repo;
    public List<Farmacia> getFarmacias() {
        List<Farmacia> farmacias=repo.findAll();
        for(Farmacia farmacia:farmacias){
            farmacia.setOrdenes(null);
            farmacia.setStocks(null);
        }
        return farmacias;
    }
    public Farmacia getFarmacia(Long id) {
        Farmacia farmacia= repo.findById(id).get();
        farmacia.setStocks(null);
        farmacia.setOrdenes(null);
        return farmacia;
    }
    public Farmacia addFarmacia(Farmacia farmacia) {
        Farmacia farmacia1=repo.save(farmacia);
        return farmacia1;
    }
    public Farmacia editFarmacia(Long id,Farmacia farmacia) {
        Farmacia farmacia1=repo.findById(id).get();
        farmacia1.setRuc(farmacia.getRuc());
        farmacia1.setNombreFarmacia(farmacia.getNombreFarmacia());
        farmacia1.setApellido(farmacia.getApellido());
        farmacia1.setNombre(farmacia.getNombre());
        farmacia1.setDni(farmacia.getDni());
        farmacia1.setProvincia(farmacia.getProvincia());
        farmacia1.setDepartamento(farmacia.getDepartamento());
        farmacia1.setDistrito(farmacia.getDistrito());
        farmacia1.setDistrito(farmacia.getDistrito());
        farmacia1.setTelefono(farmacia.getTelefono());
        farmacia1.setPassword(farmacia.getPassword());
        farmacia1.setCorreo(farmacia.getCorreo());
        farmacia1.setStocks(null);
        farmacia1.setOrdenes(null);
        return  repo.save(farmacia1);
    }

    @Override
    public Farmacia editPhoto(Long id, MultipartFile photo) throws IOException {
        Farmacia farmacia=repo.findById(id).get();
        if(photo!=null){
            farmacia.setPhoto(Util.compressZLib(photo.getBytes()));
        }
        farmacia.setStocks(null);
        farmacia.setOrdenes(null);
        return repo.save(farmacia);
    }

    @Override
    public Farmacia findFarmaciaByCorreo(String correo) {
        Farmacia farmacia=repo.findByCorreo(correo);
        farmacia.setStocks(null);
        farmacia.setOrdenes(null);
        farmacia.setPhoto(null);
        return farmacia;
    }
}
