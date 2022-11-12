package pe.com.midocvirtual.backend.services;

import org.aspectj.weaver.ast.Or;
import pe.com.midocvirtual.backend.dto.ReporteSemanalDTO;
import pe.com.midocvirtual.backend.entities.Orden;

import java.util.Date;
import java.util.List;

public interface OrdenService {
    public List<Orden> getOrdenes(Long idFarmacia);
    public Orden getOrden(Long id);
    public Orden addOrden(Orden orden);
    public void deleteOrden(Long id);
    public Object ingresosEntreFechas(Long idFarmacia, Date inicio,Date fin);
    public List<Object> getOrdenReporteSemanal(Long idFarmacia, Date inicio, Date fin);
    public List<Orden> ultimos3Dias(Long idFarmacia);
}
