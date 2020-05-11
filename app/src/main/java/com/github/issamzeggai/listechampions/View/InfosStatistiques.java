package com.github.issamzeggai.listechampions.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.issamzeggai.listechampions.Controller.MainController;
import com.github.issamzeggai.listechampions.InjectionJSON;
import com.github.issamzeggai.listechampions.R;
import com.github.issamzeggai.listechampions.Modele.Champion;
import com.squareup.picasso.Picasso;


public class InfosStatistiques extends AppCompatActivity {

    public TextView txtHeader;
    private RecyclerView recyclerView;
    public TextView txtFooter;
    public View layout;
    public ImageView imageURL;
    private MainController controller;
    private Champion champion;
    private String championName;
    private String championDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.champion_stats);
        txtHeader = findViewById(R.id.image_description);
        txtFooter = findViewById(R.id.description);
        //txtFooter = findViewById(R.id.secondLine);
        imageURL = findViewById(R.id.image);
        Intent intent = getIntent();
        Champion champion = (Champion) intent.getSerializableExtra(this.getResources().getString(R.string.champion));

        txtHeader.setText(champion.getName());
        txtFooter.setText(String.valueOf(champion.getStats().getHp()));
        Picasso.get()
                .load(champion.getIcon())
                .fit()
                .into(imageURL);

    }

}
