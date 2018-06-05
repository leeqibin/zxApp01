package cn.edu.gdmec.android.zxapp.Movie.Model;

import cn.edu.gdmec.android.zxapp.News.Model.IOnLoadListener;

/**
 * Created by apple on 18/6/5.
 */

public interface IMoviesModel {
    void loadNews(String total, IOnLoadListener iOnLoadListener);
}
