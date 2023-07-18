package com.example.mybluetooth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button button, button2;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switch1;

    BluetoothAdapter bt;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        switch1 = findViewById(R.id.switch1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                startActivity(obj);
                bt = BluetoothAdapter.getDefaultAdapter();
                if (bt == null) {
                    Toast.makeText(getApplicationContext(), "Bluetooth Device not found", Toast.LENGTH_LONG).show();
                } else {
                    if (bt.isEnabled()) {
                        String op = "Device Status : ON";
                        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        String dn = bt.getName();
                        @SuppressLint("HardwareIds") String mac = bt.getAddress();

                        op += "\n Device : " + dn + "\nAddress : " + mac;
                        tv.setText(op);
                        switch1.setChecked(true);
                    } else {
                        tv.setText("DEVICE STATUS: OFF");
                        switch1.setChecked(false);
                    }
                }
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    bt.enable();
                    String op = "Device Status : ON";
                    String dn = bt.getName();
                    @SuppressLint("HardwareIds") String mac = bt.getAddress();
                    op += "\n Device : " + dn + "\nAddress : " + mac;
                    tv.setText(op);

                }
                else{
                    bt.disable();
                    tv.setText("DEVICE STATUS: OFF");
                }
            }
        });

    }
}