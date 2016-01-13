package com.gimmicktech.budgetmanager.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import com.gimmicktech.budgetmanager.models.AppContext;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Asad on 1/13/2016.
 */
public class SaveImage {

    public SaveImage(Bitmap bitmap, String fileName) {
        createDirectoryAndSaveFile(bitmap, fileName + ".png");
//        createDirectoryFile(bitmap,fileName+".png");
    }


    private void createDirectoryAndSaveFile(Bitmap imageToSave, String fileName) {

        File direct = AppContext.context.getDir("images", Context.MODE_PRIVATE);

        if (!direct.exists()) {
            direct.mkdir();
        }

        File file = new File(new File(direct.getPath()), fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            imageToSave.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sample Code for checking if image is saving or not
     *
     * @param imageToSave
     * @param fileName
     */
    private void createDirectoryFile(Bitmap imageToSave, String fileName) {

        File direct = new File(Environment.getExternalStorageDirectory() + "/Asad");

        if (!direct.exists()) {
            File wallpaperDirectory = new File("/sdcard/Asad/");
            wallpaperDirectory.mkdirs();
        }

        File file = new File(new File("/sdcard/Asad/"), fileName);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            imageToSave.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
