package com.example.shopping_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    private EditText temail;
    private EditText tpass;
    private Button btnlogin;
    private TextView txtreg;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Login page");

        temail = (EditText) findViewById(R.id.email);
        tpass = (EditText) findViewById(R.id.pass);
        btnlogin = (Button) findViewById(R.id.login);
        txtreg = (TextView) findViewById(R.id.txt_register);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(temail.getText().toString(), tpass.getText().toString());
            }
        });

        txtreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);

            }
        });
    }

    private void validate(String useremail, String userpass) {
        progressDialog.setMessage("login Processing");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(useremail, userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    emailveri();
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    private void emailveri() {
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        Boolean emailflag = firebaseUser.isEmailVerified();

        if (emailflag) {
            Intent i = new Intent(LoginActivity.this, ShopCorner.class);
            startActivity(i);

        } else {
            Toast.makeText(LoginActivity.this, "Please verify your email-id", Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }


    }

    private Boolean Loginsetting(){
        Boolean result=false;

        String lemail=temail.getText().toString();
        String lpass=tpass.getText().toString();

        if (lemail.isEmpty() || lpass.isEmpty() ){
            Toast.makeText(LoginActivity.this, "Please enter full enteries", Toast.LENGTH_SHORT).show();
        }

        else{
            result=true;
        }


        return result;

    }



}



