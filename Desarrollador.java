public class Desarrollador extends Empleado {
    private String lenguajePrincipal;

    public Desarrollador(String nombre, double salarioBase, String lenguajePrincipal) {
        super(nombre, salarioBase); // Llama al constructor de Empleado
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguaje) {
        this.lenguajePrincipal = lenguaje;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + 500.0;
    }
} 