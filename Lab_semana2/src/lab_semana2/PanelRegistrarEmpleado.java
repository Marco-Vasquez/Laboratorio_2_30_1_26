/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;

    public class PanelRegistrarEmpleado extends JPanel {
        public PanelRegistrarEmpleado(VentanaPrincipal ventana) {
        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(5,5,5,5); g.fill = GridBagConstraints.HORIZONTAL;

        agregarCampo(this, "Código:", new JTextField(10), g, 0);
        agregarCampo(this, "Nombre:", new JTextField(15), g, 1);
        agregarCampo(this, "Salario Base:", new JTextField(10), g, 2);
        
        g.gridx = 0; g.gridy = 3; add(new JLabel("Tipo:"), g);
        g.gridx = 1; add(new JComboBox<>(new String[]{"Estándar", "Temporal", "Ventas"}), g);

        
        g.gridy = 4; g.gridx = 0;
        JButton btnGuardar = new JButton("Guardar");
        add(btnGuardar, g);
        //btnGuardar.addActionListener(e -> )

        g.gridx = 1;
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(e -> ventana.mostrarPanel("INICIO"));
        add(btnRegresar, g);
    }

    private void agregarCampo(JPanel p, String txt, JComponent c, GridBagConstraints g, int y) {
        g.gridx = 0; g.gridy = y; p.add(new JLabel(txt), g);
        g.gridx = 1; p.add(c, g);
    }
}