package com.qlzgzg.network;

import com.qingmang.baselibrary.utils.LogManager;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by qlzg-cmy on 2017/5/5.
 */

public class LogIntercepter implements Interceptor {
    public static String TAG = "LogInterceptor";

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startTime = System.currentTimeMillis();
        okhttp3.Response response = chain.proceed(chain.request());
        long endTime = System.currentTimeMillis();
        long duration=endTime-startTime;
        okhttp3.MediaType mediaType = response.body().contentType();
        String content = response.body().string();
        LogManager.i(TAG,"\n");
        LogManager.i(TAG,"----------Start----------------");
        LogManager.i(TAG, "| "+request.toString());
        String method=request.method();
        if("POST".equals(method)){

            if (request.body() instanceof FormBody) {

                requestBody(request.body());

            }else if(request.body() instanceof MultipartBody){
                MultipartBody multipartBody = (MultipartBody) request.body();
                for (MultipartBody.Part part:multipartBody.parts()) {
                     LogManager.i("part"+part.toString());

                }
            }

        }
        LogManager.i(TAG, "| Response:" + content);
        LogManager.i(TAG,"----------End:"+duration+"毫秒----------");
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();

    }



    private void requestBody(RequestBody requestBody){
        StringBuilder sb = new StringBuilder();
        FormBody body = (FormBody) requestBody;
        for (int i = 0; i < body.size(); i++) {
            sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",");
        }
        sb.delete(sb.length() - 1, sb.length());
        LogManager.i(TAG, "| RequestParams:{"+sb.toString()+"}");
    }
}
