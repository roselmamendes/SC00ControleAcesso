package br.edu.uefs.cesic.sc00controleacesso.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.edu.uefs.cesic.sc00controleacesso.dao.GrupoEstudo;
import br.edu.uefs.cesic.sc00controleacesso.dao.Laboratorio;

public class DBGrupoEstudo implements DBInterface<GrupoEstudo> {

	private static final String CODGRUPOESTUDO = "codGrupoEstudo";
	private static final String DENOMINACAO = "denominacao";
	
	public static final String TABELA_GRUPOESTUDO = "grupoEstudo";
	
	public static final String CRIA_TABELA_GRUPOESTUDO = "CREATE TABLE " + TABELA_GRUPOESTUDO
			+ "(" + CODGRUPOESTUDO + " INTEGER PRIMARY KEY," + DENOMINACAO + " TEXT)";
	
	@Override
	public int inserirAtualizar(GrupoEstudo grupoEstudo) {
		
		SQLiteDatabase dbEscritor = DBHelper.banco.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(DENOMINACAO,grupoEstudo.getDenominacao());		

		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		Cursor cursor = dbLeitor.rawQuery("SELECT * FROM " + TABELA_GRUPOESTUDO + " WHERE " + CODGRUPOESTUDO + "=" + grupoEstudo.getCodGrupoEstudo(), null);
		
		if (cursor == null) {
			
			dbEscritor.insert(TABELA_GRUPOESTUDO, null, cv);
			
		} else {
			
			dbEscritor.update(TABELA_GRUPOESTUDO, cv, CODGRUPOESTUDO + "=?",new String[] { String.valueOf(grupoEstudo.getCodGrupoEstudo()) });
			
		}
		
		return 1;
	}

	@Override
	public int excluir(Object[] chave) {
		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		 String where = CODGRUPOESTUDO + "=" + chave[0];
		 dbLeitor.delete(TABELA_GRUPOESTUDO, where, null);
		 dbLeitor.close();
		return 1;
	}

	@Override
	public GrupoEstudo buscar(Object[] chave) {
		
		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		Cursor cursor = dbLeitor.rawQuery("SELECT * FROM " + TABELA_GRUPOESTUDO + " WHERE " + CODGRUPOESTUDO + "=" + chave[0], null);
		
		GrupoEstudo grupoEstudo = new GrupoEstudo(cursor.getInt(cursor.getColumnIndex(CODGRUPOESTUDO))
				,cursor.getString(cursor.getColumnIndex(DENOMINACAO)));
		
		return grupoEstudo;
	}

	

}
