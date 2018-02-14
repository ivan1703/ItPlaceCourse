package com.example.programmer.homeworkitplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {

    //место создания переменных-------------------------------------------------------------------
    public EditText ETemail,ETpassword;
    public Button Bsignin;
    //--------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

    }

    //метод инициализации перменных---------------------------------------------------------------
    public void init(){
        ETemail = (EditText)findViewById(R.id.email);
        ETpassword = (EditText)findViewById(R.id.password);
        Bsignin = (Button)findViewById(R.id.signin);
    }
    //--------------------------------------------------------------------------------------------
}
