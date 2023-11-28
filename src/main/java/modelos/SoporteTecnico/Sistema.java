package modelos.SoporteTecnico;

import modelos.SoporteTecnico.Especialidad;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="sistema")
public class Sistema extends Especialidad {
    public Sistema(Referencia referencia){
        this.referencia = referencia;
    }

    public Sistema() {

    }
}
