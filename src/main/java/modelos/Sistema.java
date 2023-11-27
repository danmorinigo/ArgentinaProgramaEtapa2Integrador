package modelos;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sistema")
public class Sistema extends Especialidad{
    private long id;
    public Sistema(String nombre){
        this.nombre = nombre;
    }

    public Sistema() {

    }
}
