package com.example.myappvolley.ui.main2.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.myappvolley.R;
import com.example.myappvolley.main7tab1;
import com.example.myappvolley.main7tab2;
import com.example.myappvolley.main7tab3;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {


    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tabyframes_text_1, R.string.tabyframes_text_2, R.string.tabyframes_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //PONER FRAGMESNT EHER
        switch (position){

            case 0:
                main7tab1 xBlankFragmentx1 = new main7tab1();
                return xBlankFragmentx1;
            case 1:
                main7tab2 xBlankFragmentx2 = new main7tab2();
                return xBlankFragmentx2;
            case 2:
                main7tab3 xBlankFragmentx3 = new main7tab3();
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
        // Show 3 total pages.
        return 3;
    }
}