package com.example.router;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConectorActivity extends AppCompatActivity {

    private Boolean wifiConnected = false;
    private TextView textView, textView1;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conector);

        //Ver Informações da conexão WI-FI ou Dados moveis

        textView = findViewById(R.id.conecaoWIFI);
        textView1 = findViewById(R.id.nomerouter);
        checkNetworkConnection();

        //Nome do REDE CONECTADA
        /*ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_WIFI_STATE,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION},
                PackageManager.PERMISSION_GRANTED);
        nameRouter = findViewById(R.id.nameRouter);*/

        //home Activity
        Button button = findViewById(R.id.buttonHome1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConectorActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //roteamento Activity
        Button button1 = findViewById(R.id.buttonRotear);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConectorActivity.this,RouterActivity.class);
                startActivity(intent);
            }
        });

    }

    //Função para mostrar se o wi-fi esta ligado
    private void checkNetworkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.isConnected()) {
            wifiConnected = networkInfo.getType() == ConnectivityManager.TYPE_WIFI;

            if (wifiConnected) {
                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
                WifiInfo wifiInfo;
                wifiInfo = wifiManager.getConnectionInfo();

                textView.setText("Você esta conectado a rede WI-FI AndroidWifi"/*+wifiInfo.getSSID()*/);
                textView1.setText(wifiInfo.getSSID());
            }else {
                textView.setText("Você esta desconectado a rede WI-FI, Conecte-se agora!");
            }

        }else {
            textView.setText("Você não esta conectado a uma rede WI-FI");
        }
    }
    /*
    //Função para mostrar nome do roteador
    public void buttonGetSSID(View view){
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        WifiInfo wifiInfo;

        wifiInfo = wifiManager.getConnectionInfo();

        if(wifiInfo.getSupplicantState() == SupplicantState.COMPLETED){
            nameRouter.setText("conectado à" + wifiInfo.getSSID());
        }else{
            nameRouter.setText("Rede não conectada");
        }
    }*/

    public void enableWifi(View view){
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
    }
    public void disableWifi(View view){
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(false);
    }

}