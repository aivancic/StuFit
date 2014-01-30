package hr.foi.air.bananatim.stufit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PregledJelaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pregled);

		final Context context = this;

		
		/*
		 * Upravljanje klikom na gumb dodaj jelo.
		 */
		Button dodajJelo = (Button) findViewById(R.id.btnDodajNovoJelo);
		dodajJelo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				
				Intent i = new Intent(context, UnosJelaActivity.class);
				startActivity(i);
				/* 
				Dialog myDialog = new Dialog(context);
				myDialog.setContentView(R.layout.activity_unos_jela);
				myDialog.setTitle("Unesite novo jelo");
				myDialog.setCancelable(true);
				myDialog.show();
				*/
			}
		});

	}

}
