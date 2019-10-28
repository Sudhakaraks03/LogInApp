package com.customer.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import com.customer.loginapp.data.PreferenceClass;
import com.customer.loginapp.data.PreferenceInteractor;

public class MainActivity extends AppCompatActivity {

  private AppCompatButton btnLogIn;
  private AppCompatEditText etPassword;
  private AppCompatEditText etMail;
  private PreferenceInteractor prefInteractor;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
  }

  private void initView() {
    prefInteractor = new PreferenceClass(getApplicationContext());
    btnLogIn = findViewById(R.id.btnLogIn);
    etPassword = findViewById(R.id.etPassword);
    etMail = findViewById(R.id.etMail);

    btnLogIn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (!TextUtils.isEmpty(etPassword.getText())
            && !TextUtils.isEmpty(etMail.getText())
            && Patterns.EMAIL_ADDRESS.matcher(etMail.getText()).matches()) {
          prefInteractor.setPassword(etPassword.getText().toString());
          prefInteractor.setUserName(etMail.getText().toString());
          startActivity(new Intent(MainActivity.this, HomeActivity.class));
        } else if (TextUtils.isEmpty(etMail.getText()) || !Patterns.EMAIL_ADDRESS.matcher(
            etMail.getText()).matches()) {
          etPassword.setError("InValid mail ID");
        } else {
          etPassword.setError("Password Field Should not be Empty");
        }
      }
    });
  }
}
