package herencia;

import java.time.LocalDate;
import java.util.List;

public class Desarrollador extends Empleado {

    private String lenguajePrincipal;
    private String nivel;
    private List<String> tecnologias;
    private double horasExtra;

    /**
     * Constructor completo del desarrollador
     */
    public Desarrollador(String dni, String idEmpleado, String nombre, LocalDate fechaNacimiento,
                         String email, String telefono, double salarioBase,
                         LocalDate fechaContratacion, String departamento, double jornadaHoraria,
                         String lenguajePrincipal, String nivel, List<String> tecnologias) {

        super(dni, idEmpleado, nombre, fechaNacimiento, email, telefono,
                salarioBase, fechaContratacion, departamento, jornadaHoraria);

        this.lenguajePrincipal = lenguajePrincipal;
        this.nivel = nivel;
        this.tecnologias = tecnologias;
        this.horasExtra = 0.0;
    }

    // ---------------------- Getters y Setters ----------------------
    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public List<String> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<String> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public double getHorasExtra() {
        return horasExtra;
    }

    /**
     * Registrar horas extra
     */
    public void registrarHoraExtra(double horas) {
        if (horas > 0) {
            this.horasExtra += horas;
        } else {
            System.out.println("No se pueden registrar horas negativas o cero.");
        }
    }

    /**
     * Calcular salario del desarrollador
     */
    @Override
    public double calcularSalario() {
        double salario = super.calcularSalario();

        // Plus por nivel
        switch (nivel) {
            case "Mid":
                salario *= 1.15;
                break;
            case "Senior":
                salario *= 1.30;
                break;
            case "Junior":
            default:
                break;
        }

        // Plus por horas extra
        salario += horasExtra * 20;

        return salario;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Lenguaje: " + lenguajePrincipal
                + ", Nivel: " + nivel
                + ", Tecnologías: " + tecnologias
                + ", Horas extra: " + horasExtra;
    }
}
