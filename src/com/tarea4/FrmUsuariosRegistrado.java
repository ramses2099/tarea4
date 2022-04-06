package com.tarea4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.tarea4.model.Usuarios;
import com.tarea4.repository.Repository;
import com.tarea4.repository.UserRepository;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmUsuariosRegistrado extends JFrame {

	private JPanel contentPane;
	private JTable tblUsuarios;
	private DefaultTableModel model;
	private Object[] row;
	
	//respository
	private Repository rep = null;
		

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
		btnCerrarSeccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				setVisible(false);
			}
		});
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
		row = new Object[5];
		model.setColumnIdentifiers(column);
		
		scrollPane.setViewportView(tblUsuarios);
		
		//respository
	    rep = new UserRepository();
	    
	    fillGrid();
	}
	
	public void fillGrid() {
		
		try {
			List<Usuarios> usuarios = rep.getUsuarios();
			for (Usuarios user: usuarios){
				row[0] = user.getNombre();
				row[1] = user.getApellido();
				row[2] = user.getTelefono();
				row[3] = user.getEmail();
				row[4] = user.getNombre_usuario();
				model.addRow(row);
			}
			
			tblUsuarios.setModel(model);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
