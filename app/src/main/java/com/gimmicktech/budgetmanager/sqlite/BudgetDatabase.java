package com.gimmicktech.budgetmanager.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by UmerKiani on 1/11/2016.
 */
public class BudgetDatabase extends SQLiteOpenHelper{
    private static String DB_NAME = "budget.db";// Database name
    private static final int DB_VER =2;


    public BudgetDatabase(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
