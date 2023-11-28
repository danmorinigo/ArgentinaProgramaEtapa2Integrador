package modelos.Estado;

public class Ingresado implements Situacion {
    @Override
    public String estado() {
        return "Ingresado al sistema";
    }
}
