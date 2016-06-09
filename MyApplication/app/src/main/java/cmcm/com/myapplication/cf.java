package cmcm.com.myapplication;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class cf<D>
{
  int a;
  ch<D> b;
  cg<D> c;
  boolean d;
  boolean e;
  boolean f;
  boolean g;
  boolean h;

  public String a(D paramD)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    cs.a(paramD, localStringBuilder);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }

  public final void a()
  {
    this.d = true;
    this.f = false;
    this.e = false;
    b();
  }

  public void a(int paramInt, ch<D> paramch)
  {
    if (this.b != null)
      throw new IllegalStateException("There is already a listener registered");
    this.b = paramch;
    this.a = paramInt;
  }

  public void a(cg<D> paramcg)
  {
    if (this.c != null)
      throw new IllegalStateException("There is already a listener registered");
    this.c = paramcg;
  }

  public void a(ch<D> paramch)
  {
    if (this.b == null)
      throw new IllegalStateException("No listener register");
    if (this.b != paramch)
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    this.b = null;
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(this.a);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(this.b);
    if ((this.d) || (this.g) || (this.h))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(this.d);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(this.g);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(this.h);
    }
    if ((this.e) || (this.f))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(this.e);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(this.f);
    }
  }

  protected void b()
  {
  }

  public void b(cg<D> paramcg)
  {
    if (this.c == null)
      throw new IllegalStateException("No listener register");
    if (this.c != paramcg)
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    this.c = null;
  }

  public void c()
  {
    this.d = false;
    d();
  }

  protected void d()
  {
  }

  public void e()
  {
    f();
    this.f = true;
    this.d = false;
    this.e = false;
    this.g = false;
    this.h = false;
  }

  protected void f()
  {
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    cs.a(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     cf
 * JD-Core Version:    0.6.2
 */