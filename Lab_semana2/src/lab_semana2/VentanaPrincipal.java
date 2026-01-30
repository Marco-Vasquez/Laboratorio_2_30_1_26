/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelContenedor;
    private Empresa empresaLogic;

    public VentanaPrincipal() {
        setTitle("Gestión de Empleados");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        empresaLogic = new Empresa();
        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);

        
        panelContenedor.add(new PanelInicio(this), "INICIO");
        panelContenedor.add(new PanelRegistrarEmpleado(this, empresaLogic), "REGISTRAR_EMPLEADO");
        panelContenedor.add(new PanelRegistrarHoras(this, empresaLogic), "REGISTRAR_HORAS");
        panelContenedor.add(new PanelRegistrarVentas(this, empresaLogic), "REGISTRAR_VENTAS");
        panelContenedor.add(new PanelActualizarContrato(this, empresaLogic), "ACTUALIZAR_CONTRATO");
        panelContenedor.add(new PanelCalcularPago(this, empresaLogic), "CALCULAR_PAGO");
        panelContenedor.add(new PanelReportes(this, empresaLogic), "REPORTES");

        add(panelContenedor);
        cardLayout.show(panelContenedor, "INICIO");
    }

    public void mostrarPanel(String nombre) {
        cardLayout.show(panelContenedor, nombre);
    }
}
    

