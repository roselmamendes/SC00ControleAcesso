package br.edu.uefs.cesic.sc00controleacesso.dao;

import java.util.Date;

public class Usuario {

	private int codUsuario;
	private String nome;
	private int codPerfil;
	private String usuario;
	private String senha;
	private String status;
	private Date dataCadastro;
	
	public Usuario(int codUsuario, String nome, int codPerfil,String usuario,String senha,String status,Date dataCadastro){
		
		this.codUsuario = codUsuario;
		this.nome = nome;
		this.codPerfil = codPerfil;
		this.usuario = usuario;
		this.senha = senha;
		this.status = status;
		this.dataCadastro = dataCadastro;
		
	}
	
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCodPerfil() {
		return codPerfil;
	}
	public void setCodPerfil(int codPerfil) {
		this.codPerfil = codPerfil;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
