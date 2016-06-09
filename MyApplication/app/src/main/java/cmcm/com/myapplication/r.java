package cmcm.com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class r<E> extends p
{
  private final Activity a;
  final Context b;
  final int c;
  public final u d = new u();
  private final Handler e;
  private df<String, ac> f;
  private boolean g;
  private ae h;
  private boolean i;
  private boolean j;

  r(Activity paramActivity, Context paramContext, Handler paramHandler, int paramInt)
  {
    this.a = paramActivity;
    this.b = paramContext;
    this.e = paramHandler;
    this.c = paramInt;
  }

  r(m paramm)
  {
    this(paramm, paramm, paramm.a, 0);
  }

  ae a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.f == null)
      this.f = new df();
    ae localae = (ae)this.f.get(paramString);
    if (localae == null)
    {
      if (paramBoolean2)
      {
        localae = new ae(paramString, this, paramBoolean1);
        this.f.put(paramString, localae);
      }
      return localae;
    }
    localae.a(this);
    return localae;
  }

  public View a(int paramInt)
  {
    return null;
  }

  void a(df<String, ac> paramdf)
  {
    this.f = paramdf;
  }

  void a(String paramString)
  {
    if (this.f != null)
    {
      ae localae = (ae)this.f.get(paramString);
      if ((localae != null) && (!localae.f))
      {
        localae.h();
        this.f.remove(paramString);
      }
    }
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
  }

  void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    if (this.h == null);
    while (!this.j)
      return;
    this.j = false;
    if (paramBoolean)
    {
      this.h.d();
      return;
    }
    this.h.c();
  }

  public boolean a()
  {
    return true;
  }

  public boolean a(k paramk)
  {
    return true;
  }

  public LayoutInflater b()
  {
    return (LayoutInflater)this.b.getSystemService("layout_inflater");
  }

  void b(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.j);
    if (this.h != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.h)));
      paramPrintWriter.println(":");
      this.h.a(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }

  void b(k paramk)
  {
  }

  public void c()
  {
  }

  public boolean d()
  {
    return true;
  }

  public int e()
  {
    return this.c;
  }

  Activity f()
  {
    return this.a;
  }

  public Context g()
  {
    return this.b;
  }

  Handler h()
  {
    return this.e;
  }

  u i()
  {
    return this.d;
  }

  boolean j()
  {
    return this.g;
  }

  void k()
  {
    if (this.j)
      return;
    this.j = true;
    if (this.h != null)
      this.h.b();
    while (true)
    {
      this.i = true;
      return;
      if (!this.i)
      {
        this.h = a("(root)", this.j, false);
        if ((this.h != null) && (!this.h.e))
          this.h.b();
      }
    }
  }

  void l()
  {
    if (this.h == null)
      return;
    this.h.h();
  }

  void m()
  {
    if (this.f != null)
    {
      int m = this.f.size();
      ae[] arrayOfae = new ae[m];
      int k = m - 1;
      while (k >= 0)
      {
        arrayOfae[k] = ((ae)this.f.c(k));
        k -= 1;
      }
      k = 0;
      while (k < m)
      {
        ae localae = arrayOfae[k];
        localae.e();
        localae.g();
        k += 1;
      }
    }
  }

  df<String, ac> n()
  {
    int m = 0;
    int n;
    if (this.f != null)
    {
      int i1 = this.f.size();
      ae[] arrayOfae = new ae[i1];
      int k = i1 - 1;
      while (k >= 0)
      {
        arrayOfae[k] = ((ae)this.f.c(k));
        k -= 1;
      }
      k = 0;
      n = k;
      if (m < i1)
      {
        ae localae = arrayOfae[m];
        if (localae.f)
          k = 1;
        while (true)
        {
          m += 1;
          break;
          localae.h();
          this.f.remove(localae.d);
        }
      }
    }
    else
    {
      n = 0;
    }
    if (n != 0)
      return this.f;
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     r
 * JD-Core Version:    0.6.2
 */