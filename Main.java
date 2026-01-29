import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean salir = false;

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

    // ===== MENÚS =====

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE GESTIÓN Y FICHAJE ===");
        System.out.println("1. CONTRATACIÓN");
        System.out.println("2. FICHAJE");
        System.out.println("3. NÓMINAS");
        System.out.println("4. PROYECTOS (Solo desarrolladores)");
        System.out.println("5. INFORMES");
        System.out.println("6. SALIR");
    }

    private static void menuContratacion() {
        System.out.println("\n--- CONTRATACIÓN ---");
        System.out.println("1. Contratar empleado");
        System.out.println("2. Asignar a departamento");
        System.out.println("3. Ver contratos activos");

        int opcion = leerEntero("Opción: ");

        switch (opcion) {
            case 1:
                System.out.println("Contratando empleado...");
                break;
            case 2:
                System.out.println("Asignando a departamento...");
                break;
            case 3:
                System.out.println("Mostrando contratos activos...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

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

    private static void menuNominas() {
        System.out.println("\n--- NÓMINAS ---");
        System.out.println("1. Calcular salario empleado");
        System.out.println("2. Calcular nómina total");
        System.out.println("3. Ver historial de pagos");

        int opcion = leerEntero("Opción: ");

        switch (opcion) {
            case 1:
                System.out.println("Calculando salario...");
                break;
            case 2:
                System.out.println("Calculando nómina total...");
                break;
            case 3:
                System.out.println("Mostrando historial de pagos...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

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

    private static void menuInformes() {
        System.out.println("\n--- INFORMES ---");
        System.out.println("1. Empleados por departamento");
        System.out.println("2. Asistencia mensual");
        System.out.println("3. Horas extra aprobadas");
        System.out.println("4. Proyectos activos");

        int opcion = leerEntero("Opción: ");

        switch (opcion) {
            case 1:
                System.out.println("Mostrando empleados por departamento...");
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

    // ===== UTILIDAD =====

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Introduce un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
