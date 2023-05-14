package com.notebook.collegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.notebook.collegeapp.R;


public class HomeFragment extends Fragment {
    private ViewFlipper flipper;
    private ImageView map;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        int imarray[]={R.drawable.pic1,R.drawable.pic2, R.drawable.pic3, R.drawable.pic4,R.drawable.pic5, R.drawable.pic6, R.drawable.pic7};
        flipper=view.findViewById(R.id.flipper);
        for(int i=0; i< imarray.length;i++)
            showImage(imarray[i]);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        return view;
    }

    private void openMap()
    {
        Uri uri = Uri.parse("geo:0,0?q= Jaypee University of Engineering and Technology Guna");
        Intent intent= new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
    public void showImage(int img)
    {
        ImageView imageview=new ImageView(getActivity());
        imageview.setBackgroundResource(img);
        flipper.addView(imageview);
        flipper.setAutoStart(true);
        flipper.setFlipInterval(2000);
        flipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        flipper.setOutAnimation(getActivity(),android.R.anim.slide_out_right);
    }
}