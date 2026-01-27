package herencia;

import java.util.List;

public class Desarrollador extends Empleado {

    private String lenguajePrincipal;
    private String nivel;
    private List<String> tecnologias;
    private double horasExtra;

    public Desarrollador(String dni, String nombre, int edad,
                         double salarioBase, int antiguedadAnios,
                         String lenguajePrincipal,
                         String nivel,
                         List<String> tecnologias) {

        super(dni, nombre, edad, salarioBase, antiguedadAnios);
        this.lenguajePrincipal = lenguajePrincipal;
        this.nivel = nivel;
        this.tecnologias = tecnologias;
        this.horasExtra = 0;
    }

    @Override
    public double calcularSalario() {
        double salario = super.calcularSalario();

        // Plus por nivel
        switch (nivel.toLowerCase()) {
            case "mid":
                salario *= 1.15;
                break;
            case "senior":
                salario *= 1.30;
                break;
            case "junior":
            default:
                break;
        }

        // Horas extra
        salario += horasExtra * 20;

        // Plus fijo por ser desarrollador
        salario += 500;

        return salario;
    }

    public void registrarHoraExtra(double horas) {
        if (horas > 0) {
            horasExtra += horas;
        }
    }

    @Override
    public String toString() {
        return nombre +
                " - " + lenguajePrincipal +
                " (" + nivel + ")" +
                " - Tecnologías: " + tecnologias +
                " - Salario: " + calcularSalario();
    }
}
