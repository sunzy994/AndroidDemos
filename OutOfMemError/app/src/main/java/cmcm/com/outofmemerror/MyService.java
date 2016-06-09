package cmcm.com.outofmemerror;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private byte[] data;

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        data = new byte[1024 * 1024 * 110];
//        for (int i = 0;i < data.length;i++){
//            data[i] = (byte)i;
//        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {

                        Thread.sleep(1000);
                    } catch (Exception e){

                    }
                    Log.v("sunzy", "service running!");
                }
            }
        }).start();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
