package com.example.myrecorder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    MediaRecorder mediaRecorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.RECORD_AUDIO}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        mediaRecorder= new MediaRecorder();
    }
    @RequiresApi(api = Build.VERSION_CODES.S)
    public void startRecording(View view){
        Toast.makeText(this, "Recording Started", Toast.LENGTH_SHORT).show();
        try{
            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
            mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

            File path= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            File file= new File(path,"/MyAudio.3gp");
            mediaRecorder.setOutputFile(file);
            mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            mediaRecorder.prepare();
            mediaRecorder.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void stopRecording(View view){
        Toast.makeText(this, "Recording Stopped", Toast.LENGTH_SHORT).show();
    mediaRecorder.stop();
    mediaRecorder.release();

    }
}