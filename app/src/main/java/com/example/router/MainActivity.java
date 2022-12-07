package com.example.router;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //int UID;
    //private Boolean wifiConnected = false;
    //private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Router Router
        Button button = findViewById(R.id.routerActivity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RouterActivity.class);
                startActivity(intent);
            }
        });
        //Conector Activity
        Button button1 = findViewById(R.id.conectorActivity);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,ConectorActivity.class);
                startActivity(intent);
            }
        });

    }
    /*
    private void checkNetworkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()) {
            wifiConnected = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;

            if (wifiConnected){
                btnConector();
            }else {
                AlertDialog.Builder semWIFI = new AlertDialog.Builder(this);
                semWIFI.setTitle("Você não esta com o WI-FI ligado! Ative agora!");
                semWIFI.setNeutralButton("Ok",null);
                semWIFI.show();
            }
        }
        else{
        }
    }
    public void btnConector(){
        Intent intent = new Intent(MainActivity.this,ConectorActivity.class);
        startActivity(intent);
    }

    public void enableWifi(View view){
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
    }

    //Retorna o número de bytes recebidos pelo UID fornecido desde a inicialização do dispositivo.
    private void getUidRxByte(){
        TrafficStats.getUidRxBytes(UID);
    }
    //Retorna o número de bytes transmitidos pelo UID fornecido desde a inicialização do dispositivo.
    private void getUidTxPacket(){
        TrafficStats.getMobileRxPackets();
    }
*/
}