package modelos.Persona;

import modelos.Persona.Persona;
import modelos.SoporteTecnico.Especialidad;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "persona")
public class Tecnico extends Persona {
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Especialidad> especialidades = new HashSet<>();

    public Tecnico(){
    }
    public void agregarEspecialidad(Especialidad especialidad){
        this.especialidades.add(especialidad);
    }
    public Set<Especialidad> getEspecialidades(){
        return this.especialidades;
    }
}
