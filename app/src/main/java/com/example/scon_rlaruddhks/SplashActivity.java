package com.example.scon_rlaruddhks;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        FirebaseApp.initializeApp(getApplicationContext());
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        // 유저가 로그인 되어있는지 확인 후 UI 업데이트
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                updateUI(currentUser);
            }
        }, 2000);
    }

    //Change UI according to user data.
    private void updateUI(FirebaseUser account){
        if(account != null) {
            startActivity(new Intent(this, MainActivity.class));
        }else {
            startActivity(new Intent(this, SignInActivity.class));
        }
        finish();
    }
}
