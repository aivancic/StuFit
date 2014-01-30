package hr.foi.air.bananatim.stufit.database;

import java.util.ArrayList;
import java.util.List;

import hr.foi.air.bananatim.stufit.types.JelaInfo;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataAdapter {

	public static final String DATABASE_NAME = "baza.db";
	public static final int DATABASE_VERSION = 1;
	public static final String TABLE = "jela";
	public static final String KEY_ID = "id";

	private DBHelper sqLiteHelper;
	private SQLiteDatabase sqLiteDatabase;

	private Context context;

	public DataAdapter(Context c) {
		context = c;
	}

	/*
	 * Metoda za èitanje iz baze.
	 */
	public DataAdapter openToRead() throws android.database.SQLException {

		sqLiteHelper = new DBHelper(context, DATABASE_NAME, null,
				DATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getReadableDatabase();
		return this;

	}

	/*
	 * Metoda za pisanje u bazu
	 */
	public DataAdapter openToWrite() throws android.database.SQLException {
		sqLiteHelper = new DBHelper(context, DATABASE_NAME, null,
				DATABASE_VERSION);
		sqLiteDatabase = sqLiteHelper.getWritableDatabase();

		return this;

	}

	public void close() {
		sqLiteHelper.close();
	}

	/*
	 * Unos jela
	 */
	public long unesiJela(JelaInfo jelo) {

		ContentValues contentValues = new ContentValues();

		contentValues.put("vrsta", jelo.getVrsta().toString());
		contentValues.put("naziv", jelo.getNaziv().toString());
		contentValues.put("proteini", jelo.getProteini());
		contentValues.put("masti", jelo.getMasti());
		contentValues.put("bjelancevine", jelo.getBjelancevine());
		contentValues.put("kalorije", jelo.getKalorije());
		contentValues.put("kolicina", jelo.getKolicina());

		return sqLiteDatabase.insert(TABLE, null, contentValues);
	}

	public List<JelaInfo> prikaziJela() {
		List<JelaInfo> result = new ArrayList<JelaInfo>();

		String[] columns = new String[] { KEY_ID, "vrsta", "naziv", "proteini",
				"masti", "bjelancevine", "kalorije", "kolicina" };
		Cursor cursor = sqLiteDatabase.query(TABLE, columns, null, null, null,
				null, null);

		for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {

			String vrsta = cursor.getString(cursor.getColumnIndex("vrsta"));
			String naziv = cursor.getString(cursor.getColumnIndex("naziv"));
			double proteini = cursor.getDouble(cursor
					.getColumnIndex("proteini"));
			double masti = cursor.getDouble(cursor.getColumnIndex("masti"));
			double bjelancevine = cursor.getDouble(cursor
					.getColumnIndex("bjelancevine"));
			double kalorije = cursor.getDouble(cursor
					.getColumnIndex("kalorije"));
			double kolicina = cursor.getDouble(cursor
					.getColumnIndex("kolicina"));

			JelaInfo jelo = new JelaInfo(vrsta, naziv, proteini, masti,
					bjelancevine, kalorije, kolicina);
			result.add(jelo);
		}

		return result;

	}
}
