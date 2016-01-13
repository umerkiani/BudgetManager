package com.gimmicktech.budgetmanager.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gimmicktech.budgetmanager.R;
import com.gimmicktech.budgetmanager.databinding.LoginFragmentBinding;

/**
 * Created by Asad on 1/13/2016.
 */
public class LoginFragment extends ParentFragment implements View.OnClickListener {
    LoginFragmentBinding loginFragmentBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        loginFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false);
        loginFragmentBinding.fabSignIn.setOnClickListener(this);
        loginFragmentBinding.btnForgretPass.setOnClickListener(this);
        return loginFragmentBinding.getRoot();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_signIn:
                String userName = loginFragmentBinding.tilUserName.getEditText().getText().toString();
                String password = loginFragmentBinding.tilPassword.getEditText().getText().toString();

                Toast.makeText(v.getContext(), "" + userName + " " + password, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_forgretPass:
                Toast.makeText(v.getContext(), "Forget Pass", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
