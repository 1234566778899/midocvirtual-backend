package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Producto;
import pe.com.midocvirtual.backend.entities.Proveedor;
import pe.com.midocvirtual.backend.repositories.ProductoRepository;
import pe.com.midocvirtual.backend.services.ProductoServices;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class ProductoController {
    @Autowired
    private ProductoServices repo;

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>>  getProductos(){
        List<Producto> productos=repo.getProductos();
        if (productos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Producto>>(productos,HttpStatus.OK);
    }
    @PostMapping("/productos")
    public ResponseEntity<Producto> addProducto(@RequestBody Producto producto){
        Producto producto1=repo.addProducto(producto);
        return new ResponseEntity<Producto>(producto1,HttpStatus.CREATED);
    }
}
