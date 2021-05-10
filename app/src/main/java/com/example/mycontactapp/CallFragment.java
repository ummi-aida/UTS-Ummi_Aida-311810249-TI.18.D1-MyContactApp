package com.example.mycontactapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Objects;

public class CallFragment extends Fragment {
    View RootView;

    public CallFragment() {
        // Required empty public constructor
    }

    public static CallFragment newInstance(String param1, String param2) {
        return new CallFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RootView = inflater.inflate(R.layout.fragment_call, container, false);
        Glide.with(getContext())
                .load(R.drawable.img_location)
                .circleCrop()
                .into((ImageView) RootView.findViewById(R.id.img_contact));
        Button BtnCallMe = RootView.findViewById(R.id.btn_to_call);
        BtnCallMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Build.VERSION.SDK_INT > 22) {
                        if (ActivityCompat.checkSelfPermission(Objects.requireNonNull(getContext()), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(Objects.requireNonNull(getActivity()), new String[] {Manifest.permission.CALL_PHONE}, 101);
                            return;
                        }
                        Intent i = new Intent(Intent.ACTION_CALL);
                        i.setData(Uri.parse("tel:0895412015287"));
                        startActivity(i);
                    } else {
                        Intent i = new Intent(Intent.ACTION_CALL);
                        i.setData(Uri.parse("tel:0895412015287"));
                        startActivity(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getContext(), "Gagal melakukan panggilan", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return RootView;
    }
}