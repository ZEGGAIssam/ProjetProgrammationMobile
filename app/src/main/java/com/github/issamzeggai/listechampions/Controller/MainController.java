package com.github.issamzeggai.listechampions.Controller;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.github.issamzeggai.listechampions.Modele.Champion;
import com.github.issamzeggai.listechampions.View.MainActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainController {
    public MainActivity view;
    private RestApiChampion restApiChampion;
    private SharedPreferences sharedPreferences;

    public MainController(MainActivity view, RestApiChampion restApiChampion,SharedPreferences sharedPreferences) {
        this.view = view;
        this.restApiChampion = restApiChampion;
        this.sharedPreferences = sharedPreferences;
    }
    private void storeData(List<Champion> championList) {
        Gson gson = new Gson();
        String listCharacterString = gson.toJson(championList);
        sharedPreferences
                .edit()
                .putString("cle_string", listCharacterString)
                .apply();
    }

    private List<Champion> getDataFromCache() {
        String listCharacterString = sharedPreferences.getString("cle_string", "");
        if(listCharacterString != null && !TextUtils.isEmpty(listCharacterString)){
            Type listType = new TypeToken<List<Character>>(){}.getType();
            List<Champion> championList = new Gson().fromJson(listCharacterString, listType);
            return championList;
        }
        return new ArrayList<>();
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
