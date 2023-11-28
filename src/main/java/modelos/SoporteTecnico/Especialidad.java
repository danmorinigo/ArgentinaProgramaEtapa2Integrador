package modelos.SoporteTecnico;

import lombok.Data;
import modelos.Persona.Tecnico;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="especialidad")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Especialidad implements Comparable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "especialidad_id_seq")
    @SequenceGenerator(name = "especialidad_id_seq", sequenceName = "especialidad_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    //@Column(name = "nombre")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "referencia_id", referencedColumnName = "id")
    protected Referencia referencia;

    @ManyToMany(mappedBy = "especialidades", cascade = CascadeType.ALL)
    private Set<Tecnico> tecnicos = new HashSet<>();

    public String toString(){
        return this.referencia.toString();
    }

    @Override
    public int compareTo(Object especialidad) {
        Especialidad aComparar = (Especialidad) especialidad;
        return this.referencia.getNombre().compareTo(aComparar.getReferencia().getNombre());
    }
}
