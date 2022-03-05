package com.example.androidlaoou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Button cong;
    static Button tru;
    static Button nhan;
    static Button chia;
    static ListView listView;
    static EditText sodau;
    static EditText socuoi;
    static TextView ketqua;
    static double _sodau;
    static double _socuoi;
    static double _ketqua;


    boolean checknull(){
        if (sodau.getText().toString().equals("") == true || socuoi.getText().toString().equals("") == true){
            Context context = getApplicationContext();
            CharSequence text = "Fill two number";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return true;
        }

        return  false;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cong = findViewById(R.id.button);
        tru = findViewById(R.id.button2);
        nhan = findViewById(R.id.button3);
        chia = findViewById(R.id.button4);
        listView = findViewById(R.id.litview);
        sodau = findViewById(R.id.sodau);
        socuoi = findViewById(R.id.socuoi);
        ketqua = findViewById(R.id.ketqua);
        ArrayList<String> ls = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ls);
        listView.setAdapter(arrayAdapter);
        cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checknull() != true){
                    _socuoi = Double.parseDouble(socuoi.getText().toString());
                    _sodau = Double.parseDouble(sodau.getText().toString());
                    _ketqua = _socuoi + _sodau;
                    ketqua.setText("Answer: " + String.valueOf(_ketqua));
                    String str = String.valueOf(_sodau) + " + " + String.valueOf(_socuoi) + " = " + String.valueOf(_ketqua);
                    ls.add(str);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checknull() != true){
                    _socuoi = Double.parseDouble(socuoi.getText().toString());
                    _sodau = Double.parseDouble(sodau.getText().toString());
                    _ketqua = _socuoi - _sodau;
                    ketqua.setText("Answer: " + String.valueOf(_ketqua));
                    String str = String.valueOf(_sodau) + " - " + String.valueOf(_socuoi) + " = " + String.valueOf(_ketqua);
                    ls.add(str);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checknull() != true){
                    _socuoi = Double.parseDouble(socuoi.getText().toString());
                    _sodau = Double.parseDouble(sodau.getText().toString());
                    _ketqua = _socuoi * _sodau;
                    ketqua.setText("Answer: " + String.valueOf(_ketqua));
                    String str = String.valueOf(_sodau) + " x " + String.valueOf(_socuoi) + " = " + String.valueOf(_ketqua);
                    ls.add(str);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
        chia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checknull() != true){
                    _socuoi = Double.parseDouble(socuoi.getText().toString());
                    if(_socuoi == 0){
                        Context context = getApplicationContext();
                        CharSequence text = "Cannot divide into zero";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                    else {
                        _sodau = Double.parseDouble(sodau.getText().toString());
                        _ketqua = _socuoi / _sodau;
                        ketqua.setText("Answer: " + String.valueOf(_ketqua));
                        String str = String.valueOf(_sodau) + " / " + String.valueOf(_socuoi) + " = " + String.valueOf(_ketqua);
                        ls.add(str);
                        arrayAdapter.notifyDataSetChanged();
                    }

                }
            }
        });
    }
}