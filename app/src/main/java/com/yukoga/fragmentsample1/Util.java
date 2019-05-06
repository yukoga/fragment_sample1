package com.yukoga.fragmentsample1;

import android.content.Context;
import android.widget.Toast;


public class Util {
    public static void toastMessage(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void toastMessage(Context context, String message, int length) {
        Toast.makeText(context, message, length).show();
    }
}
