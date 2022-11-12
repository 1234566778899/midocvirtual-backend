package pe.com.midocvirtual.backend.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.midocvirtual.backend.dto.ReporteSemanalDTO;
import pe.com.midocvirtual.backend.entities.DetalleVenta;
import pe.com.midocvirtual.backend.entities.Orden;
import pe.com.midocvirtual.backend.repositories.OrdenRepository;
import pe.com.midocvirtual.backend.services.OrdenService;

import java.util.Date;
import java.util.List;
@Service
public class OrdenServicesImp implements OrdenService {
    @Autowired
    private OrdenRepository repo;
    public List<Orden> getOrdenes(Long idFarmacia) {
        List<Orden> ordens=repo.findAllByFarmaciaId(idFarmacia);
        for (Orden orden:ordens){
            orden.getCliente().setOrdenes(null);
            orden.setFarmacia(null);
            orden.setDetalleVentas(null);
        }
        return ordens;
    }

    public Orden getOrden(Long id) {
        Orden orden=repo.findById(id).get();
        orden.getFarmacia().setOrdenes(null);
        orden.getFarmacia().setStocks(null);
        orden.getCliente().setOrdenes(null);
       for (DetalleVenta detalleVenta:orden.getDetalleVentas()){
           detalleVenta.setOrden(null);
           detalleVenta.getProducto().setDetalleVentas(null);
           detalleVenta.getProducto().setProveedor(null);
           detalleVenta.getProducto().setStocks(null);
       }
        return orden;
    }

    public Orden addOrden(Orden orden) {
        Orden orden1=repo.save(orden);
        orden1.setDetalleVentas(null);
        orden1.setFarmacia(null);
        orden1.setCliente(null);
        return orden1;
    }
    public void deleteOrden(Long id) {
        repo.deleteById(id);
    }

    public Object ingresosEntreFechas(Long idFarmacia, Date inicio, Date fin) {
        return repo.IngresosEntreFechas(idFarmacia,inicio,fin);
    }
    public List<Object> getOrdenReporteSemanal(Long idFarmacia, Date inicio, Date fin) {
        return repo.getOrdenesReporteSemanal(idFarmacia,inicio,fin);
    }


    public List<Orden> ultimos3Dias(Long idFarmacia) {
        List<Orden> ordens=repo.findAllByFarmaciaId(idFarmacia);
        for(Orden orden:ordens){
            orden.setDetalleVentas(null);
            orden.setFarmacia(null);
            orden.setCliente(null);
        }
        return ordens;
    }
}
