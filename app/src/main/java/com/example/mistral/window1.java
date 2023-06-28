package com.example.mistral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class window1 extends AppCompatActivity {

    TextView Temp,production;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window1);
        Temp=findViewById(R.id.Temp);
        production=findViewById(R.id.production);
        Temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(window1.this, "Temperature Page", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(window1.this,line.class));
            }
        });
        production.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(window1.this, "Production page", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(window1.this,home.class));
            }
        });
    }
}