package com.rantas.bankfinalproject.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.rantas.bankfinalproject.fragments.FirstFragment;
import com.rantas.bankfinalproject.fragments.SecondFragment;
import com.rantas.bankfinalproject.fragments.ThirdFragment;

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
                break;
            case 2:
                fragment = new ThirdFragment();
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
            case 2:
                return "Admin Área";
        }
        return null;

    }

    @Override
    public int getCount() {
        return 3;
    }
}
