package br.edu.uefs.cesic.sc00controleacesso.dao;

public class Laboratorio {

	private int codlab;
	private String nome;
	private String sigla;
	private String local;
	private String ip;
	
	public Laboratorio(int codlab,String nome,String local,String sigla,String ip){
		
		this.codlab = codlab;
		this.nome = nome;
		this.sigla = sigla;
		this.local = local;
		this.ip = ip;
		
	}
	
	public int getCodlab() {
		return codlab;
	}
	public void setCodlab(int codlab) {
		this.codlab = codlab;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
