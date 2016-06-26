package com.example.newrairai;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class OcatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ocat);
        TextView titleTextView = (TextView) findViewById(R.id.textView);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        User user = (User) getIntent().getSerializableExtra("key_user");
        if(user!=null) {
            titleTextView.setText(user.getName());
            imageView.setImageResource(user.getIcon());
        }
    }

    public void rensyu(View v){
        Uri uri = Uri.parse("https://twitter.com/intent/tweet?hashtags=OCATで練習なう");
        Intent i = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i);

    }
}
