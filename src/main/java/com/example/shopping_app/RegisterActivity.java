package com.example.shopping_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private EditText name;
    private EditText phone;
    private EditText editemail;
    private EditText editpass;
    private EditText con;
    private Button reg;
    private FirebaseAuth firebaseAuth;
    String uname,uphone,uemail,upass,ucon;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Registration page");


        name=(EditText)findViewById(R.id.txt_name);
        phone=(EditText)findViewById(R.id.txt_phone);
        editemail=(EditText)findViewById(R.id.email);
        editpass=(EditText)findViewById(R.id.pass);
        con=(EditText)findViewById(R.id.txt_conpass);
        reg=(Button)findViewById(R.id.reg);

        firebaseAuth= FirebaseAuth.getInstance();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()) {

                    String uemail=editemail.getText().toString().trim();
                    String upass=editpass.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(uemail,upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                sendemailveri();

                            }
                            else{
                                Toast.makeText(RegisterActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });





    }
    private Boolean validate(){
        Boolean result=false;


         uname=name.getText().toString();
        uphone=phone.getText().toString();
         uemail=editemail.getText().toString();
         upass=editpass.getText().toString();
         ucon=con.getText().toString();


        if (uname.isEmpty() || uphone.isEmpty() || uemail.isEmpty() || upass.isEmpty() || ucon.isEmpty() ){
            Toast.makeText(RegisterActivity.this, "Please enter full enteries", Toast.LENGTH_SHORT).show();
        }

        else{
            result=true;
        }


        return result;

    }

    private void sendemailveri(){
        FirebaseUser firebaseUser=firebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser!=null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        sendUserdata();
                        Toast.makeText(RegisterActivity.this, "Registration successfull! Email Verification Sent and Uploading the Data", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        Intent i=new Intent(RegisterActivity.this,LoginActivity.class);
                        startActivity(i);

                    }

                }
            });



        }


    }

    private void sendUserdata(){
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference myRef=firebaseDatabase.getReference(firebaseAuth.getUid());
        UserProfile userProfile=new UserProfile(uname,uphone,uemail,upass);
        myRef.setValue(userProfile);




    }



}
