package com.example.mycontactapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class WebFragment extends Fragment {
    View RootView;

    public static WebFragment newInstance(String param1, String param2) {
        return new WebFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RootView = inflater.inflate(R.layout.fragment_web, container, false);
        View BtnNews = RootView.findViewById(R.id.btn_news);
        Glide.with(getContext())
                .load("https://www.masakapahariini.com/wp-content/uploads/2018/04/makan-malam-370x200.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_image_list)
                .centerCrop()
                .into((ImageView) RootView.findViewById(R.id.imageWeb));
        BtnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.masakapahariini.com/"));
                startActivity(i);
            }
        });
        return RootView;
    }
}