package cn.edu.gdmec.android.zxapp.Movie.Model;

import android.util.Log;

import cn.edu.gdmec.android.zxapp.Bean.MoviesBean;
import cn.edu.gdmec.android.zxapp.Http.Api;
import cn.edu.gdmec.android.zxapp.Http.RetrofitHelper;
import cn.edu.gdmec.android.zxapp.News.Model.IOnLoadListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by apple on 18/6/5.
 */

public class MoviesModel implements IMoviesModel {

    @Override
    public void loadNews( String total, final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper= new RetrofitHelper(Api.MOVIE_HOST);
        retrofitHelper.getMovies(total).enqueue(new Callback<MoviesBean>() {
            @Override
            public void onResponse(Call<MoviesBean> call, Response<MoviesBean> response) {
                iOnLoadListener.success(response.body());
                Log.i("response", "onResponse: "+response.body());
            }

            @Override
            public void onFailure(Call<MoviesBean> call, Throwable t) {
                iOnLoadListener.fail(t);
            }
        });
    }

}
