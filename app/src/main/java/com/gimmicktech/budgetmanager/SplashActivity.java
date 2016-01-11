package com.gimmicktech.budgetmanager;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.gimmicktech.budgetmanager.activity.LoginActivity;
import com.gimmicktech.budgetmanager.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity implements Animation.AnimationListener {

    private ActivitySplashBinding bindingViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindingViewHolder = DataBindingUtil.setContentView(this, R.layout.activity_splash);
//        bindingViewHolder.setUser(new User());
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        bindingViewHolder.inContent.imageView.setAnimation(anim);
        anim.setAnimationListener(this);

//        bindingViewHolder.inContent.imageView.se


//        bindingViewHolder.inContent.setNote("Ok i Got it ");


//    bindingViewHolder.inContent.
//bindingViewHolder.inContent.


//        setContentView(R.layout.activity_splash);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        final Animation anim = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.bounce);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

        startActivity(new Intent(getApplicationContext() , LoginActivity.class));

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
