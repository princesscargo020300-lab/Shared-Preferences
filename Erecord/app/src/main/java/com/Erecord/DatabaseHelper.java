
package com.Erecord;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "groupnine";
    public static final String TABLE_NAME = "Erecord";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "LASTNAME";
    public static final String COL_3 = "FIRSTNAME";
    public static final String COL_4 = "BIRTHDAY";
    public static final String COL_5 = "CURRENTADDRESS";
	public static final String COL_6 = "PERMANENTADDRESS";
    public static final String COL_7 = "HIGHESTDEGREE";
    public static final String COL_8 = "DESIGNATION";
    public static final String COL_9 = "CONTACT";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,LASTNAME TEXT,FIRSTNAME TEXT,BIRTHDAY TEXT,CURRENTADDRESS TEXT,PERMANENTADDRESS TEXT,HIGHESTDEGREE TEXT,DESIGNATION TEXT," +
				   "CONTACT INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String lname, String fname, String birth, String currentadd, String permanentadd, String highestdeg,String des, String contact)
	{
		SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,lname);
        contentValues.put(COL_3,fname);
        contentValues.put(COL_4,birth);
        contentValues.put(COL_5,currentadd);
		contentValues.put(COL_6,permanentadd);
        contentValues.put(COL_7,highestdeg);
        contentValues.put(COL_8,des);
        contentValues.put(COL_9,contact);

        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;

		return true;
    }



    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String id,String lname, String fname, String birth, String currentadd, String permanentadd, String highestdeg,String des, String contact)
	{  SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,lname);
        contentValues.put(COL_3,fname);
        contentValues.put(COL_4,birth);
        contentValues.put(COL_5,currentadd);
		contentValues.put(COL_6,permanentadd);
        contentValues.put(COL_7,highestdeg);
        contentValues.put(COL_8,des);
        contentValues.put(COL_9,contact);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}




