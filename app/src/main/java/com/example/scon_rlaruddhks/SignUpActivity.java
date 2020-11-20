package com.example.scon_rlaruddhks;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.scon_rlaruddhks.Util.CheckString;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    EditText emailET, passwordET, nicknameET;
    Button btnBack, btnCreate;

    private String email, password, nickname;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        btnBack = findViewById(R.id.btnBack);
        btnCreate = findViewById(R.id.btnCreate);
        emailET = findViewById(R.id.emailText);
        passwordET = findViewById(R.id.passwordText);
        nicknameET = findViewById(R.id.nickNameText);

        btnBack.setOnClickListener(view -> finish());
        btnCreate.setEnabled(false);
        btnCreate.setOnClickListener(view -> CreateAccount());

        emailET.addTextChangedListener(textChangeListener);
        passwordET.addTextChangedListener(textChangeListener);
        nicknameET.addTextChangedListener(textChangeListener);
    }

    private void CreateAccount() {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "계정이 생성되었습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(this, "Create Account Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private final TextWatcher textChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            email = emailET.getText().toString().trim();
            password = passwordET.getText().toString().trim();
            nickname = nicknameET.getText().toString().trim();

            if (email.length() > 0 && CheckString.isValidEmail(email) && password.length() >= 6 && nickname.length() > 0)
                btnCreate.setEnabled(true);
            else
                btnCreate.setEnabled(false);
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
}
