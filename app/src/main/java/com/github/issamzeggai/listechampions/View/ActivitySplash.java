package com.github.issamzeggai.listechampions.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.issamzeggai.listechampions.R;

public class ActivitySplash extends Activity {
    Button buttonstart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.activity_splash);
        buttonstart =(Button)findViewById( R.id.buttonstart );

        buttonstart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startApplication();
            }
        });
    }
    public void startApplication(){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }
}

