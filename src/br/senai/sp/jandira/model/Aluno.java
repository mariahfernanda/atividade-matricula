package br.senai.sp.jandira.model;

public class Aluno {

	private String nome;
	private String matricula;
	private Periodo perido;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setPerido(Periodo perido) {
		this.perido = perido;
	}

	public Periodo getPerido() {
		return perido;
	}

}
