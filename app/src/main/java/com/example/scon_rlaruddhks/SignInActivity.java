package com.example.scon_rlaruddhks;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    Button signInBtn, signUpBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        FirebaseApp.initializeApp(getApplicationContext());
        mAuth = FirebaseAuth.getInstance();

        signInBtn = findViewById(R.id.btnSignIn);
        signInBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        signUpBtn = findViewById(R.id.btnGotoSignUp);
        signUpBtn.setOnClickListener(v -> startActivity(new Intent(this, SignUpActivity.class)));
    }



    // 스플래시 액티비티로 들어가야 함
    @Override
    protected void onStart() {
        super.onStart();
        // 유저가 로그인 되어있는지 확인 후 UI 업데이트
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    //Change UI according to user data.
    private void updateUI(FirebaseUser account){
        if(account != null) {
            //Toast.makeText(this,"환영합니다 (id : " + account.getUid() + ")",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }else {
            Toast.makeText(this, "로그인해주세요", Toast.LENGTH_SHORT).show();
        }
    }
}
