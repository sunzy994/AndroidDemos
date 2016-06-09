package cmcm.com.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.lazyswipe.SwipeApplication;

public class aen
{
  private final aba[] a;
  private aej b;
  private int c;
  private int d;
  private int e;

  private void b(int paramInt)
  {
    if (this.e == paramInt);
    Object localObject1;
    do
    {
      return;
      this.e = paramInt;
      if (this.b != null)
      {
        this.b.b();
        this.b = null;
      }
      localObject1 = this.a;
      int i = localObject1.length;
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = localObject1[paramInt];
        if (localObject2 != null)
          localObject2.f();
        paramInt += 1;
      }
      localObject1 = SwipeApplication.c();
      this.c = 1;
      this.d = 0;
      this.a[0] = new aba((Context)localObject1, this.e);
      this.a[1] = new aba((Context)localObject1, this.e);
    }
    while (1 != this.e);
    this.b = new aej((Context)localObject1, this.e);
  }

  public int a()
  {
    Object localObject = vs.a(SwipeApplication.c());
    int i = asi.a(((SharedPreferences) localObject).getString("key_lucky_category_show_record", "0"), -1);
    if (!abd.l)
    {
      Editor localEditor = ((SharedPreferences)localObject).edit();
      i += 1;
      if (i == 0);
      for (localObject = "1"; ; localObject = String.valueOf(i))
      {
        localEditor.putString("key_lucky_category_show_record", (String)localObject).apply();
        return 1;
      }
    }
    int j = abd.f();
    if ((i >= 0) && (i < j))
    {
      ((SharedPreferences)localObject).edit().putString("key_lucky_category_show_record", String.valueOf(i + 1)).apply();
      return 1;
    }
    return abd.a(1, 1);
  }

  public void a(abp paramabp, int paramInt)
  {
    b(paramInt);
    if (this.b != null)
      this.b.a();
    if (paramabp != null)
    {
      if (!a(paramInt))
      {
        paramInt = this.c;
        this.c = this.d;
        this.d = paramInt;
        this.a[paramInt].e();
      }
      this.a[this.d].a(null);
      this.a[this.c].b(paramabp);
      return;
    }
    this.a[this.d].b(null);
  }

  public void a(aek paramaek)
  {
    try
    {
      this.a[this.c].e();
      label12: if (this.b != null)
        this.b.a(true, paramaek);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label12;
    }
  }

  public void a(Object paramObject)
  {
    if (this.b != null)
      this.b.b(paramObject);
  }

  public boolean a(int paramInt)
  {
    b(paramInt);
    return this.a[this.c].a();
  }

  public void b()
  {
    if (this.b != null)
      this.b.b();
    this.a[this.c].f();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aen
 * JD-Core Version:    0.6.2
 */