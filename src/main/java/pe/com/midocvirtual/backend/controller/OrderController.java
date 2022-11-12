package pe.com.midocvirtual.backend.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.dto.ReporteSemanalDTO;
import pe.com.midocvirtual.backend.entities.DetalleVenta;
import pe.com.midocvirtual.backend.entities.Orden;
import pe.com.midocvirtual.backend.repositories.OrdenRepository;
import pe.com.midocvirtual.backend.services.OrdenService;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class OrderController {
    @Autowired
    private OrdenService repo;
    @GetMapping("/ordenes/{idFarmacia}")
    public ResponseEntity <List<Orden>> getOrdenes(@PathVariable Long idFarmacia){
        List<Orden> ordens=repo.getOrdenes(idFarmacia);
        if (ordens.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orden>>(ordens,HttpStatus.OK);
    }

    @PostMapping("/ordenes")
    public ResponseEntity <Orden> addOrden(@RequestBody Orden orden){
        Orden orden1=repo.addOrden(orden);
        return new ResponseEntity<Orden>(orden1,HttpStatus.CREATED);
    }
    @DeleteMapping("/ordenes/{id}")
    public ResponseEntity<HttpStatus> deleteOrden(@PathVariable Long id){
        repo.deleteOrden(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/ordenes/ingresos/{idFarmacia}/{inicio}/{fin}")
    public ResponseEntity<Object> getIngresosYCantidad(@PathVariable Long idFarmacia,@PathVariable Date inicio,
                                                       @PathVariable Date fin){
        return new ResponseEntity<>(repo.ingresosEntreFechas(idFarmacia,inicio,fin),HttpStatus.OK);
    }
    @GetMapping("/ordenes/reporte/semanal/{idFarmacia}/{inicio}/{fin}")
    public ResponseEntity<List<Object>> getReporteSemanal(@PathVariable Long idFarmacia, @PathVariable Date inicio,
                                                                     @PathVariable Date fin){
        List<Object> objects=repo.getOrdenReporteSemanal(idFarmacia,inicio,fin);
        return new ResponseEntity<>(objects,HttpStatus.OK);
    }
    @GetMapping("/ordenes/ultimos/{idFarmacia}")
    public ResponseEntity<List<Orden>> getUltimos3Dias(@PathVariable Long idFarmacia){
        return new ResponseEntity<>(repo.ultimos3Dias(idFarmacia),HttpStatus.OK);
    }
    @GetMapping("/ordenes/detalle/{id}")
    public ResponseEntity<Orden> getOrden(@PathVariable Long id){
        return new ResponseEntity<>(repo.getOrden(id),HttpStatus.OK);
    }
}
