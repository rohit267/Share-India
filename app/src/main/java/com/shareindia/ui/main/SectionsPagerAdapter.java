package com.shareindia.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.shareindia.AppsFragment;
import com.shareindia.ImagesFragment;
import com.shareindia.R;
import com.shareindia.ui.FilesFragment;
import com.shareindia.ui.VideoFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3,R.string.tab_text_4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment mFragment=null;
        switch (position){
            case 0:
                mFragment = new AppsFragment();
                break;
            case 1:
                mFragment = new ImagesFragment();
                break;
            case 2:
                mFragment =  new VideoFragment();
                break;
            case 3:
                mFragment = new FilesFragment();
        }
        return  mFragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 4;
    }
}