package cn.edu.gdmec.android.zxapp.Movie.View;

import cn.edu.gdmec.android.zxapp.Bean.MoviesBean;

/**
 * Created by apple on 18/6/5.
 */


    public interface IMoviesView {
        void showNews(MoviesBean moviesBean);
        void hideDialog();
        void showDialog();
        void showErrorMsg(Throwable throwable);
    }

