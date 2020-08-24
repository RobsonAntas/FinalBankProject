package com.rantas.bankfinalproject.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.rantas.bankfinalproject.fragments.FirstFragment;
import com.rantas.bankfinalproject.fragments.SecondFragment;

public class PageAdapter extends FragmentPagerAdapter {

    private Context context;
    public PageAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm);
        this.context =context;

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new FirstFragment();
                break;
            case 1:
                fragment = new SecondFragment();

        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Menu Opções";
            case 1:
                return "Dados Cadastrais";
        }
        return null;

    }

    @Override
    public int getCount() {
        return 2;
    }
}
