package com.bw.jiguoshuai0224;

import android.os.Handler;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Netutilus {
    private static Netutilus netutilus=new Netutilus();

    public Netutilus() {
    }
    public static Netutilus getInstance(){
        return netutilus;
    }
    private Handler handler=new Handler();
    public interface ICallBack{
        void onSuccess(String json);
        void onSuerror(String msg);
    }
    public void getJson(final String path, final ICallBack iCallBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setReadTimeout(5000);
                    conn.setConnectTimeout(5000);
                    int responseCode = conn.getResponseCode();
                    if (responseCode==200){
                        InputStream inputStream = conn.getInputStream();
                        int len=0;
                        byte[] b = new byte[1024];
                        StringBuilder builder = new StringBuilder();
                        while ((len=inputStream.read(b))!=-1){
                            String s = new String(b, 0, len);
                            builder.append(s);
                        }
                        inputStream.close();
                        final String json = builder.toString();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                               iCallBack.onSuccess(json);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
