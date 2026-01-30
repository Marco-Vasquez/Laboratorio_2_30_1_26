/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;

public class PanelRegistrarHoras extends JPanel {
    public PanelRegistrarHoras(VentanaPrincipal ventana, Empresa empresa) {
        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(10, 10, 10, 10);
        g.fill = GridBagConstraints.HORIZONTAL;

        JTextField txtCod = new JTextField(10);
        JTextField txtHrs = new JTextField(10);

        g.gridx = 0; g.gridy = 0; add(new JLabel("Código Empleado:"), g);
        g.gridx = 1; add(txtCod, g);
        g.gridx = 0; g.gridy = 1; add(new JLabel("Horas a Registrar:"), g);
        g.gridx = 1; add(txtHrs, g);

        JButton btnGuardar = new JButton("Registrar Horas");
        btnGuardar.addActionListener(e -> {
            try {
                if (empresa.registrarHoras(txtCod.getText(), Double.parseDouble(txtHrs.getText()))) {
                    JOptionPane.showMessageDialog(this, "Horas registradas correctamente.");
                    ventana.mostrarPanel("INICIO");
                } else {
                    JOptionPane.showMessageDialog(this, "Empleado no encontrado.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido en horas.");
            }
        });

        g.gridy = 2; g.gridx = 0; add(btnGuardar, g);
        g.gridx = 1;
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(e -> ventana.mostrarPanel("INICIO"));
        add(btnRegresar, g);
    }
}