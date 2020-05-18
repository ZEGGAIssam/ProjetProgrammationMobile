package com.github.issamzeggai.listechampions;

import com.github.issamzeggai.listechampions.Controller.RestApiChampion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InjectionJSON {
    private static RestApiChampion restApiChampion;

    //Singleton
    public static RestApiChampion getRestApi(){
        if(restApiChampion == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/ZEGGAIssam/lol-champions-master/master/lol-champions-master/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            restApiChampion = retrofit.create(RestApiChampion.class);
        }
        return restApiChampion;
    }
}
