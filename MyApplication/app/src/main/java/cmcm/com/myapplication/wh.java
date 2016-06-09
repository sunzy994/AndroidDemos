package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.File;
import java.lang.reflect.Field;

class wh extends we
{
  private final Uri[] b;
  private final String c;
  private final String d;

  public wh(Context paramContext, Uri[] paramArrayOfUri, String paramString1, String paramString2)
  {
    super(paramContext);
    this.b = paramArrayOfUri;
    this.c = paramString1;
    this.d = paramString2;
  }

  private File b()
  {
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    Object localObject = localUncaughtExceptionHandler;
    if (localUncaughtExceptionHandler.getClass().getName().startsWith("com.flurry.sdk"));
    try
    {
      Field[] arrayOfField = localUncaughtExceptionHandler.getClass().getDeclaredFields();
      localObject = localUncaughtExceptionHandler;
      if (arrayOfField.length < 0)
      {
        localObject = arrayOfField[0];
        ((Field)localObject).setAccessible(true);
        localObject = ((Field)localObject).get(localUncaughtExceptionHandler);
      }
      localObject = arp.b(localObject, "b");
      if (!(localObject instanceof vi))
        return null;
    }
    catch (Throwable localThrowable)
    {
      return null;
    }
    return ((vi)localObject).a();
  }

  protected void a()
  {
    File localFile = b();
    if ((localFile != null) && (localFile.exists()));
    for (String str = aqx.i(localFile); ; str = null)
    {
      if (wd.a(this.a, this.b, this.c, this.d, str))
      {
        ci.a(this.a).a(new Intent("Swipe..intent.action.FEEDBACK_SENT"));
        if (localFile != null)
          localFile.delete();
      }
      return;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     wh
 * JD-Core Version:    0.6.2
 */