
package vista;

import controlador.enlace;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.datos;

public class Interfaz extends JFrame{
    private JTextField nombreField;
    private JTextField cedulaField;
    private JTextField correoField;
    private JTextField telefonoField;
    private JButton insertarButton;
    private JButton eliminarButton;
    private JButton actualizarButton;
    private JTable tabla;
    private enlace controlador;

    public Interfaz() {
        controlador = new enlace();

        // Crear componentes
        nombreField = new JTextField();
        cedulaField = new JTextField();
        correoField = new JTextField();
        telefonoField = new JTextField();
        insertarButton = new JButton("Insertar");
        eliminarButton = new JButton("Eliminar");
        actualizarButton = new JButton("Actualizar");
        tabla = new JTable();

        // Crear panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        // Agregar componentes al panel
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(4, 1));
        panelDatos.add(new JLabel("Nombre:"));
        panelDatos.add(nombreField);
        panelDatos.add(new JLabel("Cédula:"));
        panelDatos.add(cedulaField);
        panelDatos.add(new JLabel("Correo:"));
        panelDatos.add(correoField);
        panelDatos.add(new JLabel("Teléfono:"));
        panelDatos.add(telefonoField);
        panel.add(panelDatos);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(3, 1));
        panelBotones.add(insertarButton);
        panelBotones.add(eliminarButton);
        panelBotones.add(actualizarButton);
        panel.add(panelBotones);

        // Agregar tabla
        JScrollPane scrollPane = new JScrollPane(tabla);
        panel.add(scrollPane);

        // Agregar panel a la ventana
        add(panel);

        // Establecer tamaño y título de la ventana
        setSize(400, 300);
        setTitle("Taller");

        // Agregar listeners a los botones
        insertarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertarDatos();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarDatos();
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarDatos();
            }
        });
    }

    private void insertarDatos() {
        String nombre = nombreField.getText();
        String cedula = cedulaField.getText();
        String correo = correoField.getText();
        String telefono = telefonoField.getText();

        datos d = new datos(nombre, cedula, correo, telefono);
        controlador.insertarData(d);

        actualizarTabla();
    }

    private void eliminarDatos() {
        String cedula = cedulaField.getText();

        datos d = new datos("", cedula, "", "");
        controlador.eliminarData(d);

        actualizarTabla();
    }

    private void actualizarDatos() {
        String nombre = nombreField.getText();
        String cedula = cedulaField.getText();
        String correo = correoField.getText();
        String telefono = telefonoField.getText();

        datos d = new datos(nombre, cedula, correo, telefono);
        controlador.actualizarData(d);

        actualizarTabla();
    }

    private void actualizarTabla() {
        ArrayList<datos> lista = controlador.getData();
        tabla.setModel(new DefaultTableModel(
                new Object[][]{},
                new Object[]{"Nombre", "Cédula", "Correo", "Teléfono"}
        ));

        for (datos d : lista) {
            ((DefaultTableModel) tabla.getModel()).addRow(new Object[]{d.getNombre(), d.getCedula(), d.getCorreo(), d.getTelefono()});
        }
    }

    public static void main(String[] args) {
        new Interfaz().setVisible(true);
    }
}
