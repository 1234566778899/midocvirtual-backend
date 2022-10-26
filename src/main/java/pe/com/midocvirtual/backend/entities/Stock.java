package pe.com.midocvirtual.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidadDisponible;
    private Double precioVenta;
    private Double precioCompra;
    private Date fechaVencimiento;
    private Date fechaCompra;
    private double inversion;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "farmacia_id")
    private Farmacia farmacia;
}
