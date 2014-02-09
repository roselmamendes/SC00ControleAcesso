package br.edu.uefs.cesic.sc00controleacesso.view;

import br.edu.uefs.cesic.sc00controleacesso.R;
import br.edu.uefs.cesic.sc00controleacesso.R.layout;
import br.edu.uefs.cesic.sc00controleacesso.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class VerReservaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ver_reserva);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ver_reserva, menu);
		return true;
	}

}
