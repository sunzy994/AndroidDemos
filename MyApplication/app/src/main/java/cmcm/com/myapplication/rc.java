package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.util.SparseBooleanArray;
import java.util.Locale;
import org.json.JSONObject;

public class rc extends AsyncTask<Integer, Void, Void>
{
  private static final String a = "GameSDK." + rc.class.getSimpleName();
  private static volatile SparseBooleanArray b = new SparseBooleanArray(6);
  private Context c;

  rc(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
  }

  public static rc a(Context paramContext)
  {
    return b(paramContext, 1);
  }

  public static rc a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, 1);
  }

  public static rc a(Context paramContext, int paramInt1, int paramInt2)
  {
    return a(paramContext, 3, paramInt1, paramInt2, 20);
  }

  public static rc a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramContext, paramInt1, paramInt2, paramInt3, paramInt4, false);
  }

  public static rc a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i;
    if (paramInt1 == 0)
      i = paramInt2 + 1000;
    while ((1 != paramInt3) && (b.get(i)))
    {
      return null;
      i = paramInt1;
      if (3 == paramInt1)
        i = paramInt2 + 100;
    }
    if (1 == paramInt3)
      b.put(i, true);
    paramContext = new rc(paramContext);
    if (paramBoolean)
    {
      paramContext.b(new Integer[] { Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return null;
    }
    paramContext.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Integer[] { Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    return paramContext;
  }

  public static rc b(Context paramContext)
  {
    return c(paramContext, 1);
  }

  public static rc b(Context paramContext, int paramInt)
  {
    return a(paramContext, 2, 0, paramInt, 20);
  }

  public static rc b(Context paramContext, int paramInt1, int paramInt2)
  {
    return a(paramContext, 0, paramInt1, paramInt2, 20);
  }

  public static rc c(Context paramContext, int paramInt)
  {
    return a(paramContext, 1, 0, paramInt, 20);
  }

  public static rc d(Context paramContext, int paramInt)
  {
    return b(paramContext, paramInt, 1);
  }

  protected Void a(Integer[] paramArrayOfInteger)
  {
    return b(paramArrayOfInteger);
  }

  public Void b(Integer[] paramArrayOfInteger)
  {
    System.currentTimeMillis();
    int n = paramArrayOfInteger[1].intValue();
    int k = paramArrayOfInteger[0].intValue();
    int i;
    if (paramArrayOfInteger.length == 3)
    {
      i = paramArrayOfInteger[2].intValue();
      label34: if (k < 1000)
        break label284;
    }
    label284: label427: for (int j = 0; ; j = k)
    {
      label45: int m;
      switch (j)
      {
      default:
        m = k - 100;
      case 1:
      case 2:
      case 0:
      }
      while (true)
      {
        SharedPreferences localSharedPreferences;
        String str;
        try
        {
          paramArrayOfInteger = qz.b(m, n, i);
          i = m;
          paramArrayOfInteger = new JSONObject(paramArrayOfInteger);
          m = paramArrayOfInteger.optInt("totalPages");
          localSharedPreferences = qy.a(this.c);
          str = String.format(Locale.US, "key_list_page_no_%1$d", new Object[] { Integer.valueOf(k) });
          if (n == 1)
          {
            localSharedPreferences.edit().putInt(str, 1).putInt(String.format(Locale.US, "key_list_page_count_%1$d", new Object[] { Integer.valueOf(k) }), m).putLong(String.format(Locale.US, "key_list_updated_%1$d", new Object[] { Integer.valueOf(k) }), System.currentTimeMillis()).apply();
            rn.a(this.c).a(paramArrayOfInteger, j, i, n);
            switch (j)
            {
            default:
              if (n == 1)
                b.put(k, false);
              return null;
              i = 20;
              break label34;
              if (k < 100)
                break label427;
              j = 3;
              break label45;
              paramArrayOfInteger = qz.a(n, i);
              i = 0;
              continue;
              paramArrayOfInteger = qz.b(n, i);
              i = 0;
              continue;
              m = k - 1000;
              paramArrayOfInteger = qz.a(m, n, i);
              i = m;
              continue;
            case 1:
            case 2:
            }
          }
        }
        catch (Throwable paramArrayOfInteger)
        {
          if (n != 1)
            continue;
          b.put(k, false);
          return null;
        }
        int i1 = localSharedPreferences.getInt(str, 1) + 1;
        if (i1 <= m)
        {
          localSharedPreferences.edit().putInt(str, i1).apply();
          continue;
          sn.a(this.c).a(this.c, null);
        }
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     rc
 * JD-Core Version:    0.6.2
 */