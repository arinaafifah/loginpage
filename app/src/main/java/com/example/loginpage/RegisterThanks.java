package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class RegisterThanks extends AppCompatActivity {

    EditText etstudent_iddriver, etcontactdriver, etnamedriver, etcarprice, etcarplate;
    Button btnSignUpDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_thanks);
    }
}
