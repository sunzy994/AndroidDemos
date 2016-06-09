package cmcm.com.alarmclock;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.PowerManager;
import android.util.Log;

public class MyIntentService extends IntentService {

    private MediaPlayer mediaPlayer;

    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        playMusic();
    }

    private void playMusic(){
        if(mediaPlayer == null){
            mediaPlayer.release();
            mediaPlayer = null;
        } else {
            //通过后台线程播放音乐，拔掉数据线观察音乐何时停止
            mediaPlayer = MediaPlayer.create(MyIntentService.this, R.raw.music);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }
}
