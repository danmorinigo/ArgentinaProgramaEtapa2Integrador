package modelos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="especialidad")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class Especialidad implements Comparable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "especialidad_id_seq")
    @SequenceGenerator(name = "especialidad_id_seq", sequenceName = "especialidad_id_seq", allocationSize = 1)
    private long id;
    protected String nombre;
    public String toString(){
        return this.nombre;
    }

    @Override
    public int compareTo(Object especialidad) {
        Especialidad aComparar = (Especialidad) especialidad;
        return nombre.compareTo(aComparar.getNombre());
    }
}
