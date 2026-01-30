/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package lab_semana2;
    import javax.swing.*;
    import java.awt.*;
    import java.time.LocalDate;

public class PanelRegistrarEmpleado extends JPanel {
    private JTextField txtCod, txtNom, txtSal;
    private JComboBox<String> cbTipo;

    public PanelRegistrarEmpleado(VentanaPrincipal ventana, Empresa empresa) {
        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(5,5,5,5); g.fill = GridBagConstraints.HORIZONTAL;

        txtCod = new JTextField(10);
        txtNom = new JTextField(15);
        txtSal = new JTextField(10);
        cbTipo = new JComboBox<>(new String[]{"Estándar", "Temporal", "Ventas"});

        agregarCampo(this, "Código:", txtCod, g, 0);
        agregarCampo(this, "Nombre:", txtNom, g, 1);
        agregarCampo(this, "Salario Base:", txtSal, g, 2);
        agregarCampo(this, "Código:", new JTextField(10), g, 0);
        agregarCampo(this, "Nombre:", new JTextField(15), g, 1);
        agregarCampo(this, "Salario Base:", new JTextField(10), g, 2);
        
        g.gridx = 0; g.gridy = 3; add(new JLabel("Tipo:"), g);
        g.gridx = 1; add(cbTipo, g);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> {
            try {
                String cod = txtCod.getText();
                String nom = txtNom.getText();
                double sal = Double.parseDouble(txtSal.getText());
                String tipo = (String) cbTipo.getSelectedItem();

                Empleado nuevo;
                if (tipo.equals("Temporal")) {
                    nuevo = new EmpleadoTemporal(cod, nom, LocalDate.now().plusMonths(1));
                } else if (tipo.equals("Ventas")) {
                    nuevo = new EmpleadoVentas(cod, nom);
                } else {
                    nuevo = new Empleado(cod, nom);
                }
                nuevo.salarioBase = sal;

                if (empresa.registrarEmpleado(nuevo)) {
                    JOptionPane.showMessageDialog(this, "Empleado guardado con éxito.");
                    ventana.mostrarPanel("INICIO");
                } else {
                    JOptionPane.showMessageDialog(this, "Error: El código ya existe.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: Verifique los datos numéricos.");
            }
        });

        g.gridy = 4; g.gridx = 0; add(btnGuardar, g);


        
        

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