package herencia;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Empleado e1 = new Empleado("123A", "Antonio Lobato", 45, 3000, 5);
        Desarrollador d1 = new Desarrollador("456B", "Mariano Rajoy", 60, 4000, 10, "Java");
        Manager m1 = new Manager("789C", "Max Verstappen", 26, 5000, 3, 5);

        ArrayList<Empleado> empleados = new ArrayList<>();
        empleados.add(e1);
        empleados.add(d1);
        empleados.add(m1);

        for (Empleado emp : empleados) {
            System.out.println("Tipo real: " + emp.getClass().getSimpleName());
            System.out.println(emp.presentarse());
            System.out.println("Salario: " + emp.calcularSalario());
            System.out.println("-----");
        }
    }
}
