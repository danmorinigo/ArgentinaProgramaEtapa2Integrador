package modelos;

import lombok.Data;

@Data
public abstract class Persona {
    private long id;
    private long codigo = 0L;
    private String nombre;
}
