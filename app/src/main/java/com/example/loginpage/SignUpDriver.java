package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginpage.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpDriver extends AppCompatActivity {

    EditText etstudent_iddriver, etcontactdriver, etnamedriver, etcarprice, etcarplate;
    Button btnSignUpDriver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_driver);

        etstudent_iddriver = (EditText)findViewById(R.id.etstudent_iddriver);
        etcontactdriver = (EditText) findViewById(R.id.etcontactdriver);
        etnamedriver = (EditText)findViewById(R.id.etnamedriver);
        etcarprice = (EditText) findViewById(R.id.etcarprice);
        etcarplate = (EditText) findViewById(R.id.etcarplate);

        btnSignUpDriver =(Button)findViewById(R.id.btnSignUpDriver);

        //init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("");

        btnSignUpDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(SignUpDriver.this);
                mDialog.setMessage("Please waiting..." );
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //check if already user phone
                        if (dataSnapshot.child(etstudent_iddriver.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            Toast.makeText(SignUpDriver.this, "Register successfully!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignUpDriver.this, Menu.class);
                            startActivity(i); }
                        else
                        {
                            mDialog.dismiss();
                            User user = new User(etcontactdriver.getText().toString(),etnamedriver.getText().toString(), etcarprice. getText().toString(), etcarplate.getText().toString());
                            table_user.child(etstudent_iddriver.getText().toString()).setValue(user);
                            Toast.makeText(SignUpDriver.this,"Student ID already registered", Toast.LENGTH_SHORT).show();
                            finish();



                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


                Button btnSignUpDriver = (Button) view.findViewById(R.id.btnSignUpDriver);

                btnSignUpDriver.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SignUpDriver.this, RegisterThanks.class);
                        startActivity(intent);

                    }
                });


            }
        });

    }

}
