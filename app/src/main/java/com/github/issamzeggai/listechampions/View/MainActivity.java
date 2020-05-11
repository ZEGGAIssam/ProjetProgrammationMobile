package com.github.issamzeggai.listechampions.View;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.github.issamzeggai.listechampions.Controller.MainController;
import com.github.issamzeggai.listechampions.InjectionJSON;
import com.github.issamzeggai.listechampions.Modele.Champion;
import com.github.issamzeggai.listechampions.R;

import java.util.List;

public class MainActivity extends Activity {
    private List<Champion> championList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MainController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        //Instanciation de recyclerView
        recyclerView = (RecyclerView) findViewById( R.id.my_recycler_view );
        SharedPreferences sharedPreferences = this.getSharedPreferences( "user_prefs", Context.MODE_PRIVATE );
        controller = new MainController( this, Injection.getRestApi(), sharedPreferences );
        controller.onCreate();
    }

    public void showList(List<Champion> championList) {
        // use this setting to
        // improve performance if you know that changes
        // in content do not change the layout size
        // of the RecyclerView
        recyclerView.setHasFixedSize( true );
        // use a linear layout manager
        //Instanciation de layoutManager
        layoutManager = new LinearLayoutManager( this );
        recyclerView.setLayoutManager( layoutManager );
        // define an adapter
        //Instanciation de mAdapter
        mAdapter = new MyAdapter( championList, this );
        recyclerView.setAdapter( mAdapter );
    }

}