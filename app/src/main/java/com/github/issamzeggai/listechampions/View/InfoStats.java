package com.github.issamzeggai.listechampions.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.issamzeggai.listechampions.Controller.MainController;
import com.github.issamzeggai.listechampions.Modele.Champion;
import com.github.issamzeggai.listechampions.R;
import com.squareup.picasso.Picasso;

public class InfoStats extends AppCompatActivity {
        public TextView txtHeader;
        private RecyclerView recyclerView;
        public TextView txtFooter;
        public TextView txtDescription;
        public TextView txtHp;
        public TextView txtMp;
        public TextView txtMoveSpeed;
        public TextView armor;
        public TextView attackDamage;
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
            //txtHeader = findViewById(R.id.image_description);
            txtFooter = findViewById(R.id.title);
            txtDescription = findViewById(R.id.description);
            txtHp = findViewById(R.id.hp);
            txtMp = findViewById(R.id.mp);
            txtMoveSpeed = findViewById(R.id.movespeed);
            armor = findViewById(R.id.armor);
            attackDamage = findViewById(R.id.attackdamage);

            //txtFooter = findViewById(R.id.secondLine);
            imageURL = findViewById(R.id.image);
            Intent intent = getIntent();
            Champion champion = (Champion) intent.getSerializableExtra(this.getResources().getString(R.string.champion));

            //  txtHeader.setText(champion.getName());
            txtFooter.setText("Title : " + champion.getTitle());
            txtDescription.setText("Description : " + champion.getDescription());
            txtHp.setText(String.valueOf(champion.getStats().getHp()));
            txtMp.setText(String.valueOf(champion.getStats().getMp()));
            txtMoveSpeed.setText(String.valueOf(champion.getStats().getMovespeed()));
            armor.setText(String.valueOf(champion.getStats().getArmor()));
            attackDamage.setText(String.valueOf(champion.getStats().getAttackdamage()));
            // txtFooter.setText(String.valueOf(champion.getStats().getHp()));
            Picasso.get()
                    .load(champion.getIcon())
                    //.fit()
                    .into(imageURL);

        }

    }