package modelos;

import lombok.Data;

@Data
public class Incidente {
    private long id;
    private String descripcion;
    private Situacion situacion = new Ingresado();
    private Cliente cliente;
    private Tecnico tecnico;
}
