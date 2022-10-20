package pe.com.midocvirtual.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String registroSanitario;
    private String presentacion;
    private String tipo;
    private boolean esRecetado;
    private String descripcion;
    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detalleVentas;
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    @OneToMany(mappedBy = "producto")
    private List<Stock> stocks;

    @OneToMany(mappedBy = "producto")
    private List<Stock> compras;

}
