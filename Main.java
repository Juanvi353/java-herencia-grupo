import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Antonio Lobato", 3000.0);
        Desarrollador dev1 = new Desarrollador("Mariano Rajoy", 4000.0, "Java");
        Manager manager1 = new Manager("Mark Verstappen", 5000.0, 5);

        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(empleado1);
        empleados.add(dev1);
        empleados.add(manager1);

        for (Empleado emp : empleados) {
            System.out.println("Tipo real del objeto: " + emp.getClass().getSimpleName());
            System.out.println("Presentación: " + emp.presentarse());
            System.out.println("Salario calculado: " + emp.calcularSalario());
            System.out.println("---");
        }
    }
}