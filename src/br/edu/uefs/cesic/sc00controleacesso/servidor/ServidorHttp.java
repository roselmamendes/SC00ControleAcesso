package br.edu.uefs.cesic.sc00controleacesso.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public abstract class ServidorHttp<E> {

	private String lerStream(InputStream in) {
		BufferedReader reader = null ;
		StringBuilder builder = new StringBuilder();
		try {
			reader = new BufferedReader( new InputStreamReader(in));
			String line = null ;
			while ((line = reader.readLine()) != null ) {
				builder.append(line + "\n" );
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (reader != null ) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return builder.toString();
	}

	protected String extraiConteudoDoCampo(String html, String inicio, String fim) {
		if (html == null || inicio == null || fim == null) {
			return null;
		}
		int start = html.indexOf(inicio);
		if (start != -1) {
			int end = html.indexOf(fim, start + inicio.length());
			if (end != -1) {
				return html.substring(start + inicio.length(), end);
			}
		}
		return null;
	}

	protected String realizarRequisicao(String urlRequisicao) {
		HttpURLConnection con = null ;
		URL url = null ;
		String resposta = null ;
		try {
			url = new URL(urlRequisicao);
			con = (HttpURLConnection) url.openConnection();
			con.connect();
			resposta = lerStream(con.getInputStream());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			con.disconnect();
		}
		return resposta;
	}
	
	protected abstract ArrayList<E> lerResposta(String html);

}
