package com.example.user.flyingbags_test1.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.flyingbags_test1.R;
import com.example.user.flyingbags_test1.presenter.MainPresenter;
import com.example.user.flyingbags_test1.service.QRService;

public class MainActivity extends AppCompatActivity implements MainPresenter.view{

    public QRService qrService;

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qrService = new QRService();
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qrService.scanQR(MainActivity.this);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        showQR(requestCode, resultCode, data);
    }

    @Override
    public void showQR(int requestCode, int resultCode, Intent data) {
        Toast.makeText(this, qrService.showQR(requestCode, resultCode, data), Toast.LENGTH_SHORT).show();
    }
}
