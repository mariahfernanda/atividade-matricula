package br.senai.sp.jandira.app;

import br.senai.sp.jandira.model.Aluno;
import br.senai.sp.jandira.repository.AlunoRepository;
import br.senai.sp.jandira.ui.FrameCadastroAluno;

public class App {

	public static void main(String[] args) {
		
		AlunoRepository turma = new AlunoRepository(6);
		Aluno a = new Aluno();
		a.setNome("Pedro");
		turma.gravar(a, 0);
		
		Aluno b = new Aluno();
		b.setNome("Ana");
		turma.gravar(b, 1);
		
		Aluno c = new Aluno();
		c.setNome("Pedro");
		turma.gravar(c, 2);
		
		Aluno d = new Aluno();
		d.setNome("Luiza");
		turma.gravar(d, 3);
		
		Aluno e = new Aluno();
		e.setNome("Maria");
		turma.gravar(e, 4);
		
		Aluno f = new Aluno();
		f.setNome("Rodrigo");
		turma.gravar(f, 5);
		
		
		//carregar um combo model cm as descricoes do periodos
		for(Aluno alunoAtual : turma.listarTodos()) {
			System.out.println(alunoAtual.getNome());
		}
		
		FrameCadastroAluno frame = new FrameCadastroAluno();
		frame.setVisible(true);

	}

}
