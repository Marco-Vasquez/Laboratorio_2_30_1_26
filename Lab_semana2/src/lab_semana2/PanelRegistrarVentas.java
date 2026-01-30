/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;

public class PanelRegistrarVentas extends JPanel {
    public PanelRegistrarVentas(VentanaPrincipal ventana, Empresa empresa) {
        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(10, 10, 10, 10);
        g.fill = GridBagConstraints.HORIZONTAL;

        JTextField txtCod = new JTextField(10);
        JTextField txtMonto = new JTextField(10);

        g.gridx = 0; g.gridy = 0; add(new JLabel("Código Empleado:"), g);
        g.gridx = 1; add(txtCod, g);
        g.gridx = 0; g.gridy = 1; add(new JLabel("Monto de Venta ($):"), g);
        g.gridx = 1; add(txtMonto, g);

        JButton btnVenta = new JButton("Registrar Venta");
        btnVenta.addActionListener(e -> {
            try {
                if (empresa.registrarVentas(txtCod.getText(), Double.parseDouble(txtMonto.getText()))) {
                    JOptionPane.showMessageDialog(this, "Venta añadida al mes actual.");
                    ventana.mostrarPanel("INICIO");
                } else {
                    JOptionPane.showMessageDialog(this, "Error: El empleado no es de Ventas o no existe.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un monto válido.");
            }
        });

        g.gridy = 2; g.gridx = 0; add(btnVenta, g);
        g.gridx = 1;
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(e -> ventana.mostrarPanel("INICIO"));
        add(btnRegresar, g);
    }
}