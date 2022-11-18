package pe.com.midocvirtual.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Notificacion;
import pe.com.midocvirtual.backend.services.NotificacionService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class NotificacionController {
    @Autowired
    private NotificacionService repo;
    @GetMapping("/notificaciones/{idFarmacia}")
    public ResponseEntity<List<Notificacion>> getNotificaciones(@PathVariable Long idFarmacia){
        return new ResponseEntity<>(repo.getNotificaciones(idFarmacia), HttpStatus.OK);
    }
    @PutMapping("/notificaciones")
    public ResponseEntity<Notificacion> editNotificacion(@RequestBody Notificacion notificacion){
        return new ResponseEntity<>(repo.editNotificacion(notificacion),HttpStatus.CREATED);
    }
}
