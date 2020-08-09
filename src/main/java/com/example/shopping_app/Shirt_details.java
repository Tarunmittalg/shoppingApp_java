package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Shirt_details extends AppCompatActivity {
    Button btnshirt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirt_details);

        btnshirt=(Button)findViewById(R.id.btn_shirt);
        btnshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Shirt_details.this,BuyActivity.class);
                startActivity(i);

            }
        });
    }
}
