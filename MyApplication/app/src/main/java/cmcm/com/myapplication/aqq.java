package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.UserManager;
import java.lang.ref.WeakReference;

public final class aqq
{
  final WeakReference<Context> a;
  final String b;
  final String c;
  final int d;
  final boolean e;
  final String f;
  final String g;

  public aqq(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramString1, paramString2, paramInt, paramBoolean, "0");
  }

  public aqq(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    this(paramContext, paramString1, paramString2, paramInt, paramBoolean, paramString3, vg.h);
  }

  public aqq(Context paramContext, String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3, String paramString4)
  {
    this.a = new WeakReference(paramContext);
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramInt;
    this.e = paramBoolean;
    this.f = paramString3;
    this.g = paramString4;
  }

  public static void a(Context paramContext)
  {
    a(paramContext, 0L);
  }

  public static void a(Context paramContext, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return;
    new AsyncTask()
    {
      public Void a(Void[] paramAnonymousArrayOfVoid)
      {
        try
        {
          if (this.a > 0L)
            Thread.sleep(this.a);
          aqq.b(this.b);
          label23: return null;
        }
        catch (Throwable paramAnonymousArrayOfVoid)
        {
          break label23;
        }
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  @TargetApi(9)
  private void b()
  {
    if (this.a.get() == null)
      return;
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder(((Context)this.a.get()).getApplicationInfo().nativeLibraryDir);
      localStringBuilder1.append('/').append("libdaemon.so").append(' ').append(this.b).append(' ').append(this.c).append(' ').append(this.d);
      StringBuilder localStringBuilder2;
      if (Build.VERSION.SDK_INT >= 17)
      {
        long l = ((UserManager)((Context)this.a.get()).getSystemService("user")).getSerialNumberForUser(Process.myUserHandle());
        localStringBuilder1.append(' ').append(l);
        localStringBuilder2 = localStringBuilder1.append(' ');
        if (!this.e)
          break label196;
      }
      label196: for (int i = 1; ; i = 0)
      {
        localStringBuilder2.append(i).append(' ').append(this.f).append(' ').append(this.g);
        ase.a(localStringBuilder1.toString(), false, false);
        return;
        localStringBuilder1.append(" -10000");
        break;
      }
    }
    catch (Throwable localThrowable)
    {
    }
  }

  static void b(Context paramContext)
  {
    ase.a(paramContext.getApplicationInfo().nativeLibraryDir + '/' + "libdaemon.so" + " kill", false, false);
  }

  public void a()
  {
    a(0L);
  }

  public void a(final long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return;
    new AsyncTask()
    {
      public Void a(Void[] paramAnonymousArrayOfVoid)
      {
        try
        {
          if (paramLong > 0L)
            Thread.sleep(paramLong);
          aqq.a(aqq.this);
          label23: return null;
        }
        catch (Throwable paramAnonymousArrayOfVoid)
        {
          break label23;
        }
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aqq
 * JD-Core Version:    0.6.2
 */