package com.example.tip_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipAmt extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_amt);
        Intent intent = getIntent();
        String text = Double.toString(intent.getDoubleExtra("tipKey",0.00));
        String total = Double.toString(intent.getDoubleExtra("billKey",0.00));

        TextView tip = (TextView) findViewById(R.id.tipAmt);
        TextView bill = (TextView) findViewById(R.id.TotalAmt);
        tip.setText(String.format(" %s", text));
        bill.setText(String.format(" %s", total));



    }
}