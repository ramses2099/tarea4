package com.tarea4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tarea4.repository.Repository;
import com.tarea4.repository.UserRepository;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JPasswordField passFContrasena;

	//respository
	private Repository rep = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
   //propretys
	public String getUserName() {
		return this.txtNombreUsuario.getText();
	}
	
	public String getPassword() {
		return this.passFContrasena.getText();
	}
	

	/**
	 * Create the frame.
	 */
	public Login() {
		//respository
		rep = new UserRepository();
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 283, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombreUsuario.setBounds(10, 76, 247, 57);
		contentPane.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Login");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTitulo.setBounds(10, 13, 144, 52);
		contentPane.add(lblTitulo);
		
		ImageIcon iconEntrar = new ImageIcon("C:\\Users\\navis.service\\eclipse-workspace\\tarea4\\Images\\icons8-key-2-48.png");
		
		JButton btnEntrar = new JButton("Entrar",new ImageIcon("C:\\Users\\navis.service\\eclipse-workspace\\tarea4\\Images\\icons8-key-2-48.png"));
		btnEntrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Valida campos UsuerName
				if(getUserName().length() <= 0) {
					JOptionPane.showMessageDialog(null,
							"debe ingresar su usuario y contraseña,\r\n si no está registrado debe registrarse ",
							"Error Message",
			                JOptionPane.ERROR_MESSAGE);
					//limpiar input text
					limpiarInput();
					return;
				}
				//valida la contrasena				
				if(getPassword().length() <= 0) {
					JOptionPane.showMessageDialog(null,
			                "debe ingresar su usuario y contraseña,\r\n si no está registrado debe registrarse ",
			                "Error Message",
			                JOptionPane.ERROR_MESSAGE);
					//limpiar input text 
					limpiarInput();
					return;
				}
				
				
				try {
					boolean valida = rep.isValidUser(getUserName(), getPassword());
					
					if(valida) {
						FrmUsuariosRegistrado frame = new FrmUsuariosRegistrado();
						frame.setVisible(true);
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null,
				                "Usuario y contrasena incorrecto. Intente de nuevo ",
				                "Error Message",
				                JOptionPane.ERROR_MESSAGE);
						//limpiar input text 
						limpiarInput();
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntrar.setBounds(10, 212, 247, 63);
		contentPane.add(btnEntrar);
		
		ImageIcon iconRegistrar = new ImageIcon("C:\\Users\\navis.service\\eclipse-workspace\\tarea4\\Images\\icons8-join-48.png");
		
		JButton btnRegistro = new JButton("Registrar",iconRegistrar);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmRegistro frmResgistro = new FrmRegistro();
				frmResgistro.setVisible(true);
				setVisible(false);
			}
		});
		btnRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegistro.setBounds(10, 286, 247, 63);
		contentPane.add(btnRegistro);
		
		passFContrasena = new JPasswordField();
		passFContrasena.setBounds(10, 144, 247, 57);
		contentPane.add(passFContrasena);
	}
	
	private void limpiarInput() {
		this.txtNombreUsuario.setText("");
		this.passFContrasena.setText("");		
	}
}
