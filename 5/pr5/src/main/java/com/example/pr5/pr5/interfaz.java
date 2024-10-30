package com.example.pr5.pr5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfaz extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaz frame = new interfaz();
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
	public interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 538);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel tituloMenu = new JLabel("Gestor de usuarios");
		tituloMenu.setBackground(SystemColor.inactiveCaption);
		tituloMenu.setFont(new Font("Tahoma", Font.BOLD, 20));
		tituloMenu.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(tituloMenu);
		
		JButton addUser = new JButton("Añadir usuario");
		addUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddUser usuario  = new AddUser();
				usuario.setVisible(true);
			}
		});
		addUser.setBackground(new Color(240, 240, 240));
		contentPane.add(addUser);
		
		JButton addProduct = new JButton("Añadir Producto");
		addProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddProduct producto  = new AddProduct();
				producto.setVisible(true);
			}
		});
		addProduct.setFont(new Font("Tahoma", Font.PLAIN, 11));
		addProduct.setBackground(new Color(240, 240, 240));
		contentPane.add(addProduct);
		
		JButton addPedido = new JButton("Añadir Pedido");
		addPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddPedidos pedido  = new AddPedidos();
				pedido.setVisible(true);
			}
		});
		addPedido.setBackground(new Color(240, 240, 240));
		contentPane.add(addPedido);
	}

}
