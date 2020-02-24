package com.bw.jiguoshuai0224;

public class HomeMoudle implements IHomePage.IMoudle {
    @Override
    public void getBanner(String url, final IBack ib) {
        Netutilus.getInstance().getJson(url, new Netutilus.ICallBack() {
            @Override
            public void onSuccess(String json) {
                ib.onSuccess(json);
            }

            @Override
            public void onSuerror(String msg) {

            }
        });
    }
}
