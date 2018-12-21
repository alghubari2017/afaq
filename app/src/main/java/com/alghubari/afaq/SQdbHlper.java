package com.alghubari.afaq;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alghubari.afaq.StoreContract.CustomereEntry;
public class SQdbHlper extends SQLiteOpenHelper {

    public static final String LOG_TAG =  SQdbHlper.class.getSimpleName();

    /** Name of the database file */
   private static final String DATABASE_NAME = "afaqadress.db";
   // private static final String DATABASE_NAME ="afaqdata.db";
    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
   private static final int DATABASE_VERSION = 2;

    /**
     * Constructs a new instance of {@link SQdbHlper}.
     *
     * @param context of the app
     */


    public SQdbHlper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + CustomereEntry.TABLE_NAME + " ("
                + CustomereEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CustomereEntry.COLUMN_NAME_CUSTOMER + " TEXT NOT NULL, "
                + CustomereEntry.COLUMN_PHONE_NUM + " TEXT,"
                + CustomereEntry.COLUMN_PRICE + " TEXT, "
                + CustomereEntry.COLUMN_PAYED_VALUE + " TEXT,"
                + CustomereEntry.COLUMN_REMIND_VALUE + " TEXT,"
                + CustomereEntry.COLUMN_RECIVE_DATE + " TEXT,"
                + CustomereEntry.COLUMN_ADRESS_COUNT + " TEXT,"
                + CustomereEntry.COLUMN_ADRESS_LENGHT + " TEXT,"
                + CustomereEntry.COLUMN_SHOULDER_LENGHT + " TEXT,"
                + CustomereEntry.COLUMN_KUM_LENGHT + " TEXT,"
                + CustomereEntry.COLUMN_CHEST_WEDIGHT + " TEXT,"
                + CustomereEntry.COLUMN_NIKE_SIZE + " TEXT,"
                + CustomereEntry.COLUMN_HAND_LENGHT + " TEXT,"
                + CustomereEntry.COLUMN_CABACK_LENGHT + " TEXT,"
                + CustomereEntry.COLUMN_FROM_DAWON + " TEXT,"
                + CustomereEntry.COLUMN_GABSOR_TYPE +" INTEGER NOT NULL,"
                + CustomereEntry.COLUMN_GEEB_TYPE + " INTEGER NOT NULL,"
                + CustomereEntry.COLUMN_CABACK_TYPE + " INTEGER NOT NULL,"
                + CustomereEntry.COLUMN_NIKE_TYPE + " INTEGER NOT NULL,"
                +CustomereEntry.COLUMN_PAGE_NUM + " TEXT);";





        // Execute the SQL statement
        db.execSQL(SQL_CREATE_PETS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // If you need to add a column
        db.execSQL("DROP TABLE IF EXISTS "+CustomereEntry.TABLE_NAME);
        onCreate(db);

    }
}
