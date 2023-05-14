package com.notebook.collegeapp.ui.about;

import android.content.Intent;
import android.net.Uri;
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
    private ImageView map;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_computer,"Computer science", "The Department of Computer Science and Engineering at the Jaypee University of Engineering and Technology, Guna was formed in 2003, to address the needs of the 21st century where the boundaries between traditional science and engineering disciplines are blurring. Since its inception, the department is dedicated to education, research and overall excellence providing a superior teaching environment for its students to flourish in. The Department of Computer Science and Engineering enjoys a place of pride amongst all the Departments of the institute"));
        list.add(new BranchModel(R.drawable.ic_mechanical,"Mechanical", "The Mechanical Engineering Department has been established in session 2008-09 with an intake of thirty undergraduate students. Since then, the department has been growing continuously and presently, apart from B.Tech., it is offering M.Tech. and Ph.D. courses as well. Department is equipped with state-of-the art laboratories."));
        list.add(new BranchModel(R.drawable.ic_ec,"Electronics", "Electronics has been a major driving force in the development of modern technologies in virtually every field of engineering. Semiconductor technology has led to the development of fantastic devices like computers, mobile phones, televisions, music systems etc. Paired up with communications technology, the possibilities that arise are infinite. Considered as a core engineering field, electronics technology is the foundation for several other technologies like communications technology, computer technology, information technology etc"));
        list.add(new BranchModel(R.drawable.ic_civil,"Civil", "The Department of Civil Engineering at the Jaypee University of Engineering and Technology, Guna was formed in 2003, to address the needs of technical manpower for industry, R&D organizations and academic institutions.\n" +
                "\n" +
                "Aim of the Department is to graduate the students who are socially aware and have deep understanding of fundamental principles to solve problems and meet challenges in the Civil Engineering domain of design, construction, research and management in various disciplines. The Department also encourages its students to engage in extra-curricular and co-curricular activities, t o provide a platform in order to showcase and sharpen their technical skills, to make them confident in the field of Civil Engineering profession"));
        list.add(new BranchModel(R.drawable.ic_chemical,"Chemical", "Since its inception in 2003 , the chemical engineering department has made great strides in providing high quality education to the students enrolled in the various courses offered by the department. The department offers the following courses:\n" +
                "\n" +
                "•  Four years Bachelor of Technology (B.Tech.) degree program in Chemical Engineering.\n" +
                "\n" +
                "•  Two years Master of Technology (M.Tech.) degree program in Chemical Engineering.\n" +
                "\n" +
                "Besides the Doctor of Philosophy (Ph.D.) degree programs in Chemistry and Chemical Engineering,"));

        adapter= new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.collegeImage);

        Glide.with(getContext()).load("https://www.juet.ac.in/images/show/1.jpg").into(imageView);

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
}