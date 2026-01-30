/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;

public class PanelCalcularPago extends JPanel {
    public PanelCalcularPago(VentanaPrincipal ventana, Empresa empresa) {
        setLayout(new BorderLayout());
        JTextField txtCod = new JTextField(10);
        JLabel lblResultado = new JLabel("Pago: $0.00", SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel pNorte = new JPanel();
        pNorte.add(new JLabel("Código:")); pNorte.add(txtCod);
        
        JButton btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(e -> {
            double pago = empresa.calcularPago(txtCod.getText());
            lblResultado.setText("Pago Mensual: $" + String.format("%.2f", pago));
        });
        pNorte.add(btnCalcular);

        add(pNorte, BorderLayout.NORTH);
        add(lblResultado, BorderLayout.CENTER);
        
        JButton btnVolver = new JButton("Regresar");
        btnVolver.addActionListener(e -> ventana.mostrarPanel("INICIO"));
        add(btnVolver, BorderLayout.SOUTH);
    }
}