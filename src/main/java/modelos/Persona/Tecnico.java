package modelos.Persona;

import lombok.Data;
import modelos.Incidente;
import modelos.Persona.Persona;
import modelos.SoporteTecnico.Especialidad;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "persona")
public class Tecnico extends Persona {
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Especialidad> especialidades = new HashSet<>();
    @OneToMany
    private Set<Incidente> incidente = new HashSet<>();

    public Tecnico(){
    }
    public void agregarEspecialidad(Especialidad especialidad){
        this.especialidades.add(especialidad);
    }
    public Set<Especialidad> getEspecialidades(){
        return this.especialidades;
    }
}
