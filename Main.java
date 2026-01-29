package herencia;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean salir = false;

    private static GestorEmpleados gestor = new GestorEmpleados();
    private static Departamento departamentoIT = new Departamento("IT", "Carlos", 50000);

    public static void main(String[] args) {

        while (!salir) {
            mostrarMenuPrincipal();
            int opcion = leerEntero("Selecciona una opción: ");

            switch (opcion) {
                case 1:
                    menuContratacion();
                    break;
                case 2:
                    menuFichaje();
                    break;
                case 3:
                    menuNominas();
                    break;
                case 4:
                    menuProyectos();
                    break;
                case 5:
                    menuInformes();
                    break;
                case 6:
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE GESTIÓN Y FICHAJE ===");
        System.out.println("1. CONTRATACIÓN");
        System.out.println("2. FICHAJE");
        System.out.println("3. NÓMINAS");
        System.out.println("4. PROYECTOS (Solo desarrolladores)");
        System.out.println("5. INFORMES");
        System.out.println("6. SALIR");
    }

    // ---------------------- Menú Contratación ----------------------
    private static void menuContratacion() {
        System.out.println("\n--- CONTRATACIÓN ---");
        System.out.println("1. Contratar empleado");
        System.out.println("2. Asignar a departamento");
        System.out.println("3. Ver contratos activos");

        int opcion = leerEntero("Opción: ");

        switch (opcion) {
            case 1:
                contratarEmpleado();
                break;
            case 2:
                asignarADepartamento();
                break;
            case 3:
                verContratosActivos();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void contratarEmpleado() {
        System.out.println("\n--- NUEVO EMPLEADO ---");
        System.out.print("DNI: ");
        String dni = scanner.next();
        System.out.print("ID empleado: ");
        String id = scanner.next();
        System.out.print("Nombre: ");
        scanner.nextLine(); // Limpiar buffer
        String nombre = scanner.nextLine();
        System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.next());
        System.out.print("Email: ");
        String email = scanner.next();
        System.out.print("Teléfono: ");
        String telefono = scanner.next();
        System.out.print("Salario base: ");
        double salario = leerDouble("Salario base: ");
        System.out.print("Fecha contratación (YYYY-MM-DD): ");
        LocalDate fechaContratacion = LocalDate.parse(scanner.next());
        System.out.print("Departamento: ");
        String dep = scanner.next();
        System.out.print("Jornada horaria (h/día): ");
        double jornada = leerDouble("Jornada horaria: ");

        Empleado e = new Empleado(dni, id, nombre, fechaNacimiento, email, telefono,
                salario, fechaContratacion, dep, jornada);
        gestor.agregarEmpleado(e);
        System.out.println("Empleado contratado correctamente: " + e.getNombre());
    }

    private static void asignarADepartamento() {
        System.out.println("\n--- ASIGNAR A DEPARTAMENTO ---");
        System.out.print("ID empleado: ");
        String id = scanner.next();
        Empleado e = gestor.obtenerEmpleado(id);
        if (e != null) {
            departamentoIT.agregarEmpleado(id);
            System.out.println("Empleado " + e.getNombre() + " asignado a departamento " + departamentoIT.getNombre());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    private static void verContratosActivos() {
        System.out.println("\n--- CONTRATOS ACTIVOS ---");
        for (String id : departamentoIT.listarEmpleados()) {
            Empleado e = gestor.obtenerEmpleado(id);
            if (e != null) {
                System.out.println(e);
            }
        }
    }

    // ---------------------- Menú Fichaje ----------------------
    private static void menuFichaje() {
        System.out.println("\n--- FICHAJE ---");
        System.out.println("1. Registrar entrada");
        System.out.println("2. Registrar salida");
        System.out.println("3. Consultar mis fichajes");
        System.out.println("4. Reporte mensual de horas");

        int opcion = leerEntero("Opción: ");

        switch (opcion) {
            case 1:
                System.out.println("Entrada registrada.");
                break;
            case 2:
                System.out.println("Salida registrada.");
                break;
            case 3:
                System.out.println("Consultando fichajes...");
                break;
            case 4:
                System.out.println("Generando reporte mensual...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // ---------------------- Menú Nóminas ----------------------
    private static void menuNominas() {
        System.out.println("\n--- NÓMINAS ---");
        System.out.println("1. Calcular salario empleado");
        System.out.println("2. Calcular nómina total");
        System.out.println("3. Ver historial de pagos");

        int opcion = leerEntero("Opción: ");

        switch (opcion) {
            case 1:
                System.out.print("ID empleado: ");
                String id = scanner.next();
                Empleado e = gestor.obtenerEmpleado(id);
                if (e != null) {
                    System.out.println("Salario de " + e.getNombre() + ": " + e.calcularSalario());
                } else {
                    System.out.println("Empleado no encontrado.");
                }
                break;
            case 2:
                System.out.println("Nómina total departamento IT: " + departamentoIT.calcularNominaDepartamento(gestor));
                break;
            case 3:
                System.out.println("Mostrando historial de pagos (simulado)...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // ---------------------- Menú Proyectos ----------------------
    private static void menuProyectos() {
        System.out.println("\n--- PROYECTOS ---");
        System.out.println("1. Asignar a proyecto");
        System.out.println("2. Registrar horas proyecto");
        System.out.println("3. Ver productividad");

        int opcion = leerEntero("Opción: ");

        switch (opcion) {
            case 1:
                System.out.println("Asignando a proyecto...");
                break;
            case 2:
                System.out.println("Registrando horas...");
                break;
            case 3:
                System.out.println("Calculando productividad...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // ---------------------- Menú Informes ----------------------
    private static void menuInformes() {
        System.out.println("\n--- INFORMES ---");
        System.out.println("1. Empleados por departamento");
        System.out.println("2. Asistencia mensual");
        System.out.println("3. Horas extra aprobadas");
        System.out.println("4. Proyectos activos");

        int opcion = leerEntero("Opción: ");

        switch (opcion) {
            case 1:
                System.out.println("Empleados en IT:");
                for (String id : departamentoIT.listarEmpleados()) {
                    Empleado e = gestor.obtenerEmpleado(id);
                    if (e != null) {
                        System.out.println("- " + e.getNombre());
                    }
                }
                break;
            case 2:
                System.out.println("Mostrando asistencia mensual...");
                break;
            case 3:
                System.out.println("Mostrando horas extra aprobadas...");
                break;
            case 4:
                System.out.println("Mostrando proyectos activos...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // ---------------------- Métodos auxiliares ----------------------
    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Introduce un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print("Introduce un número válido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
