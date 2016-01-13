package com.gimmicktech.budgetmanager.fragments;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gimmicktech.budgetmanager.R;
import com.gimmicktech.budgetmanager.databinding.SignupFragmentBinding;
import com.gimmicktech.budgetmanager.interfaces.ILoadProfilePicture;
import com.gimmicktech.budgetmanager.models.UserModel;
import com.gimmicktech.budgetmanager.utils.SelectProfilePicture;


public class SignUpFragment extends ParentFragment implements View.OnClickListener, ILoadProfilePicture {

    public static ILoadProfilePicture iLoadProfilePicture;
    SignupFragmentBinding fragBinding;
    private UserModel model;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        iLoadProfilePicture = this;
        model = new UserModel();
        fragBinding = DataBindingUtil.inflate(inflater, R.layout.signup_fragment, container, false);
        fragBinding.setUser(model);
        fragBinding.fabSignUp.setOnClickListener(this);
        fragBinding.civDp.setOnClickListener(this);

        return fragBinding.getRoot();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_signUp:
                model.setFirstName(fragBinding.tilFirstName.getEditText().getText().toString());
                Toast.makeText(v.getContext(), "" + model.getFirstName(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.civ_dp:
                new SelectProfilePicture(v.getContext()).selectImage();
                break;
        }

    }

    @Override
    public void ILoadProfilePicture(Bitmap bitmap) {
        fragBinding.civDp.setImageBitmap(bitmap);
    }
}
