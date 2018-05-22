package cn.edu.gdmec.android.zxapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class FgNewsFragment extends Fragment  {

    public static final int NEW_TYPE_TOP=0;
    public static final int NEW_TYPE_NAB=1;
    public static final int NEW_TYPE_JOKES=3;

    private List<Fragment> fragments=new ArrayList<>();
    private List<String> fragmentTitle=new ArrayList<>();
    private TabLayout tl_news;
    private ViewPager vp_news;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_news, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tl_news=(TabLayout)view.findViewById(R.id.tl_news);
        vp_news=(ViewPager)view.findViewById(R.id.vp_news);
        setViewPager();
        vp_news.setOffscreenPageLimit(2);
        tl_news.setupWithViewPager(vp_news);

    }

    private void setViewPager() {
        fragments.add(FgNewsListFragment.newsListFragment(NEW_TYPE_TOP));
        fragments.add(FgNewsListFragment.newsListFragment(NEW_TYPE_NAB));
        fragments.add(FgNewsListFragment.newsListFragment(NEW_TYPE_JOKES));

        fragmentTitle.add("头条");
        fragmentTitle.add("NBA");
        fragmentTitle.add("笑话");

        MyFragmentAdapter adapter=new MyFragmentAdapter(getChildFragmentManager(),fragments,fragmentTitle);
        vp_news.setAdapter(adapter);

    }

}
