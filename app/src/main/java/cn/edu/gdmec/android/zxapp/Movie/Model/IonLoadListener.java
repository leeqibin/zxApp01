package cn.edu.gdmec.android.zxapp.Movie.Model;

import cn.edu.gdmec.android.zxapp.Bean.MoviesBean;

/**
 * Created by apple on 18/6/5.
 */

public interface IonLoadListener {
    void success(MoviesBean moviesBean);
    void fail(Throwable throwable);
}
