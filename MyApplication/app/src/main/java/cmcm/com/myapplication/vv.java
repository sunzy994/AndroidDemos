package cmcm.com.myapplication;

import android.content.Context;
import android.location.Criteria;
import java.util.HashMap;
import java.util.Map;

public abstract class vv
{
  protected static vv a;
  private static final Object b = new Object();

  public static vv a()
  {
    synchronized (b)
    {
      if (a == null)
        a = new vx();
      return a;
    }
  }

  public void a(long paramLong)
  {
  }

  public void a(Context paramContext)
  {
  }

  public void a(Criteria paramCriteria)
  {
  }

  public void a(String paramString)
  {
  }

  public void a(String paramString1, String paramString2, int paramInt)
  {
    a(paramString1, paramString2, String.valueOf(paramInt));
  }

  public void a(String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put(paramString2, paramString3);
    a(paramString1, localHashMap);
  }

  public void a(String paramString, Map<String, String> paramMap)
  {
  }

  public void a(boolean paramBoolean)
  {
  }

  public void b(Context paramContext)
  {
  }

  public void b(String paramString)
  {
  }

  public void c(Context paramContext)
  {
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     vv
 * JD-Core Version:    0.6.2
 */