package modelos;

import lombok.Data;
import modelos.Estado.Ingresado;
import modelos.Estado.Situacion;
import modelos.Persona.*;

@Data
public class Incidente {
    private long id;
    private String descripcion;
    private Situacion situacion = new Ingresado();
    private Cliente cliente;
    private Tecnico tecnico;
}
