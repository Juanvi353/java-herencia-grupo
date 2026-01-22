package herencia;

import java.time.LocalDate;
import java.time.Period;

public class Persona {

    private String dni;
    protected String nombre;
    private LocalDate fechaNacimiento;
    private String email;
    private String telefono;

    public Persona(String dni, String nombre, LocalDate fechaNacimiento, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
    }

    public int calcularEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    public String presentarse() {
        return "Hola, me llamo " + nombre + ", tengo " + calcularEdad() + " años.";
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }
}