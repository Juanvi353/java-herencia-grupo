package herencia;

import java.util.HashMap;
import java.util.Map;

public class GestorEmpleados {

    private Map<String, Empleado> empleados;

    public GestorEmpleados() {
        empleados = new HashMap<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.put(empleado.getIdEmpleado(), empleado);
    }

    public double obtenerSalario(String idEmpleado) {
        Empleado e = empleados.get(idEmpleado);
        return (e != null) ? e.calcularSalario() : 0.0;
    }

    public Empleado obtenerEmpleado(String idEmpleado) {
        return empleados.get(idEmpleado);
    }
}
