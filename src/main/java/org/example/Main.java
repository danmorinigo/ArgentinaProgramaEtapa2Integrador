package org.example;

import modelos.Aplicacion;
import modelos.Especialidad;
import modelos.Sistema;
import modelos.Tecnico;

public class Main {
    public static void main(String[] args) {
        Tecnico t = new Tecnico();
        t.setNombre("Daniel");
        System.out.println(t.getNombre());
        Especialidad w = new Sistema("Windows");
        Sistema l = new Sistema("Linux");
        Sistema w2 = new Sistema("Windows");
        Especialidad a1 = new Aplicacion("PS");
        Especialidad a2 = new Aplicacion("JAVA");
        Especialidad a3 = new Aplicacion("PS");

        t.agregarEspecialidad(w);
        t.agregarEspecialidad(l);
        t.agregarEspecialidad(w2);
        t.agregarEspecialidad(a1);
        t.agregarEspecialidad(a2);
        t.agregarEspecialidad(a3);
        for(Especialidad e : t.getEspecialidades()){
            System.out.println(e);
        }
    }
}