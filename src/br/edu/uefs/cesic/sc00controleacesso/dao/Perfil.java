package br.edu.uefs.cesic.sc00controleacesso.dao;

public class Perfil {

	private int codPerfil;
	private String perfil;
	
	
	public Perfil(int codPerfil,String perfil){
		
		this.codPerfil = codPerfil;
		this.perfil = perfil;
		
	}
	
	public int getCodPerfil() {
		return codPerfil;
	}
	public void setCodPerfil(int codPerfil) {
		this.codPerfil = codPerfil;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
}
