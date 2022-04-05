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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FrmRegistro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistro frame = new FrmRegistro();
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
	public FrmRegistro() {
		setTitle("Registro de Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Registro Usuarios:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(10, 11, 165, 42);
		contentPane.add(lblTitulo);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(10, 49, 273, 35);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(10, 102, 273, 35);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(10, 148, 273, 35);
		contentPane.add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(10, 194, 273, 35);
		contentPane.add(passwordField);
		
		ImageIcon iconRegistrar = new ImageIcon("C:\\Users\\navis.service\\eclipse-workspace\\tarea4\\Images\\icons8-join-48.png");
	
		JButton btnSave = new JButton("Registrar",iconRegistrar);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setBounds(10, 240, 273, 63);
		contentPane.add(btnSave);
	}

}
