package br.edu.uefs.cesic.sc00controleacesso.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.edu.uefs.cesic.sc00controleacesso.dao.Laboratorio;

public class DBLaboratorios implements DBInterface<Laboratorio>{

	public static final String TABELA_LABORATORIOS = "laboratorios";
		/*
	 * CREATE TABLE IF NOT EXISTS `laboratorios` (
  `codlab` int(3) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `sigla` varchar(8) NOT NULL,
  `local` varchar(100) NOT NULL,
  `ip` varchar(20) NOT NULL,
  PRIMARY KEY (`codlab`)
)
	 */
	
	private static final String CODLAB = "codlab";
	private static final String NOME = "nome";
	private static final String SIGLA = "sigla";
	private static final String LOCAL = "local";
	private static final String IP = "ip";
	
	public static final String CRIA_TABELA_LABORATORIOS = "CREATE TABLE " + TABELA_LABORATORIOS
			+ "(" + CODLAB + " INTEGER PRIMARY KEY," + NOME + " TEXT," +
			SIGLA +" TEXT," + LOCAL + " TEXT," + IP + " TEXT)";	
	
	/**
	 * Antes de usar esse método chame o método obtemInstancia da classe DBHelper.
	 * @param lab
	 */
	public int inserirAtualizar(Laboratorio lab){
		
		SQLiteDatabase dbEscritor = DBHelper.banco.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(NOME,lab.getNome());
		cv.put(SIGLA,lab.getSigla());
		cv.put(LOCAL,lab.getLocal());
		cv.put(IP,lab.getIp());
		

		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		Cursor cursor = dbLeitor.rawQuery("SELECT * FROM " + TABELA_LABORATORIOS + " WHERE " + CODLAB + "=" + lab.getCodlab(), null);
		
		if (cursor == null) {
			
			dbEscritor.insert(TABELA_LABORATORIOS, null, cv);
			
		} else {
			
			dbEscritor.update(TABELA_LABORATORIOS, cv, CODLAB + "=?",new String[] { String.valueOf(lab.getCodlab()) });
			
		}
		
		return 1;
		
	}
	
	
	
	/**
	 * Antes de usar esse método chame o método obtemInstancia da classe DBHelper.
	 */
	public int excluir(Object[] chave){
		
		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		 String where = CODLAB + "=" + chave[0];
		 dbLeitor.delete(TABELA_LABORATORIOS, where, null);
		 dbLeitor.close();
		return 1;
		
	}
	
	/**
	 * Antes de usar esse método chame o método obtemInstancia da classe DBHelper.
	 * @return Um objeto da classe Laboratorio devidamente preenchido caso seja achado um registro de acordo com a clausula de pesquisa.
	 */
	public Laboratorio buscar(Object[] chave){
		
		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		Cursor cursor = dbLeitor.rawQuery("SELECT * FROM " + TABELA_LABORATORIOS + " WHERE " + CODLAB + "=" + chave[0], null);
		
		Laboratorio lab = new Laboratorio(cursor.getInt(cursor.getColumnIndex(CODLAB))
				,cursor.getString(cursor.getColumnIndex(NOME))
				,cursor.getString(cursor.getColumnIndex(LOCAL))
				,cursor.getString(cursor.getColumnIndex(SIGLA))
				,cursor.getString(cursor.getColumnIndex(IP)));
		
		return lab;
		
	}
	
}
