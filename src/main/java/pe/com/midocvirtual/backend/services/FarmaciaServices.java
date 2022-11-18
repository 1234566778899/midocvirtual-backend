package pe.com.midocvirtual.backend.services;

import pe.com.midocvirtual.backend.entities.Farmacia;

import java.util.List;

public interface FarmaciaServices {
    public List<Farmacia> getFarmacias();
    public Farmacia getFarmacia(Long id);
    public Farmacia addFarmacia(Farmacia farmacia);
    public Farmacia aditFarmacia(Farmacia farmacia);
    public Farmacia findFarmaciaByCorreo(String correo);
}
