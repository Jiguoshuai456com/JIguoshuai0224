package com.bw.jiguoshuai0224;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IHomePage.Iview {

    private HomePrenster prenster;
    private XBanner xb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prenster = new HomePrenster(this);
        String url="http://mobile.bwstudent.com/small/commodity/v1/bannerShow";
        prenster.getBanner(url);
        xb = findViewById(R.id.xb);
    }

    @Override
    public void onSuccess(String url) {
        Log.i("xxx",url);
        Gson gson = new Gson();
        Bean bean = gson.fromJson(url, Bean.class);
        final List<Bean.ResultBean> result = bean.getResult();
        xb.setBannerData(result);
        xb.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Bean.ResultBean resultBean = result.get(position);
                String imageUrl = resultBean.getImageUrl();
                Glide.with(MainActivity.this).load(imageUrl).into((ImageView) view);
            }
        });



    }

    @Override
    public void onError(String url) {

    }
}
