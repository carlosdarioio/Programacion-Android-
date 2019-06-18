package com.example.myapptabtest2.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapptabtest2.FragmentMain;
import com.example.myapptabtest2.FragmentMain2;
import com.example.myapptabtest2.FragmentMain3;
import com.example.myapptabtest2.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        switch (position){

            case 0:
                FragmentMain xBlankFragmentx1 = new FragmentMain();
                return xBlankFragmentx1;
            case 1:
                FragmentMain2 xBlankFragmentx2 = new FragmentMain2();
                return xBlankFragmentx2;
            case 2:
                FragmentMain3 xBlankFragmentx3 = new FragmentMain3();
                return xBlankFragmentx3;
        }



        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}