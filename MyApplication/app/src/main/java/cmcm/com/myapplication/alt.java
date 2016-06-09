package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.lazyswipe.notification.NotificationData;

final class alt extends ContentObserver
{
  private final Context a;
  private Runnable b;

  public alt(Context paramContext, Handler paramHandler)
  {
    super(paramHandler);
    this.a = paramContext;
  }

  public void a()
  {
    arj.a(new Runnable() {
      public void run() {
        try {
          alt.a(alt.this).getContentResolver().delete(xj.a, "package_name=?key_suppress_notify", new String[]{"0"});
          return;
        } catch (Throwable localThrowable) {
        }
      }
    });
    this.b = new als(this.a);
    ContentResolver localContentResolver = this.a.getContentResolver();
    try
    {
      localContentResolver.registerContentObserver(NotificationData.b, false, this);
      try
      {
        label43: localContentResolver.registerContentObserver(NotificationData.a, false, this);
        label52: dispatchChange(true);
        return;
      }
      catch (Throwable localThrowable1)
      {
        break label52;
      }
    }
    catch (Throwable localThrowable2)
    {
      break label43;
    }
  }

  public void onChange(boolean paramBoolean)
  {
    onChange(paramBoolean, null);
  }

  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    arj.a(this.b, true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     alt
 * JD-Core Version:    0.6.2
 */