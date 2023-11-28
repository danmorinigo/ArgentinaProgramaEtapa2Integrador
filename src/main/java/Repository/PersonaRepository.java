package Repository;

import modelos.Persona.Cliente;
import modelos.Persona.Persona;
import modelos.SoporteTecnico.Referencia;
import modelos.SoporteTecnico.Servicio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class PersonaRepository {
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Cliente> clientes() {
        return em.createQuery(
                "select c from Cliente c", Cliente.class).getResultList();
    }

    public void insertarPersona(Persona persona) {
        em.persist(persona);
    }

    public Persona personaPorId(long id) {
        return em.find(Persona.class, id);
    }

    public void insertarServicio(Servicio servicio) {
        em.persist(servicio);
    }

    public List<Servicio> servicios() {
        return em.createQuery(
                "select s from Servicio s", Servicio.class).getResultList();
    }
}
