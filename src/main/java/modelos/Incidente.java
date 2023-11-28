package modelos;

import lombok.Data;
import modelos.Estado.Ingresado;
import modelos.Estado.Situacion;
import modelos.Persona.*;
import modelos.SoporteTecnico.Servicio;

import javax.persistence.*;

@Data
@Entity
@Table(name = "incidente")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incidente_id_seq")
    @SequenceGenerator(name = "incidente_id_seq", sequenceName = "incidente_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name="clienteOK")
    private boolean clienteSatisfecho = false;
    @Column(name="tecnicoOK")
    private boolean tecnicoTermino = false;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tecnico_id", referencedColumnName = "id")
    private Tecnico tecnico;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Servicio servicioConProblemas;
}
