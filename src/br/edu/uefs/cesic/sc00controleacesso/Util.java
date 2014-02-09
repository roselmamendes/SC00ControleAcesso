package br.edu.uefs.cesic.sc00controleacesso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static String formataData(String mascara,Date data){
		
		SimpleDateFormat formatador = new SimpleDateFormat(mascara);
		return formatador.format(data);
		
	}
	
	public static Date obtemData(String mascara,String dataString){
		
		SimpleDateFormat formatador = new SimpleDateFormat(mascara);
		try {
			
			return formatador.parse(dataString);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
			return null;
			
		}
		
	}

}
