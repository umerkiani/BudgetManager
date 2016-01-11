package com.gimmicktech.budgetmanager.activity;

import android.content.res.Configuration;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gimmicktech.budgetmanager.R;
import com.gimmicktech.budgetmanager.adapters.LoginSignUpPagerAdapter;
import com.gimmicktech.budgetmanager.databinding.ActivityLoginBinding;
import com.gimmicktech.budgetmanager.fragments.OneFragment;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding bindingViewHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingViewHolder = DataBindingUtil.setContentView(this, R.layout.activity_login);

        ArrayList<String> titles = new ArrayList<>();
        titles.add("Sign In");
        titles.add("Sign Up");

        ArrayList<Fragment> fragList = new ArrayList<>();
        fragList.add(new OneFragment());
        fragList.add(new OneFragment());
        LoginSignUpPagerAdapter adapter = new LoginSignUpPagerAdapter(getSupportFragmentManager(), titles, fragList);

        bindingViewHolder.loginContent.vpLoginSignup.setAdapter(adapter);
        bindingViewHolder.tlLoginTabs.setupWithViewPager(bindingViewHolder.loginContent.vpLoginSignup);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
}
