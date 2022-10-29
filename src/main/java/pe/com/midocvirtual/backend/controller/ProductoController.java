package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Producto>>  getProductos(){
        List<Producto> productos=repo.findAll();
        if (productos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Producto producto:productos){
            producto.getProveedor().setProductos(null);
            producto.setDetalleVentas(null);
            producto.setStocks(null);
        }
        return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
    }
    @PostMapping("/productos")
    public ResponseEntity<Producto> addProducto(@RequestBody Producto producto){
        Producto producto1=repo.save(producto);
        producto1.setStocks(null);
        producto1.setProveedor(null);
        producto1.setDetalleVentas(null);
        return new ResponseEntity<Producto>(producto1,HttpStatus.CREATED);
    }
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<HttpStatus> deleteProducto(@PathVariable Long id){
        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
