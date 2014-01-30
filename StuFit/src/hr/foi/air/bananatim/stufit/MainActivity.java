package hr.foi.air.bananatim.stufit;

import hr.foi.air.bananatim.stufit.R;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Context context = this;

		Button btnBodyFatActivity = (Button) findViewById(R.id.btnBodyFatActivity);
		btnBodyFatActivity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, BodyFatActivity.class);
				startActivity(i);

			}
		});

		Button btnBMRActivity = (Button) findViewById(R.id.btnBMRActivity);
		btnBMRActivity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, BMRActivity.class);
				startActivity(i);

			}
		});

		Button btnPregledUnosJela = (Button) findViewById(R.id.btnPregledUnosJela);
		btnPregledUnosJela.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(context, PregledJelaActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

}
