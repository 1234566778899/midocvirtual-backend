package pe.com.midocvirtual.backend.services;

import pe.com.midocvirtual.backend.entities.DetalleVenta;

import java.util.List;

public interface DetalleServices {
    public List<DetalleVenta> addDetalleOrden(List<DetalleVenta> detalleVentas);
}
