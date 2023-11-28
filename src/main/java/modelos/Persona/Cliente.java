package modelos.Persona;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//@Data
@Entity
@Table(name = "persona")
public class Cliente extends Persona {

}
