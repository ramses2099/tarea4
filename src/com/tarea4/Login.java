package com.tarea4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JPasswordField passFContrasena;

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

	/**
	 * Create the frame.
	 */
	public Login() {
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
				 char[] input = passFContrasena.getPassword();
			        if (isPasswordCorrect(input)) {
			            JOptionPane.showMessageDialog(null,
			                "Success! You typed the right password.");
			        } else {
			            JOptionPane.showMessageDialog(null,
			                "Invalid password. Try again.",
			                "Error Message",
			                JOptionPane.ERROR_MESSAGE);
			        }

			        //Zero out the possible password, for security.
			        Arrays.fill(input, '0');

			        passFContrasena.selectAll();
			        
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEntrar.setBounds(10, 212, 247, 63);
		contentPane.add(btnEntrar);
		
		ImageIcon iconRegistrar = new ImageIcon("C:\\Users\\navis.service\\eclipse-workspace\\tarea4\\Images\\icons8-join-48.png");
		
		JButton btnRegistro = new JButton("Registrar",iconRegistrar);
		btnRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnRegistro.setBounds(10, 286, 247, 63);
		contentPane.add(btnRegistro);
		
		passFContrasena = new JPasswordField();
		passFContrasena.setBounds(10, 144, 247, 57);
		contentPane.add(passFContrasena);
	}
	
	private static boolean isPasswordCorrect(char[] input) {
	    boolean isCorrect = true;
	    char[] correctPassword = { 'b', 'u', 'g', 'a', 'b', 'o', 'o' };

	    if (input.length != correctPassword.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (input, correctPassword);
	    }

	    //Zero out the password.
	    Arrays.fill(correctPassword,'0');

	    return isCorrect;
	}
}
