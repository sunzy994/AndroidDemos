package cmcm.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.hola.channel.pub.GamesActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class qz
{
  private static final Object a = new Object();
  private static Handler b;
  private static qt c;
  private static int d;

  public static String a()
  {
    return qo.a("http://sdk.holagames.com/sdk/subject/list?locale=" + ql.a().replace('-', '_') + "&tz=" + ql.b() + "&al=" + g() + "&page=1" + "&psize=100");
  }

  public static String a(int paramInt1, int paramInt2)
  {
    return qo.a("http://sdk.holagames.com/sdk/game/hots?locale=" + ql.a().replace('-', '_') + "&tz=" + ql.b() + "&al=" + g() + "&page=" + paramInt1 + "&psize=" + paramInt2);
  }

  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    return qo.a("http://sdk.holagames.com/sdk/game/cate/list?locale=" + ql.a().replace('-', '_') + "&tz=" + ql.b() + "&cateCode=" + paramInt1 + "&al=" + g() + "&page=" + paramInt2 + "&psize=" + paramInt3);
  }

  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, GamesActivity.class).putExtra("hola_games_extra.ENTRY_INDEX", paramInt);
    if (!(paramContext instanceof Activity))
      localIntent.addFlags(268435456);
    try
    {
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
    }
  }

  static <T> void a(WeakReference<ph<T>> paramWeakReference, final T paramT)
  {
    if (paramWeakReference.get() != null)
      c.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ((ph)qz.this.get()).a(paramT);
            return;
          }
          catch (Throwable localThrowable)
          {
          }
        }
      });
  }

  static <T> void a(WeakReference<ph<T>> paramWeakReference, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof pi))
    {
      a(paramWeakReference, (pi)paramThrowable);
      return;
    }
    a(paramWeakReference, new pi(paramThrowable));
  }

  static <T> void a(WeakReference<ph<T>> paramWeakReference, final pi parampi)
  {
    if (paramWeakReference.get() != null)
      c.post(new Runnable()
      {
        public void run()
        {
          try
          {
            ((ph)qz.this.get()).a(parampi);
            return;
          }
          catch (Throwable localThrowable)
          {
          }
        }
      });
  }

  public static void a(ph<List<pc>> paramph)
  {
    f();
    paramph = new WeakReference(paramph);
    b.post(new Runnable()
    {
      public void run()
      {
        try
        {
          Object localObject1 = qz.this.get();
          if (localObject1 == null)
            return;
          localObject1 = new JSONObject(qo.a("http://sdk.holagames.com/sdk/game/cates?locale=" + ql.a().replace('-', '_') + "&tz=" + ql.b() + "&al=" + qz.c() + "&page=1" + "&psize=100")).getJSONArray("cates");
          int j = ((JSONArray)localObject1).length();
          ArrayList localArrayList = new ArrayList();
          int i = 0;
          while (i < j)
          {
            JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
            pc localpc = new pc();
            localpc.a = localJSONObject.getInt("code");
            localpc.b = localJSONObject.getString("name");
            localArrayList.add(localpc);
            i += 1;
          }
          qz.a(qz.this, localArrayList);
          return;
        }
        catch (pi localpi)
        {
          qz.a(qz.this, localpi);
          return;
        }
        catch (Throwable localThrowable)
        {
          qz.a(qz.this, localThrowable);
          return;
        }
        finally
        {
          qz.d();
        }
      }
    });
  }

  public static String b(int paramInt1, int paramInt2)
  {
    return qo.a("http://sdk.holagames.com/sdk/game/latests?locale=" + ql.a().replace('-', '_') + "&tz=" + ql.b() + "&al=" + g() + "&page=" + paramInt1 + "&psize=" + paramInt2);
  }

  public static String b(int paramInt1, int paramInt2, int paramInt3)
  {
    return qo.a("http://sdk.holagames.com/sdk/subject/games?locale=" + ql.a().replace('-', '_') + "&tz=" + ql.b() + "&sid=" + paramInt1 + "&al=" + g() + "&page=" + paramInt2 + "&psize=" + paramInt3);
  }

  static void b()
  {
    synchronized (a)
    {
      if (b != null)
      {
        b.getLooper().quit();
        b = null;
        c = null;
      }
      return;
    }
  }

  private static void e()
  {
    synchronized (a)
    {
      int i = d - 1;
      d = i;
      if (i <= 0)
        c.a(600000L);
      return;
    }
  }

  private static void f()
  {
    synchronized (a)
    {
      if (b == null)
      {
        c = new qt(Looper.getMainLooper())
        {
          public void b()
          {
            qz.b();
          }
        };
        HandlerThread localHandlerThread = new HandlerThread("GameSDK", 10);
        localHandlerThread.start();
        b = new Handler(localHandlerThread.getLooper());
        d += 1;
        return;
      }
      c.a();
    }
  }

  private static int g()
  {
    int i = 19;
    if (Build.VERSION.SDK_INT != 19)
      i = Build.VERSION.SDK_INT;
    while (true)
    {
      return i;
      try
      {
        String[] arrayOfString = Build.VERSION.RELEASE.split("\\.");
        if (arrayOfString.length >= 3)
        {
          int j = Integer.parseInt(arrayOfString[2]);
          if (j >= 3)
            continue;
        }
        label44: return 18;
      }
      catch (Throwable localThrowable)
      {
        break label44;
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     qz
 * JD-Core Version:    0.6.2
 */