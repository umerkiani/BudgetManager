package com.gimmicktech.budgetmanager.app;

import android.app.Application;

import com.gimmicktech.budgetmanager.models.AppContext;

/**
 * Created by UmerKiani on 1/11/2016.
 */
public class BudgetApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.context = getApplicationContext();
    }
}
