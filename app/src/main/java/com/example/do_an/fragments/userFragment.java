package com.example.do_an.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.do_an.R;
import com.example.do_an.TabAdapter;
import com.google.android.material.tabs.TabLayout;



public class userFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    TabAdapter tabAdapter;

    public userFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout và lưu vào biến View
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        // Ánh xạ View
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager2 = view.findViewById(R.id.view_pager);

        // Khởi tạo adapter cho ViewPager2
        tabAdapter = new TabAdapter(requireActivity());
        viewPager2.setAdapter(tabAdapter);

        // Đồng bộ giữa TabLayout và ViewPager2
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

        // Trả về View đã inflate
        return view;
    }

}