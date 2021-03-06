package com.matheus.view;

import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.matheus.ItemDAO.ItensDAO;
import com.matheus.entidades.Itens;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Consultar {

	private JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consultar window = new Consultar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Consultar() {
		initialize();
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome : ");
		lblNewLabel.setBounds(107, 98, 76, 14);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(193, 95, 197, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(86, 186, 525, 276);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Nome" }) {
			Class[] columnTypes = new Class[] { String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String nome = textField.getText();
				if (nome.equals("") || nome == null) {
					DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
					tablemodel.setRowCount(0);
					try {
						Itens i = new Itens();
						ArrayList<Itens> item = i.lista();
						item.forEach((Itens itens) -> {
							tablemodel.addRow(new Object[] { itens.getCodigoItem(), itens.getNome() });
						});
						table.setModel(tablemodel);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {
					DefaultTableModel tablemodel = (DefaultTableModel) table.getModel();
					try {
						tablemodel.setRowCount(0);
						Itens i = new Itens();
						ArrayList<Itens> item = i.listaItensNome(nome);
						item.forEach((Itens itens) -> {
							tablemodel.addRow(new Object[] { itens.getCodigoItem(), itens.getNome() });
						});
						table.setModel(tablemodel);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnNewButton
				.setIcon(new ImageIcon("C:\\Users\\mathe\\Desktop\\ProjetoStardewValley\\com.matheus\\IMG\\file.png"));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(437, 82, 89, 40);
		btnNewButton.setFocusPainted(false);
		frame.getContentPane().add(btnNewButton);
		frame.setBounds(100, 100, 687, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void abreTela() {
		frame.setVisible(true);
	}
}
