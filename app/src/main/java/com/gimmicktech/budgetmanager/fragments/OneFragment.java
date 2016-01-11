package com.gimmicktech.budgetmanager.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gimmicktech.budgetmanager.R;
import com.gimmicktech.budgetmanager.databinding.SignupFragmentBinding;


public class OneFragment extends Fragment {

    SignupFragmentBinding fragBinding;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragBinding = DataBindingUtil.inflate(inflater, R.layout.signup_fragment, container, false);


        return fragBinding.getRoot();
    }

}
