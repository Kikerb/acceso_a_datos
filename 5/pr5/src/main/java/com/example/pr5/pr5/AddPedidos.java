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
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class AddPedidos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddPedidos dialog = new AddPedidos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddPedidos() {
		setBounds(100, 100, 456, 554);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
			JLabel lblNewLabel_3 = new JLabel("Añadir pedido");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_3);
		
		
			JLabel lblNewLabel_2 = new JLabel("Usuario");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_2);
		
		
			JComboBox comboBoxUsuario = new JComboBox();
			contentPanel.add(comboBoxUsuario);
		
		
			JLabel lblNewLabel_1 = new JLabel("Producto");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel_1);
		
		
			JComboBox comboBoxProducto = new JComboBox();
			contentPanel.add(comboBoxProducto);
		
		
			JLabel lblNewLabel = new JLabel("Cantidad");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblNewLabel);
		
		
			JTextArea textAreaCantidad = new JTextArea();
			contentPanel.add(textAreaCantidad);
		
			JButton botonAñadir = new JButton("Añadir");
			botonAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String productoSeleccionado = comboBoxProducto.getSelectedItem().toString();
					String usuarioSeleccionado = comboBoxUsuario.getSelectedItem().toString();
					Integer cantidad = Integer.valueOf(textAreaCantidad.getText());
					
					System.out.println("Selected User: " + usuarioSeleccionado);
					
					Pattern pattern = Pattern.compile("id:\\s*(\\d+)");
					Matcher matcher = pattern.matcher(usuarioSeleccionado);
					String userId = "";
					if (matcher.find()) {
						userId = matcher.group(1);
						System.out.println("userId; " + userId);
					}else {
						System.out.println("No ID encontrado");
					}
					System.out.println("Selected Product: " + productoSeleccionado);
					
					Pattern pattern2 = Pattern.compile("id:\\s*(\\d+)");
					Matcher matcher2 = pattern2.matcher(productoSeleccionado);
					
					String productId = "";
					if (matcher2.find()) {
						productId = matcher2.group(1);
						System.out.println("Product ID: " + productoSeleccionado);
					}
					
					
					if(!userId.equals("") && !productId.equals("") && cantidad > 0) {
						String URL_CONEXION = "jdbc:h2:file:~/test";
						String usuario = "sa";
						String password = "password";
						
						try {
							Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
							Statement statementAgregar = conn.createStatement();
							String sentenciaSQLAgregar = "INSERT INTO pedidos (id_usuario, id_producto, cantidad) VALUES (?, ?, ?)";
							PreparedStatement pstmtAgregar = conn.prepareStatement(sentenciaSQLAgregar);
							pstmtAgregar.setInt(1, Integer.valueOf(userId));
							pstmtAgregar.setInt(2,  Integer.valueOf(productId));
							pstmtAgregar.setInt(3, cantidad);
							
							
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
			botonAñadir.setFont(new Font("Tahoma", Font.BOLD, 11));
			contentPanel.add(botonAñadir);
			
				JButton BotonAtras = new JButton("Atras");
				BotonAtras.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				BotonAtras.setFont(new Font("Tahoma", Font.BOLD, 11));
				contentPanel.add(BotonAtras);
		
		
		ArrayList<String> datosUsuarios = addChoicesToUserDropDown();
		for(String datoUsuario : datosUsuarios) {
			comboBoxUsuario.addItem(datoUsuario);
		}
		
		ArrayList<String> datosProducto = addChoicesToProductDropDown();
		for(String datoProducto : datosProducto) {
			comboBoxProducto.addItem(datoProducto);
		}
	}
	
	private ArrayList<String> addChoicesToUserDropDown(){
		String URL_CONEXION = "jdbc:h2:file:~/test";
		String usuario = "sa";
		String password = "password";
		Connection conn;
		ArrayList<String> choices = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
			Statement statement = conn.createStatement();
			String selectTableSQL ="SELECT * FROM usuarios";
			ResultSet rs = statement.executeQuery(selectTableSQL);
			while(rs.next())
			{
				String id= rs.getString("id");
				String nombre = rs.getString("nombre");
				choices.add("id: " + id + " nombre: " + nombre);
			}
			rs.close();
			statement.close();
		}catch (SQLException ex) {
			
			
		}
		return choices;
	}
	
	private ArrayList<String> addChoicesToProductDropDown(){
		String URL_CONEXION = "jdbc:h2:file:~/test";
		String usuario = "sa";
		String password = "password";
		Connection conn;
		ArrayList<String> choices = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
			Statement statement = conn.createStatement();
			String selectTableSQL ="SELECT * FROM productos";
			ResultSet rs = statement.executeQuery(selectTableSQL);
			while(rs.next())
			{
				String id= rs.getString("id");
				String nombre = rs.getString("nombre");
				choices.add("id: " + id + " nombre: " + nombre);
			}
			rs.close();
			statement.close();
		}catch (SQLException ex) {
			
			
		}
		return choices;
	}

}


