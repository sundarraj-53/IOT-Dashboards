package com.example.mistral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public abstract class line extends AppCompatActivity implements SensorEventListener {
    private static final String tag = "line";
    private SensorManager mdata;
    private Sensor Accelerometer;
    private boolean plotData = true;
    private LineChart line;
    private Thread thread;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
    }
}
//        mdata = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        Accelerometer = mdata.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELEROMETER);
//        if (Accelerometer!= null) {
//            mdata.registerListener(this, Accelerometer, dataManager.SENSOR_DELAY_NORMAL);
//
//        }
//        line = (LineChart) findViewById(R.id.line);
//        line.getDescription().setEnabled(true);
//        line.getDescription().setText("Line chart");
//        line.setTouchEnabled(false);
//        line.setDragEnabled(false);
//        line.setScaleEnabled(true);
//        line.setDrawGridBackground(false);
//        LineData values = new LineData();
//        values.setValueTextColor(Color.BLACK);
//        line.setData(values);
//        Legend l = line.getLegend();
//
//        // modify the legend ...
//        l.setForm(Legend.LegendForm.LINE);
//        l.setTextColor(Color.WHITE);
//
//        XAxis xl = line.getXAxis();
//        xl.setTextColor(Color.WHITE);
//        xl.setDrawGridLines(true);
//        xl.setAvoidFirstLastClipping(true);
//        xl.setEnabled(true);
//
//        YAxis leftAxis = line.getAxisLeft();
//        leftAxis.setTextColor(Color.WHITE);
//        leftAxis.setDrawGridLines(false);
//        leftAxis.setAxisMaximum(10f);
//        leftAxis.setAxisMinimum(0f);
//        leftAxis.setDrawGridLines(true);
//
//        YAxis rightAxis = line.getAxisRight();
//        rightAxis.setEnabled(false);
//
//        line.getAxisLeft().setDrawGridLines(false);
//        line.getXAxis().setDrawGridLines(false);
//        line.setDrawBorders(false);
//        start();
//    }
//    private void start() {
//        if (thread != null) {
//            thread.interrupt();
//        }
//        thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    plotData = true;
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        });
//        thread.start();
//    }
//    private void addEntry(SensorEvent event) {
//        LineData data = new LineData();
//        if (data != null) {
//            LineDataset set = data.getDataSetByIndex(0);
//            if (set == null) {
//                set.createSet();
//                data.addDataSet(set);
//            }
//            data.addEntry(new Entry(set.getEntryCount(), event.values[0] + 5), 0);
//            data.notifyDataChanged();
//            line.setMaxVisibleValueCount(500);
//            line.moveViewToX(data.getEntryCount());
//        }
//    public void onSensorChanged(SensorEvent event) {
//        if (plotData) {
//            addEntry(sensorEvent);
//            plotData = false;
//        }
//    }
//        private LineData createSet() {
//            LineDataSet set = new LineDataSet(null, "Real time Data");
//            set.setAxisDependency(YAxis.AxisDependency.LEFT);
//            set.setLineWidth(3f);
//            set.setColor(Color.MAGENTA);
//            set.setMode(LineDataSet.Mode.LINEAR);
//            set.setCubicIntensity(0.2f);
//            return set;
//        }
//        @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//    }
//        protected void onPause() {
//            super.onPause();
//            if (thread != null) {
//                thread.interrupt();
//            }
//            mdata.unregisterListener(this);
//        }
//        protected void onPostResume() {
//            super.onPostResume();
//            mdata.registerListener(this, Accelerometer, dataManager.SENSOR_DELAY_GAME);
//        }
//
//        protected void onDestroy() {
//            dataManager.unregisterListener(line.this);
//            thread.interrupt();
//            super.onDestroy();
//        }
//
//    }
//}
//}
//    ArrayList lineArrayList;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_line);
//        LineChart lineChart=findViewById(R.id.line);
//        getData();
//        LineDataSet lineDataSet=new LineDataSet(lineArrayList,"IOT DASHBOARD");
//        LineData lineData=new LineData(lineDataSet);
//        lineChart.setData(lineData);
//        lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
//        lineDataSet.setValueTextColor(Color.BLACK);
//        lineDataSet.setValueTextSize(15f);
////        lineChart.getDescription().setText("Line chart for Temperature");
//        lineChart.animateY(3000);
//
//    }
//    private void getData(){
//        lineArrayList=new ArrayList();
//        lineArrayList.add(new BarEntry(2f,20f));
//        lineArrayList.add(new BarEntry(3f,100f));
//        lineArrayList.add(new BarEntry(4f,40f));
//        lineArrayList.add(new BarEntry(5f,80f));
//        lineArrayList.add(new BarEntry(6f,60f));
//
//    }
//}