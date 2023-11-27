package org.example;

import modelos.Aplicacion;
import modelos.Especialidad;
import modelos.Sistema;
import modelos.Tecnico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManager em = getEntityManager();

        Set<Especialidad> especialidades = cargarEspecialidades();
        Tecnico t = new Tecnico();
        t.setNombre("Daniel");
        System.out.println(t.getNombre());

        for(Especialidad e : especialidades){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(e);
            tx.commit();
            t.agregarEspecialidad(e);
        }
        for(Especialidad e : t.getEspecialidades()){
            System.out.println(e);
        }
    }
    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                        "JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
    private static HashSet<Especialidad> cargarEspecialidades(){
        HashSet<Especialidad> especialidades = new HashSet<>();
        Especialidad w = new Sistema("Windows");
        Especialidad l = new Sistema("Linux");
        Especialidad w2 = new Sistema("Windows");
        Especialidad a1 = new Aplicacion("PS");
        Especialidad a2 = new Aplicacion("JAVA");
        Especialidad a3 = new Aplicacion("PS");
        especialidades.add(w);
        especialidades.add(l);
        especialidades.add(w2);
        especialidades.add(a1);
        especialidades.add(a2);
        especialidades.add(a3);
        return especialidades;
    }
}