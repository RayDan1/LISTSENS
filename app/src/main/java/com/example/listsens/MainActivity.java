package com.example.listsens;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView sensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensores = (TextView) findViewById(R.id.listsensores);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SensorManager sensorAdmin = (SensorManager)
                        getSystemService(SENSOR_SERVICE);

                List<Sensor> list = sensorAdmin.getSensorList(Sensor.TYPE_ALL);

                for (Sensor sensor : list) {
                    log(sensor.getName());
                }
            }
        });
    }
    private void log(String cadena){
        sensores.append(cadena+"\n");
    }
}