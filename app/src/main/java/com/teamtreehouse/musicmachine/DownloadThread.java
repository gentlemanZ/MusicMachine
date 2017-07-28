package com.teamtreehouse.musicmachine;

import android.os.Looper;
import android.util.Log;

/**
 * Created by tiany on 2017/7/28.
 */

public class DownloadThread extends Thread {
    private static final String TAG = DownloadThread.class.getSimpleName();
    public DownloadHandler mHandler;
    @Override
    public void run() {
        Looper.prepare(); //message queue starts
        mHandler = new DownloadHandler();
        Looper.loop();
    }


}
