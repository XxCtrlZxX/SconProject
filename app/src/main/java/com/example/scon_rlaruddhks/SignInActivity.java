package com.example.scon_rlaruddhks;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.scon_rlaruddhks.Util.CheckString;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInActivity extends AppCompatActivity {

    EditText emailET, passwordET;
    Button signInBtn, signUpBtn;

    private FirebaseAuth mAuth;
    private String userEmail, userPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        FirebaseApp.initializeApp(getApplicationContext());
        mAuth = FirebaseAuth.getInstance();

        signInBtn = findViewById(R.id.btnSignIn);
        signUpBtn = findViewById(R.id.btnGotoSignUp);
        emailET = findViewById(R.id.emailText);
        passwordET = findViewById(R.id.passwordText);

        signInBtn.setEnabled(false);
        signInBtn.setOnClickListener(v -> SignIn());
        signUpBtn.setOnClickListener(v -> startActivity(new Intent(this, SignUpActivity.class)));
        emailET.addTextChangedListener(textChangeListener);
        passwordET.addTextChangedListener(textChangeListener);
    }


    private void SignIn() {
        if (userEmail != null && userPassword != null) {
            mAuth.signInWithEmailAndPassword(userEmail, userPassword)
                    .addOnCompleteListener(this, task -> {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            if (user != null) {
                                startActivity(new Intent(this, MainActivity.class));
                                finish();
                            }
                        } else {
                            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private final TextWatcher textChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            userEmail = emailET.getText().toString().trim();
            userPassword = passwordET.getText().toString().trim();

            if (userEmail.length() > 0 && CheckString.isValidEmail(userEmail) && userPassword.length() >= 6)
                signInBtn.setEnabled(true);
            else
                signInBtn.setEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };
}
