package pe.com.midocvirtual.backend.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Orden;
import pe.com.midocvirtual.backend.repositories.OrdenRepository;

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
        return repo.save(orden);
    }
}
