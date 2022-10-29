package pe.com.midocvirtual.backend.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Orden;
import pe.com.midocvirtual.backend.repositories.OrdenRepository;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class OrderController {
    @Autowired
    private OrdenRepository repo;
    @GetMapping("/ordenes/{idFarmacia}")
    public ResponseEntity <List<Orden>> getOrdenes(@PathVariable Long idFarmacia){
        List<Orden> ordens=repo.findAllByFarmaciaId(idFarmacia);
        if (ordens.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Orden orden:ordens){
            orden.getCliente().setOrdenes(null);
            orden.setFarmacia(null);
            orden.setDetalleVentas(null);
        }
        return new ResponseEntity<List<Orden>>(ordens,HttpStatus.OK);
    }
    @PostMapping("/ordenes")
    public ResponseEntity <Orden> addOrden(@RequestBody Orden orden){
        Orden orden1=repo.save(orden);
        orden1.setDetalleVentas(null);
        orden1.setFarmacia(null);
        orden1.setCliente(null);
        return new ResponseEntity<Orden>(orden1,HttpStatus.CREATED);
    }
    @GetMapping("/ordenes/ingresos/{inicio}/{fin}")
    public ResponseEntity<Double> total(@PathVariable Date inicio,@PathVariable Date fin){
        Double ingresos = repo.totalIngresosEntreFechas(inicio,fin);
        return new ResponseEntity<Double>(ingresos,HttpStatus.OK);
    }
    @GetMapping("/ordenes/cantidad/{inicio}/{fin}")
    public ResponseEntity <Double> cantidad(@PathVariable Date inicio,@PathVariable Date fin){
        Double cantidad = repo.cantidadVentasEntreFechas(inicio,fin);
        return new ResponseEntity<Double>(cantidad,HttpStatus.OK);
    }
    @GetMapping("/ordenes/ultimos/{idFarmacia}")
    public ResponseEntity <List<Orden>> getUltimos3Dias(@PathVariable Long idFarmacia){
        List<Orden> ordens=repo.findAllUltimos3Dias(idFarmacia);
        if (ordens.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Orden orden:ordens){
            orden.setCliente(null);
            orden.setDetalleVentas(null);
            orden.setFarmacia(null);
        }
        return new ResponseEntity<List<Orden>>(ordens,HttpStatus.OK);
    }
    @DeleteMapping("/ordenes/{id}")
    public ResponseEntity<HttpStatus> deleteOrden(@PathVariable Long id){
        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
