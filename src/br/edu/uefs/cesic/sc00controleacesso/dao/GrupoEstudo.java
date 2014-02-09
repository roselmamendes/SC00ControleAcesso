package br.edu.uefs.cesic.sc00controleacesso.dao;

public class GrupoEstudo {
	
	private int codGrupoEstudo;
	private String denominacao;
	
	public GrupoEstudo(int codGrupoEstudo,String denominacao){
		this.codGrupoEstudo = codGrupoEstudo;
		this.denominacao = denominacao;
	}
	
	public int getCodGrupoEstudo() {
		return codGrupoEstudo;
	}
	public void setCodGrupoEstudo(int codGrupoEstudo) {
		this.codGrupoEstudo = codGrupoEstudo;
	}
	public String getDenominacao() {
		return denominacao;
	}
	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}
	

}
