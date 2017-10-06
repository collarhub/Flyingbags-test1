package com.example.user.flyingbags_test1.service;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

import com.example.user.flyingbags_test1.presenter.MainPresenter;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * Created by User on 2017-10-07.
 */

public class QRService implements MainPresenter.presenter{

    @Override
    public String showQR(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        return result.getContents();
    }

    @Override
    public void scanQR(Activity activity) {
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        integrator.addExtra("PROMPT_MESSAGE", "Scan QR Code within frame");
        //integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.initiateScan();
    }
}
