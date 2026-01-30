/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;
    import java.util.Date;

    public class PanelActualizarContrato extends JPanel {
        public PanelActualizarContrato(VentanaPrincipal ventana) {
        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(10, 10, 10, 10);
        g.fill = GridBagConstraints.HORIZONTAL;

        g.gridx = 0; g.gridy = 0; add(new JLabel("Código (Temporal):"), g);
        g.gridx = 1; add(new JTextField(10), g);

        g.gridx = 0; g.gridy = 1; add(new JLabel("Nueva Fecha Fin:"), g);
        JSpinner fechaSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(fechaSpinner, "dd/MM/yyyy");
        fechaSpinner.setEditor(editor);
        g.gridx = 1; add(fechaSpinner, g);

        g.gridy = 2; g.gridx = 0;
        JButton btnActualizar = new JButton("Actualizar Fecha");
        add(btnActualizar, g);

        g.gridx = 1;
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(e -> ventana.mostrarPanel("INICIO"));
        add(btnRegresar, g);
    }
}