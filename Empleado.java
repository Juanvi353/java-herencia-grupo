import java.time.LocalDate;

public class Empleado extends Persona {

    protected double salarioBase;
    protected int antiguedadAnios;

    
    protected String idEmpleado;
    protected LocalDate fechaContratacion;
    protected String departamento;
    protected double jornadaHoraria; 
    protected boolean activo;

    
    public Empleado(String nombre, int edad, double salarioBase, int antiguedadAnios) {
        super(nombre, edad);
        this.salarioBase = salarioBase;
        this.antiguedadAnios = antiguedadAnios;
        this.activo = true;
    }

    
    public Empleado(String idEmpleado, String nombre, int edad, double salarioBase,
                    LocalDate fechaContratacion, String departamento, double jornadaHoraria) {
        super(nombre, edad);
        this.idEmpleado = idEmpleado;
        this.salarioBase = salarioBase;
        this.fechaContratacion = fechaContratacion;
        this.departamento = departamento;
        this.jornadaHoraria = jornadaHoraria;
        this.activo = true;
        this.antiguedadAnios = calcularAntiguedad();
    }

    
    public int calcularAntiguedad() {
        if (fechaContratacion == null) {
            return antiguedadAnios;
        }
        return LocalDate.now().getYear() - fechaContratacion.getYear();
    }


    public double calcularSalario() {
        int antiguedad = calcularAntiguedad();
        double plusAntiguedad = salarioBase * 0.03 * antiguedad;
        return salarioBase + plusAntiguedad;
    }

  
    @Override
    public String toString() {
        return super.toString()
                + ", ID: " + idEmpleado
                + ", Departamento: " + departamento
                + ", Jornada: " + jornadaHoraria + "h/día"
                + ", Activo: " + activo
                + ", Salario Calculado: " + calcularSalario();
    }
}
