package com.example.loginpage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AboutFragment extends Fragment  implements View.OnClickListener {


    Button Go;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);


        Button Go = (Button) view.findViewById(R.id.btnGo);

        Go.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGo:

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tg://resolve?domain=YourPrebetHelp_chatbot"));
                startActivity(intent);

                break;


        }
    }
}