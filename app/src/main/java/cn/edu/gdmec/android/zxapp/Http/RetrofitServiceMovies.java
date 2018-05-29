package cn.edu.gdmec.android.zxapp.Http;

import cn.edu.gdmec.android.zxapp.Bean.MoviesBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by apple on 18/5/29.
 */

public interface RetrofitServiceMovies {
    @GET("v2/{movie}/{type}")
    Call<MoviesBean> getMovies(@Path("movie") String movie,
                               @Path("type") String type);
}