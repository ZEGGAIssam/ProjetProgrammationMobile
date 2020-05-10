package com.github.issamzeggai.listechampions.Controller;

import com.github.issamzeggai.listechampions.Modele.Champion;
import com.github.issamzeggai.listechampions.Modele.RestChampionResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiChampion {

    @GET("champions.json")
    Call<List<Champion>> getChampiondata();

}
