package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tshirt_details extends AppCompatActivity {
    Button btntshirt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tshirt_details);
        btntshirt=(Button)findViewById(R.id.btn_tshirt);
        btntshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(tshirt_details.this,BuyActivity.class);
                startActivity(i);

            }
        });
    }
}
