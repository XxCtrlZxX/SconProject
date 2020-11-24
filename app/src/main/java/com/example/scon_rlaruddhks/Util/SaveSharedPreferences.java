package com.example.scon_rlaruddhks.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class SaveSharedPreferences {
    static final String PREF_STRING = "string";

    static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    //*** set ***//
    public static void setPrefString(Context context, String s) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(PREF_STRING, s);
        editor.apply();
    }

    //*** get ***//
    public static String getPrefString(Context context) {
        return getSharedPreferences(context).getString(PREF_STRING, "");
    }
}
