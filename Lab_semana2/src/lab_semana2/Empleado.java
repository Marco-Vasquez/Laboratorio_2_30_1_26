package lab_semana2;
import java.time.LocalDate;
public class Empleado {
    protected String codigo, nombre;
    protected LocalDate fecha;
    protected double horasTrabajadas, salarioBase;

    public Empleado(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha=LocalDate.now();
        this.horasTrabajadas=0;
    }
    
    public void registrarHoras(double horas){
        this.horasTrabajadas=+this.horasTrabajadas+horas;
    }
    
    public double calcularPagoMensual(){
        return (horasTrabajadas/160)*salarioBase;
    }
    
    public String mostrarInfo(){
        return "Codigo: "+codigo+"\n Nombre: "+nombre+"\n Horas trabajadas: "+horasTrabajadas;
    }
    
}
