package br.edu.uefs.cesic.sc00controleacesso.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.edu.uefs.cesic.sc00controleacesso.Util;
import br.edu.uefs.cesic.sc00controleacesso.dao.Usuario;

public class DBUsuario implements DBInterface<Usuario> {

	public static final String TABELA_USUARIO = "usuario";
	
	private static final String CODUSUARIO = "codUsuario";
	private static final String NOME = "nome";
	private static final String CODPERFIL = "codPerfil";
	private static final String USUARIO = "usuario";
	private static final String SENHA = "senha";
	private static final String STATUS = "status";
	private static final String DATACADASTRO = "dataCadastro";
	
	public static final String CRIA_TABELA_USUARIO = "CREATE TABLE " + TABELA_USUARIO
			+ " (" + CODUSUARIO + " INTEGER PRIMARY KEY," + NOME + " TEXT," +
			CODPERFIL +" INTEGER," + USUARIO + " TEXT," + SENHA + " TEXT,"
					+ STATUS + " TEXT,"+ DATACADASTRO +" TEXT)";	
	
	@Override
	public int inserirAtualizar(Usuario usuario) {
		
		SQLiteDatabase dbEscritor = DBHelper.banco.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(NOME,usuario.getNome());
		cv.put(CODPERFIL,usuario.getCodPerfil());
		cv.put(USUARIO,usuario.getUsuario());
		cv.put(SENHA,usuario.getSenha());
		cv.put(STATUS,usuario.getStatus());
		cv.put(DATACADASTRO,Util.formataData("yyyy-MM-dd HH:mm:ss.SSS",usuario.getDataCadastro()));
		

		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		Cursor cursor = dbLeitor.rawQuery("SELECT * FROM " + TABELA_USUARIO + " WHERE " + CODUSUARIO + "=" + usuario.getCodUsuario(), null);
		
		if (cursor == null) {
			
			dbEscritor.insert(TABELA_USUARIO, null, cv);
			
		} else {
			
			dbEscritor.update(TABELA_USUARIO, cv, CODUSUARIO + "=?",new String[] { String.valueOf(usuario.getCodUsuario())});
			
		}
		
		return 1;

	}

	@Override
	public int excluir(Object[] chave) {
		
		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		 String where = CODUSUARIO + "=" + chave[0];
		 dbLeitor.delete(TABELA_USUARIO, where, null);
		 dbLeitor.close();
		return 1;
		
	}

	@Override
	public Usuario buscar(Object[] chave) {
		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		Cursor cursor = dbLeitor.rawQuery("SELECT * FROM " + TABELA_USUARIO + " WHERE " + CODUSUARIO + "=" + chave[0], null);
		
		Usuario usuario = new Usuario(cursor.getInt(cursor.getColumnIndex(CODUSUARIO))
				,cursor.getString(cursor.getColumnIndex(NOME))
				,cursor.getInt(cursor.getColumnIndex(CODPERFIL))
				,cursor.getString(cursor.getColumnIndex(USUARIO))
				,cursor.getString(cursor.getColumnIndex(SENHA))
				,cursor.getString(cursor.getColumnIndex(STATUS))
				,Util.obtemData("",cursor.getString(cursor.getColumnIndex(DATACADASTRO)))
				);
		
		return usuario;
	}

}
