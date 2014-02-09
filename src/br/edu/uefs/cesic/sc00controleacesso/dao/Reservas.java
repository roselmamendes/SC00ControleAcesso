package br.edu.uefs.cesic.sc00controleacesso.dao;

import java.util.Date;

public class Reservas {

	private int id;
	private int id_usuario;
	private int id_laboratorio;
	private int id_grupoEstudo;
	private Date inicio;
	private Date fim;
	
	public Reservas(int id, int idUsuario, int idLaboratorio, int idGrupoEstudo, long inicio,long fim) {
		
		this.id = id;
		this.id_usuario = idUsuario;
		this.id_laboratorio = idLaboratorio;
		this.id_grupoEstudo = idGrupoEstudo;
		this.inicio = new Date(inicio);
		this.fim = new Date(fim);
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_laboratorio() {
		return id_laboratorio;
	}
	public void setId_laboratorio(int id_laboratorio) {
		this.id_laboratorio = id_laboratorio;
	}
	public int getId_grupoEstudo() {
		return id_grupoEstudo;
	}
	public void setId_grupoEstudo(int id_grupoEstudo) {
		this.id_grupoEstudo = id_grupoEstudo;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	
	
}
