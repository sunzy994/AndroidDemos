package cmcm.com.myapplication;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.CallLog.Calls;
import android.util.Log;

public class um
{
  private ContentResolver a;
  private ContentObserver b;

  public um(Context paramContext, Handler paramHandler, final un paramun)
  {
    this.a = paramContext.getContentResolver();
    this.b = new ContentObserver(paramHandler)
    {
      public void onChange(boolean paramAnonymousBoolean, Uri paramAnonymousUri)
      {
        super.onChange(paramAnonymousBoolean, paramAnonymousUri);
        int i = um.a(um.this);
        int j = um.b(um.this);
        if ((paramun != null) && (j + i > 0))
          paramun.a(i, j);
      }
    };
  }

  private int c()
  {
    Cursor localCursor = this.a.query(Uri.parse("content://sms"), null, "type = 1 and read = 0", null, null);
    if (localCursor != null)
    {
      int i = localCursor.getCount();
      localCursor.close();
      return i;
    }
    return 0;
  }

  private int d()
  {
    int j = 0;
    Cursor localCursor = this.a.query(CallLog.Calls.CONTENT_URI, new String[] { "number", "type", "new" }, null, null, "date DESC");
    int i = j;
    if (localCursor != null)
    {
      i = j;
      if (localCursor.moveToFirst())
        switch (localCursor.getInt(localCursor.getColumnIndex("type")))
        {
        default:
        case 3:
        }
    }
    for (i = 0; ; i = 1)
    {
      localCursor.close();
      return i;
      if (localCursor.getInt(localCursor.getColumnIndex("new")) != 1)
        break;
      Log.v("@@@SmsAndCall", "you have a missed call");
    }
  }

  public void a()
  {
    b();
    this.a.registerContentObserver(Uri.parse("content://sms"), true, this.b);
    this.a.registerContentObserver(CallLog.Calls.CONTENT_URI, true, this.b);
  }

  public void b()
  {
    try
    {
      if (this.b != null)
        this.a.unregisterContentObserver(this.b);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
    finally
    {
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     um
 * JD-Core Version:    0.6.2
 */