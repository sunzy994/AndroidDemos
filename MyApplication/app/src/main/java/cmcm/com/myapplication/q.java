package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class q
{
  private final r<?> a;

  private q(r<?> paramr)
  {
    this.a = paramr;
  }

  public static final q a(r<?> paramr)
  {
    return new q(paramr);
  }

  public View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.a.d.a(paramView, paramString, paramContext, paramAttributeSet);
  }

  public List<k> a(List<k> paramList)
  {
    if (this.a.d.f == null)
      return null;
    Object localObject = paramList;
    if (paramList == null)
      localObject = new ArrayList(b());
    ((List)localObject).addAll(this.a.d.f);
    return localObject;
  }

  public s a()
  {
    return this.a.i();
  }

  public void a(Configuration paramConfiguration)
  {
    this.a.d.a(paramConfiguration);
  }

  public void a(Parcelable paramParcelable, List<k> paramList)
  {
    this.a.d.a(paramParcelable, paramList);
  }

  public void a(df<String, ac> paramdf)
  {
    this.a.a(paramdf);
  }

  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.a.b(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }

  public void a(k paramk)
  {
    this.a.d.a(this.a, this.a, paramk);
  }

  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }

  public boolean a(Menu paramMenu)
  {
    return this.a.d.a(paramMenu);
  }

  public boolean a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    return this.a.d.a(paramMenu, paramMenuInflater);
  }

  public boolean a(MenuItem paramMenuItem)
  {
    return this.a.d.a(paramMenuItem);
  }

  public int b()
  {
    ArrayList localArrayList = this.a.d.f;
    if (localArrayList == null)
      return 0;
    return localArrayList.size();
  }

  public void b(Menu paramMenu)
  {
    this.a.d.b(paramMenu);
  }

  public boolean b(MenuItem paramMenuItem)
  {
    return this.a.d.b(paramMenuItem);
  }

  public void c()
  {
    this.a.d.i();
  }

  public Parcelable d()
  {
    return this.a.d.h();
  }

  public List<k> e()
  {
    return this.a.d.g();
  }

  public void f()
  {
    this.a.d.j();
  }

  public void g()
  {
    this.a.d.k();
  }

  public void h()
  {
    this.a.d.l();
  }

  public void i()
  {
    this.a.d.m();
  }

  public void j()
  {
    this.a.d.n();
  }

  public void k()
  {
    this.a.d.o();
  }

  public void l()
  {
    this.a.d.p();
  }

  public void m()
  {
    this.a.d.r();
  }

  public void n()
  {
    this.a.d.s();
  }

  public boolean o()
  {
    return this.a.d.e();
  }

  public void p()
  {
    this.a.k();
  }

  public void q()
  {
    this.a.l();
  }

  public void r()
  {
    this.a.m();
  }

  public df<String, ac> s()
  {
    return this.a.n();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     q
 * JD-Core Version:    0.6.2
 */