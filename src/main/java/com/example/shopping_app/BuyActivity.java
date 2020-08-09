package com.example.shopping_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BuyActivity extends AppCompatActivity {
    EditText personname;
    EditText personeamil;
    Spinner spinneritems;
    EditText code;
    Spinner payment;
    Button order;
    String paymentsselect;
    private FirebaseAuth firebaseAuth;
    String[] items={"NO. OF ITEMS","1","2","3","4","5","6","7","8","9","10"};

    String[] paymentmethod={"Select Payment Method","Cash on Delivery","Credit card/Debit card"};

    private View.OnClickListener myclick=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (paymentsselect=="Cash on Delivery"){
                Toast.makeText(BuyActivity.this, "You have Selected the COD", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(BuyActivity.this,ShopCorner.class);
                startActivity(i);
            }
            else if (paymentsselect=="Credit card/Debit card"){
                Toast.makeText(BuyActivity.this, "Online Payment Is not Available at this moment", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(BuyActivity.this, "Please select the payment method first", Toast.LENGTH_SHORT).show();
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        firebaseAuth=FirebaseAuth.getInstance();

        personname=(EditText)findViewById(R.id.buyname);
        personeamil=(EditText)findViewById(R.id.buyeamil);
        spinneritems=(Spinner)findViewById(R.id.itemsspinner);
        code=(EditText)findViewById(R.id.buycode);
        payment=(Spinner)findViewById(R.id.paymentspinner);
        order=(Button)findViewById(R.id.order);

        FirebaseUser user=firebaseAuth.getCurrentUser();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>( this,
                android.R.layout.simple_spinner_item,paymentmethod);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        payment.setAdapter(adapter);


        payment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                paymentsselect=paymentmethod[position];
                Toast.makeText(BuyActivity.this, "you are selected::"+ paymentsselect, Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(BuyActivity.this, "no payment method is selected", Toast.LENGTH_SHORT).show();

            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (epmtyvalue()){
                   if (payment.getSelectedItem().equals("Cash on Delivery")) {
                       Toast.makeText(BuyActivity.this, "you have selected the COD", Toast.LENGTH_SHORT).show();
                       Intent i = new Intent(BuyActivity.this, ShopCorner.class);
                       startActivity(i);
                   } else if (payment.getSelectedItem().equals("Credit card/Debit card")) {
                       Toast.makeText(BuyActivity.this, "Not available at this moment", Toast.LENGTH_SHORT).show();
                   } else {
                       Toast.makeText(BuyActivity.this, "no payment method is selected", Toast.LENGTH_SHORT).show();

                   }

               }

                else {

                }

            }
        });




       ArrayAdapter<String> adapter1 = new ArrayAdapter<String>( this,
                android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinneritems.setAdapter(adapter1);






    }


    private Boolean epmtyvalue(){
        Boolean result=false;


        String bname=personname.getText().toString();
        String bemail=personeamil.getText().toString();
        String bcode=code.getText().toString();

        if(bname.isEmpty() || bemail.isEmpty() || bcode.isEmpty()){
            Toast.makeText(this, "Please enter full enteries", Toast.LENGTH_SHORT).show(); }
        else{
            result=true;
            }
        return result;



    }

    






}
