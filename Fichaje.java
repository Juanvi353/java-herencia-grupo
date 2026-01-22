package herencia;

import java.time.LocalDateTime;

public class Fichaje {

    private String idFichaje;
    private String idEmpleado;
    private LocalDateTime fechaHoraEntrada;
    private LocalDateTime fechaHoraSalida;
    private String tipo;

    public Fichaje(String idFichaje, String idEmpleado, String tipo) {
        this.idFichaje = idFichaje;
        this.idEmpleado = idEmpleado;
        this.tipo = tipo;

        if (tipo.equals("ENTRADA")) {
            this.fechaHoraEntrada = LocalDateTime.now();
        }

        if (tipo.equals("SALIDA")) {
            this.fechaHoraSalida = LocalDateTime.now();
        }
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDateTime getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }
}