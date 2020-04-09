package dk.aau.student.meda2a220astudent.ballthrowingapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private SensorManager linearAccelerationManager;
    private Sensor linearAccelerationSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearAccelerationManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        linearAccelerationSensor = linearAccelerationManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

        linearAccelerationManager.registerListener(this, linearAccelerationSensor, SensorManager.SENSOR_DELAY_UI);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
