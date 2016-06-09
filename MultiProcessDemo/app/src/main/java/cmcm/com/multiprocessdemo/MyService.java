package cmcm.com.multiprocessdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MultiProcessConfigImpl().asBinder();
    }
}
