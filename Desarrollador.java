package herencia;

public class Desarrollador extends Empleado {

    private String lenguajePrincipal;

    public Desarrollador(String dni, String nombre, int edad,
                         double salarioBase, int antiguedadAnios,
                         String lenguajePrincipal) {
        super(dni, nombre, edad, salarioBase, antiguedadAnios);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    @Override
    public double calcularSalario() {
        return super.calcularSalario() + 500;
    }
}
