package cn.edu.gdmec.android.zxapp.News.Model;

/**
 * Created by apple on 18/5/29.
 */


import cn.edu.gdmec.android.zxapp.Bean.NewsBean;
import cn.edu.gdmec.android.zxapp.Http.Api;
import cn.edu.gdmec.android.zxapp.Http.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class NewsModel implements INewsModel
{
    @Override
    public void loadNews(final String hostType, final int startPage, final String id, final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper=new RetrofitHelper(Api.NEWS_HOST);
        retrofitHelper.getNews(hostType,id,startPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<NewsBean>(){
                   @Override
                    public void onCompleted(){

                   }
                    @Override
                    public void onError(Throwable e) {
                        iOnLoadListener.fail(e.getMessage());
                    }
                   @Override
                    public void onNext(NewsBean newsBean){
                        iOnLoadListener.success(newsBean);
                   }

                });
    }
}