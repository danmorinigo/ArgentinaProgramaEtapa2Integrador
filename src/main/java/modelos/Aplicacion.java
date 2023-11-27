package modelos;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="aplicacion")
public class Aplicacion extends Especialidad{
    public Aplicacion(String nombre){
        this.nombre = nombre;
    }

    public Aplicacion() {

    }
}

