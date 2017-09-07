package com.example.pc.cpuscheduling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    private Button add;
    private Button compute;

    private EditText ETProcess;
    private EditText ETArrivalTime1;
    private EditText ETArrivalTime2;
    private EditText ETArrivalTime3;
    private EditText ETArrivalTime4;
    private EditText ETArrivalTime5;
    private EditText ETBurstTime1;
    private EditText ETBurstTime2;
    private EditText ETBurstTime3;
    private EditText ETBurstTime4;
    private EditText ETBurstTime5;

    private TextView results;
    private TextView result1;

    int at=5;
    int BT1,BT2,BT3,BT4,BT5;
    int awt,atat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findview();

        ArrayList<String> list = new ArrayList<String>();
        list.add("FCFS");
        list.add("SJF");
        list.add("SRT");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);

        spinner.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = ETProcess.getText().toString();
                if (result.equals("3")) {
                    ETBurstTime1.setVisibility(View.VISIBLE);
                    ETBurstTime2.setVisibility(View.VISIBLE);
                    ETBurstTime3.setVisibility(View.VISIBLE);
                    compute.setVisibility(View.VISIBLE);
                } else if (result.equals("4")) {
                    ETBurstTime1.setVisibility(View.VISIBLE);
                    ETBurstTime2.setVisibility(View.VISIBLE);
                    ETBurstTime3.setVisibility(View.VISIBLE);
                    ETBurstTime4.setVisibility(View.VISIBLE);
                    compute.setVisibility(View.VISIBLE);
                } else if (result.equals("5")) {
                    ETBurstTime1.setVisibility(View.VISIBLE);
                    ETBurstTime2.setVisibility(View.VISIBLE);
                    ETBurstTime3.setVisibility(View.VISIBLE);
                    ETBurstTime4.setVisibility(View.VISIBLE);
                    ETBurstTime5.setVisibility(View.VISIBLE);
                    compute.setVisibility(View.VISIBLE);
                }
            }
        });

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ETProcess.equals("3")) {
                    int Burst1 = Integer.parseInt(ETBurstTime1.getText().toString());
                    int Burst2 = Integer.parseInt(ETBurstTime2.getText().toString());
                    int Burst3 = Integer.parseInt(ETBurstTime3.getText().toString());
                    BT1=Burst1+at;
                    BT2=Burst2+BT1;
                    BT3=Burst3+BT2;
                    awt=(at+BT1+BT2)/3-at;
                    results.setText(awt);
                    atat= (BT1+BT2+BT3)/3-at;
                    result1.setText(atat);
                }
                else if (ETProcess.equals("4")) {
                    int Burst1 = Integer.parseInt(ETBurstTime1.getText().toString());
                    int Burst2 = Integer.parseInt(ETBurstTime2.getText().toString());
                    int Burst3 = Integer.parseInt(ETBurstTime3.getText().toString());
                    int Burst4 = Integer.parseInt(ETBurstTime4.getText().toString());
                    BT1=Burst1+at;
                    BT2=Burst2+BT1;
                    BT3=Burst3+BT2;
                    BT4=Burst4+BT3;
                    awt=(at+BT1+BT2+BT3)/4-at;
                    results.setText(awt);
                    atat= (BT1+BT2+BT3+BT4)/4-at;
                    result1.setText(atat);
                }
                else if (ETProcess.equals("5")) {
                    int Burst1 = Integer.parseInt(ETBurstTime1.getText().toString());
                    int Burst2 = Integer.parseInt(ETBurstTime2.getText().toString());
                    int Burst3 = Integer.parseInt(ETBurstTime3.getText().toString());
                    int Burst4 = Integer.parseInt(ETBurstTime4.getText().toString());
                    int Burst5 = Integer.parseInt(ETBurstTime5.getText().toString());
                    BT1=Burst1+at;
                    BT2=Burst2+BT1;
                    BT3=Burst3+BT2;
                    BT4=Burst4+BT3;
                    BT5=Burst5+BT3;
                    awt=(at+BT1+BT2+BT3+BT4)/5-at;
                    results.setText(awt);
                    atat= (BT1+BT2+BT3+BT4+BT5)/5-at;
                    result1.setText(atat);
                }
                }
        });

    }


    private void findview() {
        spinner = (Spinner) findViewById(R.id.spinner2);

        add = (Button) findViewById(R.id.add);
        compute = (Button) findViewById(R.id.compute);

        ETProcess = (EditText) findViewById(R.id.ETprocess);
        ETBurstTime1 = (EditText) findViewById(R.id.ETBurstTime1);
        ETBurstTime2 = (EditText) findViewById(R.id.ETBurstTime2);
        ETBurstTime3 = (EditText) findViewById(R.id.ETBurstTime3);
        ETBurstTime4 = (EditText) findViewById(R.id.ETBurstTime4);
        ETBurstTime5 = (EditText) findViewById(R.id.ETBurstTime5);

        results = (TextView) findViewById(R.id.textView);
        result1 = (TextView)findViewById(R.id.textView3);
    }





}
