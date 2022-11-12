package pe.com.midocvirtual.backend.services;

import pe.com.midocvirtual.backend.entities.Proveedor;

import java.util.List;

public interface ProveedorService {
    public List<Proveedor> getProveedores();
    public Proveedor addProveedor(Proveedor proveedor);
}
