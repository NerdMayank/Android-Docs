package com.example.uibasicscollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtHello;
    private EditText edtTxtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnHELLO= findViewById(R.id.btnHELLO);
        btnHELLO.setOnClickListener(this);
        btnHELLO.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Long Press", Toast.LENGTH_SHORT).show();
                return true;
            }
        });



    }

    @Override
    public void onClick(View v) {

            edtTxtName= findViewById(R.id.edtTxtName);
            txtHello=findViewById(R.id.txtHello);
            switch (v.getId()){
                case R.id.btnHELLO:
                    Toast.makeText(this, "Hello "+edtTxtName.getText(), Toast.LENGTH_SHORT).show();
                    txtHello.setText("Hello "+edtTxtName.getText().toString());
                    break;
                default:
                    break;
            }

    }
}