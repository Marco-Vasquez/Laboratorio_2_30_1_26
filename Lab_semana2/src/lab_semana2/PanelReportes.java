/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;

    public class PanelReportes extends JPanel {
        public PanelReportes(VentanaPrincipal ventana) {
        setLayout(new BorderLayout());

        String[] cols = {"Código", "Nombre", "Tipo", "Salario Final"};
        JTable tabla = new JTable(new Object[][]{}, cols); 
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel pSur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pSur.add(new JLabel("Total Empleados: 0"));
        
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(e -> ventana.mostrarPanel("INICIO"));
        pSur.add(btnRegresar);

        add(pSur, BorderLayout.SOUTH);
    }
}