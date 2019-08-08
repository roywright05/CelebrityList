package com.example.celebritylist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static com.example.celebritylist.CelebrityDataBaseContract.*;

public class CelebrityDatabaseHelper extends SQLiteOpenHelper {


    public CelebrityDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(getCreateTableQuery());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(DROP_TABLE_QUERY);
        onCreate(sqLiteDatabase);

    }

    public ArrayList<Celebrity> getAllCelebrities(){

        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        ArrayList<Celebrity> returnCelebrityList = new ArrayList<>();

        Cursor cursor = readableDatabase.rawQuery(SELECT_ALL_CELEBRITIES, null);

        if(cursor.moveToFirst()){

            do{

                final String fName = cursor.getString(cursor.getColumnIndex(COL_FNAME));
                final String lName = cursor.getString(cursor.getColumnIndex(COL_LNAME));
                final String profession = cursor.getString(cursor.getColumnIndex(COL_PROF));
                final int age = cursor.getInt(cursor.getColumnIndex(COL_AGE));
                final double netWorth = cursor.getDouble(cursor.getColumnIndex(COL_NETWORTH));

                Celebrity currentCelebrity = new Celebrity(fName, lName, profession, age, netWorth);

            }while(cursor.moveToNext());
        }

        cursor.close();

        return returnCelebrityList;
    }


    public Celebrity getCelebrityByLastName(String lNameToQuery){

        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        Celebrity returnCelebrity = null;

        Cursor cursor = readableDatabase.rawQuery(CelebrityDataBaseContract.getSelectedCelebrityByLastName(lNameToQuery), null);

        if(cursor.moveToFirst()){

            final String fName = cursor.getString(cursor.getColumnIndex(COL_FNAME));
            final String lName = cursor.getString(cursor.getColumnIndex(COL_LNAME));
            final String profession = cursor.getString(cursor.getColumnIndex(COL_PROF));
            final int age = cursor.getInt(cursor.getColumnIndex(COL_AGE));
            final double netWorth = cursor.getDouble(cursor.getColumnIndex(COL_NETWORTH));

            returnCelebrity =  new Celebrity(fName, lName, profession, age, netWorth);
        }

        cursor.close();

        return returnCelebrity;
    }

    public void insertCelebrityIntoDatabase(Celebrity celebToInsert){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_FNAME, celebToInsert.getfName());
        contentValues.put(COL_LNAME, celebToInsert.getlName());
        contentValues.put(COL_PROF, celebToInsert.getProfession());
        contentValues.put(COL_AGE, celebToInsert.getAge());
        contentValues.put(COL_NETWORTH, celebToInsert.getNetWorth());

        database.insert(TABLE_NAME, null, contentValues);
    }

    public void removeCelebrity(String celebrityToDelete){

        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(TABLE_NAME, COL_LNAME + " = ?", new String[] {celebrityToDelete});
    }

    public void updateCelebIntoDatabase(Celebrity celebToUpdate){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_FNAME, celebToUpdate.getfName());
        contentValues.put(COL_LNAME, celebToUpdate.getlName());
        contentValues.put(COL_PROF, celebToUpdate.getProfession());
        contentValues.put(COL_AGE, celebToUpdate.getAge());
        contentValues.put(COL_NETWORTH, celebToUpdate.getNetWorth());

        database.update(TABLE_NAME, contentValues, COL_LNAME + " = ?",
                new String[]{celebToUpdate.getlName()});

    }

    public void deleteCelebrity(String lName) {
    }
}
