package hr.foi.air.bananatim.stufit.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/*
 * Klasa DBHelper koja sluzi za rad s bazom podataka.
 */
public class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Kreiranje tablice
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE jela (id INTEGER PRIMARY KEY, vrsta TEXT, naziv TEXT, proteini NUMERIC, masti NUMERIC, ugljikohidrati NUMERIC, kalorije NUMERIC, kolicina NUMERIC);");
		Log.d(null, "Kreirana tablica");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
