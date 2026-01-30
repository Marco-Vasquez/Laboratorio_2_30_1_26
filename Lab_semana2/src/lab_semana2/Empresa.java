/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_semana2;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 *
 * @author andres
 */
public class Empresa {
    private ArrayList<Empleado> empleados;
    public Empresa(){
        empleados=new ArrayList<>();
    }
    
    public boolean registrarEmpleado(Empleado empleado){
        for(int control=0;control<empleados.size();control++){
            if(empleados.get(control).codigo.equals(empleado.codigo)){
                return false;
            }
        }
        empleados.add(empleado);
        return true;
    }
    public Empleado buscarEmpleado(String codigo){
        for(int control=0;control<empleados.size();control++){
            if(empleados.get(control).codigo.equals(codigo))
                return empleados.get(control);
        }
        return null;
    }
    public boolean registrarHoras(String codigo, double horas){
        Empleado empleado=buscarEmpleado(codigo);
        if(empleado!=null){
            empleado.registrarHoras(horas);
            return true;
        } 
        return false;
    }
    public boolean registrarVentas(String codigo, double monto){
        Empleado empleado=buscarEmpleado(codigo);
        if(empleado!=null){
            if(empleado.getClass().getSimpleName().equals("EmpleadoVentas")){
                ((EmpleadoVentas)empleado).registroVentas(monto);
                return true;
            }
        }
        return false;
    }
    public boolean actualizarContrato(String codigo, LocalDate fecha){
        Empleado empleado=buscarEmpleado(codigo);
        if(empleado!=null){
            if(empleado.getClass().getSimpleName().equals("EmpleadoTemporal")){
                ((EmpleadoTemporal)empleado).actualizarFecha(fecha);
                return true;
            }
        }
        return false;
    }
    
    public double calcularPago(String codigo){
        Empleado empleado=buscarEmpleado(codigo);
        if(empleado!=null){
            return empleado.calcularPagoMensual();
        }
        return 0;
    }
    public String generarReporte(){
        String reporte=" REPORTE DE EMPLEADOS ";
        int estandar=0, temporal=0, ventas=0;
        for(int control=0;control<empleados.size();control++){
            Empleado empleado=empleados.get(control);
            reporte=reporte+empleados.get(control).mostrarInfo()+"\n";
            reporte=reporte+"Pago mensual: "+empleados.get(control).calcularPagoMensual()+"\n";
            
            double pago=empleado.calcularPagoMensual();
            reporte+="Pago mensual: "+pago+"\n";
            
            String tipo=empleado.getClass().getSimpleName();
            if(tipo.equals("EmpleadoTemporal")){
                temporal++;
            }
            else if(tipo.equals("EmpleadoVentas")){
                EmpleadoVentas empv=(EmpleadoVentas)empleado;
                double comision=empv.calculoComision();
                double ventasMes=empv.ventasMens[LocalDate.now().getMonthValue()-1];
                reporte+="Ventas mes actual: "+ventasMes+"\n";
                reporte+="Comisión mes actual: "+comision+"\n";
                ventas++;
            }
            else
                estandar++;  
            reporte+="-------------\n";
        }
        reporte+="Total de empleados: \n";
        reporte+="Estandar: "+estandar+"\n";
        reporte+="Temporal: "+temporal+"\n";
        reporte+="Ventas: "+ventas+"\n";
        return reporte;
    }
    
}
