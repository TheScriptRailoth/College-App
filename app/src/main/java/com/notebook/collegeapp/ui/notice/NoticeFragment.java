package com.notebook.collegeapp.ui.notice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.notebook.collegeapp.R;

import java.util.ArrayList;

public class NoticeFragment extends Fragment {

    private RecyclerView deleteNoticeRecycler;
    private ProgressBar progressBar;
    private ArrayList<NoticeData> list;
    private NoticeAdapter adapter;

    private DatabaseReference reference;
    ShimmerFrameLayout shimmerFrameLayout;


    LinearLayout shimmerLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_notice, container, false);
        deleteNoticeRecycler= view.findViewById(R.id.deleteNoticeRecycler);
        //progressBar= view.findViewById(R.id.progressBar);

        reference= FirebaseDatabase.getInstance().getReference().child("Notice");

        deleteNoticeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        deleteNoticeRecycler.setHasFixedSize(true);

        shimmerFrameLayout = view.findViewById(R.id.shimmer_view_container);

        shimmerLayout = view.findViewById(R.id.shimmerLayout);

        getNotice();

    return view;
}

    private void getNotice() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for(DataSnapshot snapshot : dataSnapshot.getChildren() ){
                    NoticeData data = snapshot.getValue(NoticeData.class);
                    list.add(0,data);
                }
                adapter = new NoticeAdapter(getContext(),list);
                adapter.notifyDataSetChanged();
                //progressBar.setVisibility(View.GONE);
                deleteNoticeRecycler.setAdapter(adapter);
                shimmerFrameLayout.stopShimmer();

                shimmerLayout.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }

    @Override
    public void onResume() {
        shimmerFrameLayout.startShimmer();
        super.onResume();
    }
}

