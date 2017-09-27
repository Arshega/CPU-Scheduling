package com.example.pc.cpuscheduling;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button add;
    private Button showValues;
    private Button compute;

    private RadioGroup radioGroup;
    private RadioButton rdFcfs;
    private RadioButton rdSJF;
    private RadioButton rdRR;

    private EditText editTime;
    private EditText editBurst;
    private EditText editQuantum;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView5;
    private TextView textView9;
    private TextView textView7;
    private TextView textView8;
    private TextView textView11;
    private TextView textView10;
    private TextView textView12;


    ArrayList<Integer> Arrival = new ArrayList<>();
    ArrayList<Integer> Burst = new ArrayList<>();
    ArrayList<Integer> rr = new ArrayList<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findview();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                rr.add(Integer.parseInt(editQuantum.getText().toString()));
                Arrival.add(Integer.parseInt(editTime.getText().toString()));
                Burst.add(Integer.parseInt(editBurst.getText().toString()));
                editBurst.setText("");
                editTime.setText("");
//                editQuantum.setText("");
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
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                    int pos, pos1;
                    pos=radioGroup.indexOfChild(findViewById(i));
                    pos1=radioGroup.indexOfChild(findViewById(radioGroup.getCheckedRadioButtonId()));
                    switch (pos) {
                        case 0:
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
                            break;
                        case 1:
                            compute.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    int size = Arrival.size();
                                    int pos, temp, total = 0, i = 0, j;
                                    int[] wt = new int[size];
                                    int[] tat = new int[size];
                                    float awt = 0, waitAvg, tatAvg;

                                    for (i = 0; i < size; i++) {
                                        Arrival.set(i, i + 1);
                                    }


                                    for (i = 0; i < size; i++) {
                                        pos = i;
                                        for (j = i + 1; j < size; j++) {
                                            if (Burst.get(j) < Burst.get(pos))
                                                pos = j;
                                        }

                                        temp = Burst.get(i);
                                        Burst.set(i, Burst.get(pos));
                                        Burst.set(pos, temp);

                                        temp = Arrival.get(i);
                                        Arrival.set(i, Arrival.get(pos));
                                        Arrival.set(pos, temp);
                                    }


                                    wt[0] = 0;
                                    for (i = 1; i < size; i++) {
                                        wt[i] = 0;
                                        for (j = 0; j < i; j++)
                                            wt[i] += Burst.get(j);

                                        total += wt[i];
                                    }

                                    waitAvg = (float) total / size;
                                    total = 0;
                                    for (i = 0; i < size; i++) {
                                        tat[i] = Burst.get(i) + wt[i];
                                        total += tat[i];
                                    }
                                    tatAvg = (float) total / size;
                                    textView3.setText(String.valueOf(waitAvg));
                                    textView9.setVisibility(View.VISIBLE);
                                    textView5.setVisibility(View.VISIBLE);
                                    textView5.setText(String.valueOf(tatAvg));
                                }
                            });
                            break;
                    }
                }
            });
    }

    private void findview() {
        add = (Button) findViewById(R.id.add);
        showValues = (Button) findViewById(R.id.showValues);
        compute = (Button) findViewById(R.id.compute);


        editTime = (EditText) findViewById(R.id.editTime);
        editBurst = (EditText) findViewById(R.id.editBurst);
        editQuantum = (EditText) findViewById(R.id.editQuantum);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView12 = (TextView) findViewById(R.id.textView12);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        rdFcfs = (RadioButton) findViewById(R.id.rdFcfs);
        rdSJF = (RadioButton) findViewById(R.id.rdSJF);
        rdRR = (RadioButton) findViewById(R.id.rdRR);
    }





}
