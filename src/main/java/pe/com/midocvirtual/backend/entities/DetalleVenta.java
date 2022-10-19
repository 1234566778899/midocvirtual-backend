package pe.com.midocvirtual.backend.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double precioUnitario;
    private Double descuento;
    private Double subTotal;
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "orden_id")
    private Orden orden;
}
