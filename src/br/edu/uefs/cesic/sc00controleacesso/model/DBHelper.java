package br.edu.uefs.cesic.sc00controleacesso.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public static DBHelper banco;
	
	private static final String NOME_BANCO = "controleAcesso";
	private static final int VERSAO_BANCO = 1;
	
	private DBHelper(Context context) {
		
		super(context, NOME_BANCO, null, VERSAO_BANCO);
		
	}
	
	/**
	 * Este método deve ser chamado na inicialização do app. Ele cria a instancia para a variável banco. Esta por sua vez é utilizada pelas classes da tabela para realizar as operações em banco.
	 * Passar o contexto da app, chamando o método getApplicationContext() de uma classe Activity.
	 * @param context
	 * @return
	 */
	public static DBHelper obtemInstancia(Context context){
		
		if(banco == null)
			banco = new DBHelper(context);
		
		return banco;
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(DBLaboratorios.CRIA_TABELA_LABORATORIOS);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		
		db.execSQL("DROP TABLE IF EXISTS " + DBLaboratorios.TABELA_LABORATORIOS);
		
		onCreate(db);

	}

}
