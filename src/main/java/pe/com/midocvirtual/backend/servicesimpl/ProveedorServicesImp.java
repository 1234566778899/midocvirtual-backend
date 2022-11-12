package pe.com.midocvirtual.backend.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.midocvirtual.backend.entities.Producto;
import pe.com.midocvirtual.backend.entities.Proveedor;
import pe.com.midocvirtual.backend.repositories.ProveedorRepository;
import pe.com.midocvirtual.backend.services.ProductoServices;
import pe.com.midocvirtual.backend.services.ProveedorService;

import java.util.List;
@Service
public class ProveedorServicesImp implements ProveedorService {
    @Autowired
    private ProveedorRepository repo;
    public List<Proveedor> getProveedores() {
        List<Proveedor> proveedors=repo.findAll();
        for (Proveedor proveedor:proveedors){
            proveedor.setProductos(null);
        }
        return proveedors;
    }

    public Proveedor addProveedor(Proveedor proveedor) {
        Proveedor proveedor1=repo.save(proveedor);
        proveedor1.setProductos(null);
        return proveedor1;
    }
}
