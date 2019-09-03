package com.example.ejemplosensordeflash;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Camera camera;
    private Button encender;
    private Button apagar;
    private Button iniciarVibrador;

    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encender = findViewById(R.id.btnEncender);
        apagar = findViewById(R.id.btnApagar);
        iniciarVibrador = findViewById(R.id.btnVibrar);

        vibrator = (Vibrator)getSystemService(VIBRATOR_SERVICE);

        encender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera = Camera.open();
                Camera.Parameters parameters = camera.getParameters();
                parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(parameters);
                camera.startPreview();

            }
        });

        iniciarVibrador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(5000);
            }
        });


        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera.stopPreview();
                camera.release();
            }
        });
    }

}
