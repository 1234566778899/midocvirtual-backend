package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Producto;
import pe.com.midocvirtual.backend.entities.Proveedor;
import pe.com.midocvirtual.backend.repositories.ProductoRepository;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class ProductoController {
    @Autowired
    private ProductoRepository repo;

    @GetMapping("/productos")
    public List<Producto>  getProductos(){
        List<Producto> productos=repo.findAll();
        for (Producto producto:productos){
            producto.getProveedor().setProductos(null);
            producto.setDetalleVentas(null);
            producto.setStocks(null);
        }
        return productos;
    }
}
