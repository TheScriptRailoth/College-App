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
import android.widget.LinearLayout;

import com.facebook.shimmer.ShimmerFrameLayout;
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
    ShimmerFrameLayout shimmerFrameLayout,shimmerFrameLayout1,shimmerFrameLayout2;


    LinearLayout shimmerLayout,shimmerLayout1,shimmerLayout2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);
        dequinox = view.findViewById(R.id.dequinox);
        cultural = view.findViewById(R.id.cultural);
        others = view.findViewById(R.id.others);
        
        reference = FirebaseDatabase.getInstance().getReference().child("gallery");
        shimmerFrameLayout = view.findViewById(R.id.shimmer_view_container);

        shimmerLayout = view.findViewById(R.id.shimmerLayout);
        shimmerFrameLayout1 = view.findViewById(R.id.shimmer_view_container1);

        shimmerLayout1 = view.findViewById(R.id.shimmerLayout1);
        shimmerFrameLayout2 = view.findViewById(R.id.shimmer_view_container2);

        shimmerLayout2 = view.findViewById(R.id.shimmerLayout2);
        
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
                shimmerFrameLayout2.stopShimmer();

                shimmerLayout2.setVisibility(View.GONE);
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
                shimmerFrameLayout1.stopShimmer();

                shimmerLayout1.setVisibility(View.GONE);
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
                shimmerFrameLayout.stopShimmer();

                shimmerLayout.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {



            }
        });
    }
}