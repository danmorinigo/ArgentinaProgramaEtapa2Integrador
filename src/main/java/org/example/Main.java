package org.example;

import modelos.SoporteTecnico.Aplicacion;
import modelos.SoporteTecnico.Especialidad;
import modelos.SoporteTecnico.Referencia;
import modelos.SoporteTecnico.Sistema;
import modelos.Persona.Tecnico;

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

        EntityTransaction tx = em.getTransaction();

        for(Especialidad e : especialidades){
            //tx.begin();
            //em.persist(e);
            //tx.commit();
            t.agregarEspecialidad(e);
        }
        tx.begin();
        em.persist(t);
        tx.commit();
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
        //Primero creo Referencias
        Referencia ref1 = new Referencia("Windows");
        Referencia ref2 = new Referencia("Linux");
        Referencia ref3 = new Referencia("Windows");
        Referencia ref4 = new Referencia("PhotoShop");
        Referencia ref5 = new Referencia("Java");
        Referencia ref6 = new Referencia("SmallTalk");
        //Creo especialidades
        Especialidad e1 = new Sistema(ref1);
        Especialidad e2 = new Sistema(ref2);
        Especialidad e3 = new Sistema(ref3);
        Especialidad e4 = new Aplicacion(ref4);
        Especialidad e5 = new Aplicacion(ref5);
        Especialidad e6 = new Aplicacion(ref6);
        //Junto especialidades
        especialidades.add(e1);
        especialidades.add(e2);
        especialidades.add(e3);
        especialidades.add(e4);
        especialidades.add(e5);
        especialidades.add(e6);
        return especialidades;
    }
}