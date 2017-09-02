package com.example.pc.cpuscheduling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button add;
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
                if (result.equals("3")){
                    ETArrivalTime1.setVisibility(View.VISIBLE);
                    ETBurstTime1.setVisibility(View.VISIBLE);
                    ETArrivalTime2.setVisibility(View.VISIBLE);
                    ETBurstTime2.setVisibility(View.VISIBLE);
                    ETArrivalTime3.setVisibility(View.VISIBLE);
                    ETBurstTime3.setVisibility(View.VISIBLE);
                }
                else if (result.equals("4")){
                    ETArrivalTime1.setVisibility(View.VISIBLE);
                    ETBurstTime1.setVisibility(View.VISIBLE);
                    ETArrivalTime2.setVisibility(View.VISIBLE);
                    ETBurstTime2.setVisibility(View.VISIBLE);
                    ETArrivalTime3.setVisibility(View.VISIBLE);
                    ETBurstTime3.setVisibility(View.VISIBLE);
                    ETArrivalTime4.setVisibility(View.VISIBLE);
                    ETBurstTime4.setVisibility(View.VISIBLE);
                }
                else if (result.equals("5")){
                    ETArrivalTime1.setVisibility(View.VISIBLE);
                    ETBurstTime1.setVisibility(View.VISIBLE);
                    ETArrivalTime2.setVisibility(View.VISIBLE);
                    ETBurstTime2.setVisibility(View.VISIBLE);
                    ETArrivalTime3.setVisibility(View.VISIBLE);
                    ETBurstTime3.setVisibility(View.VISIBLE);
                    ETArrivalTime4.setVisibility(View.VISIBLE);
                    ETBurstTime4.setVisibility(View.VISIBLE);
                    ETArrivalTime5.setVisibility(View.VISIBLE);
                    ETBurstTime5.setVisibility(View.VISIBLE);
                }
            }
        });

    }



    private void findview() {
        spinner = (Spinner)findViewById(R.id.spinner2);

        add = (Button)findViewById(R.id.add);

        ETProcess = (EditText)findViewById(R.id.ETprocess);
        ETArrivalTime1 = (EditText)findViewById(R.id.ETArrivalTime1);
        ETArrivalTime2 = (EditText)findViewById(R.id.ETArrivalTime2);
        ETArrivalTime3 = (EditText)findViewById(R.id.ETArrivalTime3);
        ETArrivalTime4 = (EditText)findViewById(R.id.ETArrivalTime4);
        ETArrivalTime5 = (EditText)findViewById(R.id.ETArrivalTime5);
        ETBurstTime1 = (EditText)findViewById(R.id.ETBurstTime1);
        ETBurstTime2 = (EditText)findViewById(R.id.ETBurstTime2);
        ETBurstTime3 = (EditText)findViewById(R.id.ETBurstTime3);
        ETBurstTime4 = (EditText)findViewById(R.id.ETBurstTime4);
        ETBurstTime5 = (EditText)findViewById(R.id.ETBurstTime5);
    }




}
