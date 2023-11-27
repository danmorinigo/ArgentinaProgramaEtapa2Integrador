package modelos;

import lombok.Data;

@Data
public class Especialidad implements Comparable{
    private long id;
    protected String nombre;
    public String toString(){
        return this.nombre;
    }

    @Override
    public int compareTo(Object especialidad) {
        Especialidad aComparar = (Especialidad) especialidad;
        return nombre.compareTo(aComparar.getNombre());
    }
}
