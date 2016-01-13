package com.gimmicktech.budgetmanager.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asad on 1/13/2016.
 */
public class BudgetDataBaseHelper extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "budgetmanger";

    public BudgetDataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tables.TableUser.CREATE_TABLE_USER);
        db.execSQL(Tables.TableCalculations.CREATE_TABLE_CALCULATIONS);
        db.execSQL(Tables.TableExpenses.CREATE_TABLE_EXPENSES);
        db.execSQL(Tables.TableIncome.CREATE_TABLE_INCOME);
        db.execSQL(Tables.TableIncomeType.CREATE_TABLE_INCOME_TYPE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Tables.TableUser.DROP_TABLE_USER);
        db.execSQL(Tables.TableCalculations.DROP_TABLE_CALCULATIONS);
        db.execSQL(Tables.TableExpenses.DROP_TABLE_EXPENSES);
        db.execSQL(Tables.TableIncome.DROP_TABLE_INCOME);
        db.execSQL(Tables.TableIncomeType.DROP_TABLE_INCOME_TYPE);
        onCreate(db);
    }
}
