package com.example.minitwitter.retrofit;

import com.example.minitwitter.common.Constantes;
import com.example.minitwitter.common.SharedPreferencesManager;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        String token = SharedPreferencesManager.getSomeStringValue(Constantes.PREF_TOKEN);
        Request request = chain
                .request()
                .newBuilder()
                .addHeader("Content-Type","application/json")
                .addHeader("Accept","application/json")
                .addHeader("Authorization", "Bearer "+token)
                .build();

        return chain.proceed(request);

    }
}
