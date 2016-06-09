package cmcm.com.notifautostart;

import android.annotation.SuppressLint;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by sunzy on 16-2-18.
 */
@SuppressLint("OverrideAbstract")
public class NotificationService extends NotificationListenerService {

    @Override
    public void onCreate() {
        Log.v("sunzy", "NotificationService onCreate!");
        Toast.makeText(this, "NotificationService onCreate!", Toast.LENGTH_LONG).show();
    }

    @Override
    public final void onNotificationPosted(StatusBarNotification sbn) {
        Log.v("sunzy", "NotificationService onNotificationPosted!");
        Toast.makeText(this, "NotificationService onNotificationPosted!", Toast.LENGTH_LONG).show();
    }
}
