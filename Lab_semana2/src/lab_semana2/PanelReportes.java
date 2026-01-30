/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;

public class PanelReportes extends JPanel {
    public PanelReportes(VentanaPrincipal ventana, Empresa empresa) {
        setLayout(new BorderLayout());
        JTextArea txtReporte = new JTextArea();
        txtReporte.setEditable(false);
        add(new JScrollPane(txtReporte), BorderLayout.CENTER);

        JButton btnGenerar = new JButton("Generar Reporte");
        btnGenerar.addActionListener(e -> {
            txtReporte.setText(empresa.generarReporte());
        });
        
        JPanel pSur = new JPanel();
        pSur.add(btnGenerar);
        JButton btnVolver = new JButton("Regresar");
        btnVolver.addActionListener(e -> ventana.mostrarPanel("INICIO"));
        pSur.add(btnVolver);
        
        add(pSur, BorderLayout.SOUTH);
    }
}