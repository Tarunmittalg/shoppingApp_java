package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class belts_details extends AppCompatActivity {
    Button btnbelt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belts_details);

        btnbelt=(Button)findViewById(R.id.btn_belt);
        btnbelt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(belts_details.this,BuyActivity.class);
                startActivity(i);

            }
        });
    }
}
