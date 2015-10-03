package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Ventana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
					// Centro la ventana
					frame.setLocationRelativeTo(null);
					// Muestro la ventana
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// DISPOSE_ON_CLOSE , para ventanas secundarias
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelText = new JLabel("");
		labelText.setHorizontalAlignment(SwingConstants.CENTER);
		labelText.setFont(new Font("Verdana", Font.PLAIN, 24));
		labelText.setBounds(10, 84, 410, 136);
		contentPane.add(labelText);
		
		JButton btnHola = new JButton("HOLA");
		btnHola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelText.setText(btnHola.getText());
			}
		});
		btnHola.setBounds(10, 10, 130, 50);
		contentPane.add(btnHola);
		
		JButton btnComo = new JButton("COMO");
		btnComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelText.setText(btnComo.getText());
			}
		});
		btnComo.setBounds(150, 10, 130, 50);
		contentPane.add(btnComo);
		
		JButton btnEstas = new JButton("ESTAS");
		btnEstas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelText.setText(btnEstas.getText());
			}
		});
		btnEstas.setBounds(290, 10, 130, 50);
		contentPane.add(btnEstas);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				confirmarSalida();
			}
		});

	}
	
	private void confirmarSalida(){
		
		int res = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea salir?","Salida", JOptionPane.YES_NO_OPTION);
		if (res == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

}
