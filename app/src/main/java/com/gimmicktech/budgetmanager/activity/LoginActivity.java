package com.gimmicktech.budgetmanager.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.gimmicktech.budgetmanager.R;
import com.gimmicktech.budgetmanager.adapters.LoginSignUpPagerAdapter;
import com.gimmicktech.budgetmanager.databinding.ActivityLoginBinding;
import com.gimmicktech.budgetmanager.fragments.LoginFragment;
import com.gimmicktech.budgetmanager.fragments.SignUpFragment;
import com.gimmicktech.budgetmanager.models.AppContext;
import com.gimmicktech.budgetmanager.utils.SaveImage;

import java.io.File;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding bindingViewHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingViewHolder = DataBindingUtil.setContentView(this, R.layout.activity_login);
        AppContext.activity = this;
        AppContext.context = this;


        ArrayList<String> titles = new ArrayList<>();
        titles.add("Sign In");
        titles.add("Sign Up");

        ArrayList<Fragment> fragList = new ArrayList<>();
        fragList.add(new LoginFragment());
        fragList.add(new SignUpFragment());
        LoginSignUpPagerAdapter adapter = new LoginSignUpPagerAdapter(getSupportFragmentManager(), titles, fragList);

        bindingViewHolder.loginContent.vpLoginSignup.setAdapter(adapter);
        bindingViewHolder.tlLoginTabs.setupWithViewPager(bindingViewHolder.loginContent.vpLoginSignup);
        setupTabIcons();
    }

    private void setupTabIcons() {
        int[] tabIcons = {
                R.drawable.single_user,
                R.drawable.multi_user
        };
        bindingViewHolder.tlLoginTabs.getTabAt(0).setIcon(tabIcons[0]);
        bindingViewHolder.tlLoginTabs.getTabAt(1).setIcon(tabIcons[1]);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                File f = new File(Environment.getExternalStorageDirectory()
                        .toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }

                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();

                    bitmap = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            bitmapOptions);
                    bitmap = Bitmap
                            .createScaledBitmap(bitmap, 320, 320, true);

                    if (SignUpFragment.iLoadProfilePicture != null) {
                        SignUpFragment.iLoadProfilePicture.ILoadProfilePicture(bitmap);
                    }
                    new SaveImage().saveUserProfileDP(bitmap, "asad.png");
                    bitmap = null;

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == 2) {

                Uri selectedImage = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Cursor c = getContentResolver().query(selectedImage, filePath,
                        null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));

                thumbnail = Bitmap
                        .createScaledBitmap(thumbnail, 320, 320, true);
                if (SignUpFragment.iLoadProfilePicture != null) {
                    SignUpFragment.iLoadProfilePicture.ILoadProfilePicture(thumbnail);
                }
                new SaveImage().saveUserProfileDP(thumbnail, "asad.png");
                thumbnail = null;

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File f = new File(android.os.Environment.getExternalStorageDirectory(),
                        "temp.jpg");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                startActivityForResult(intent, 1);
            } else {

            }
        }
    }
}
