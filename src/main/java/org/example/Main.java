package org.example;

import modelos.Persona.Cliente;
import modelos.SoporteTecnico.*;
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

        Set<Referencia> referencias = cargarReferencias();
        Set<Especialidad> especialidades = cargarEspecialidades(referencias);
        Set<Servicio> servicios = cargarServicios(referencias);

        Tecnico t = new Tecnico();
        t.setNombre("Daniel");
        EntityTransaction tx = em.getTransaction();
        especialidades.forEach(t::agregarEspecialidad);
        tx.begin();
        em.persist(t);
        tx.commit();

        Cliente c = new Cliente();
        c.setNombre("Federrico");
        for(Servicio s : servicios){
            c.agregarServicio(s);
        }
        tx.begin();
        em.persist(c);
        tx.commit();
    }

    private static HashSet<Servicio> cargarServicios(Set<Referencia> referencias) {
        HashSet<Servicio> servicios = new HashSet<>();
        for(Referencia r: referencias){
            servicios.add(new Servicio(r));
        }
        return servicios;
    }

    public static EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                        "JPA_PU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }
    private static HashSet<Referencia> cargarReferencias(){
        HashSet<Referencia> referencias = new HashSet<>();
        //Primero creo Referencias
        Referencia ref1 = new Referencia("Windows");
        Referencia ref2 = new Referencia("Linux");
        Referencia ref3 = new Referencia("Windows");
        Referencia ref4 = new Referencia("PhotoShop");
        Referencia ref5 = new Referencia("Java");
        Referencia ref6 = new Referencia("SmallTalk");
        referencias.add(ref1);
        referencias.add(ref2);
        referencias.add(ref3);
        referencias.add(ref4);
        referencias.add(ref5);
        referencias.add(ref6);
        return referencias;
    }
    private static HashSet<Especialidad> cargarEspecialidades(Set<Referencia> referencias){
        HashSet<Especialidad> especialidades = new HashSet<>();
        int i = 0;
        Especialidad e;
        for(Referencia r: referencias){
            if( i % 2 == 0){
                e = new Sistema(r);
            }else{
                e = new Aplicacion(r);
            }
            especialidades.add(e);
            i++;
        }
        return especialidades;
    }
}