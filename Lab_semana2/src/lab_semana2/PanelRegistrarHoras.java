/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;

public class PanelRegistrarHoras extends JPanel {
    public PanelRegistrarHoras(VentanaPrincipal ventana) {
        setLayout(new BorderLayout());
        
        JPanel pCentro = new JPanel(new GridLayout(4, 1, 10, 10));
        pCentro.add(new JLabel("Código Empleado:"));
        pCentro.add(new JTextField());
        pCentro.add(new JLabel("Monto de Venta:"));
        pCentro.add(new JTextField());

        add(pCentro, BorderLayout.CENTER);

        JButton btnRegresar = new JButton("Regresar al Menú");
        btnRegresar.addActionListener(e -> ventana.mostrarPanel("INICIO"));
        add(btnRegresar, BorderLayout.SOUTH);
    }
}