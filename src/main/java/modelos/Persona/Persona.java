package modelos.Persona;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "persona")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "persona_id_seq")
    @SequenceGenerator(name = "persona_id_seq", sequenceName = "persona_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;
    @Column(name = "codigo")
    private long codigo = 0L;
    @Column(name = "nombre")
    private String nombre;
}
