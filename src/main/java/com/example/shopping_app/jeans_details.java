package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class jeans_details extends AppCompatActivity {
    Button btnjeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeans_details);
        btnjeans=(Button)findViewById(R.id.btn_jeans);
        btnjeans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(jeans_details.this,BuyActivity.class);
                startActivity(i);

            }
        });
    }
}
