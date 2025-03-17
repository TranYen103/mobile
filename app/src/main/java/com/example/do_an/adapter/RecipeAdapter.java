package com.example.do_an.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.do_an.fragments.IngredientFragment;
import com.example.do_an.fragments.StepFragment;

public class RecipeAdapter extends FragmentStateAdapter {

    public RecipeAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new IngredientFragment();
            case 1:
                return new StepFragment();
            default:
                return new IngredientFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
