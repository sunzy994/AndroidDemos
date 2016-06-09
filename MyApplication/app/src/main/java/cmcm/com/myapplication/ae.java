package cmcm.com.myapplication;

import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class ae extends ac
{
  static boolean a = false;
  final dg<af> b = new dg();
  final dg<af> c = new dg();
  final String d;
  boolean e;
  boolean f;
  private r g;

  ae(String paramString, r paramr, boolean paramBoolean)
  {
    this.d = paramString;
    this.g = paramr;
    this.e = paramBoolean;
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str;
    int i;
    af localaf;
    if (this.b.b() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      str = paramString + "    ";
      i = 0;
      while (i < this.b.b())
      {
        localaf = (af)this.b.b(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.b.a(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localaf.toString());
        localaf.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
    if (this.c.b() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      str = paramString + "    ";
      i = j;
      while (i < this.c.b())
      {
        localaf = (af)this.c.b(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.c.a(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localaf.toString());
        localaf.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
  }

  void a(r paramr)
  {
    this.g = paramr;
  }

  public boolean a()
  {
    int j = this.b.b();
    int i = 0;
    boolean bool2 = false;
    if (i < j)
    {
      af localaf = (af)this.b.b(i);
      if ((localaf.h) && (!localaf.f));
      for (boolean bool1 = true; ; bool1 = false)
      {
        bool2 |= bool1;
        i += 1;
        break;
      }
    }
    return bool2;
  }

  void b()
  {
    if (a)
      Log.v("LoaderManager", "Starting in " + this);
    if (this.e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStart when already started: " + this, localRuntimeException);
    }
    while (true)
    {
      return;
      this.e = true;
      int i = this.b.b() - 1;
      while (i >= 0)
      {
        ((af)this.b.b(i)).a();
        i -= 1;
      }
    }
  }

  void c()
  {
    if (a)
      Log.v("LoaderManager", "Stopping in " + this);
    if (!this.e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStop when not started: " + this, localRuntimeException);
      return;
    }
    int i = this.b.b() - 1;
    while (i >= 0)
    {
      ((af)this.b.b(i)).e();
      i -= 1;
    }
    this.e = false;
  }

  void d()
  {
    if (a)
      Log.v("LoaderManager", "Retaining in " + this);
    if (!this.e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doRetain when not started: " + this, localRuntimeException);
    }
    while (true)
    {
      return;
      this.f = true;
      this.e = false;
      int i = this.b.b() - 1;
      while (i >= 0)
      {
        ((af)this.b.b(i)).b();
        i -= 1;
      }
    }
  }

  void e()
  {
    if (this.f)
    {
      if (a)
        Log.v("LoaderManager", "Finished Retaining in " + this);
      this.f = false;
      int i = this.b.b() - 1;
      while (i >= 0)
      {
        ((af)this.b.b(i)).c();
        i -= 1;
      }
    }
  }

  void f()
  {
    int i = this.b.b() - 1;
    while (i >= 0)
    {
      ((af)this.b.b(i)).k = true;
      i -= 1;
    }
  }

  void g()
  {
    int i = this.b.b() - 1;
    while (i >= 0)
    {
      ((af)this.b.b(i)).d();
      i -= 1;
    }
  }

  void h()
  {
    if (!this.f)
    {
      if (a)
        Log.v("LoaderManager", "Destroying Active in " + this);
      i = this.b.b() - 1;
      while (i >= 0)
      {
        ((af)this.b.b(i)).f();
        i -= 1;
      }
      this.b.c();
    }
    if (a)
      Log.v("LoaderManager", "Destroying Inactive in " + this);
    int i = this.c.b() - 1;
    while (i >= 0)
    {
      ((af)this.c.b(i)).f();
      i -= 1;
    }
    this.c.c();
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    cs.a(this.g, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ae
 * JD-Core Version:    0.6.2
 */