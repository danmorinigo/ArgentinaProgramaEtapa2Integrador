package Controller;

import Repository.ReferenciasRepository;
import modelos.SoporteTecnico.Referencia;
import modelos.SoporteTecnico.Servicio;

import java.util.List;

public class ReferenciasController {
    private ReferenciasRepository comunicacionDB;

    public ReferenciasRepository getcomunicacionDB() {
        return comunicacionDB;
    }

    public void setcomunicacionDB(ReferenciasRepository comunicacionDB) {
        this.comunicacionDB = comunicacionDB;
    }

    public ReferenciasController() {
        this.comunicacionDB = new ReferenciasRepository();
    }

    public void agregarReferencia(String nombre) {
        Referencia aGuardar = new Referencia();
        aGuardar.setNombre(nombre);

        if(!nombreRefExiste(nombre)){
            comunicacionDB.getEm().getTransaction().begin();
            comunicacionDB.insertarReferencia(aGuardar);
            comunicacionDB.getEm().getTransaction().commit();
            System.out.println("Guardado!!");
        }else{
            System.out.println("No se guardo porque ya existe!");
        }
    }
    public List<Referencia> referenciasGuardadas(){
        return comunicacionDB.referencias();
    }
    private boolean nombreRefExiste(String nombre) {
        List<Referencia> refGuardadas = comunicacionDB.referencias();
        return refGuardadas.stream().anyMatch(r -> r.getNombre().equalsIgnoreCase(nombre));
    }

    public void agregarServicio(long codigo) {
        if(codigoRefExiste(codigo) && !brindamosServicioRef(codigo)){
            Referencia nombre = comunicacionDB.refPorId(codigo);
            Servicio aGuardar = new Servicio();
            aGuardar.setReferencia(nombre);
            comunicacionDB.getEm().getTransaction().begin();
            comunicacionDB.insertarServicio(aGuardar);
            comunicacionDB.getEm().getTransaction().commit();
            System.out.println("Guardado!!" + aGuardar.getReferencia());
        }else{
            System.out.println("No se guardo porque no existe o ya brindamos ese servicio!");
        }
    }

    private boolean brindamosServicioRef(long codigo) {
        Referencia ref = comunicacionDB.refPorId(codigo);
        //String nombreRef = ref.getNombre();
        List<Servicio> servicios = comunicacionDB.servicios();
        for(Servicio s : servicios){
            if(s.getReferencia() == ref){
                return true;
            }
        }
        return false;
    }

    private boolean codigoRefExiste(long codigo) {
        List<Referencia> refGuardadas = comunicacionDB.referencias();
        return refGuardadas.stream().anyMatch(r -> r.getId() == codigo);
    }

    public List<Servicio> serviciosGuardados() {
        return comunicacionDB.servicios();
    }
}
