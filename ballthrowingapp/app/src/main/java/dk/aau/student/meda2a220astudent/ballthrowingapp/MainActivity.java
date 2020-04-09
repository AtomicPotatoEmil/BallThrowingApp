package dk.aau.student.meda2a220astudent.ballthrowingapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    int tennisBallWeight = 59; // grams
    int throwValue = 0;
    int time = 0;
    private SensorManager linearAccelerationManager;
    private Sensor linearAccelerationSensor;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearAccelerationManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        linearAccelerationSensor = linearAccelerationManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

        linearAccelerationManager.registerListener(this, linearAccelerationSensor, SensorManager.SENSOR_DELAY_UI);

        timer = new Timer();
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
       // Log.d("ACC X", String.valueOf(event.values[0]));

        if (event.values[0] > 15){
            if(event.values[0] > throwValue){
                throwValue = event.values[0];
            }
            try{
                timer.scheduleAtFixedRate(task, 1000, 1000);
            }catch (IllegalStateException e){
                System.out.println("whatever");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void throwBall(View view){
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            time++;
            Log.d("Timer", String.valueOf(time));
            Log.d("Throw", String.valueOf(throwValue));
        }
    };

}
