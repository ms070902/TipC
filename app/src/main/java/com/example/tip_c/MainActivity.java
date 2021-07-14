package com.example.tip_c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textView;
    private ProgressBar progressBar;
    private Button calculateBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.TipLabel);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        progressBar = (ProgressBar)  findViewById(R.id.seekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
                textView.setText(""+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        calculateBtn = findViewById(R.id.calculateBtn);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billingStatus(v);
            }
        });

    }
    public void billingStatus(View v) {
        EditText baseAmt = (EditText) findViewById(R.id.baseAmt);

        double base = Double.parseDouble(baseAmt.getText().toString());
        double tipPercentage = Double.parseDouble(textView.getText().toString());
        double tip = (base*tipPercentage)/100;
        double Bill = base+tip;
        Intent intent = new Intent(MainActivity.this,TipAmt.class);
        intent.putExtra("tipKey",tip);
        intent.putExtra("billKey",Bill);
        startActivity(intent);
    }
}