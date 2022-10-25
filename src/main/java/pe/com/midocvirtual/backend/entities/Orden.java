package pe.com.midocvirtual.backend.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ordenes")
public class Orden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private Double total;
    private String numeroBoleta;
    private String formaPago;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "farmacia_id")
    private Farmacia farmacia;

    @OneToMany(mappedBy = "orden")
    private List<DetalleVenta> detalleVentas;
}
