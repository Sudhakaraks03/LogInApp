package com.customer.loginapp.data;

import static com.customer.loginapp.KeyConstants.PREF_NAME;
import static com.customer.loginapp.KeyConstants.USER_NAME;
import static com.customer.loginapp.KeyConstants.USER_PASSWoRD;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceClass implements PreferenceInteractor {


  private SharedPreferences sharedPref;
  SharedPreferences.Editor editor;

  @SuppressLint("CommitPrefEdits")
  public PreferenceClass(Context context) {
    sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    editor = sharedPref.edit();
  }

  public void setUserName(String name) {
    editor.putString(USER_NAME, name);
    editor.commit();
  }

  public String getUserName() {
    return sharedPref.getString(USER_NAME, "");
  }

  public void setPassword(String name) {
    editor.putString(USER_PASSWoRD, name);
    editor.commit();
  }

  public String getPassword() {
    return sharedPref.getString(USER_PASSWoRD, "");
  }
}
