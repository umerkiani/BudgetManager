package com.gimmicktech.budgetmanager.Database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.gimmicktech.budgetmanager.models.User;

/**
 * Created by Asad on 1/13/2016.
 */
public class UserOperations {
    private final BudgetDataBaseHelper dbHelper;

    public UserOperations(BudgetDataBaseHelper db) {
        this.dbHelper = db;
    }

    public void registerUser(User user) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Tables.TableUser.USER_FIRST_NAME, user.firstName);
        cv.put(Tables.TableUser.USER_LAST_NAME, user.lasttName);
        cv.put(Tables.TableUser.USER_GENDER, user.gender);
        cv.put(Tables.TableUser.USER_USERNAME, user.userName);
        cv.put(Tables.TableUser.USER_PASSWORD, user.password);
        cv.put(Tables.TableUser.USER_PROFILE_DP, user.profileDp);

        db.insert(Tables.TableUser.TABLE_USER, null, cv);
        db.close();
    }
}
