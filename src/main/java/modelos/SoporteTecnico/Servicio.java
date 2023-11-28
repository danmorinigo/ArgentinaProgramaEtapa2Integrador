package modelos.SoporteTecnico;

import lombok.Data;
import modelos.Persona.Cliente;
import modelos.Persona.Tecnico;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="servicio")
public class Servicio implements Comparable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servicio_id_seq")
    @SequenceGenerator(name = "servicio_id_seq", sequenceName = "servicio_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "referencia_id", referencedColumnName = "id")
    private Referencia referencia;

    @ManyToMany(mappedBy = "servicios", cascade = CascadeType.ALL)
    private Set<Cliente> clientes = new HashSet<>();
    public Servicio(Referencia referencia){
        this.referencia = referencia;
    }
    public Servicio(){

    }
    public String toString(){
        return this.referencia.toString();
    }
    @Override
    public int compareTo(Object servicio) {
        Servicio aComparar = (Servicio) servicio;
        return this.referencia.getNombre().compareTo(aComparar.getReferencia().getNombre());
    }
}
