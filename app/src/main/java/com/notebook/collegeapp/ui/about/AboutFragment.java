package com.notebook.collegeapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.notebook.collegeapp.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_computer,"Computer science", "sadyfyue efy8eyf 8fysuidyfuiueyi dfhuhf djfheu ejdjhe"));
        list.add(new BranchModel(R.drawable.ic_mechanical,"Mechanical", "sadyfyue efy8eyf 8fysuidyfuiueyi dfhuhf djfheu ejdjhe"));
        list.add(new BranchModel(R.drawable.ic_ec,"Electronics", "sadyfyue efy8eyf 8fysuidyfuiueyi dfhuhf djfheu ejdjhe"));
        list.add(new BranchModel(R.drawable.ic_civil,"Civil", "sadyfyue efy8eyf 8fysuidyfuiueyi dfhuhf djfheu ejdjhe"));
        list.add(new BranchModel(R.drawable.ic_chemical,"Chemical", "sadyfyue efy8eyf 8fysuidyfuiueyi dfhuhf djfheu ejdjhe"));

        adapter= new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.collegeImage);

        Glide.with(getContext()).load("https://www.juet.ac.in/images/show/1.jpg").into(imageView);

        return view;

    }
}