package cmcm.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

public abstract class amo extends ans
{
  protected Intent a;

  public amo(Context paramContext)
  {
    this(paramContext, null);
    s_();
  }

  public amo(Context paramContext, ant paramant)
  {
    super(paramContext, paramant);
    s_();
  }

  public int a(Context paramContext)
  {
    return 1;
  }

  public boolean a(int paramInt)
  {
    return true;
  }

  protected Intent b(Context paramContext)
  {
    return null;
  }

  public int d()
  {
    return 0;
  }

  public String g()
  {
    Object localObject = this.e.getPackageManager();
    try
    {
      localObject = (String)((PackageManager)localObject).resolveActivity(this.a, 0).activityInfo.loadLabel((PackageManager)localObject);
      return localObject;
    }
    catch (Throwable localThrowable)
    {
    }
    return "Calc";
  }

  public boolean h()
  {
    return false;
  }

  public boolean i()
  {
    return asq.d(this.e, this.a);
  }

  protected abstract void s_();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     amo
 * JD-Core Version:    0.6.2
 */