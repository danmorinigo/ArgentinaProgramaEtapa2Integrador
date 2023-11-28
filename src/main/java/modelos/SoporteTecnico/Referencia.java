package modelos.SoporteTecnico;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "referencia")
public class Referencia {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referencia_id_seq")
    @SequenceGenerator(name = "referencia_id_seq", sequenceName = "referencia_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    public Referencia(){

    }
    public Referencia(String nombre){
        this.nombre = nombre;
    }
    public String toString(){
        return this.id + "-" + nombre;
    }
}
