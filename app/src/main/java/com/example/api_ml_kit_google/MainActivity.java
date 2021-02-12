package com.example.api_ml_kit_google;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.camerakit.CameraKitView;
import com.example.api_ml_kit_google.Helper.GraphicOverlay;

import dmax.dialog.SpotsDialog;

public class MainActivity extends AppCompatActivity {
    private Button faceDetecButton;
    private GraphicOverlay graphicOverlay;
    private CameraView cameraView;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        faceDetecButton = findViewById(R.id.detect_face_btn);
        graphicOverlay = findViewById(R.id.graphic_overlay);
        cameraView = findViewById(R.id.camera_view);

        alertDialog = new SpotsDialog().Builder()
                .setContext(this)
                .setMessage("Por favor espere un momento, Loading...")
                .setCancelable(false)
                .build();

        faceDetecButton.setOnClickListener (new View.OnClickListener( {
            @Override
            public void onClick(View v)
            {
                cameraView.star();
                cameraView.captureImage();
                graphicOverlay.clear();

            }
        });

        cameraView.addCameraKitListener(new CameraKitEventListener() {
            @Override
            public void onEvent(CameraKitEvent cameraKitEvent)
            {

            }
            @Override
            public void onError(CameraKitEvent cameraKitEvent)
            {

            }
            @Override
            public void onImage(CameraKitImage cameraKitImage)
            {
                alertDialog.show();
                Bitmap bitmap = cameraKitImage.getBitmap();
                bitmap = Bitmap.createScaledBitmap(bitmap,cameraView.getWidth(),cameraView.getHeight(),
                        cameraView.stop();
                processFacedetection(bitmap);
            }
            @Override
            public void onVideo(CameraKitVideo cameraKitVideo)
            {

            }

        });
    }



    }

    @Override
    protected void onPause() {
        super.onPause();

        cameraView.stop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraView.start();
    }
}