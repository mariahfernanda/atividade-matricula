package br.senai.sp.jandira.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrameCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JLabel lblAluno;
	private JTextField txtAluno;
	private JLabel lblPeriodo;
	private JLabel lblNewLabel;
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCadastroAluno frame = new FrameCadastroAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameCadastroAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatricula = new JLabel("M\u00E1tricula");
		lblMatricula.setBounds(20, 28, 66, 14);
		contentPane.add(lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(95, 25, 150, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		lblAluno = new JLabel("Aluno");
		lblAluno.setBounds(20, 66, 46, 14);
		contentPane.add(lblAluno);
		
		txtAluno = new JTextField();
		txtAluno.setBounds(95, 63, 150, 20);
		contentPane.add(txtAluno);
		txtAluno.setColumns(10);
		
		lblPeriodo = new JLabel("Peri\u00F3do");
		lblPeriodo.setBounds(20, 111, 46, 14);
		contentPane.add(lblPeriodo);
		
		JButton btnSalvar = new JButton("Salvar Aluno");
		btnSalvar.setBounds(20, 178, 225, 40);
		contentPane.add(btnSalvar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"selecione..", "Manh\u00E3 ", "Tarde", "Noite", "S\u00E1bado"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(95, 107, 150, 22);
		contentPane.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(280, 64, 142, 166);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		lblNewLabel = new JLabel("Lista das Alunos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(280, 39, 113, 14);
		contentPane.add(lblNewLabel);
	}
}
