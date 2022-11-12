package pe.com.midocvirtual.backend.services;

import pe.com.midocvirtual.backend.entities.Producto;

import java.util.List;

public interface ProductoServices {
    public List<Producto> getProductos();
    public Producto addProducto(Producto producto);
}
