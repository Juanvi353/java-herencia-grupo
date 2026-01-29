package herencia;

import java.time.LocalDate;

public class Manager extends Empleado {

    private int personasACargo;
    private String titulo;
    private double presupuestoGestionado;
    private int reunionesSemanales;

    // Constructor básico con solo personas a cargo
    public Manager(String dni, String idEmpleado, String nombre, LocalDate fechaNacimiento,
                   String email, String telefono, double salarioBase,
                   LocalDate fechaContratacion, String departamento, double jornadaHoraria,
                   int personasACargo) {

        super(dni, idEmpleado, nombre, fechaNacimiento, email, telefono,
                salarioBase, fechaContratacion, departamento, jornadaHoraria);

        this.personasACargo = personasACargo;
        this.titulo = "";
        this.presupuestoGestionado = 0;
        this.reunionesSemanales = 0;
    }

    // Constructor completo
    public Manager(String dni, String idEmpleado, String nombre, LocalDate fechaNacimiento,
                   String email, String telefono, double salarioBase,
                   LocalDate fechaContratacion, String departamento, double jornadaHoraria,
                   int personasACargo, String titulo, double presupuestoGestionado, int reunionesSemanales) {

        super(dni, idEmpleado, nombre, fechaNacimiento, email, telefono,
                salarioBase, fechaContratacion, departamento, jornadaHoraria);

        this.personasACargo = personasACargo;
        this.titulo = titulo;
        this.presupuestoGestionado = presupuestoGestionado;
        this.reunionesSemanales = reunionesSemanales;
    }

    @Override
    public double calcularSalario() {
        double salario = super.calcularSalario();

        // Plus por personas a cargo
        salario += personasACargo * 250;

        // Plus por presupuesto gestionado
        salario += presupuestoGestionado * 0.002;

        return salario;
    }

    public void aprobarHorasExtra(String idDesarrollador, double horas) {
        if (horas > 0) {
            System.out.println("Horas extra aprobadas para el desarrollador "
                    + idDesarrollador + ": " + horas + " horas");
        } else {
            System.out.println("No se puede aprobar horas negativas o cero.");
        }
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Personas a cargo: " + personasACargo
                + ", Título: " + titulo
                + ", Presupuesto gestionado: " + presupuestoGestionado
                + ", Reuniones semanales: " + reunionesSemanales;
    }

    // Getters y setters opcionales
    public int getPersonasACargo() { return personasACargo; }
    public String getTitulo() { return titulo; }
    public double getPresupuestoGestionado() { return presupuestoGestionado; }
    public int getReunionesSemanales() { return reunionesSemanales; }
}
