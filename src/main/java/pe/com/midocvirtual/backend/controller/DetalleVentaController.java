package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.DetalleVenta;
import pe.com.midocvirtual.backend.repositories.DetalleVentaRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaRepository repo;
    @PostMapping("/detalleVenta")
    public List<DetalleVenta> addDetalleventa(@RequestBody List<DetalleVenta> detalleVenta){
        List<DetalleVenta> lista=repo.saveAll(detalleVenta);
        for (DetalleVenta detalleVenta1:lista){
            detalleVenta1.setProducto(null);
            detalleVenta1.setOrden(null);
        }
        return lista;
    }
    @GetMapping("/detalleVenta/{idFarmacia}")
    public List<DetalleVenta> getDetalleVentas(@PathVariable Long idFarmacia){
        List<DetalleVenta> detalles=repo.findAllByFarmaciaId(idFarmacia);
        for (DetalleVenta detalleVenta:detalles){
            detalleVenta.setOrden(null);
            detalleVenta.getProducto().setDetalleVentas(null);
            detalleVenta.getProducto().setProveedor(null);
            detalleVenta.getProducto().setStocks(null);
        }
        return detalles;
    }
}
