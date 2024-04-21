package com.example.restaurantreview.data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConfig {

    private static final String BASE_URL = "https://restaurant-api.dicoding.dev/";

    public static ApiService getApiService() {
        // Tambahkan logging interceptor untuk melihat log request dan response
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // Buat instance OkHttpClient dengan logging interceptor
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        // Buat instance Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        // Mengembalikan instance ApiService yang dibuat oleh Retrofit
        return retrofit.create(ApiService.class);
    }
}
