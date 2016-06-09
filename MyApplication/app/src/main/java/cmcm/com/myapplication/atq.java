package cmcm.com.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class atq
  implements Callback, aut
{
  public final Handler a;
  private att b;
  private atu c;
  private final Map<String, atr> d = new ConcurrentHashMap();
  private final Map<String, List<atr>> e = new ConcurrentHashMap();
  private String f;
  private boolean g;
  private final aup h;
  private final WeakReference<Context> i;

  public atq(Context paramContext)
  {
    this.i = new WeakReference(paramContext);
    this.h = aup.a(paramContext, this);
    this.a = new Handler(Looper.getMainLooper(), this);
  }

  public static atq a(Context paramContext, String paramString, att paramatt)
  {
    return a(paramContext, paramString, paramatt, false);
  }

  public static atq a(Context paramContext, String paramString, att paramatt, boolean paramBoolean)
  {
    paramContext = new atq(paramContext);
    paramContext.a(paramatt);
    paramContext.b(paramString);
    paramContext.g = paramBoolean;
    return paramContext;
  }

  private void a(int paramInt, atr paramatr)
  {
    Message localMessage = this.a.obtainMessage();
    localMessage.obj = paramatr;
    localMessage.what = paramInt;
    localMessage.sendToTarget();
  }

  public static boolean a(atq paramatq)
  {
    if (paramatq == null)
      return false;
    paramatq.a();
    paramatq.b();
    return true;
  }

  private File d(atr paramatr)
  {
    String str = paramatr.c();
    if (!TextUtils.isEmpty(str))
      return new File(str, paramatr.d());
    return new File(this.f, paramatr.d());
  }

  public atr a(atr paramatr)
  {
    atr localatr = b(paramatr);
    if (localatr != null)
      return localatr;
    return c(paramatr);
  }

  public void a()
  {
    int j = this.d.size();
    String[] arrayOfString;
    if (j > 0)
      arrayOfString = new String[j];
    try
    {
      this.d.keySet().toArray(arrayOfString);
      this.h.a(arrayOfString);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void a(att paramatt)
  {
    this.b = paramatt;
  }

  public void a(atu paramatu)
  {
    this.c = paramatu;
  }

  public void a(String paramString)
  {
    this.d.remove(paramString);
    this.e.remove(paramString);
  }

  public void a(String paramString1, String paramString2, Bitmap paramBitmap)
  {
    paramString1 = (atr)this.d.remove(paramString1);
    if (paramString1 != null)
    {
      paramString1.e = paramBitmap;
      a(2, paramString1);
    }
  }

  public atr b(atr paramatr)
  {
    Object localObject;
    if (this.c != null)
    {
      localObject = this.c.a(paramatr.a());
      if (atw.b((Bitmap) localObject))
      {
        paramatr.e = ((Bitmap)localObject);
        return paramatr;
      }
    }
    if (paramatr.e() != null)
    {
      localObject = paramatr.e().a();
      if (atw.b((Bitmap) localObject))
      {
        paramatr.e = ((Bitmap)localObject);
        return paramatr;
      }
    }
    if (this.g)
      try
      {
        localObject = d(paramatr).getAbsolutePath();
        if ((paramatr.f > 0) && (paramatr.g > 0))
        {
          paramatr.e = atw.a((String) localObject, paramatr.f, paramatr.g, false);
          return paramatr;
        }
        paramatr.e = BitmapFactory.decodeFile((String)localObject);
        return paramatr;
      }
      catch (Throwable paramatr)
      {
      }
    return null;
  }

  public void b()
  {
    this.h.a();
  }

  public void b(String paramString)
  {
    this.f = paramString;
  }

  public atr c(atr paramatr)
  {
    String str = paramatr.a();
    File localFile = d(paramatr);
    if (this.d.containsKey(str))
    {
      List localList = (List)this.e.get(str);
      Object localObject = localList;
      if (localList == null)
      {
        localObject = new ArrayList(1);
        this.e.put(str, localObject);
      }
      ((List)localObject).add(paramatr);
    }
    while (true)
    {
      paramatr = this.h.a(str, localFile.getAbsolutePath(), true, paramatr.f, paramatr.g);
      if (paramatr != null)
        a(str, localFile.getAbsolutePath(), paramatr);
      return null;
      this.d.put(str, paramatr);
    }
  }

  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1 = (atr)paramMessage.obj;
    switch (paramMessage.what)
    {
    default:
    case 2:
    }
    while (true)
    {
      return true;
      Object localObject2;
      if (atw.b(((atr) localObject1).e))
      {
        if (this.c != null)
          this.c.c((atr)localObject1);
        ((atr)localObject1).b();
        if (this.b != null)
          this.b.a((atr)localObject1);
        paramMessage = (List)this.e.remove(((atr)localObject1).a());
        if (paramMessage != null)
        {
          localObject2 = paramMessage.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            atr localatr = (atr)((Iterator)localObject2).next();
            localatr.e = ((atr)localObject1).e;
            localatr.b();
            if (this.b != null)
              this.b.a(localatr);
          }
          paramMessage.clear();
        }
      }
      else
      {
        if (this.b != null)
          this.b.b((atr)localObject1);
        paramMessage = (List)this.e.remove(((atr)localObject1).a());
        if (paramMessage != null)
        {
          localObject1 = paramMessage.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (atr)((Iterator)localObject1).next();
            if (this.b != null)
              this.b.b((atr)localObject2);
          }
          paramMessage.clear();
        }
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     atq
 * JD-Core Version:    0.6.2
 */