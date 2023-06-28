package com.example.mistral;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class home extends AppCompatActivity {

    ArrayList barArrayList;
    BarChart barchart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BarChart barchart=findViewById(R.id.Chart);
        getData();
        BarDataSet barDataSet=new BarDataSet(barArrayList,"IOT DASHBOARD");
        BarData barData=new BarData(barDataSet);
        barchart.setData(barData);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(15f);
        barchart.getDescription().setText("Y axis");
        barchart.animateY(3000);
    }
    private void getData(){
        barArrayList=new ArrayList();
        barArrayList.add(new BarEntry(2f,10));
        barArrayList.add(new BarEntry(3f,30));
        barArrayList.add(new BarEntry(4f,50));
        barArrayList.add(new BarEntry(5f,70));
        barArrayList.add(new BarEntry(6f,100));

    }

}