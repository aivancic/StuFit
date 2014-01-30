package hr.foi.air.bananatim.stufit;

import hr.foi.air.bananatim.stufit.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class BMRActivity extends Activity {

	Button izracunaj;
	TextView rezultatBMR;
	EditText visina;
	EditText masa;
	EditText godine;

	RadioGroup grupa;
	RadioButton zenski_spol;
	RadioButton muski_spol;
	TextView rezultatBMI;
	Button savjeti;
	EditText tip;
	Double rezBMI;
	EditText statusBMI;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bmr);

		visina = (EditText) findViewById(R.id.txtInputHeight);
		masa = (EditText) findViewById(R.id.txtInputWeight);
		godine = (EditText) findViewById(R.id.txtInputAge);
		rezultatBMR = (TextView) findViewById(R.id.txtActivityBMRResult);
		rezultatBMI = (TextView) findViewById(R.id.txtActivityBMIResult);
		izracunaj = (Button) findViewById(R.id.btnBMRCalculate);
		grupa = (RadioGroup) findViewById(R.id.radioGroup1);
		zenski_spol = (RadioButton) findViewById(R.id.rbBMRFemale);
		muski_spol = (RadioButton) findViewById(R.id.rbBMRMale);
		tip = (EditText) findViewById(R.id.txtTip);
		savjeti = (Button) findViewById(R.id.btnBMRTips);
		statusBMI = (EditText) findViewById(R.id.txtBMIstatus);

		/*
		 * Kada se klikne gumb Izraèunaj, raèuna se bazièni metabolizam.
		 */

		izracunaj.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				double BMRres = 0;
				double BMIres = 0;

				double h = Double.parseDouble(visina.getText().toString());
				double w = Double.parseDouble(masa.getText().toString());
				double a = Double.parseDouble(godine.getText().toString());

				BMIres = BMIres + (w) / ((h * h) / 10000);

				if (muski_spol.isChecked()) {
					BMRres = BMRres + (13.7516 * w) + (5.0033 * h)
							- (6.7550 * a) + 66.4730;

				}
				if (zenski_spol.isChecked()) {

					BMRres = BMRres + (9.5634 * w) + (1.8496 * h)
							- (4.6756 * a) + 655.0955;

				}
				BMRres = Math.round(BMRres * 100.0) / 100.0;
				rezultatBMR.setText(Double.toString(BMRres) + "  kcal/day");

				BMIres = Math.round(BMIres * 100.0) / 100.0;
				rezultatBMI.setText(Double.toString(BMIres));
				rezBMI = BMIres;

				if (rezBMI < 18.5) {
					statusBMI.setText("Mršav");
				} else if (rezBMI > 18.5 && rezBMI < 24.9) {
					statusBMI.setText("Normalan");
				} else if (rezBMI > 25.0 && rezBMI < 29.9) {
					statusBMI.setText("Iznad prosjeka");
				} else if (rezBMI > 30.0) {
					statusBMI.setText("Debeo");
				}

			}

		});
		/*
		 * Klikom na gumb savjeti, korisniku se prikažu savjeti u odnosu na
		 * bazièni metabolizam.
		 */
		savjeti.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (rezBMI < 18.5) {
					tip.setText("Morate paziti na prehranu!");
				} else if (rezBMI > 18.5 && rezBMI < 24.9) {
					tip.setText("Normalna prehrana.");
				} else if (rezBMI > 25.0 && rezBMI < 29.9) {
					tip.setText("Pazite na prehranu i unos kalorija!");
				} else if (rezBMI > 30.0) {
					tip.setText("Pretilo! Smanjite prehranu!");
				}
			}
		});

	}
}
