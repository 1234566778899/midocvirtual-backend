package pe.com.midocvirtual.backend.services;

import pe.com.midocvirtual.backend.entities.Notificacion;

import java.util.List;

public interface NotificacionService {
    public List<Notificacion> getNotificaciones(Long idFarmacia);
    public Notificacion editNotificacion(Notificacion notificacion);
}
