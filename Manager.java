package herencia;

public class Manager extends Empleado {

    protected int personasACargo;

    protected String titulo; // Team Lead, Department Head, Director
    protected double presupuestoGestionado;
    protected int reunionesSemanales;

    public Manager(String dni, String nombre, int edad,
                   double salarioBase, int antiguedadAnios,
                   int personasACargo) {
        super(dni, nombre, edad, salarioBase, antiguedadAnios);
        this.personasACargo = personasACargo;
    }

    public Manager(String dni, String nombre, int edad,
                   double salarioBase, int antiguedadAnios,
                   int personasACargo, String titulo,
                   double presupuestoGestionado, int reunionesSemanales) {
        super(dni, nombre, edad, salarioBase, antiguedadAnios);
        this.personasACargo = personasACargo;
        this.titulo = titulo;
        this.presupuestoGestionado = presupuestoGestionado;
        this.reunionesSemanales = reunionesSemanales;
    }

    @Override
    public double calcularSalario() {
        double salario = super.calcularSalario();

        salario += personasACargo * 250;

        salario += presupuestoGestionado * 0.002;

        return salario;
    }

   public void aprobarHorasExtra(String idDesarrollador, double horas) {
        if (horas > 0) {
            System.out.println("Horas extra aprobadas para el desarrollador "
                    + idDesarrollador + ": " + horas + " horas");
        }
    }
}
