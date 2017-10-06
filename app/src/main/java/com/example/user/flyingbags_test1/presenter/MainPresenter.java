package com.example.user.flyingbags_test1.presenter;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by User on 2017-10-07.
 */

public class MainPresenter {
    public interface view {
        void showQR(int requestCode, int resultCode, Intent data);
    }

    public interface presenter {
        String showQR(int requestCode, int resultCode, Intent data);
        void scanQR(Activity activity);
    }
}
