package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

final class alp extends ContentObserver
{
  private final Context a;
  private Runnable b;

  public alp(Context paramContext, Handler paramHandler)
  {
    super(paramHandler);
    this.a = paramContext;
  }

  public void a()
  {
    this.b = new alr(this.a);
    try
    {
      this.a.getContentResolver().registerContentObserver(xj.a, true, this);
      label30: dispatchChange(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label30;
    }
  }

  public void onChange(boolean paramBoolean)
  {
    onChange(paramBoolean, null);
  }

  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    arj.a(this.b, 100L, true);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     alp
 * JD-Core Version:    0.6.2
 */