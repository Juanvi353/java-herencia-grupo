import java.util.ArrayList;
import java.util.List;

public class Departamento {

    private String nombre;
    private String jefeDepartamento; 
    private double presupuestoAnual;
    private List<String> empleados; 

    public Departamento(String nombre, String jefeDepartamento, double presupuestoAnual) {
        this.nombre = nombre;
        this.jefeDepartamento = jefeDepartamento;
        this.presupuestoAnual = presupuestoAnual;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(String idEmpleado) {
        if (idEmpleado != null && !empleados.contains(idEmpleado)) {
            empleados.add(idEmpleado);
        }
    }

    public double calcularNominaDepartamento(GestorEmpleados gestor) {
        double totalNomina = 0.0;

        for (String idEmpleado : empleados) {
            totalNomina += gestor.obtenerSalario(idEmpleado);
        }

        return totalNomina;
    }

    public List<String> listarEmpleados() {
        return new ArrayList<>(empleados); 
    }

    public String getNombre() {
        return nombre;
    }

    public String getJefeDepartamento() {
        return jefeDepartamento;
    }

    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }
}

public interface GestorEmpleados {
    double obtenerSalario(String idEmpleado);
}

