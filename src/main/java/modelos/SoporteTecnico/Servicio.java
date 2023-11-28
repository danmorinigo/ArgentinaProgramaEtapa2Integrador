package modelos.SoporteTecnico;

import lombok.Data;
import modelos.Persona.Cliente;
import modelos.Persona.Tecnico;

import java.util.HashSet;
import java.util.Set;

@Data
public class Servicio implements Comparable{
    private long id;
    private Referencia referencia;
    private Set<Cliente> clientes = new HashSet<>();
    public String toString(){
        return this.referencia.toString();
    }
    @Override
    public int compareTo(Object servicio) {
        Servicio aComparar = (Servicio) servicio;
        return this.referencia.getNombre().compareTo(aComparar.getReferencia().getNombre());
    }
}
