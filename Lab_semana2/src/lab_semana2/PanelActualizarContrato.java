/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;
    import java.time.LocalDate;
    import java.time.ZoneId;
    import java.util.Date;

public class PanelActualizarContrato extends JPanel {
    public PanelActualizarContrato(VentanaPrincipal ventana, Empresa empresa) {
        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(10,10,10,10);

        JTextField txtCod = new JTextField(10);
        JSpinner fechaSpinner = new JSpinner(new SpinnerDateModel());
        fechaSpinner.setEditor(new JSpinner.DateEditor(fechaSpinner, "dd/MM/yyyy"));

        g.gridx = 0; g.gridy = 0; add(new JLabel("Código:"), g);
        g.gridx = 1; add(txtCod, g);
        g.gridx = 0; g.gridy = 1; add(new JLabel("Nueva Fecha:"), g);
        g.gridx = 1; add(fechaSpinner, g);

        JButton btnAct = new JButton("Actualizar");
        btnAct.addActionListener(e -> {
            Date fechaD = (Date) fechaSpinner.getValue();
            LocalDate ld = fechaD.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (empresa.actualizarContrato(txtCod.getText(), ld)) {
                JOptionPane.showMessageDialog(this, "Contrato actualizado.");
            } else {
                JOptionPane.showMessageDialog(this, "Error: Empleado no es Temporal.");
            }
        });
        
        g.gridy = 2; g.gridx = 0; add(btnAct, g);
        g.gridx = 1;
        JButton btnVolver = new JButton("Regresar");
        btnVolver.addActionListener(e -> ventana.mostrarPanel("INICIO"));
        add(btnVolver, g);
    }
}