package cmcm.com.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.lazyswipe.SwipeApplication;
import java.lang.ref.WeakReference;

public abstract class aaq
  implements OnDismissListener, OnClickListener
{
  protected static final String a = "Swipe." + aaq.class.getSimpleName();
  protected final aba b = new aba(SwipeApplication.c(), a());
  private boolean c;
  private boolean d;
  private WeakReference<DialogInterface> e;

  public static aaq b()
  {
    switch (aoa.a)
    {
    default:
      return anz.h();
    case 0:
      return anz.h();
    case 1:
    }
    return acp.h();
  }

  private boolean c(Context paramContext)
  {
    boolean bool2 = false;
    int i = a();
    boolean bool1 = bool2;
    if (abd.a(paramContext, i))
    {
      bool1 = bool2;
      if (vs.a(i, false))
        bool1 = true;
    }
    return bool1;
  }

  private void h()
  {
    this.c = false;
    if (d())
    {
      amk.c(SwipeApplication.c(), true);
      vs.e(SwipeApplication.c(), 108);
      this.c = true;
    }
  }

  private void i()
  {
    vs.a(a());
  }

  private void j()
  {
    this.d = false;
    this.b.b();
  }

  private boolean k()
  {
    if (this.c)
      return false;
    return this.d;
  }

  private String l()
  {
    if (yb.o())
      return "扇形开";
    return "扇形关";
  }

  private String m()
  {
    return String.valueOf(a());
  }

  protected abstract int a();

  protected int a(View paramView)
  {
    if (paramView.getResources().getConfiguration().orientation != 2)
      return 0;
    int i = aqs.ae();
    paramView = (ImageView)paramView.findViewById(2131755098);
    i = i - asq.a(80.0F) - asq.a(56.669998F) - asq.a(3.0F);
    if (i > 0)
      paramView.setMaxHeight(i);
    return i;
  }

  protected View a(LayoutInflater paramLayoutInflater)
  {
    return paramLayoutInflater.inflate(g(), null);
  }

  protected void a(abg paramabg)
  {
    paramabg.h.setBackgroundDrawable(asq.u(SwipeApplication.c()));
    paramabg.h.setTextColor(-1);
  }

  public void a(Context paramContext)
  {
    h();
    b(paramContext);
  }

  public void a(DialogInterface paramDialogInterface)
  {
    this.e = new WeakReference(paramDialogInterface);
  }

  public void b(Context paramContext)
  {
    if (!c(paramContext))
      return;
    j();
  }

  public boolean c()
  {
    return this.b.a();
  }

  protected boolean d()
  {
    return false;
  }

  void e()
  {
    if ((this.e != null) && (this.e.get() != null));
    try
    {
      ((DialogInterface)this.e.get()).dismiss();
      label32: this.b.f();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label32;
    }
  }

  public View f()
  {
    if (this.c)
      return null;
    Object localObject = this.b.l();
    if ((localObject == null) || (((abt)localObject).t()) || (!((abt)localObject).s()))
    {
      e();
      return null;
    }
    this.d = true;
    i();
    View localView = a(LayoutInflater.from(SwipeApplication.c()));
    abg localabg = new abg();
    localView.setTag(localabg);
    localabg.a(localView);
    localabg.a((abq)localObject);
    a(localView);
    a(localabg);
    ((abt)localObject).a(localView, new Runnable()
    {
      public void run()
      {
        aaq.this.e();
        yb.p();
        vv.a().a("清理广告点击", aaq.a(aaq.this), aaq.b(aaq.this));
      }
    });
    localObject = ((abt)localObject).w();
    if (localObject != null);
    try
    {
      localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).rightMargin += asq.a(6.0F);
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = asq.a(3.0F);
      label149: vv.a().a("清理广告展示", m(), l());
      return localView;
    }
    catch (Throwable localThrowable)
    {
      break label149;
    }
  }

  protected abstract int g();

  public void onClick(View paramView)
  {
    if (!k())
      e();
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if ((this.c) && (yb.o()))
    {
      yb.getInstance().c();
      amk.c(SwipeApplication.c(), false);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aaq
 * JD-Core Version:    0.6.2
 */