package herencia;

import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class GestorFichajes {

    private Map<String, List<Fichaje>> fichajes = new HashMap<>();

    public void registrarEntrada(String idEmpleado) {
        Fichaje fichaje = new Fichaje(
                UUID.randomUUID().toString(),
                idEmpleado,
                "ENTRADA"
        );
        fichajes.computeIfAbsent(idEmpleado, k -> new ArrayList<>()).add(fichaje);
    }

    public void registrarSalida(String idEmpleado) {
        Fichaje fichaje = new Fichaje(
                UUID.randomUUID().toString(),
                idEmpleado,
                "SALIDA"
        );
        fichajes.computeIfAbsent(idEmpleado, k -> new ArrayList<>()).add(fichaje);
    }

    public List<Fichaje> obtenerFichajesDelDia(String idEmpleado, LocalDate fecha) {
        List<Fichaje> resultado = new ArrayList<>();
        List<Fichaje> lista = fichajes.getOrDefault(idEmpleado, new ArrayList<>());

        for (Fichaje f : lista) {
            if (f.getFechaHoraEntrada() != null &&
                f.getFechaHoraEntrada().toLocalDate().equals(fecha)) {
                resultado.add(f);
            }
            if (f.getFechaHoraSalida() != null &&
                f.getFechaHoraSalida().toLocalDate().equals(fecha)) {
                resultado.add(f);
            }
        }
        return resultado;
    }

    public double calcularHorasMensuales(String idEmpleado, int mes, int año) {
        List<Fichaje> lista = fichajes.getOrDefault(idEmpleado, new ArrayList<>());
        double horas = 0;
        Fichaje entrada = null;

        for (Fichaje f : lista) {
            if (f.getTipo().equals("ENTRADA") &&
                f.getFechaHoraEntrada().getMonthValue() == mes &&
                f.getFechaHoraEntrada().getYear() == año) {
                entrada = f;
            }

            if (f.getTipo().equals("SALIDA") &&
                entrada != null &&
                f.getFechaHoraSalida().getMonthValue() == mes &&
                f.getFechaHoraSalida().getYear() == año) {

                horas += Duration.between(
                        entrada.getFechaHoraEntrada(),
                        f.getFechaHoraSalida()
                ).toMinutes() / 60.0;

                entrada = null;
            }
        }
        return horas;
    }

    public String generarReporteAsistencia(String idEmpleado) {
        StringBuilder sb = new StringBuilder();
        List<Fichaje> lista = fichajes.getOrDefault(idEmpleado, new ArrayList<>());

        for (Fichaje f : lista) {
            sb.append(f.getTipo()).append(" ");

            if (f.getFechaHoraEntrada() != null) {
                sb.append(f.getFechaHoraEntrada());
            }

            if (f.getFechaHoraSalida() != null) {
                sb.append(f.getFechaHoraSalida());
            }

            sb.append("\n");
        }
        return sb.toString();
    }
}