package com.example.getsensorlist;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView mTxtEsnsors;
    SensorManager sensorMgr;
    List<Sensor> sensorList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtEsnsors = findViewById(R.id.txtSensors);
//        mTxtEsnsors.setMovementMethod(new ScrollingMovementMethod());

        sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE); // 가져온다
        sensorList = sensorMgr.getSensorList(Sensor.TYPE_ALL);
        mTxtEsnsors.append("(# Sensors: " + sensorList.size() + ")\n\n") ;
        for (Sensor sensor : sensorList){
            mTxtEsnsors.append("Sensor name: " + sensor.getName() + "\n");
            mTxtEsnsors.append("Sensor type: " + sensor.getType() + "\n\n");

        }

    }
}