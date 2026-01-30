/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;

public class PanelInicio extends JPanel {
    public PanelInicio(VentanaPrincipal ventana) {
        setLayout(new GridLayout(3, 2, 10, 10)); 
        setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        String[] opciones = {"REGISTRAR_EMPLEADO", "REGISTRAR_HORAS", "REGISTRAR_VENTAS", 
                             "ACTUALIZAR_CONTRATO", "CALCULAR_PAGO", "REPORTES"};
        String[] nombres = {"Registrar Empleado", "Registrar Horas", "Registrar Ventas", 
                            "Actualizar Contrato", "Calcular Pago", "Ver Reportes"};

        for (int i = 0; i < opciones.length; i++) {
            JButton boton = new JButton(nombres[i]);
            String destino = opciones[i];
            boton.addActionListener(e -> ventana.mostrarPanel(destino));
            add(boton);
        }
    }
}