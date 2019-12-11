package com.example.loginpage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BookingFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booking,container,false);

        Button ContactUs = view.findViewById(R.id.ContactUs);
        Button select1 = view.findViewById(R.id.select1);
        Button select2 = view.findViewById(R.id.select2);
        Button select3 = view.findViewById(R.id.select3);
        Button select4 = view.findViewById(R.id.select4);
        Button select5 = view.findViewById(R.id.select5);
        Button select6 = view.findViewById(R.id.select6);

        select1.setOnClickListener(this);
        select2.setOnClickListener(this);
        select3.setOnClickListener(this);
        select4.setOnClickListener(this);
        select5.setOnClickListener(this);
        select6.setOnClickListener(this);
        ContactUs.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.select1:
                Uri uri = Uri.parse("smsto:60134721481");
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
                break;

            case R.id.select2:
                uri = Uri.parse("smsto:60173955254");
                sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
                break;

            case R.id.select3:
                uri = Uri.parse("smsto:601125675827");
                sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
                break;

            case R.id.select4:
                uri = Uri.parse("smsto:601125308620");
                sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
                break;

            case R.id.select5:
                uri = Uri.parse("smsto:601112402824");
                sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
                break;

            case R.id.select6:
                uri = Uri.parse("smsto:60104170469");
                sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
                break;

            case R.id.ContactUs:
                uri = Uri.parse("smsto:60137097015");
                sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);
                break;
        }
    }
}
