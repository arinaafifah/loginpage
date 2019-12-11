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

public class SignUp extends AppCompatActivity {

    EditText etstudent_id, etcontact, etname;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etstudent_id = (EditText)findViewById(R.id.etstudent_id);
        etcontact = (EditText) findViewById(R.id.etcontact);
        etname = (EditText)findViewById(R.id.etname);

        btnSignUp =(Button)findViewById(R.id.btnSignUp);

        //init Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage("Please waiting..." );
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //check if already user phone
                        if (dataSnapshot.child(etstudent_id.getText().toString()).exists())
                        {
                            mDialog.dismiss();
                            Toast.makeText(SignUp.this, "Sign up successfully!", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(SignUp.this, Menu.class);
                            startActivity(i); }
                        else
                        {
                            mDialog.dismiss();
                            User user = new User(etcontact.getText().toString(),etname.getText().toString());
                            table_user.child(etstudent_id.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this,"Student ID already registered", Toast.LENGTH_SHORT).show();
                            finish();



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
