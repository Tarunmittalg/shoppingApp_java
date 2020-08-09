package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class watches_details extends AppCompatActivity {
    Button btnwatches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watches_details);

        btnwatches=(Button)findViewById(R.id.btn_watches);
        btnwatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(watches_details.this,BuyActivity.class);
                startActivity(i);

            }
        });
    }
}
