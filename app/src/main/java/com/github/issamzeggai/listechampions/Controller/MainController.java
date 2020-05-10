package com.github.issamzeggai.listechampions.Controller;

import com.github.issamzeggai.listechampions.Modele.Champion;
import com.github.issamzeggai.listechampions.View.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainController {
        public MainActivity view;
        private RestApiChampion restApiChampion;

        public MainController(MainActivity view, RestApiChampion restApiChampion) {
            this.view = view;
            this.restApiChampion = restApiChampion;
        }

        public void onCreate() {
            Call<List<Champion>> call = restApiChampion.getChampiondata();
            call.enqueue(new Callback<List<Champion>>() {
                @Override
                public void onResponse(Call<List<Champion>> call, Response<List<Champion>> response) {
                    if (response.isSuccessful()) {
                        List<Champion> championList = response.body();
                        view.showList(championList);
                    }else{
                        System.out.println(response.errorBody());
                    }
                }

                @Override
                public void onFailure(Call<List<Champion>> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }