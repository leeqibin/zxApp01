package cn.edu.gdmec.android.zxapp.Movie.Presenter;



import cn.edu.gdmec.android.zxapp.Bean.NewsBean;
import cn.edu.gdmec.android.zxapp.Movie.Model.IMoviesModel;
import cn.edu.gdmec.android.zxapp.Movie.Model.MoviesModel;
import cn.edu.gdmec.android.zxapp.Movie.View.IMoviesView;
import cn.edu.gdmec.android.zxapp.News.Model.IOnLoadListener;

/**
 * Created by apple on 18/6/5.
 */
public class MoviesPresenter implements IMoviesPresenter,IOnLoadListener {

    private IMoviesModel iMoviesModel;
    private IMoviesView iMoviesView;

    public MoviesPresenter(IMoviesView iMoviesView) {
        this.iMoviesView = iMoviesView;
        this.iMoviesModel =new MoviesModel();
    }

    @Override
    public void fail(Throwable throwable) {
        iMoviesView.hideDialog();
        iMoviesView.showErrorMsg(throwable);
    }

    @Override
    public void loadNews(String total) {
        iMoviesView.showDialog();
        iMoviesModel.loadNews(total,this);
    }

    @Override
    public void success(NewsBean newsBean) {
        iMoviesView.hideDialog();
        iMoviesView.showNews(moviesBean);
    }

}