package modelos.SoporteTecnico;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="aplicacion")
public class Aplicacion extends Especialidad {
    public Aplicacion(Referencia referencia){
        this.referencia = referencia;
    }

    public Aplicacion() {

    }
}

