package model;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana2 frame = new Ventana2();
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
	public Ventana2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 153);
		contentPane.add(scrollPane);
		
		JTextArea txtArea = new JTextArea();
		scrollPane.setViewportView(txtArea);
		
		textField = new JTextField();
		textField.setBounds(10, 192, 269, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (KeyEvent.VK_ENTER == e.getKeyCode()) {
					agregarTexto(txtArea);
				}
			}
		});
		
		JButton btnAgregarTexto = new JButton("Agregar");
		btnAgregarTexto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarTexto(txtArea);
			}
		});
		
		btnAgregarTexto.setBounds(289, 191, 135, 23);
		contentPane.add(btnAgregarTexto);
	}
	
	private void agregarTexto(JTextArea txtArea) {
		if (!textField.getText().trim().isEmpty()) {
			txtArea.setText(txtArea.getText() + textField.getText().trim() + "\n");
			txtArea.setCaretPosition(txtArea.getText().length());
			textField.setText("");
		}
	}
}
