package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginpage.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {
    EditText etstudent_id, etcontact;
    Button btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etstudent_id= (EditText) findViewById(R.id.etstudent_id);
        etcontact= (EditText) findViewById(R.id.etcontact);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        //init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please wait..." );
                mDialog.show();


                ((DatabaseReference) table_user).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //check if user not exist in database
                        if(dataSnapshot.child(etstudent_id.getText().toString()).exists()){

                        //Get User Information
                        mDialog.dismiss();
                        User user = dataSnapshot.child(etstudent_id.getText().toString()).getValue(User.class);
                        if (user.getContact().equals(etcontact.getText().toString()))
                        {
                            Toast.makeText((SignIn.this),"Sign in successfully!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignIn.this, Menu.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText((SignIn.this),"Invalid password. Please try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                        else
                        {
                            mDialog.dismiss();
                            Toast.makeText((SignIn.this),"User not exist or invalid Student ID.", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
