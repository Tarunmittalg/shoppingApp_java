package com.example.shopping_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class ShopCorner extends AppCompatActivity {
    ImageView imageViewshirt;
    ImageView imageViewtshirt;
    ImageView imageViewjoggers;
    ImageView imageViewformals;
    ImageView imageViewshoes;
    ImageView imageViewbelts;
    ImageView imageViewwatches;
     ImageView imageViewjeans;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_corner);
        getSupportActionBar().setTitle("Shop_Corner");
        imageViewshirt=(ImageView)findViewById(R.id.shirt);
        imageViewtshirt=(ImageView)findViewById(R.id.tshirt);
        imageViewjoggers=(ImageView)findViewById(R.id.joggers);
        imageViewformals=(ImageView)findViewById(R.id.formals);
        imageViewshoes=(ImageView)findViewById(R.id.shoes);
        imageViewbelts=(ImageView)findViewById(R.id.belts);
        imageViewwatches=(ImageView)findViewById(R.id.watches);
        imageViewjeans=(ImageView)findViewById(R.id.jeans);
        imageViewshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ShopCorner.this,Shirt_details.class);
                startActivity(i);
            }
        });

        imageViewtshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ShopCorner.this,tshirt_details.class);
                startActivity(i);
            }
        });

        imageViewformals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ShopCorner.this,formals_details.class);
                startActivity(i);
            }
        });

        imageViewshoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ShopCorner.this,shoes_details.class);
                startActivity(i);
            }
        });

        imageViewbelts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ShopCorner.this,belts_details.class);
                startActivity(i);
            }
        });

        imageViewwatches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ShopCorner.this,watches_details.class);
                startActivity(i);
            }
        });

        imageViewjeans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ShopCorner.this,jeans_details.class);
                startActivity(i);
            }
        });


        firebaseAuth=FirebaseAuth.getInstance();
    }
    private void logout(){
        firebaseAuth.signOut();
        finish();
        Intent i=new Intent(ShopCorner.this,LoginActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.userProfile) {
            Intent i=new Intent(ShopCorner.this,UserProfileActivity.class);
            startActivity(i);
        }

        else if (id==R.id.logout){
            logout();

        }

        return super.onOptionsItemSelected(item);
    }
}
