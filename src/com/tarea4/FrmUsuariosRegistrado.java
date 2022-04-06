package com.tarea4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class FrmUsuariosRegistrado extends JFrame {

	private JPanel contentPane;
	private JTable tblUsuarios;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUsuariosRegistrado frame = new FrmUsuariosRegistrado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmUsuariosRegistrado() {
		setTitle("Registro Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon iconNuevo = new ImageIcon("C:\\Users\\navis.service\\eclipse-workspace\\tarea4\\Images\\icons8-add-folder-48.png");
		
		JButton btnNuevo = new JButton("NUEVO",iconNuevo);
		btnNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		btnNuevo.setBounds(10, 282, 137, 50);
		contentPane.add(btnNuevo);
		
		ImageIcon iconActualizar = new ImageIcon("C:\\Users\\navis.service\\eclipse-workspace\\tarea4\\Images\\icons8-create-16.png");
		
		JButton btnActualizar = new JButton("ACTUALIZAR",iconActualizar);
		btnActualizar.setBounds(157, 282, 133, 50);
		contentPane.add(btnActualizar);
		
		ImageIcon iconEliminar = new ImageIcon("C:\\Users\\navis.service\\eclipse-workspace\\tarea4\\Images\\icons8-denied-skin-type-7-48.png");
		
		JButton btnEliminar = new JButton("ELIMINAR",iconEliminar);
		btnEliminar.setBounds(290, 282, 141, 50);
		contentPane.add(btnEliminar);
		
		ImageIcon iconCerrar = new ImageIcon("C:\\Users\\navis.service\\eclipse-workspace\\tarea4\\Images\\icons8-logout-48.png");
		
		JButton btnCerrarSeccion = new JButton("CERRAR SECCION",iconCerrar);
		btnCerrarSeccion.setBounds(434, 282, 205, 50);
		contentPane.add(btnCerrarSeccion);
		
		JLabel lblNewLabel = new JLabel("Usuarios Registrado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 205, 24);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 629, 222);
		contentPane.add(scrollPane);
		
		tblUsuarios = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Nombre","Apellido","Telefono","Email","Usuario"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		model.setNumRows(1);
		tblUsuarios.setModel(model);
		scrollPane.setViewportView(tblUsuarios);
	}
}
