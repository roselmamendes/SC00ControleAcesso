package br.edu.uefs.cesic.sc00controleacesso.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.edu.uefs.cesic.sc00controleacesso.dao.Perfil;

public class DBPerfil implements DBInterface<Perfil> {

	public static final String TABELA_PERFIL = "perfil";
	
	private static final String CODPERFIL = "codperfil";
	private static final String PERFIL = "perfil";
	
	public static final String CRIA_TABELA_PERFIL = "CREATE TABLE " + TABELA_PERFIL
			+ "(" + CODPERFIL + " INTEGER PRIMARY KEY," + PERFIL + " TEXT)"; 
	
	@Override
	public int inserirAtualizar(Perfil perfil) {
		
		SQLiteDatabase dbEscritor = DBHelper.banco.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(PERFIL,perfil.getPerfil());
		

		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		Cursor cursor = dbLeitor.rawQuery("SELECT * FROM " + TABELA_PERFIL + " WHERE " + CODPERFIL + "=" + perfil.getCodPerfil(), null);
		
		if (cursor == null) {
			
			dbEscritor.insert(TABELA_PERFIL, null, cv);
			
		} else {
			
			dbEscritor.update(TABELA_PERFIL, cv, CODPERFIL + "=?",new String[] { String.valueOf(perfil.getCodPerfil()) });
			
		}
		
		return 1;

	}

	@Override
	public int excluir(Object[] chave) {
		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		 String where = CODPERFIL + "=" + chave[0];
		 dbLeitor.delete(TABELA_PERFIL, where, null);
		 dbLeitor.close();
		return 1;
	}

	@Override
	public Perfil buscar(Object[] chave) {
		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		Cursor cursor = dbLeitor.rawQuery("SELECT * FROM " + TABELA_PERFIL + " WHERE " + CODPERFIL + "=" + chave[0], null);
		
		Perfil perfil = new Perfil(cursor.getInt(cursor.getColumnIndex(CODPERFIL))
				,cursor.getString(cursor.getColumnIndex(PERFIL))
				);
		
		return perfil;
	}

}
