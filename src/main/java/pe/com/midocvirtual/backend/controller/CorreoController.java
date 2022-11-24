package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Correo;
import pe.com.midocvirtual.backend.repositories.CorreoRepository;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class CorreoController {
    @Autowired
    private JavaMailSender mail;
    @Autowired
    private CorreoRepository repo;
    @PostMapping("/correo")
    public ResponseEntity<Correo> sendCorreo(@RequestBody Correo correo){

         SimpleMailMessage email=new SimpleMailMessage();
                 email.setTo(correo.getDestino());
                 email.setFrom("ordazhoyos2001@gmail.com");
                 email.setSubject(correo.getAsunto());
                email.setText(correo.getTexto());
                mail.send(email);
        return new ResponseEntity<Correo>(repo.save(correo),HttpStatus.OK);
    }
    @GetMapping("/correo/{correo}")
    public ResponseEntity<Correo> getCorreo(@PathVariable String correo){
        return new ResponseEntity<>(repo.getCodigoByEmail(correo),HttpStatus.OK);
    }
}
