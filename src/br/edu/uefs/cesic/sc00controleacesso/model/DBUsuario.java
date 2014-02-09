package br.edu.uefs.cesic.sc00controleacesso.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

	@Override
	public int excluir(Object[] chave) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario buscar(Object[] chave) {
		// TODO Auto-generated method stub
		return null;
	}

}
