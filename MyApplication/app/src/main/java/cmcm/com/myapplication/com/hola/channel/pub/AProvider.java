package cmcm.com.myapplication.com.hola.channel.pub;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import oy;
import oz;
import qe;
import qh;
import qn;
import qq;
import qu;
import qv;

public class AProvider extends ContentProvider
{
  private static Context a;
  private static ProviderInfo b;
  private static boolean c = false;
  private static File d;
  private static String e;

  public Object a(String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    a();
    try
    {
      paramArrayOfObject = qe.a(a, paramString, paramArrayOfObject, paramArrayOfClass);
      return paramArrayOfObject;
    }
    catch (Throwable paramArrayOfObject)
    {
      qq.a(a, "AProvider.call." + paramString, paramArrayOfObject);
    }
    return null;
  }

  public void a()
  {
    if (!c)
      try
      {
        if (!oy.a(a, "analytics.jar").exists())
        {
          qu.a(a, false, new qh());
          return;
        }
        qe.a(a, "attachInfo", new Object[] { a, b }, new Class[] { Context.class, ProviderInfo.class });
        c = true;
        if (d == null)
          d = oy.a(a, "analytics.jar");
        e = qn.b(d);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
        {
          public void run()
          {
            qu.a(AProvider.b(), false, new qh()
            {
              public void a(Object paramAnonymous2Object)
              {
                try
                {
                  qn.b(AProvider.c());
                  qq.a("AProvider.reinit", "Start");
                  qe.b(AProvider.b());
                  AProvider.a(false);
                  AProvider.this.a();
                  return;
                }
                catch (Throwable paramAnonymous2Object)
                {
                  qq.a(AProvider.b(), "AProvider.reinit", paramAnonymous2Object);
                }
              }
            });
          }
        }
        , 1800000L);
        return;
      }
      catch (Throwable localThrowable)
      {
        qq.a(a, "AProvider.init", localThrowable);
      }
  }

  public void attachInfo(Context paramContext, ProviderInfo paramProviderInfo)
  {
    super.attachInfo(paramContext, paramProviderInfo);
    if (!qu.a());
    do
    {
      return;
      a = paramContext;
      b = paramProviderInfo;
      a();
    }
    while (oz.c(a));
    qv.a(a);
  }

  public Bundle call(String paramString1, String paramString2, Bundle paramBundle)
  {
    a("call", new Object[] { paramString1, paramString2, paramBundle }, new Class[] { String.class, String.class, Bundle.class });
    return super.call(paramString1, paramString2, paramBundle);
  }

  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = ((Integer)a("delete", new Object[] { paramUri, paramString, paramArrayOfString }, new Class[] { Uri.class, String.class, [Ljava.lang.String.class })).intValue();
    if (i == 0);
    return i;
  }

  public String getType(Uri paramUri)
  {
    paramUri = (String)a("getType", new Object[] { paramUri }, new Class[] { Uri.class });
    if (paramUri == null);
    return paramUri;
  }

  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    paramUri = (Uri)a("insert", new Object[] { paramUri, paramContentValues }, new Class[] { Uri.class, ContentValues.class });
    if (paramUri == null);
    return paramUri;
  }

  public boolean onCreate()
  {
    return true;
  }

  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramUri = (Cursor)a("query", new Object[] { paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2 }, new Class[] { Uri.class, [Ljava.lang.String.class, String.class, [Ljava.lang.String.class, String.class });
    if (paramUri == null);
    return paramUri;
  }

  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int i = ((Integer)a("update", new Object[] { paramUri, paramContentValues, paramString, paramArrayOfString }, new Class[] { Uri.class, ContentValues.class, String.class, [Ljava.lang.String.class })).intValue();
    if (i == 0);
    return i;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.pub.AProvider
 * JD-Core Version:    0.6.2
 */