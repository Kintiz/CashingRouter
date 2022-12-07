package com.example.router;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RouterActivity extends AppCompatActivity {

    private TextView bytesRecebidosT;
    private TextView pacotesRecebidosT;
    private TextView bytesUIDT;
    private TextView pacotesUIDT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_router);

        //bytesUIDT = findViewById(R.id.Uitextby);
        //pacotesUIDT = findViewById(R.id.Uitextb);
        //gMRB();

        //home Activity
        Button button = findViewById(R.id.buttonHome);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RouterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //wifi Activity
        Button button1 = findViewById(R.id.buttonWifi);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RouterActivity.this,ConectorActivity.class);
                startActivity(intent);
            }
        });
        //cashback Activity
        Button button2 = findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RouterActivity.this,CashbackActivity.class);
                startActivity(intent);
            }
        });

    }
/*
    private void gMRB() {
        long bytesRecebidos = android.net.TrafficStats.getMobileRxBytes();
        long pacotesRecebidos = android.net.TrafficStats.getMobileRxPackets();
        long klRecebidos = bytesRecebidos / 1024;
        long megaBytesRecebidos = klRecebidos / 1024;

        long bytesUID = android.net.TrafficStats.getUidRxBytes(12);
        long pacotesUID = android.net.TrafficStats.getUidRxPackets(145);

        bytesRecebidosT.setText("Você tem "+(float) megaBytesRecebidos + " MegaBytes");
        pacotesRecebidosT.setText("Você tem "+(float) pacotesRecebidos + " Pacotes");
        bytesUIDT.setText("O usuário '<unknow>' gastou "+/*(float) bytesUID + " Bytes");
        pacotesUIDT.setText("O usuário '<unknow>' gastou "+/*(float) pacotesUID + " Pacotes");
    }
*/
}