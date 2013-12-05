package ua.example.apitest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DB {

	private static final String DATABASE_NAME = "some_name.db";
		private static final int DATABASE_VERSION = 1;
		public static final String ID = "_id";
		public static final String SOME_ROW = "note";
		
		
		public static final String TABLE_NAME = "some_table";
		private static final String CREATE_DATABASE = "CREATE TABLE "
				+ TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ SOME_ROW + " VARCHAR(255));";
		private static final String DROP_TABLE = "DROP TABLE IF EXISTS "
				+ TABLE_NAME;
private final Context c;
private DBHelper dbHelper;
private SQLiteDatabase db;
public DB(Context context){
	c=context;
}
public void open(){
	dbHelper = new DBHelper(c, DATABASE_NAME, null, DATABASE_VERSION);
	db = dbHelper.getWritableDatabase();
}
public void close(){
	if (dbHelper!=null) dbHelper.close();
}
public void delete(long id){
	db.delete(TABLE_NAME, ID + "=" + id, null);
}
public Cursor getAllData(){
	return db.query(TABLE_NAME, null, null,null,null,null,null);
}
public void insert(String some) {
    ContentValues cv = new ContentValues();
    cv.put(SOME_ROW, some);
    
   db.insert(TABLE_NAME, SOME_ROW, cv);
  }

private class DBHelper extends SQLiteOpenHelper {
	public DBHelper(Context context, String name, CursorFactory factory, int Version){
		super(context, name, factory, Version);
	}
	public void onCreate(SQLiteDatabase db){
		db.execSQL(CREATE_DATABASE);
		ContentValues cv = new ContentValues();
		cv.put(SOME_ROW, "Пример чего-то!");
		db.insert(TABLE_NAME, null, cv);
	}

	  @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		  db.execSQL(DROP_TABLE);
		  onCreate(db);
	    }
	 
}
}
