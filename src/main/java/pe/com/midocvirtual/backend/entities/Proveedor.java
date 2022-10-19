package pe.com.midocvirtual.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String pais;
    private String contacto;
    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;
}
