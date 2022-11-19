package pe.com.midocvirtual.backend.dto;

import lombok.Data;

@Data
public class ClienteFrecuente {
    private Long id;
    private String dni;
    private String nombre;
    private String apellido;
    private Integer cantidad;
    private Double monto;
}
