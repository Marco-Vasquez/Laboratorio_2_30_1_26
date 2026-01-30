/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;

    public class PanelCalcularPago extends JPanel {
        public PanelCalcularPago(VentanaPrincipal ventana) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel pBusqueda = new JPanel(new FlowLayout());
        pBusqueda.add(new JLabel("Código:"));
        pBusqueda.add(new JTextField(10));
        JButton btnCalcular = new JButton("Calcular Pago");
        pBusqueda.add(btnCalcular);
        add(pBusqueda, BorderLayout.NORTH);

        JPanel pResultado = new JPanel(new GridLayout(3, 1));
        JLabel lblNombre = new JLabel("Empleado: ---", SwingConstants.CENTER);
        JLabel lblMonto = new JLabel("Monto a Pagar: $0.00", SwingConstants.CENTER);
        lblMonto.setFont(new Font("Arial", Font.BOLD, 18));
        
        pResultado.add(lblNombre);
        pResultado.add(lblMonto);
        add(pResultado, BorderLayout.CENTER);

        JButton btnRegresar = new JButton("Regresar al Menú Principal");
        btnRegresar.addActionListener(e -> ventana.mostrarPanel("INICIO"));
        add(btnRegresar, BorderLayout.SOUTH);
    }
}