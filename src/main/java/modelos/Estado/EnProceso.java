package modelos.Estado;

public class EnProceso implements Situacion {
    @Override
    public String estado() {
        return "En proceso de resolucion.";
    }
}
