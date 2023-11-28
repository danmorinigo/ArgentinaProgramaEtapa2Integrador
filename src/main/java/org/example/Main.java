package org.example;

import Controller.PersonaController;
import Controller.ReferenciasController;
import modelos.Persona.Cliente;
import modelos.Persona.Persona;
import modelos.SoporteTecnico.*;
import modelos.Persona.Tecnico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManager em = getEntityManager();

        ReferenciasController rc = new ReferenciasController();
        rc.getcomunicacionDB().setEm(em);

        PersonaController pc = new PersonaController();
        pc.getcomunicacionDB().setEm(em);

        Scanner teclado = new Scanner(System.in);
        int opcion;
        long id;
        do{
            menuPrincipal();
            System.out.print("Elija opcion: ");
            opcion = teclado.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("AGREGANDO REFERENCIA:");
                    System.out.print("\tIngrese nombre: ");
                    String nombre = teclado.next();
                    rc.agregarReferencia(nombre);
                    break;
                case 2:
                    System.out.println("REFERENCIAS EN DB:");
                    for(Referencia r : rc.referenciasGuardadas()){
                        System.out.println("\t" + r);
                    }
                    break;
                case 3:
                    System.out.println("AGREGANDO SERVICIO:");
                    for(Referencia r : rc.referenciasGuardadas()){
                        System.out.println("\t" + r);
                    }
                    System.out.print("\tIngrese codigo: ");
                    long codigo = teclado.nextInt();
                    rc.agregarServicio(codigo);
                    break;
                case 4:
                    System.out.println("SERVICIOS QUE BRINDAMOS");
                    for(Servicio s: rc.serviciosGuardados()){
                        System.out.println("\t" + s);
                    }
                    break;
                case 5:
                    System.out.println("AGREGANDO CLIENTE:");
                    System.out.print("\tNombre:");
                    String n = teclado.next();
                    Persona persona = new Cliente();
                    persona.setNombre(n);
                    pc.agregarPersona(persona);
                    break;
                case 6:
                    System.out.println("AGREGANDO TECNICO:");
                    System.out.print("\tNombre:");
                    String n2 = teclado.next();
                    Persona persona2 = new Tecnico();
                    persona2.setNombre(n2);
                    pc.agregarPersona(persona2);
                    break;


                default:
                    System.out.println("Opcion no válida o Saliendo...");
            }
        }while(opcion != 0);
        despedida();
        /*

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
         */
    }

    private static void despedida() {
        System.out.println("BAY BAY!");
    }

    private static void menuPrincipal() {
        System.out.println("MENU PRINCIPAL");
        System.out.println("\t1-Agregar REFERENCIA");
        System.out.println("\t2-Mostrar REFERENCIAS GUARDADAS");
        System.out.println("\t3-Agregar SERVICIO");
        System.out.println("\t4-Mostrar SERVICIOS");
        System.out.println("\t5-Agregar CLIENTE");
        System.out.println("\t6-Agregar TECNICO");
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