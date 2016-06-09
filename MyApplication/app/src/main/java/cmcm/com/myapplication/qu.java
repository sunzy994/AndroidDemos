package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.hola.channel.pub.GamesActivity;
import java.io.File;
import java.io.IOException;
import java.nio.channels.FileLock;

public class qu
{
  public static String a;
  public static String b;
  public static boolean c = false;
  public static long d = 0L;
  private static File e;
  private static FileLock f;
  private static boolean g;

  public static void a(final Context paramContext, final boolean paramBoolean, qh paramqh)
  {
    qn.b(new Runnable()
    {
      public void run()
      {
        try
        {
          if (qu.b())
          {
            qu.this.a("IE");
            return;
          }
          if (!qu.d(paramContext))
          {
            qu.this.a(new pi("Try lock failed"));
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          qu.c = false;
          qu.this.a(new pi(localThrowable));
          qu.e(paramContext);
          return;
        }
        if (qu.a(paramContext))
          qu.this.a("CE");
        for (Object localObject = new qh()
        {
          public void a(Object paramAnonymous2Object)
          {
            qq.b("background.init", "onSuccess " + paramAnonymous2Object);
          }

          public void a(pi paramAnonymous2pi)
          {
            qq.d("background.init", "onError " + paramAnonymous2pi.a() + " " + paramAnonymous2pi.getMessage());
          }
        }
        ; ; localObject = qu.this)
        {
          qk.a(paramContext);
          pa.a(paramContext, paramBoolean, new ot()
          {
            public void a(final Object paramAnonymous2Object)
            {
              qu.c = true;
              qu.d = System.currentTimeMillis();
              qu.e(qu.1.this.b);
              qu.f(qu.1.this.b);
              String str = (String)paramAnonymous2Object;
              if (!str.equals("LO"))
                qf.a(qu.1.this.b, str);
              if (str.equals("RM"))
                sn.a(qu.1.this.b).b(qu.1.this.b);
              po.a(qu.1.this.b, new pz()
              {
                public void a(Exception paramAnonymous3Exception)
                {
                  qu.1.2.this.a.a(new pi(paramAnonymous3Exception));
                }

                public void a(Object paramAnonymous3Object)
                {
                  qu.1.2.this.a.a(paramAnonymous2Object);
                }
              });
            }

            public void a(Throwable paramAnonymous2Throwable)
            {
              qu.c = false;
              qu.e(qu.1.this.b);
              this.a.a(new pi(paramAnonymous2Throwable));
            }
          });
          return;
        }
      }
    });
  }

  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 14;
  }

  public static boolean a(Context paramContext)
  {
    return oy.b(paramContext, "rtgamerunjar.jar").exists();
  }

  public static String b(Context paramContext)
  {
    if (a != null)
      return a;
    Object localObject = oy.a(paramContext, "hola_channelId");
    if (((File)localObject).exists())
      try
      {
        localObject = qn.a((File)localObject);
        return localObject;
      }
      catch (IOException localIOException)
      {
        qq.a(paramContext, "Sdk.getChannelId", localIOException);
      }
    return null;
  }

  public static String c(Context paramContext)
  {
    if (b != null)
      return b;
    Object localObject = oy.a(paramContext, "hola_subChannelId");
    if (((File)localObject).exists())
      try
      {
        localObject = qn.a((File)localObject);
        return localObject;
      }
      catch (IOException localIOException)
      {
        qq.a(paramContext, "Sdk.getSubChannelId", localIOException);
      }
    return null;
  }

  private static boolean c()
  {
    return (c) && (System.currentTimeMillis() - d < 60000L);
  }

  private static boolean g(Context paramContext)
  {
    try
    {
      if (g)
        return false;
      e = oy.a(paramContext, "hola_sdk.lock");
      f = qn.d(e);
      g = true;
      return true;
    }
    catch (Throwable localThrowable)
    {
      qq.a(paramContext, "Sdk.lock", localThrowable);
    }
    return false;
  }

  private static boolean h(Context paramContext)
  {
    try
    {
      g = false;
      qn.a(f, e);
      return true;
    }
    catch (IOException localIOException)
    {
      qq.a(paramContext, "Sdk.unlock", localIOException);
    }
    return false;
  }

  private static void i(Context paramContext)
  {
    SharedPreferences localSharedPreferences = qy.a(paramContext);
    Bundle localBundle;
    ComponentName localComponentName;
    Object localObject;
    if (localSharedPreferences.getInt("key_shortcut_created", 0) == 0)
    {
      localBundle = new Bundle(1);
      localBundle.putBoolean("hola_games_extra.SHORTCUT_LAUNCH", true);
      localComponentName = new ComponentName(paramContext, GamesActivity.class);
      localObject = paramContext.getPackageManager();
    }
    try
    {
      localObject = ((PackageManager)localObject).getActivityInfo(localComponentName, 0).loadLabel((PackageManager)localObject);
      qn.a(paramContext, localComponentName, (CharSequence)localObject, BitmapFactory.decodeResource(paramContext.getResources(), td.ic_games), localBundle);
      localSharedPreferences.edit().putInt("key_shortcut_created", 1).apply();
      return;
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      while (true)
        String str = "Games";
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qu
 * JD-Core Version:    0.6.2
 */