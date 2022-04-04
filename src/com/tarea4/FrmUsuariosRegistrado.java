package com.tarea4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTable;

public class FrmUsuariosRegistrado extends JFrame {

	private JPanel contentPane;

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
		btnActualizar.setBounds(136, 282, 106, 50);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(252, 282, 106, 50);
		contentPane.add(btnEliminar);
		
		JButton btnCerrarSeccion = new JButton("CERRAR SECCION");
		btnCerrarSeccion.setBounds(368, 282, 127, 50);
		contentPane.add(btnCerrarSeccion);
		
		JLabel lblNewLabel = new JLabel("Usuarios Registrado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 205, 24);
		contentPane.add(lblNewLabel);
	}
}
