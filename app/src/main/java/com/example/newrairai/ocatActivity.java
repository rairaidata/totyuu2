package com.example.newrairai;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ocatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocat);
    }


    public void rensyu(View v){
        Uri uri = Uri.parse("https://twitter.com/intent/tweet?hashtags=OCATで練習なう");
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);

    }
}
