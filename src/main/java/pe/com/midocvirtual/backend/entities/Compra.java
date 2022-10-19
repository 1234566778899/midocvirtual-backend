package pe.com.midocvirtual.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fechaCompra;
    private Double precioUnitario;
    private Integer cantidad;
    @ManyToOne
    @JoinColumn(name = "farmacia_id")
    private Farmacia farmacia;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
}
