package cmcm.com.wakelockdemo;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.PowerManager;
import android.preference.Preference;
import android.support.annotation.Nullable;

import java.io.IOException;

/**
 * Created by sunzy on 16-3-21.
 */
public class MyIntentService extends Service {

    //必须变成全局变量否则会被回收
    private MediaPlayer mediaPlayer;
    private boolean isRunning = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        doAsyncWork();
        return START_STICKY;
    }

    private void playMusic(){
        //通过后台线程播放音乐，拔掉数据线观察音乐何时停止
        PowerManager manager = (PowerManager) getSystemService(POWER_SERVICE);
        mediaPlayer = MediaPlayer.create(MyIntentService.this, R.raw.music);
        mediaPlayer.setLooping(true);
        //mediaPlayer.setWakeMode(MyIntentService.this, PowerManager.PARTIAL_WAKE_LOCK);
        try {
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });
            mediaPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void doAsyncWork() {
        if(isRunning)return;
        isRunning = true;
        SharedPreferences sp = getSharedPreferences("service_config", Context.MODE_PRIVATE);
        sp.edit().putLong("service_start_time", System.currentTimeMillis()).commit();
        final Intent intent = new Intent(MainActivity.ACTION);
        intent.setPackage(getPackageName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                MyLogger.log("MyIntentService on handle intent!");
                for (int i = 0; true; i++){
                    try{
                        Thread.sleep(1000);
                    } catch (Exception e){

                    }
                    intent.putExtra("running_seconds", i);
                    sendBroadcast(intent);
                    MyLogger.log("MyIntentService running " + i);
                }
            }
        }).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    protected void onHandleIntent(Intent intent) {


//        MyLogger.log("MyIntentService on handle intent!");
//
//        for (int i = 0; i< 100; i++){
//            try{
//                Thread.sleep(5000);
//            } catch (Exception e){
//
//            }
//            MyLogger.log("MyIntentService running");
//        }

        //MyWakefulReceiver.completeWakefulIntent(intent);

    }

}
