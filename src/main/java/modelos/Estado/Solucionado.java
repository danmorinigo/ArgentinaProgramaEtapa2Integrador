package modelos.Estado;

import modelos.Estado.Situacion;

public class Solucionado implements Situacion {
    @Override
    public String estado() {
        return "Solucionado!";
    }
}
