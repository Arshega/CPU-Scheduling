package com.example.pc.cpuscheduling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    private Button add;
    private Button showValues;
    private Button compute;

    private EditText editTime;
    private EditText editBurst;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;

    ArrayList<Integer> Arrival = new ArrayList<>();
    ArrayList<Integer> Burst = new ArrayList<>();




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
                Arrival.add(Integer.parseInt(editTime.getText().toString()));
                Burst.add(Integer.parseInt(editBurst.getText().toString()));
                editBurst.setText("");
                editTime.setText("");
            }
        });

        showValues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < Arrival.size(); i++) {
                    textView2.setText(textView2.getText() + " " + Arrival.get(i) + "  \n");
                }
                for (int i = 0; i < Burst.size(); i++) {
                    textView1.setText(textView1.getText() + " " + Burst.get(i) + " \n");
                }
            }
        });

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int size = Arrival.size();
                int[] wt = new int[size];
                int[] tat = new int[size];
                float awt = 0;
                wt[0] = 0;
                for (int i = 1; i < size; i++) {
                    wt[i] = wt[i - 1] + Burst.get(i - 1);
                    wt[i] = wt[i] - Arrival.get(i);
                }
                for (int i = 0; i < size; i++) {
                    tat[i] = wt[i] + Burst.get(i);
                    awt = awt + wt[i];
                }
                awt = awt / size;
                textView3.setText(String.valueOf(awt));
            }
        });
    }

    private void findview() {
        spinner = (Spinner) findViewById(R.id.spinner2);

        add = (Button) findViewById(R.id.add);
        showValues = (Button) findViewById(R.id.showValues);
        compute = (Button) findViewById(R.id.compute);


        editTime = (EditText) findViewById(R.id.editTime);
        editBurst = (EditText) findViewById(R.id.editBurst);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
    }





}
