package com.notebook.collegeapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.notebook.collegeapp.R;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    RecyclerView dequinox,cultural,others;
    GalleryAdapter adapter;
    DatabaseReference reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);
        dequinox = view.findViewById(R.id.dequinox);
        cultural = view.findViewById(R.id.cultural);
        others = view.findViewById(R.id.others);
        
        reference = FirebaseDatabase.getInstance().getReference().child("gallery");
        
        getDequinoxImage();
        getCulturalImage();
        getOthersImage();
        return view;

    }

    private void getOthersImage() {
        reference.child("Others").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    String data = (String) snapshot.getValue();
                    imageList.add(0,data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                others.setLayoutManager(new GridLayoutManager(getContext(),3));
                others.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {



            }
        });
    }

    private void getCulturalImage() {
        reference.child("Cultural").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    String data = (String) snapshot.getValue();
                    imageList.add(0,data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                cultural.setLayoutManager(new GridLayoutManager(getContext(),3));
                cultural.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {



            }
        });
    }

    private void getDequinoxImage() {
        reference.child("Dequinox").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){

                    String data = (String) snapshot.getValue();
                    imageList.add(0,data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                dequinox.setLayoutManager(new GridLayoutManager(getContext(),3));
                dequinox.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {



            }
        });
    }
}