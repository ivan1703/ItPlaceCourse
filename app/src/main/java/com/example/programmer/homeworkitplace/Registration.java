package com.example.programmer.homeworkitplace;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registration extends AppCompatActivity {

    //место создания переменных-------------------------------------------------------------------
    public EditText ETemail,ETpassword;
    public TextView name;
    public Button Bsignin;

    private FirebaseAuth mAuth;
    //--------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();
        init();
        Bsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin(ETemail.getText().toString(),ETpassword.getText().toString());
            }
        });

    }

    //метод инициализации перменных---------------------------------------------------------------
    public void init(){
        ETemail = (EditText)findViewById(R.id.email);
        ETpassword = (EditText)findViewById(R.id.password);
        name = (TextView) findViewById(R.id.name);
        Bsignin = (Button)findViewById(R.id.signin);
    }
    //--------------------------------------------------------------------------------------------
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {

    }
    //скрипт авторизации(рекомендованный документацией FireBase.)---------------------------------
    public void signin(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                            Toast.makeText(Registration.this, "успешный вход",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Registration.this, "ошибка входа",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getDisplayName();
            name.split(name);
            boolean emailVerified = user.isEmailVerified();
            String uid = user.getUid();
        }
    }
}
