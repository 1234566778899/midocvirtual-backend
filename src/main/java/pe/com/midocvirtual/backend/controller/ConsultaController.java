package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Consulta;
import pe.com.midocvirtual.backend.repositories.ConsultaRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class ConsultaController {
    @Autowired
    private ConsultaRepository repo;
    @GetMapping("/consultas")
    public List<Consulta> getConsultas(){
        return repo.findAll();
    }
    @PostMapping("/consultas")
    public Consulta addConsulta(@RequestBody Consulta consulta){
        return repo.save(consulta);
    }
}
