package pe.com.midocvirtual.backend.services;

import org.springframework.web.multipart.MultipartFile;
import pe.com.midocvirtual.backend.entities.Farmacia;

import java.io.IOException;
import java.util.List;

public interface FarmaciaServices {
    public List<Farmacia> getFarmacias();
    public Farmacia getFarmacia(Long id);
    public Farmacia addFarmacia(Farmacia farmacia);
    public Farmacia editFarmacia(Long id,Farmacia farmacia);
    public Farmacia editPhoto(Long id, MultipartFile photo) throws IOException;
    public Farmacia findFarmaciaByCorreo(String correo);
}
