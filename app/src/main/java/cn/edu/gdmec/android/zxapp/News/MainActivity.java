package cn.edu.gdmec.android.zxapp.News;



import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;


import java.util.ArrayList;

import cn.edu.gdmec.android.zxapp.FgNewsFragment;
import cn.edu.gdmec.android.zxapp.Movie.FgMovieFragment;
import cn.edu.gdmec.android.zxapp.News.Video.FgVideoFragment;
import cn.edu.gdmec.android.zxapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener{


    private View view_status;
    private ImageView iv_title_movies;
    private ImageView iv_title_news;
    private ImageView iv_title_video;
    private ViewPager vp_content;
    private Toolbar toolbars;

    private void initView(){
        view_status = findViewById(R.id.view_status);
        iv_title_movies = (ImageView) findViewById(R.id.iv_title_movie);
        iv_title_news = (ImageView) findViewById(R.id.iv_title_news);
        iv_title_video = (ImageView) findViewById(R.id.iv_title_video);
        vp_content = (ViewPager) findViewById(R.id.vp_content);
        toolbars = (Toolbar) findViewById(R.id.toolbars);
        initContentFragment();
        iv_title_movies.setOnClickListener(this);
        iv_title_news.setOnClickListener(this);
        iv_title_video.setOnClickListener(this);

    }
    private void setCurrentItem(int i){

        vp_content.setCurrentItem(i);
        iv_title_video.setSelected(false);
        iv_title_news.setSelected(false);
        iv_title_movies.setSelected(false);

        switch (i){
            case 0:
                iv_title_news.setSelected(true);
                break;
            case 1:
                iv_title_movies.setSelected(true);
                break;
            case 2:
                iv_title_video.setSelected(true);
                break;
        }

    }

    private void initContentFragment(){
        ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
        fragmentArrayList.add(new FgMovieFragment());
        fragmentArrayList.add(new FgNewsFragment());
        fragmentArrayList.add(new FgVideoFragment());

        MyFragmentAdapter adapter=new MyFragmentAdapter(getSupportFragmentManager(),fragmentArrayList);
        vp_content.setAdapter(adapter);
        vp_content.setOffscreenPageLimit(2);
        vp_content.addOnPageChangeListener(this);

        setSupportActionBar(toolbars);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayShowTitleEnabled(false);
        }
        setCurrentItem(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(Color.parseColor("#ffce3d3a"));
        }
        initView();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.iv_title_news:
                if (vp_content.getCurrentItem()!=0){
                    setCurrentItem(0);
                }
                break;
            case R.id.iv_title_movie:
                if (vp_content.getCurrentItem()!=1){
                    setCurrentItem(1);
                }
                break;
            case R.id.iv_title_video:
                if (vp_content.getCurrentItem()!=2){
                    setCurrentItem(2);
                }
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


    }

    @Override
    public void onPageSelected(int position) {
        setCurrentItem(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
