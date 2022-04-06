package com.tarea4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tarea4.model.Usuarios;
import com.tarea4.repository.Repository;
import com.tarea4.repository.UserRepository;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRegistro extends JFrame implements MouseListener {

	// fields
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtNombreUsuario;
	private JPasswordField passFContrasena;
	private JPasswordField passFContrasena2;

	// respository
	private Repository rep = null;

	// propertys
	public String Nombre() {
		return txtNombre.getText();
	}

	//
	public String Apellido() {
		return txtApellido.getText();
	}

	//
	public String NombreUsuario() {
		return txtNombreUsuario.getText();
	}

	//
	public String Contrasenaa() {
		return passFContrasena.getText();
	}

	/**
	 * Create the frame.
	 */
	public FrmRegistro() {

		// respository
		rep = new UserRepository();

		setTitle("Registro de Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Registro Usuarios:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setBounds(10, 11, 165, 42);
		contentPane.add(lblTitulo);

		txtNombre = new JTextField();
		txtNombre.setText("Nombre");
		txtNombre.addMouseListener(this);
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 49, 273, 35);
		contentPane.add(txtNombre);

		txtApellido = new JTextField();
		txtApellido.setText("Apellido");
		txtApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtApellido.setColumns(10);
		txtApellido.setBounds(10, 102, 273, 35);
		contentPane.add(txtApellido);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setText("Nombre Usuario");
		txtNombreUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNombreUsuario.setColumns(10);
		txtNombreUsuario.setBounds(10, 148, 273, 35);
		contentPane.add(txtNombreUsuario);

		passFContrasena = new JPasswordField();
		passFContrasena.setToolTipText("Contrase\u00F1a");
		passFContrasena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passFContrasena.setBounds(10, 194, 273, 35);
		contentPane.add(passFContrasena);

		ImageIcon iconRegistrar = new ImageIcon(
				"C:\\Users\\navis.service\\eclipse-workspace\\tarea4\\Images\\icons8-join-48.png");

		JButton btnSave = new JButton("Registrar", iconRegistrar);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// valida
				if (txtNombre.getText().equals("") || txtNombre.getText().equals("Nombre")) {
					JOptionPane.showMessageDialog(null, "debe ingresar un nombre ", "Error Message",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else if (txtApellido.getText().equals("") || txtApellido.getText().equals("Apellido")) {
					JOptionPane.showMessageDialog(null, "debe ingresar un Apellido ", "Error Message",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else if (txtNombreUsuario.getText().equals("")
						|| txtNombreUsuario.getText().equals("Nombre Usuario")) {
					JOptionPane.showMessageDialog(null, "debe ingresar un nombre de usuario ", "Error Message",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

				if (passFContrasena.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "debe ingresar una contraseña ", "Error Message",
							JOptionPane.ERROR_MESSAGE);
					return;

				} else if (passFContrasena2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "debe ingresar de confirmar la contraseña ", "Error Message",
							JOptionPane.ERROR_MESSAGE);

					return;
				} else {
					if (!passFContrasena.getText().toString().equals(passFContrasena2.getText().toString())) {
						JOptionPane.showMessageDialog(null,
								"la contraseña es diferente a la confirmacion de la contraseña ", "Error Message",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

				}
				// Registrar
				Usuarios user = new Usuarios();
				user.setNombre_usuario(NombreUsuario());
				user.setContrasena_usuario(Contrasenaa());
				user.setNombre(Nombre());
				user.setApellido(Apellido());

				try {
					int n = rep.add(user);

					if (n > 0) {
						JOptionPane.showMessageDialog(null, "Usuario registrado correctamente ", "Info Message",
								JOptionPane.INFORMATION_MESSAGE);
						limpiarFields();
						Login login = new Login();
						login.setVisible(true);
						setVisible(false);
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setBounds(10, 292, 273, 63);
		contentPane.add(btnSave);

		passFContrasena2 = new JPasswordField();
		passFContrasena2.setToolTipText("Confirmacion de la Contrase\u00F1a");
		passFContrasena2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passFContrasena2.setBounds(10, 240, 273, 35);
		contentPane.add(passFContrasena2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (txtNombre.getText().equals("Nombre")) {
			txtNombre.setText("");
			repaint();
			revalidate();
		}

		if (txtApellido.getText().equals("Apellido")) {
			txtApellido.setText("");
			repaint();
			revalidate();
		}

		if (txtNombreUsuario.getText().equals("Nombre Usuario")) {
			txtNombreUsuario.setText("");
			repaint();
			revalidate();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if (txtNombre.getText().equals("")) {
			txtNombre.setText("Nombre");
			repaint();
			revalidate();
		}

		if (txtApellido.getText().equals("")) {
			txtApellido.setText("Apellido");
			repaint();
			revalidate();
		}

		if (txtNombreUsuario.getText().equals("")) {
			txtNombreUsuario.setText("Nombre Usuario");
			repaint();
			revalidate();
		}
	}

	public void limpiarFields() {
		txtNombre.setText("Nombre");
		txtApellido.setText("Apellido");
		txtNombreUsuario.setText("Nombre Usuario");
		passFContrasena.setText("");
		passFContrasena2.setText("");
	}

}
