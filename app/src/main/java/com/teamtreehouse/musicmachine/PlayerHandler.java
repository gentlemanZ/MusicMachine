package com.teamtreehouse.musicmachine;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;

/**
 * Created by tiany on 2017/8/1.
 */

public class PlayerHandler extends Handler {
    private PlayerService mPlayerService;
    public PlayerHandler(PlayerService playerService){
        mPlayerService = playerService;

    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.arg1){
            case 0:     // 0 == play
                mPlayerService.play();
                break;
            case 1:     // 1 == pause
                mPlayerService.pause();
                break;
            case 2:     //2 == is playing
                int isPlaying = mPlayerService.isPlaying() ? 1 : 0;
                Message message = Message.obtain();
                message.arg1 = isPlaying;
                if (msg.arg2 == 1){
                    message.arg2 = 1;
                }
                message.replyTo = mPlayerService.mMessenger;
                //send it toreply
                try {
                    msg.replyTo.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


}
