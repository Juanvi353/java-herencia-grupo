import java.util.List;

public class Desarrollador extends Empleado {

    private String lenguajePrincipal;
    private String nivel;
    private List<String> tecnologias;
    private double horasExtra;

    public Desarrollador(String nombre, double salarioBase, String lenguajePrincipal,
                         String nivel, List<String> tecnologias) {
        super(nombre, salarioBase);
        this.lenguajePrincipal = lenguajePrincipal;
        this.nivel = nivel;
        this.tecnologias = tecnologias;
        this.horasExtra = 0.0;
    }

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

    public void registrarHoraExtra(double horas) {
        if (horas > 0) {
            this.horasExtra += horas;
        }
    }

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

        salario += horasExtra * 20;

        return salario;
    }
}
