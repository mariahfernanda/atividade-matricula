package br.senai.sp.jandira.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.model.Periodo;
import br.senai.sp.jandira.repository.AlunoRepository;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameCadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JLabel lblAluno;
	private JTextField txtAluno;
	private JLabel lblPeriodo;
	private JLabel lblLista;

	// criar um contador para contolar a posi��o de aluno no vetor
	private int posicao = 0;

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
		setBounds(100, 100, 493, 298);
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
		btnSalvar.setBounds(20, 153, 225, 40);
		contentPane.add(btnSalvar);

		JComboBox<String> comboPeriodo = new JComboBox<String>();
		DefaultComboBoxModel<String> comboModelPeriodo = new DefaultComboBoxModel<String>();

		for (Periodo descricao : Periodo.values()) {
			comboModelPeriodo.addElement(descricao.getDescricao());
		}

		// comboPedriodo.setModel(new DefaultComboBoxModel(Periodo.values()));
		comboPeriodo.setModel(comboModelPeriodo);
		comboPeriodo.setToolTipText("");
		comboPeriodo.setBounds(95, 107, 150, 22);
		contentPane.add(comboPeriodo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(276, 47, 191, 197);
		contentPane.add(scrollPane);

		JList listAlunos = new JList();
		scrollPane.setViewportView(listAlunos);

		// criar model que vau exibir os alunos na Jlist
		DefaultListModel<String> modelAlunos = new DefaultListModel<String>();

		// definir model alun como sendo o model do nosso Jlist
		listAlunos.setModel(modelAlunos);

		// criar uma turma que e um repositorio de alunos
		AlunoRepository turma = new AlunoRepository();

		// vamos colocar um listiner no bot�o
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Aluno aluno = new Aluno();
				aluno.setNome(txtAluno.getText());
				aluno.setMatricula(txtMatricula.getText());

				// Definir o horario que o aluno estuda
				aluno.setPerido(determinarPerido(comboPeriodo.getSelectedIndex()));

				turma.gravar(aluno, posicao);

				posicao++;

				modelAlunos.addElement(aluno.getNome());
				if (posicao == turma.getTamanho()) {
					btnSalvar.setEnabled(false);
					JOptionPane.showMessageDialog(null, "A turma j� est� completa", "cheio",
							JOptionPane.WARNING_MESSAGE);
				}
				

			}
		});

		lblLista = new JLabel("Lista das Alunos");
		lblLista.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLista.setBounds(276, 28, 113, 14);
		contentPane.add(lblLista);

		JButton btnLala = new JButton("Exibir Alunos");
		btnLala.setBounds(20, 204, 225, 40);
		contentPane.add(btnLala);
		btnLala.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (Aluno aluno : turma.listarTodos()) {
					System.out.println(aluno.getNome());
					System.out.println(aluno.getMatricula());
					System.out.println(aluno.getPeriodo().getDescricao());
					System.out.println("---------------------");

				}

			}
		});
		listAlunos.addListSelectionListener(new ListSelectionListener() {			
			public void valueChanged(ListSelectionEvent e) {
				 Aluno aluno = turma.listarAluno(listAlunos.getSelectedIndex());
				 txtMatricula.setText(aluno.getMatricula());
				 txtAluno.setText(aluno.getNome());
				 comboPeriodo.setSelectedIndex(aluno.getPeriodo().ordinal());				
				
			}
		});
	}

	private Periodo determinarPerido(int periodoSelecionado) {

		if (periodoSelecionado == 0) {
			return Periodo.MANHA;
		} else if (periodoSelecionado == 1) {
			return Periodo.TARDE;
		} else if (periodoSelecionado == 2) {
			return Periodo.NOITE;
		} else if (periodoSelecionado == 3) {
			return Periodo.SABADO;
		} else {
			return Periodo.ONLINE;
		}

	}

}
