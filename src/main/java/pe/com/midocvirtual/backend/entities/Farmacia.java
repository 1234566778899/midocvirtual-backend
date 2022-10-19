package pe.com.midocvirtual.backend.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "farmacias")
public class Farmacia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ruc;
    private String nombre;
    private String apellido;
    private String dni;
    private String provincia;
    private String departamento;
    private String distrito;
    private String telefono;
    private String correo;
    private String password;
}
