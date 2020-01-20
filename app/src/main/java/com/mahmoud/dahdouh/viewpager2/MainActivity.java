package com.mahmoud.dahdouh.viewpager2;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ViewPager2 viewPager;
    private RecyclerAdapter adapter;
    private List<PageModel> pageModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inflate
        viewPager = findViewById(R.id.viewpager);


        // set Data
        pageModelList = new ArrayList<>();

        pageModelList.add(new PageModel(R.drawable.image_1));
        pageModelList.add(new PageModel(R.drawable.image_2));
        pageModelList.add(new PageModel(R.drawable.image_3));
        pageModelList.add(new PageModel(R.drawable.image_4));
        pageModelList.add(new PageModel(R.drawable.image_5));
        pageModelList.add(new PageModel(R.drawable.image_6));
        pageModelList.add(new PageModel(R.drawable.image_7));
        pageModelList.add(new PageModel(R.drawable.image_8));
        pageModelList.add(new PageModel(R.drawable.image_9));
        pageModelList.add(new PageModel(R.drawable.image_10));

        adapter = new RecyclerAdapter();

        adapter.setList(pageModelList);

        // set adapter to viewpager2
        viewPager.setAdapter(adapter);

        // add animation
        viewPager.setOffscreenPageLimit(3);
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        // set the PageTransformer to viewpager
        viewPager.setPageTransformer(compositePageTransformer);


    }
}
