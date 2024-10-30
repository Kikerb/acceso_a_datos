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

public class AddProduct extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddProduct dialog = new AddProduct();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddProduct() {
		setBounds(100, 100, 483, 486);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
			JLabel lblNewLabel_2 = new JLabel("Añadir producto");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_2);
			JLabel lblNewLabel_1 = new JLabel("Nombre del producto");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_1);
			JTextArea textAreaProducto = new JTextArea();
			contentPanel.add(textAreaProducto);
			JLabel TituloPrecio = new JLabel("Precio del producto");
			TituloPrecio.setFont(new Font("Tahoma", Font.BOLD, 12));
			TituloPrecio.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(TituloPrecio);
			JTextArea textAreaPrecio = new JTextArea();
			contentPanel.add(textAreaPrecio);
			JButton BotonAñadir = new JButton("Añadir");
			
			BotonAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String nombreProducto = textAreaProducto.getText();
					double precioProducto = Double.valueOf(textAreaPrecio.getText());
					
					if(!nombreProducto.equals("")) {
						String URL_CONEXION = "jdbc:h2:file:~/test";
						String usuario = "sa";
						String password = "password";
						
						try {
							Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
							Statement statementAgregar = conn.createStatement();
							String sentenciaSQLAgregar = "INSERT INTO productos (nombre, precio) VALUES (?, ?)";
							PreparedStatement pstmtAgregar = conn.prepareStatement(sentenciaSQLAgregar);
							pstmtAgregar.setString(1, nombreProducto);
							pstmtAgregar.setDouble(2, precioProducto);
							
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
			JButton botonAtras = new JButton("Atras");
			botonAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			botonAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(botonAtras);
			BotonAñadir.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(BotonAñadir);
		}
		{
		}
	}

