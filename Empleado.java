package herencia;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Empleado extends Persona {


    protected double salarioBase;
    protected int antiguedadAnios;
    protected String idEmpleado;
    protected LocalDate fechaContratacion;
    protected String departamento;
    protected double jornadaHoraria;
    protected boolean activo;

    public Empleado(String dni, String nombre, int edad,
                    double salarioBase, int antiguedadAnios) {
        super(dni, nombre, edad);
        this.salarioBase = salarioBase;
        this.antiguedadAnios = antiguedadAnios;
    }

    public int calcularAntiguedad() {
        if (fechaContratacion == null) {
            return antiguedadAnios; 
        }
        return (int) ChronoUnit.YEARS.between(fechaContratacion, LocalDate.now());
    }

    public double calcularSalario() {
        int anios = calcularAntiguedad();
        return salarioBase * (1 + (anios * 0.03));
    }

    @Override
    public String toString() {
        return nombre + " - Salario: " + calcularSalario();
    }
}