package pe.com.midocvirtual.backend.entities;

import lombok.Data;

import javax.persistence.*;

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

    @Data
    @Entity
    @Table(name = "consultas")
    public static class Consulta {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private String correo;
        private String descripcion;
    }
}
