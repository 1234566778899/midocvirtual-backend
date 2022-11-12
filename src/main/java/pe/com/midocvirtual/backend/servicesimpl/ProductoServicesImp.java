package pe.com.midocvirtual.backend.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.midocvirtual.backend.entities.Producto;
import pe.com.midocvirtual.backend.repositories.ProductoRepository;
import pe.com.midocvirtual.backend.services.ProductoServices;

import java.util.List;
@Service
public class ProductoServicesImp implements ProductoServices {
    @Autowired
    private ProductoRepository repo;
    public List<Producto> getProductos() {
        List<Producto> productos=repo.findAll();
        for (Producto producto:productos){
            producto.getProveedor().setProductos(null);
            producto.setDetalleVentas(null);
            producto.setStocks(null);
        }
        return productos;
    }
    public Producto addProducto(Producto producto) {
        Producto producto1=repo.save(producto);
        producto1.setStocks(null);
        producto1.setProveedor(null);
        producto1.setDetalleVentas(null);
        return producto1;
    }
}
