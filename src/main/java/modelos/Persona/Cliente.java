package modelos.Persona;

import lombok.Data;
import modelos.SoporteTecnico.Especialidad;
import modelos.SoporteTecnico.Servicio;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
@Table(name = "persona")
public class Cliente extends Persona {
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Servicio> servicios = new HashSet<>();

    public Cliente(){
    }
    public void agregarServicio(Servicio servicio){
        this.servicios.add(servicio);
    }
    public Set<Servicio> getServicios(){
        return this.servicios;
    }
}
