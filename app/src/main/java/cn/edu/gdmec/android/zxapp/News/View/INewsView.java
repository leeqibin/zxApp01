package cn.edu.gdmec.android.zxapp.News.View;

import cn.edu.gdmec.android.zxapp.Bean.NewsBean;

/**
 * Created by apple on 18/5/29.
 */





public interface INewsView {
    void showNews(NewsBean newsBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(String error);
}