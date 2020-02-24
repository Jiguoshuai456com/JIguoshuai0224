package com.bw.jiguoshuai0224;

public interface IHomePage {
     interface Iview{
      void onSuccess(String url);
      void onError(String url);
    }
    interface Iprencenter{
         void getBanner(String url);
    }
    interface IMoudle{
         void getBanner(String url,IBack ib);
         interface IBack{
             void onSuccess(String url);
             void onError(String url);
         }
    }

}
