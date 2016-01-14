package com.gimmicktech.budgetmanager.app;

import android.app.Application;
import android.util.Log;

import com.gimmicktech.budgetmanager.models.AppContext;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.config.Configuration;
import com.path.android.jobqueue.log.CustomLogger;


public class BudgetApplication extends Application {

    private JobManager jobManager;
    private BudgetApplication instance;

    public BudgetApplication() {
        instance = this;
    }

    public BudgetApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.context = getApplicationContext();
//        configureJobManager();
    }

    private void configureJobManager() {
        Configuration configuration = new Configuration.Builder(this)
                .customLogger(new CustomLogger() {
                    private static final String TAG = "JOBS";

                    @Override
                    public boolean isDebugEnabled() {
                        return true;
                    }

                    @Override
                    public void d(String text, Object... args) {
                        Log.d(TAG, String.format(text, args));
                    }

                    @Override
                    public void e(Throwable t, String text, Object... args) {
                        Log.e(TAG, String.format(text, args), t);
                    }

                    @Override
                    public void e(String text, Object... args) {
                        Log.e(TAG, String.format(text, args));
                    }
                })
                .minConsumerCount(1)//always keep at least one consumer alive
                .maxConsumerCount(3)//up to 3 consumers at a time
                .loadFactor(3)//3 jobs per consumer
                .consumerKeepAlive(120)//wait 2 minute
                .build();
        jobManager = new JobManager(this, configuration);
    }

    public JobManager getJobManager() {
        return jobManager;
    }
}
