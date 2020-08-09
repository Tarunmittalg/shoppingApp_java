package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class joggers_details extends AppCompatActivity {
    Button btnjogeers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joggers_details);
        btnjogeers=(Button)findViewById(R.id.btn_joggers);
        btnjogeers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(joggers_details.this,BuyActivity.class);
                startActivity(i);

            }
        });
    }
}
