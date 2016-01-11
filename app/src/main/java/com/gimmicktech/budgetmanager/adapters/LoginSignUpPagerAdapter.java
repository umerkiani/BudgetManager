package com.gimmicktech.budgetmanager.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Asad on 1/11/2016.
 */
public class LoginSignUpPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<String> titles;
    private final ArrayList<Fragment> fragmentList;

    public LoginSignUpPagerAdapter(FragmentManager fm, ArrayList<String> titles, ArrayList<Fragment> fragmentsList) {
        super(fm);
        this.titles = titles;
        this.fragmentList = fragmentsList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
