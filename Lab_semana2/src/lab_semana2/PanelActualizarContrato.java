/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;

    import com.toedter.calendar.JDateChooser;
    import javax.swing.*;
    import java.awt.*;
    import java.time.LocalDate;
    import java.time.ZoneId;

public class PanelActualizarContrato extends JPanel {
    private JDateChooser calFin;
    private JTextField txtCod;

    public PanelActualizarContrato(VentanaPrincipal ventana, Empresa empresa) {
        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(10, 10, 10, 10);
        g.fill = GridBagConstraints.HORIZONTAL;

        txtCod = new JTextField(10);
        calFin = new JDateChooser();
        calFin.setDateFormatString("dd/MM/yyyy");

        g.gridx = 0; g.gridy = 0; add(new JLabel("Código Empleado:"), g);
        g.gridx = 1; add(txtCod, g);
        
        g.gridx = 0; g.gridy = 1; add(new JLabel("Nueva Fecha Fin:"), g);
        g.gridx = 1; add(calFin, g);

        JButton btnAct = new JButton("Actualizar Fecha");
        btnAct.addActionListener(e -> {
            if (calFin.getDate() == null) {
                JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha del calendario.");
                return;
            }

            LocalDate nuevaFecha = calFin.getDate().toInstant()
                                     .atZone(ZoneId.systemDefault())
                                     .toLocalDate();

            if (empresa.actualizarContrato(txtCod.getText(), nuevaFecha)) {
                JOptionPane.showMessageDialog(this, "Fecha de contrato actualizada correctamente.");
                ventana.mostrarPanel("INICIO");
            } else {
                JOptionPane.showMessageDialog(this, "Error: El empleado no existe o no es de tipo Temporal.");
            }
        });

        g.gridy = 2; g.gridx = 0; add(btnAct, g);
        g.gridx = 1;
        JButton btnVolver = new JButton("Regresar");
        btnVolver.addActionListener(ev -> ventana.mostrarPanel("INICIO"));
        add(btnVolver, g);
    }
}