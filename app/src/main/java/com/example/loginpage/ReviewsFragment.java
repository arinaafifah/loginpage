package com.example.loginpage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.loginpage.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment  {

    TextView writesomething;
    Button submit;
    DatabaseReference reff;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reviews, container, false);


        TextView writesomething =(TextView) view.findViewById(R.id.writesomething);
        Button submit = (Button) view.findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Thanks.class);
                startActivity(intent);

            }
        });

        return view;
    }
}



        reff = FirebaseDatabase.getInstance().getReference().child("User").child("D072615");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String student_id = dataSnapshot.child("studentid").getValue().toString();
                String Fullname = dataSnapshot.child("name").getValue().toString();
                String Contact = dataSnapshot.child("contact").getValue().toString();

                etstudent_id.setText(student_id);
                etname.setText(Fullname);
                etcontact.setText(Contact);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });
        return view;
    }
}
