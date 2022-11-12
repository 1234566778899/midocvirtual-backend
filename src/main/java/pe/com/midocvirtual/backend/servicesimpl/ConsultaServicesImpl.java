package pe.com.midocvirtual.backend.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.midocvirtual.backend.entities.Consulta;
import pe.com.midocvirtual.backend.repositories.ConsultaRepository;
import pe.com.midocvirtual.backend.services.ConsultaServices;

import java.util.List;
@Service
public class ConsultaServicesImpl implements ConsultaServices {
    @Autowired
    private ConsultaRepository repo;
    public Consulta addConsulta(Consulta consulta) {
        return repo.save(consulta);
    }
    public List<Consulta> getConsultas() {
        return repo.findAllOrderByFechaDesc();
    }
}
