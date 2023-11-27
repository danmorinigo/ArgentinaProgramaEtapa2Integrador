package modelos;

import java.util.HashSet;
import java.util.Set;

public class Tecnico extends Persona{
    Set<Especialidad> especialidades;
    public Tecnico(){
        this.especialidades = new HashSet<>();
    }
    public void agregarEspecialidad(Especialidad especialidad){
        this.especialidades.add(especialidad);
    }
    public Set<Especialidad> getEspecialidades(){
        return this.especialidades;
    }
}
