package Repository;

import modelos.Persona.Cliente;
import modelos.SoporteTecnico.Referencia;
import modelos.SoporteTecnico.Servicio;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ReferenciasRepository {
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Referencia> referencias() {
        return em.createQuery(
                "select r from Referencia r", Referencia.class).getResultList();
    }

    public void insertarReferencia(Referencia referencia) {
        em.persist(referencia);
    }

    public Referencia refPorId(long codigo) {
        return em.find(Referencia.class, codigo);
    }

    public void insertarServicio(Servicio servicio) {
        em.persist(servicio);
    }

    public List<Servicio> servicios() {
        return em.createQuery(
                "select s from Servicio s", Servicio.class).getResultList();
    }
}
