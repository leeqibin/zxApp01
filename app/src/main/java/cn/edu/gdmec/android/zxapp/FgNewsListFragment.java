package cn.edu.gdmec.android.zxapp;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;

public class FgNewsListFragment extends Fragment  {


    private TextView tvNews;
    private int type;

    public static FgNewsListFragment newsListFragment(int type){
        Bundle args=new Bundle();
        FgNewsListFragment fragment=new FgNewsListFragment();
        args.putInt("type",type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_news_list, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvNews = (TextView) view.findViewById(R.id.tv_news);
        type=getArguments().getInt("type");

        switch (type){
            case FgNewsFragment.NEW_TYPE_TOP:
                tvNews.setText("top");
                break;
                case FgNewsFragment.NEW_TYPE_JOKES:
                    tvNews.setText("nba");
                    break;
                    case FgNewsFragment.NEW_TYPE_NAB:
                        tvNews.setText("joke");
                        break;
        }
    }



}
