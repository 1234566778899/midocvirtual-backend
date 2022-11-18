package pe.com.midocvirtual.backend.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.midocvirtual.backend.entities.Notificacion;
import pe.com.midocvirtual.backend.repositories.NotificacionRepository;
import pe.com.midocvirtual.backend.services.NotificacionService;

import java.util.List;

@Service
public class NotificacionServicesImpl implements NotificacionService {
    @Autowired
    private NotificacionRepository repo;
    public List<Notificacion> getNotificaciones(Long idFarmacia){
        return repo.getNotificaciones(idFarmacia);
    }

    public Notificacion editNotificacion(Notificacion notificacion) {
            return repo.save(notificacion);
    }

}
