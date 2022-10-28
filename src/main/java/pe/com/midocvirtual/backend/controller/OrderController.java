package pe.com.midocvirtual.backend.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Orden> getOrdenes(@PathVariable Long idFarmacia){
        List<Orden> ordens=repo.findAllByFarmaciaId(idFarmacia);
        for (Orden orden:ordens){
            orden.getCliente().setOrdenes(null);
            orden.setFarmacia(null);
            orden.setDetalleVentas(null);
        }
        return ordens;
    }
    @PostMapping("/ordenes")
    public Orden addOrden(@RequestBody Orden orden){
        Orden orden1=repo.save(orden);
        orden1.setDetalleVentas(null);
        orden1.setFarmacia(null);
        orden1.setCliente(null);
        return orden1;
    }
    @GetMapping("/ordenes/ingresos/{inicio}/{fin}")
    public Double total(@PathVariable Date inicio,@PathVariable Date fin){
        return repo.totalIngresosEntreFechas(inicio,fin);
    }
    @GetMapping("/ordenes/cantidad/{inicio}/{fin}")
    public Double cantidad(@PathVariable Date inicio,@PathVariable Date fin){
        return repo.cantidadVentasEntreFechas(inicio,fin);
    }
    @GetMapping("/ordenes/ultimos/{idFarmacia}")
    public List<Orden> getUltimos3Dias(@PathVariable Long idFarmacia){
        List<Orden> ordens=repo.findAllUltimos3Dias(idFarmacia);
        for (Orden orden:ordens){
            orden.setCliente(null);
            orden.setDetalleVentas(null);
            orden.setFarmacia(null);
        }
        return ordens;
    }
}
