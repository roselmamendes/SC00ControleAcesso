package br.edu.uefs.cesic.sc00controleacesso.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.edu.uefs.cesic.sc00controleacesso.dao.Perfil;
import br.edu.uefs.cesic.sc00controleacesso.dao.Reservas;

public class DBReservas implements DBInterface<Reservas>{

	public static final String TABELA_RESERVA = "reserva";
	
	
	/*
	 * CREATE TABLE IF NOT EXISTS `reservas` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `id_usuario` varchar(6) NOT NULL,
  `id_laboratorio` varchar(6) NOT NULL,
  `id_grupoestudo` varchar(6) NOT NULL,
  `inicio` datetime NOT NULL,
  `fim` datetime NOT NULL,
  PRIMARY KEY (`id`)
	 */
	
	private static final String ID = "id";
	private static final String IDUSUARIO = "id_usuario";
	private static final String IDLABORATORIO = "id_laboratorio";
	private static final String IDGRUPOESTUDO = "id_grupoEstudo";
	private static final String INICIO = "inicio";
	private static final String FIM = "fim";
	
	public static final String CRIA_TABELA_RESERVA = "CREATE TABLE " + TABELA_RESERVA
			+ "(" + ID + " INTEGER PRIMARY KEY," + IDUSUARIO + " INTEGER,"+IDLABORATORIO+" INTEGER,"+IDGRUPOESTUDO+" INTEGER, "+INICIO+" LONG,"+FIM+" LONG)";
	
	@Override
	public int inserirAtualizar(Reservas reserva) {
		
		SQLiteDatabase dbEscritor = DBHelper.banco.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(IDUSUARIO,reserva.getId_usuario());
		cv.put(IDLABORATORIO,reserva.getId_laboratorio());
		cv.put(IDGRUPOESTUDO,reserva.getId_grupoEstudo());
		cv.put(INICIO,reserva.getInicio().getTime());
		cv.put(FIM,reserva.getFim().getTime());

		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		Cursor cursor = dbLeitor.rawQuery("SELECT * FROM " + TABELA_RESERVA + " WHERE " + ID + "=" + reserva.getId()
				+ " and " + IDUSUARIO + "=" + reserva.getId_usuario() 
				+ " and " + IDLABORATORIO + "=" + reserva.getId_laboratorio()
				+ " and " + IDGRUPOESTUDO + "=" + reserva.getId_grupoEstudo()
				, null);
		
		if (cursor == null) {
			
			dbEscritor.insert(TABELA_RESERVA, null, cv);
			
		} else {
			
			dbEscritor.update(TABELA_RESERVA, cv, ID + "=?"
					+ " and " + IDUSUARIO + "=?" 
					+ " and " + IDLABORATORIO + "=?"
					+ " and " + IDGRUPOESTUDO + "=?"
					,new String[] { String.valueOf(reserva.getId()),
					String.valueOf(reserva.getId_usuario()),
					String.valueOf(reserva.getId_laboratorio()),
					String.valueOf(reserva.getId_grupoEstudo())});
			
		}
		
		return 1;

	}

	@Override
	public int excluir(Object[] chave) {
		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		 String where = ID + "=" + chave[0]
					+ " and " + IDUSUARIO + "=" + chave[1] 
					+ " and " + IDLABORATORIO + "=" + chave[2]
					+ " and " + IDGRUPOESTUDO + "=" + chave[3];
		 dbLeitor.delete(TABELA_RESERVA, where, null);
		 dbLeitor.close();
		return 1;
	}

	@Override
	public Reservas buscar(Object[] chave) {
		
		SQLiteDatabase dbLeitor = DBHelper.banco.getReadableDatabase();
		Cursor cursor = dbLeitor.rawQuery("SELECT * FROM " + TABELA_RESERVA + " WHERE " + ID + "=" + chave[0]
				+ " and " + IDUSUARIO + "=" + chave[1] 
				+ " and " + IDLABORATORIO + "=" + chave[2]
				+ " and " + IDGRUPOESTUDO + "=" + chave[3], null);
		
		Reservas reservas = new Reservas(cursor.getInt(cursor.getColumnIndex(ID)),
				cursor.getInt(cursor.getColumnIndex(IDUSUARIO)),
				cursor.getInt(cursor.getColumnIndex(IDLABORATORIO)),
				cursor.getInt(cursor.getColumnIndex(IDGRUPOESTUDO)),
				cursor.getLong(cursor.getColumnIndex(INICIO)),
				cursor.getLong(cursor.getColumnIndex(FIM))
				);
		
		return reservas;
		
	}

}
