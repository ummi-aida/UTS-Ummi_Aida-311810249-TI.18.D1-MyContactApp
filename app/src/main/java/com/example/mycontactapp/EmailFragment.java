package com.example.mycontactapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class EmailFragment extends Fragment {
    View RootView;

    public EmailFragment() {
        // Required empty public constructor
    }

    public static EmailFragment newInstance(String param1, String param2) {
        return new EmailFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RootView = inflater.inflate(R.layout.fragment_email, container, false);
        Glide.with(getContext())
                .load(R.drawable.img_location)
                .circleCrop()
                .into((ImageView) RootView.findViewById(R.id.img_email));
        Button BtnToEmail = RootView.findViewById(R.id.btn_to_email);
        BtnToEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:aydaragandy408@gmail.com"));
                startActivity(i);
            }
        });
        return RootView;
    }
}