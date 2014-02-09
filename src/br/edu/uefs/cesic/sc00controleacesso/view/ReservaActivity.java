package br.edu.uefs.cesic.sc00controleacesso.view;

import java.util.ArrayList;

import br.edu.uefs.cesic.sc00controleacesso.R;
import br.edu.uefs.cesic.sc00controleacesso.R.id;
import br.edu.uefs.cesic.sc00controleacesso.R.layout;
import br.edu.uefs.cesic.sc00controleacesso.R.menu;
import br.edu.uefs.cesic.sc00controleacesso.servidor.Reserva;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ReservaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		Reserva reserva = new Reserva();
		//Reserva[] reservas = (Reserva[])reserva.obtemTodos().toArray();
		Reserva[] reservas = {};
		ArrayList<Reserva> list = reserva.obtemTodos();
		for(int i = 0 ; i < list.size() ; i++){
			reservas[i] = list.get(i);
		}
		ArrayAdapter adapter = new ArrayAdapter<Reserva>(this,R.id.listView1,reservas);
		ListView lista = (ListView)findViewById(R.id.listView1);
		lista.setAdapter(adapter);
		lista.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//abrir a reserva
				
			}
		});
		setContentView(R.layout.activity_reserva);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reserva, menu);
		return true;
	}

}
