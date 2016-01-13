package com.gimmicktech.budgetmanager.models;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextWatcher;

import com.gimmicktech.budgetmanager.BR;

/**
 * Created by Asad on 1/12/2016.
 */
public class UserModel extends BaseObservable {
    private String firstName;
    private String lastName;


    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

        lastName = firstName;
        notifyPropertyChanged(BR.firstName);
        notifyPropertyChanged(BR.lastName);
    }


    @Bindable
    public TextWatcher getOnFirstNameChanged() {

        return new SimpleTextWatcher() {
            @Override
            public void onTextChanged(String newValue) {
                setLastName(newValue);
            }
        };
    }
}
