package com.example.celebritylist;

import java.util.Locale;

public class CelebrityDataBaseContract {

    public static final String DATABASE_NAME = "celebrity_db";

    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "celebrity_table";

    public static final String COL_FNAME = "fName";

    public static final String COL_LNAME = "lName";

    public static final String COL_PROF = "profession";

    public static final String COL_AGE = "age";

    public static final String COL_NETWORTH = "netWorth";

    public static final String DROP_TABLE_QUERY = "DROP TABLE " + TABLE_NAME;

    public static final String SELECT_ALL_CELEBRITIES = "SELECT * FROM " + TABLE_NAME;

    public static String getCreateTableQuery(){

        return String.format(Locale.US, "CREATE TABLE %s( %s TEXT PRIMARY_KEY, " +
                "%s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)" ,
                TABLE_NAME, COL_FNAME, COL_LNAME, COL_PROF, COL_AGE, COL_NETWORTH);
    }

    public static String getSelectedCelebrityByLastName(String lName){

        return String.format(Locale.US, "SELECT * FROM " +
                "%s WHERE %s = \'%s\'", TABLE_NAME, lName);
    }


}
