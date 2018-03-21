package com.qlzgzg.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by qlzg-cmy on 2017/5/5.
 */

public class BaseHttpHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
                .addHeader("token", "d19fe3f49b8f4a9a8829acf80f5c5407")
                .method(original.method(), original.body())
                .build();
        return chain.proceed(request);

    }


}
