package cn.edu.gdmec.android.zxapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 18/5/22.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments=new ArrayList<>();
    private List<String> fragmentTitles=new ArrayList<>();

    public MyFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }
    public MyFragmentAdapter(FragmentManager fm,List<Fragment> fragments,List<String> fragmentTitles){
        super(fm);
        this.fragments=fragments;
        this.fragmentTitles=fragmentTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (fragmentTitles!=null){
            return fragmentTitles.get(position);
        }else{
            return "";
        }

    }
}
