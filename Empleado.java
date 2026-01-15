public class Empleado extends Persona {
    protected double salarioBase;
    protected int antiguedadAnios;

    // Constructor completo
    public Empleado(String nombre, int edad, double salarioBase, int antiguedadAnios) {
        super(nombre, edad); 
        this.salarioBase = salarioBase;
        this.antiguedadAnios = antiguedadAnios;
    }

    // Metodo calcularSalario
    public double calcularSalario() {
        return salarioBase + (antiguedadAnios * 100);
    }

    // Metodo toString 
    @Override
    public String toString() {
        return super.toString() + ", Salario Base: " + salarioBase + ", Antigüedad: " + antiguedadAnios + " años, Salario Calculado: " + calcularSalario();
    }
}