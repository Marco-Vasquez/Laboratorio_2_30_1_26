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
    private Empresa empresa;
    public VentanaPrincipal() {
        setTitle("Gestión de Empleados");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);

        PanelInicio inicio = new PanelInicio(this);
        PanelRegistrarEmpleado registrarEmpleado = new PanelRegistrarEmpleado(this);
        PanelRegistrarHoras registrarHoras = new PanelRegistrarHoras(this);
        PanelRegistrarVentas registrarVentas = new PanelRegistrarVentas(this);
        PanelActualizarContrato actualizarContrato = new PanelActualizarContrato(this);
        PanelCalcularPago calcularPago = new PanelCalcularPago(this);
        PanelReportes reportes = new PanelReportes(this);

        panelContenedor.add(inicio, "INICIO");
        panelContenedor.add(registrarEmpleado, "REGISTRAR_EMPLEADO");
        panelContenedor.add(registrarHoras, "REGISTRAR_HORAS");
        panelContenedor.add(registrarVentas, "REGISTRAR_VENTAS");
        panelContenedor.add(actualizarContrato, "ACTUALIZAR_CONTRATO");
        panelContenedor.add(calcularPago, "CALCULAR_PAGO");
        panelContenedor.add(reportes, "REPORTES");

        add(panelContenedor);
        cardLayout.show(panelContenedor, "INICIO");
    }
    public void mostrarPanel(String nombre) {
        cardLayout.show(panelContenedor, nombre);
    }
}
    

