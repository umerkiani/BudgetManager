package com.gimmicktech.budgetmanager.utils;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.gimmicktech.budgetmanager.R;
import com.gimmicktech.budgetmanager.models.AppContext;

import java.io.File;


public class SelectProfilePicture implements OnClickListener {
    public PopupWindow pwindo;
    Context ctxRef;

    public SelectProfilePicture(Context ctx) {
        this.ctxRef = ctx;

    }

    @SuppressWarnings("deprecation")
    public void selectImage() {

        LayoutInflater inflater = (LayoutInflater) ctxRef
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popup_choose_image, null);
        pwindo = new PopupWindow(view, LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT, true);
        pwindo.setOutsideTouchable(true);
        pwindo.setTouchable(true);
        pwindo.setAnimationStyle(R.style.PopupWindowAnimation);
        pwindo.setBackgroundDrawable(new BitmapDrawable());


        view.findViewById(R.id.iv_camera).setOnClickListener(this);
        view.findViewById(R.id.iv_gallery).setOnClickListener(this);
        view.findViewById(R.id.btn_close_selectimage).setOnClickListener(this);
        pwindo.showAtLocation(view, Gravity.CENTER, 0, 0);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.iv_camera:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                File f = new File(
                        android.os.Environment.getExternalStorageDirectory(),
                        "temp.jpg");

                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.M) {
                    if (ctxRef.checkSelfPermission(Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(AppContext.activity,
                                Manifest.permission.CAMERA)) {
                            Toast.makeText(ctxRef, "Accessing Camera Permission", Toast.LENGTH_SHORT).show();
                            AppContext.activity.requestPermissions(new String[]{Manifest.permission.CAMERA},
                                    1);
                        } else {
                            AppContext.activity.requestPermissions(new String[]{Manifest.permission.CAMERA},
                                    1);
                        }

                    } else {
                        AppContext.activity.startActivityForResult(intent, 1);
                    }

                } else {
                    AppContext.activity.startActivityForResult(intent, 1);
                }
                pwindo.dismiss();
                break;

            case R.id.iv_gallery:
                intent = new Intent(
                        Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                AppContext.activity.startActivityForResult(intent, 2);
                pwindo.dismiss();
                break;

            case R.id.btn_close_selectimage:
                pwindo.dismiss();
                break;
        }

    }

}
