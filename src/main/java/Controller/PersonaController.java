package Controller;

import Repository.PersonaRepository;
import Repository.ReferenciasRepository;
import modelos.Persona.Persona;
import modelos.SoporteTecnico.Referencia;

public class PersonaController {
    private PersonaRepository comunicacionDB;

    public PersonaRepository getcomunicacionDB() {
        return comunicacionDB;
    }

    public void setcomunicacionDB(PersonaRepository comunicacionDB) {
        this.comunicacionDB = comunicacionDB;
    }

    public PersonaController() {
        this.comunicacionDB = new PersonaRepository();
    }

    public void agregarPersona(Persona persona) {
        comunicacionDB.getEm().getTransaction().begin();
        comunicacionDB.insertarPersona(persona);
        comunicacionDB.getEm().getTransaction().commit();
        System.out.println("Guardado!!");
        /*
        if(!nombreRefExiste(nombre)){
            comunicacionDB.getEm().getTransaction().begin();
            comunicacionDB.insertarReferencia(aGuardar);
            comunicacionDB.getEm().getTransaction().commit();
            System.out.println("Guardado!!");
        }else{
            System.out.println("No se guardo porque ya existe!");
        }
        */
    }

}
