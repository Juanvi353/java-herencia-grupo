package herencia;

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
        this.horasReales = 0;
        this.estado = "PLANIFICADO";
        this.desarrolladoresAsignados = new ArrayList<>();
    }

    public void asignarDesarrollador(String idDesarrollador) {
        if (!desarrolladoresAsignados.contains(idDesarrollador)) {
            desarrolladoresAsignados.add(idDesarrollador);
        }
    }

    public void registrarHoras(String idDesarrollador, double horas) {
        if (horas <= 0) {
            return;
        }

        if (desarrolladoresAsignados.contains(idDesarrollador)) {
            horasReales += horas;

            if (estado.equals("PLANIFICADO")) {
                estado = "EN_CURSO";
            }

            if (horasReales >= horasEstimadas) {
                estado = "COMPLETADO";
            }
        }
    }

    public double calcularProductividad() {
        if (horasReales == 0) {
            return 0;
        }
        return (horasEstimadas / horasReales) * 100;
    }

    @Override
    public String toString() {
        return "Proyecto: " + nombre +
                " | Estado: " + estado +
                " | Devs: " + desarrolladoresAsignados +
                " | Productividad: " + calcularProductividad() + "%";
    }
}
