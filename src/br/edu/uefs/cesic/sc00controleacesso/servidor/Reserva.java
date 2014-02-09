package br.edu.uefs.cesic.sc00controleacesso.servidor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Reserva extends ServidorHttp<Reserva> {
	
	private int id;
	private int id_usuario;
	private int id_laboratorio;
	private int id_grupoEstudo;
	private Date inicio;
	private Date fim;
	
	public Reserva(){
		
	}
	
	public Reserva(String id, String id_usuario,String id_laboratorio,String id_grupoEstudo,String inicio,String fim){
		
		this.id = Integer.parseInt(id);
		this.id_laboratorio = Integer.parseInt(id_laboratorio);
		this.id_grupoEstudo = Integer.parseInt(id_grupoEstudo);
		this.id_usuario = Integer.parseInt(id_usuario);
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		try {
			
			this.inicio = formatador.parse(inicio);
			this.fim = formatador.parse(fim);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected ArrayList<Reserva> lerResposta(String html) {
		
		ArrayList<Reserva> lista = new ArrayList();
		
		String reservas = super.extraiConteudoDoCampo(html, "<entidades>", "</entidades>");
		
		String reserva = "";
		String id;
		String id_usuario;
		String id_laboratorio;
		String id_grupoEstudo;
		String inicio;
		String fim;
		
		Reserva reservaObj;
		
		reserva = super.extraiConteudoDoCampo(reservas, "<reserva" + 1 + ">", "<reserva" + 1 + "/>");
		
		for(int i = 2 ; reserva != null ; i++){
			
			
			id = super.extraiConteudoDoCampo(reserva, "<id>", "</>");
			id_usuario = super.extraiConteudoDoCampo(reserva, "<id_usuario>", "</>");
			id_laboratorio = super.extraiConteudoDoCampo(reserva, "<id_laboratorio>", "</>");
			id_grupoEstudo = super.extraiConteudoDoCampo(reserva, "<id_grupoEstudo>", "</>");
			inicio = super.extraiConteudoDoCampo(reserva, "<inicio>", "</>");
			fim = super.extraiConteudoDoCampo(reserva, "<fim>", "</>");
			
			reservaObj = new Reserva(id,id_usuario,id_laboratorio,id_grupoEstudo,inicio,fim);
			
			lista.add(reservaObj);
			
			reserva = super.extraiConteudoDoCampo(reservas, "<reserva" + i + ">", "<reserva" + i + "/>");			
			
		}
		
		return lista;
		
	}

	public int inserir(Reserva reserva){
		return Integer.parseInt(super.realizarRequisicao(""));
	}
	
	public int alterar(Reserva reserva){
		return Integer.parseInt(super.realizarRequisicao(""));
	}
	
	
	public void criaArquivo(String retorno){
		File arq = new File("c:\resposta.php");
		if(arq.exists())
			arq.delete();
		
		try {
			arq.createNewFile();
			FileWriter fw = new FileWriter(arq);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(retorno);
			bw.close();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Reserva> obtemTodos(){
		
		String retorno = super.realizarRequisicao("http://192.168.1.39/pdigital/requisicao/requisicao_reservas.php");
		
		return this.lerResposta(retorno);
		
	}
	
	public ArrayList<Reserva> obtemReserva(int id_usuario){
		
		String retorno = super.realizarRequisicao("");
		return this.lerResposta(retorno);
		
	}
	
	public int excluir(int id_reserva){
		return Integer.parseInt(super.realizarRequisicao(""));
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
