package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class shoes_details extends AppCompatActivity {
    Button btnshoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes_details);

        btnshoes=(Button)findViewById(R.id.btn_shoes);
        btnshoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(shoes_details.this,BuyActivity.class);
                startActivity(i);

            }
        });
    }
}
