package br.senai.sp.jandira.app;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.repository.AlunoRepository;
import br.senai.sp.jandira.ui.FrameCadastroAluno;

public class App {

	public static void main(String[] args) {
		
		AlunoRepository turma = new AlunoRepository(6);
		
		
		//carregar um combo model com as descrições do periodos
		for(Aluno alunoAtual : turma.listarTodos()) {
			System.out.println(alunoAtual.getNome());
		}
		
		FrameCadastroAluno frame = new FrameCadastroAluno();
		frame.setVisible(true);

	}

}
