package com.example.pr5.pr5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddUser extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddUser dialog = new AddUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddUser() {
		setBounds(100, 100, 684, 505);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel TituloAñadirUsuario = new JLabel("Añadir usuario");
		TituloAñadirUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		TituloAñadirUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(TituloAñadirUsuario);
		
		JLabel TituloNombreUsuario = new JLabel("Nombre de usuario");
		TituloNombreUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		TituloNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(TituloNombreUsuario);
		
		JTextArea textArea = new JTextArea();
		getContentPane().add(textArea);
		
		JButton botonAñadir = new JButton("Añadir");
		botonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textArea.getText();
				if(!username.equals("")) {
					String URL_CONEXION = "jdbc:h2:file:~/test";
					String usuario = "sa";
					String password = "password";
					try {
						Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
						Statement statementAgregar = conn.createStatement();
						String sentenciaSQLAgregar = "INSERT INTO usuarios (nombre) VALUES (?)";
						PreparedStatement pstmtAgregar = conn.prepareStatement(sentenciaSQLAgregar);
						pstmtAgregar.setString(1, username);
						int filasAfectadas = pstmtAgregar.executeUpdate();
						if (filasAfectadas > 0) {
							System.out.println("Se insertó correctamente");
						} else {
							System.out.println("No se ha podido insertar");
						}
					
						
					}catch (SQLException ex) {
						
					}
					
				}
				
			}
		});
		getContentPane().add(botonAñadir);
		
		JButton botonAtras = new JButton("Atras");
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(botonAtras);
	}

}
