package pe.com.midocvirtual.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "stocks")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cantidadUnitaria;
    private Long precioUnitario;
    private Date fechaVencimiento;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "farmacia_id")
    private Farmacia farmacia;
}
