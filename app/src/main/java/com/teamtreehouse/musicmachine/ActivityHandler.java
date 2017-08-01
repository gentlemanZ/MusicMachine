package com.teamtreehouse.musicmachine;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;

/**
 * Created by tiany on 2017/8/1.
 */

public class ActivityHandler extends Handler {

    private MainActivity mMainActivity;
    public ActivityHandler(MainActivity mainActivity){
        mMainActivity = mainActivity;
    }

    @Override
    public void handleMessage(Message msg) {
        if (msg.arg1 == 0){
            //Music is not playing
            if (msg.arg2 ==1){
                mMainActivity.changePlayButtonText("Play");
            }else {
                //Play the music
                //Change the button to Pause
                Message message = Message.obtain();
                message.arg1 = 0;
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                mMainActivity.changePlayButtonText("Pause");
            }
        }else if (msg.arg1 ==1) {
            // Mucis is playing
            if (msg.arg2 == 1) {
                mMainActivity.changePlayButtonText("Pause");
            } else {
                //pause music
                //change button to play
                Message message = Message.obtain();
                message.arg1 = 1;
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                mMainActivity.changePlayButtonText("Play");
            }
        }
    }
}
