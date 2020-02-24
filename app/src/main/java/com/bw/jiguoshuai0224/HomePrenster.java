package com.bw.jiguoshuai0224;

public class HomePrenster implements IHomePage.Iprencenter {
    IHomePage.Iview iv;
    HomeMoudle moudle;
    public HomePrenster(IHomePage.Iview view) {
        iv=view;
        moudle=new HomeMoudle();
    }

    @Override
    public void getBanner(String url) {
        moudle.getBanner(url, new IHomePage.IMoudle.IBack() {
            @Override
            public void onSuccess(String url) {
                iv.onSuccess(url);
            }

            @Override
            public void onError(String url) {
                iv.onError(url);

            }
        });

    }
}
