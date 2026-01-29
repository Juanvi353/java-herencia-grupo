import java.util.ArrayList;
import java.util.List;

public class Proyecto {

    private String idProyecto;
    private String nombre;
    private List<String> desarrolladoresAsignados;
    private double horasEstimadas;
    private double horasReales;
    private String estado;

    public Proyecto(String idProyecto, String nombre, double horasEstimadas) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.horasEstimadas = horasEstimadas;
        this.horasReales = 0.0;
        this.estado = "PLANIFICADO";
        this.desarrolladoresAsignados = new ArrayList<>();
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getDesarrolladoresAsignados() {
        return desarrolladoresAsignados;
    }

    public double getHorasEstimadas() {
        return horasEstimadas;
    }

    public double getHorasReales() {
        return horasReales;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void asignarDesarrollador(String idDesarrollador) {
        if (!desarrolladoresAsignados.contains(idDesarrollador)) {
            desarrolladoresAsignados.add(idDesarrollador);
        }
    }

    public void registrarHoras(String idDesarrollador, double horas) {
        if (desarrolladoresAsignados.contains(idDesarrollador) && horas > 0) {
            this.horasReales += horas;
            this.estado = "EN_CURSO";
        }
    }

    public double calcularProductividad() {
        if (horasReales == 0) {
            return 0;
        }
        return (horasEstimadas / horasReales) * 100;
    }
}