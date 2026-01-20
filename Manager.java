package herencia;

public class Manager extends Empleado {

    protected int personasACargo;

    public Manager(String dni, String nombre, int edad,
                   double salarioBase, int antiguedadAnios,
                   int personasACargo) {
        super(dni, nombre, edad, salarioBase, antiguedadAnios);
        this.personasACargo = personasACargo;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (personasACargo * 100);
    }
}
