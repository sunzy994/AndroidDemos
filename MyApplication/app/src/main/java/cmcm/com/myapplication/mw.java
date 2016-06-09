package cmcm.com.myapplication;

import android.content.Context;
import android.text.TextUtils;
import com.duapps.ad.a.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class mw
{
  static final String a = mw.class.getSimpleName();
  public static final String b;
  private static mw c;
  private static final ThreadFactory d;
  private final PriorityBlockingQueue e = new PriorityBlockingQueue(20);
  private HashSet f = new HashSet();
  private Context g;
  private ThreadPoolExecutor h;

  static
  {
    String str = System.getProperty("http.agent");
    if (TextUtils.isEmpty(str));
    for (b = "dianxinosdxbs/3.2 (Linux; Android; Tapas OTA) Mozilla/5.0 (X11; U; Linux x86_64; en-US; rv:1.9.2.18) Gecko/20110628 Ubuntu/10.04 (lucid) Firefox/3.6.18"; ; b = str)
    {
      d = new mx();
      return;
    }
  }

  private mw(Context paramContext)
  {
    this.g = paramContext;
    this.h = new ThreadPoolExecutor(5, 5, 1L, TimeUnit.MINUTES, this.e, d);
  }

  public static List a(Context paramContext, List paramList)
  {
    paramContext = oe.a(paramContext);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if ((a.a(locala)) && (paramContext.b(locala.f) == 2))
        localIterator.remove();
    }
    return paramList;
  }

  public static mw a(Context paramContext)
  {
    try
    {
      if (c == null)
        c = new mw(paramContext.getApplicationContext());
      return c;
    }
    finally
    {
    }
    throw paramContext;
  }

  public final mz a(String paramString)
  {
    return oe.a(this.g).a(paramString);
  }

  final void a(a parama, int paramInt1, int paramInt2, long paramLong)
  {
    nr.a(this.g, parama, paramInt1, paramInt2, paramLong);
  }

  public final boolean a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (a)paramList.next();
      if (!np.a(this.g, ((a) localObject).c))
      {
        Context localContext = this.g;
        if ((a.a((a)localObject)) && (!nz.a(((a) localObject).f)))
          if (this.f.contains(((a)localObject).f))
          {
            mv.c(a, "Task already Running.");
          }
          else
          {
            localObject = new my(this, (a)localObject);
            if (this.e.contains(localObject))
              mv.c(a, "Task already in Queue");
            else
              this.h.execute((Runnable)localObject);
          }
      }
    }
    return true;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     mw
 * JD-Core Version:    0.6.2
 */