package lab_semana2;
import java.time.LocalDate;
public class EmpleadoTemporal extends Empleado {
    
    LocalDate finContrato;

    public EmpleadoTemporal(String codigo, String nombre, LocalDate finContrato) {
        super(codigo, nombre);
        this.finContrato=finContrato;
    }
    
    @Override
     public double calcularPagoMensual(){
         if(LocalDate.now().isAfter(finContrato)){
             return 0;
         }
        return super.calcularPagoMensual();
     }
     
     public void actualizarFecha(LocalDate fecha){
         finContrato=fecha;
     }
     
    @Override
    public String mostrarInfo(){
        return super.mostrarInfo()+"\nFecha fin de contrato: "+finContrato;
    }
}
