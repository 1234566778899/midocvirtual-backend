package pe.com.midocvirtual.backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "farmacias")
public class Farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruc;
    private String nombreFarmacia;
    private String nombre;
    private String apellido;
    private String dni;
    private String provincia;
    private String departamento;
    private String distrito;
    private String telefono;
    private String correo;
    private String password;

    @OneToMany(mappedBy = "farmacia")
    private List<Orden> ordenes;

    @OneToMany(mappedBy = "farmacia")
    private List<Stock> stocks;

}
