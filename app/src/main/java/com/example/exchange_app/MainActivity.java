package com.example.exchange_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button exchange_button;
    TextView first_textview,second_textview;
    EditText ammount_Edittext;
    Spinner spinner_currency;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    exchange_button=findViewById(R.id.exchangebtn);
    first_textview=findViewById(R.id.firsttextview);
    second_textview=findViewById(R.id.secondtextview);
    ammount_Edittext=findViewById(R.id.ammounttext);
    spinner_currency=findViewById(R.id.spinner);

    String[] from={"USD","EURO","MAD"};
    ArrayAdapter adapter=new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
    spinner_currency.setAdapter(adapter);



    exchange_button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            double total1;
            double total2;
            double ammount=Double.parseDouble(ammount_Edittext.getText().toString());
            if(spinner_currency.getSelectedItem().toString()=="USD"){
                total1=ammount * 10.46;
                total2=ammount * 0.95;
                first_textview.setText(total1+"MAD");
                second_textview.setText(total2+"EURO");
            }else if(spinner_currency.getSelectedItem().toString()=="MAD"){
                total1=ammount * 0.096;
                total2=ammount * 0.091;
                first_textview.setText(total1+"USD");
                second_textview.setText(total2+"EURO");
            }else{
                total1=ammount * 1.05;
                total2=ammount * 11.02;
                first_textview.setText(total1+"USD");
                second_textview.setText(total2+"MAD");
            }

        }
    });

    }
}