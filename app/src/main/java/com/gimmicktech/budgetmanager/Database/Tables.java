package com.gimmicktech.budgetmanager.Database;

/**
 * Created by Asad on 1/13/2016.
 */
public class Tables {
    public static class TableUser {
        public static String TABLE_USER = "tblUser";
        public static String USER_ID = "u_id";
        public static String USER_FIRST_NAME = "first_name";
        public static String USER_LAST_NAME = "last_name";
        public static String USER_USERNAME = "user_name";
        public static String USER_EMAIL = "email";
        public static String USER_GENDER = "gender";
        public static String USER_PASSWORD = "password";
        public static String USER_PROFILE_DP = "profile_dp";

        public static String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + " ( " + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                USER_FIRST_NAME + " TEXT NOT NULL, " + USER_LAST_NAME + " TEXT NOT NULL, " + USER_USERNAME + " TEXT NOT NULL, " +
                USER_EMAIL + " TEXT NOT NULL, " + USER_GENDER + " TEXT NOT NULL," + USER_PASSWORD + " TEXT NOT NULL, " + USER_PROFILE_DP + " TEXT );";

        public static String DROP_TABLE_USER = "DROP TABLE IF EXISTS " + TABLE_USER;
    }

    public static class TableIncome {
        public static String TABLE_INCOME = "tblIncome";
        public static String INCOME_ID = "id";
        public static String INCOME_AMOUNT = "amount";
        public static String INCOME_DATE = "date";
        public static String INCOME_DESCRIPTION = "description";
        public static String INCOME_USER_ID = "user_id";
        public static String INCOME_TYPE_ID = "type_id";

        public static String CREATE_TABLE_INCOME = "CREATE TABLE " + TABLE_INCOME + " ( " + INCOME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INCOME_AMOUNT + " INTEGER, "
                + INCOME_DATE + " DATE, " + INCOME_DESCRIPTION + " TEXT, " + INCOME_USER_ID + " INTEGER, " + INCOME_TYPE_ID + " INTEGER);";
        public static String DROP_TABLE_INCOME = "DROP TABLE IF EXISTS " + TABLE_INCOME;
    }

    public static class TableExpenses {
        public static String TABLE_EXPENSES = "tblExpenses";
        public static String EXPENSE_ID = "id";
        public static String EXPENSE_AMOUNT = "amount";
        public static String EXPENSE_DATE = "date";
        public static String EXPENSE_DESCRIPTION = "description";
        public static String EXPENSE_USER_ID = "user_id";

        public static String CREATE_TABLE_EXPENSES = "CREATE TABLE " + TABLE_EXPENSES + " ( " + EXPENSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EXPENSE_AMOUNT + " INTEGER, " +
                EXPENSE_DATE + " DATE, " + EXPENSE_DESCRIPTION + " TEXT, " + EXPENSE_USER_ID + " INTEGER);";
        public static String DROP_TABLE_EXPENSES = "DROP TABLE IF EXISTS " + TABLE_EXPENSES;
    }

    public static class TableIncomeType {
        public static String TABLE_INCOME_TYPE = "tblIncomeType";
        public static String INCOME_TYPE_ID = "type_id";
        public static String INCOME_TYPE_NAME = "name";

        public static String CREATE_TABLE_INCOME_TYPE = "CREATE TABLE " + TABLE_INCOME_TYPE + " ( " + INCOME_TYPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + INCOME_TYPE_NAME + " TEXT);";
        public static String DROP_TABLE_INCOME_TYPE = "DROP TABLE IF EXISTS " + TABLE_INCOME_TYPE;
    }

    public static class TableCalculations {
        public static String TABLE_CALCULATIONS = "tblCalculations";
        public static String CALCULATION_ID = "id";
        public static String CALCULATION_TOTAL_AMOUNT = "total_amount";
        public static String CALCULATION_USER_ID = "user_id";

        public static String CREATE_TABLE_CALCULATIONS = "CREATE TABLE " + TABLE_CALCULATIONS + " ( " + CALCULATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CALCULATION_TOTAL_AMOUNT + " INTEGER, " +
                CALCULATION_USER_ID + " INTEGER);";
        public static String DROP_TABLE_CALCULATIONS = "DROP TABLE IF EXISTS " + TABLE_CALCULATIONS;
    }
}
