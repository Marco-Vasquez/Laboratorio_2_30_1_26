package lab_semana2;
import java.time.LocalDate;
public class EmpleadoVentas extends Empleado{
    LocalDate fecha;
    double ventasMens[]=new double[12], tasaComision;

    public EmpleadoVentas(String codigo, String nombre) {
        super(codigo, nombre);
        this.tasaComision=0.05;
        for(int i=0;i<12;i++){
            this.ventasMens[i]=0;
        }
        this.fecha=LocalDate.now();
    }
    
    public void registroVentas(double monto){
        ventasMens[fecha.getMonthValue()-1]+=monto;
    }
    
    public double calculoComision(){
       return ventasMens[fecha.getMonthValue()-1]*tasaComision;
    }
    
    @Override
    public double calcularPagoMensual(){
        return super.calcularPagoMensual()+calculoComision();
    }
    
    public double ventasAnuales(){
        return ventasAnuales(0);
    }
    
    private double ventasAnuales(int contador){
        if(contador<12)
            return ventasAnuales(contador+1)+ventasMens[contador];
        return 0; 
    }
    
    @Override
    public String mostrarInfo(){
        return super.mostrarInfo()+"\nVentas anuales: "+ventasAnuales();
    }
}
