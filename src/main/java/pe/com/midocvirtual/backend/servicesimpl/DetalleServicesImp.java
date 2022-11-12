package pe.com.midocvirtual.backend.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.midocvirtual.backend.entities.DetalleVenta;
import pe.com.midocvirtual.backend.repositories.DetalleVentaRepository;
import pe.com.midocvirtual.backend.services.DetalleServices;

import java.util.List;
@Service
public class DetalleServicesImp implements DetalleServices {
    @Autowired
    private DetalleVentaRepository repo;
    public List<DetalleVenta> addDetalleOrden(List<DetalleVenta> detalleVentas) {
        List<DetalleVenta> lista=repo.saveAll(detalleVentas);
        for (DetalleVenta detalleVenta1:lista){
            detalleVenta1.setProducto(null);
            detalleVenta1.setOrden(null);
        }
        return lista;
    }
}
