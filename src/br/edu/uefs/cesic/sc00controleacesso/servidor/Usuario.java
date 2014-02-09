package br.edu.uefs.cesic.sc00controleacesso.servidor;

import java.util.ArrayList;

public class Usuario extends ServidorHttp<Usuario> {

	private int id;
	private String usuario;
	private String senha;
	private int tipo;
	
	public Usuario(String id,String nome,String senha,String tipo){
		
		this.id = Integer.parseInt(id);
		this.usuario = nome;
		this.senha = senha;
		this.tipo = Integer.parseInt(tipo);
		
	}
	
	@Override
	protected ArrayList<Usuario> lerResposta(String html) {
		
		ArrayList<Usuario> lista = new ArrayList();
		
		String usuarios = super.extraiConteudoDoCampo(html, "<entidades>", "</entidades>");
		
		String reserva = "";
		String id;
		String nome;
		String senha;
		String tipo;
		
		Usuario usuarioObj;
		
		usuario = super.extraiConteudoDoCampo(usuarios, "<usuario" + 1 + ">", "<usuario" + 1 + "/>");
		
		for(int i = 2 ; reserva != null ; i++){
			
			
			id = super.extraiConteudoDoCampo(reserva, "<id>", "</>");
			nome = super.extraiConteudoDoCampo(reserva, "<nome>", "</>");
			senha = super.extraiConteudoDoCampo(reserva, "<senha>", "</>");
			tipo = super.extraiConteudoDoCampo(reserva, "<tipo>", "</>");
			
			usuarioObj = new Usuario(id,nome,senha,tipo);
			
			lista.add(usuarioObj);
			
			reserva = super.extraiConteudoDoCampo(usuarios, "<usuario" + i + ">", "<usuario" + i + "/>");			
			
		}
		
		return lista;
	}
	
	public int inserir(Usuario usuario){
		return Integer.parseInt(super.realizarRequisicao(""));
	}
	
	public int alterar(Usuario usuario){
		return Integer.parseInt(super.realizarRequisicao(""));
	}
	
	public ArrayList<Usuario> obtemUsuario(int id_usuario){
		
		String retorno = super.realizarRequisicao("");
		return this.lerResposta(retorno);
		
	}
	
	public int excluir(int id_usuario){
		return Integer.parseInt(super.realizarRequisicao(""));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
