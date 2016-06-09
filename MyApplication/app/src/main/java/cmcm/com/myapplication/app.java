package cmcm.com.myapplication;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.widget.GridGallery;
import com.lazyswipe.widget.HorizontalGridList;

public class app extends RelativeLayout
  implements OnClickListener, avm
{
  public int a;
  public boolean[] b;
  public boolean[] c;
  public int d;
  public int e;
  public TextView f;
  public HorizontalGridList g;
  public apr h;
  protected Intent i;
  public PendingIntent j;
  public PendingIntent k;

  public app(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public static void a(Context paramContext, Intent paramIntent)
  {
    new apo(paramContext).a(paramIntent).b();
  }

  public static int c(boolean paramBoolean)
  {
    if (paramBoolean)
      return 2130968580;
    return 2130968581;
  }

  private void m()
  {
    ColorStateList localColorStateList = getResources().getColorStateList(2131689564);
    Object localObject = getResources().getColorStateList(2131689565);
    TextView localTextView = (TextView)findViewById(2131755365);
    localTextView.setOnClickListener(this);
    localTextView.setTextColor((ColorStateList)localObject);
    localTextView.setBackgroundDrawable(getResources().getDrawable(2130837550));
    localObject = (TextView)findViewById(2131755363);
    ((TextView)localObject).setOnClickListener(this);
    ((TextView)localObject).setTextColor(localColorStateList);
    ((TextView)localObject).setBackgroundDrawable(getResources().getDrawable(2130837550));
  }

  public void a()
  {
  }

  public void a(int paramInt)
  {
    this.f.setText(paramInt);
  }

  public void a(int paramInt, float paramFloat)
  {
  }

  protected void a(View paramView)
  {
    int m = 1;
    int n = ((Integer)paramView.getTag()).intValue();
    boolean bool = ((FanItem)paramView).b();
    if ((this.d > 0) && (this.e >= this.d) && (!bool))
      return;
    if (!bool)
    {
      bool = true;
      label54: ((FanItem)paramView).setChecked(bool);
      this.b[n] = bool;
      n = this.e;
      if (!bool)
        break label106;
    }
    while (true)
    {
      this.e = (n + m);
      if (this.d <= 0)
        break;
      l();
      return;
      bool = false;
      break label54;
      label106: m = -1;
    }
  }

  public void a(FanItem paramFanItem)
  {
  }

  public void a(FanItem paramFanItem, int paramInt)
  {
    paramFanItem.setChecked(this.b[paramInt]);
    paramFanItem.setTag(Integer.valueOf(paramInt));
  }

  public void a(boolean paramBoolean)
  {
  }

  public void b()
  {
  }

  public void b(boolean paramBoolean)
  {
  }

  public void c()
  {
    this.b = new boolean[this.a];
    this.c = new boolean[this.a];
  }

  public void d()
  {
    m();
    if (this.d > 0)
      l();
  }

  public boolean e()
  {
    return false;
  }

  public void f()
  {
    this.g = ((HorizontalGridList)findViewById(2131755055));
    this.g.getGridGallery().setOnScrollListener(this);
    this.f = ((TextView)findViewById(2131755369));
    this.g.setOnItemClickListener(this);
    this.g.setAdapter(getAdapter());
    d();
    try
    {
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void g()
  {
  }

  protected avp getAdapter()
  {
    return new apq(this, this.g);
  }

  public PendingIntent getCancelAction()
  {
    return this.k;
  }

  public int getChosenCount()
  {
    int m = 0;
    int i1;
    for (int n = 0; m < this.a; n = i1)
    {
      i1 = n;
      if (this.b[m] != 0)
        i1 = n + 1;
      m += 1;
    }
    return n;
  }

  public Intent getIntent()
  {
    return this.i;
  }

  public PendingIntent getOkAction()
  {
    return this.j;
  }

  public void h()
  {
  }

  public void i()
  {
  }

  public void j()
  {
  }

  protected void k()
  {
  }

  public void l()
  {
    this.f.setText(getResources().getString(2131231108, new Object[] { Integer.valueOf(this.e), Integer.valueOf(this.d) }));
  }

  public void onClick(View paramView)
  {
    try
    {
      if ((paramView instanceof FanItem))
      {
        a(paramView);
        return;
      }
      switch (paramView.getId())
      {
      case 2131755363:
        k();
        if (this.h == null)
          break label97;
        this.h.h();
        return;
      case 2131755365:
      case 2131755364:
      }
    }
    catch (Throwable paramView)
    {
      asp.a("Swipe.MultiChooserPanel", "Error occurred when handling onClick", paramView);
      return;
    }
    boolean bool = e();
    if (this.h != null)
      this.h.b(bool);
    label97: return;
  }

  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.g.a(getAdapter(), getResources().getInteger(2131361793), getResources().getInteger(2131361792));
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(getResources().getDimensionPixelOffset(2131296268), getResources().getDimensionPixelOffset(2131296264));
  }

  public void setIntent(Intent paramIntent)
  {
    this.i = paramIntent;
  }

  public void setMultiChooserCallBack(apr paramapr)
  {
    this.h = paramapr;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     app
 * JD-Core Version:    0.6.2
 */