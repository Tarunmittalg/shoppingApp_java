package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class formals_details extends AppCompatActivity {
    Button btnformal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formals_details);
        btnformal=(Button)findViewById(R.id.btn_formals);
        btnformal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(formals_details.this,BuyActivity.class);
                startActivity(i);

            }
        });
    }
}
