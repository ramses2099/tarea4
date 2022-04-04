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
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

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
		setBounds(100, 100, 519, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(10, 282, 106, 50);
		contentPane.add(btnNuevo);
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(126, 282, 106, 50);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(242, 282, 106, 50);
		contentPane.add(btnEliminar);
		
		JButton btnCerrarSeccion = new JButton("CERRAR SECCION");
		btnCerrarSeccion.setBounds(358, 282, 137, 50);
		contentPane.add(btnCerrarSeccion);
		
		JLabel lblNewLabel = new JLabel("Usuarios Registrado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 205, 24);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 483, 222);
		contentPane.add(scrollPane);
		
		tblUsuarios = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"Nombre","Apellido","Telefono","Email","Usuario"};
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		tblUsuarios.setModel(model);
		scrollPane.setViewportView(tblUsuarios);
	}
}
