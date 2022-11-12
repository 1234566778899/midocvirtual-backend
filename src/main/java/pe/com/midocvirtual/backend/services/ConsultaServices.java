package pe.com.midocvirtual.backend.services;

import pe.com.midocvirtual.backend.entities.Consulta;

import java.util.List;

public interface ConsultaServices {
    public Consulta addConsulta(Consulta consulta);
    public List<Consulta> getConsultas();
}
