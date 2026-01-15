public class Manager extends Empleado {
    protected int personasACargo;

    public Manager(String nombre, double salarioBase, int personasACargo) {
        super(nombre, salarioBase);
        this.personasACargo = personasACargo;
    }

    public int getPersonasACargo() {
        return personasACargo;
    }

    public void setPersonasACargo(int personas) {
        this.personasACargo = personas;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + (personasACargo * 100.0);
    }
} 