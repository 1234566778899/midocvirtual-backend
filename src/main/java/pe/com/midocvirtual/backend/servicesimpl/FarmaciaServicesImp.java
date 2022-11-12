package pe.com.midocvirtual.backend.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.midocvirtual.backend.entities.Farmacia;
import pe.com.midocvirtual.backend.exceptions.ResourceNotFoundException;
import pe.com.midocvirtual.backend.repositories.FarmaciaRepository;
import pe.com.midocvirtual.backend.services.FarmaciaServices;

import java.util.List;
import java.util.Optional;
@Service
public class FarmaciaServicesImp implements FarmaciaServices {
    @Autowired
    private FarmaciaRepository repo;
    public List<Farmacia> getFarmacias() {
        List<Farmacia> farmacias=repo.findAll();
        for (Farmacia farmacia:farmacias){
            farmacia.setStocks(null);
            farmacia.setOrdenes(null);
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
        farmacia1.setOrdenes(null);
        farmacia.setStocks(null);
        return farmacia1;
    }
    public Farmacia aditFarmacia(Farmacia farmacia) {
        Farmacia farmacia1=repo.save(farmacia);
        farmacia1.setStocks(null);
        farmacia1.setOrdenes(null);
        return  farmacia1;
    }
}
