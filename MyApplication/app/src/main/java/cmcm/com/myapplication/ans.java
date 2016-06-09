package cmcm.com.myapplication;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class ans extends BroadcastReceiver
  implements Callback
{
  private boolean a = false;
  private Boolean b = null;
  private Boolean c = null;
  private boolean d = false;
  final Context e;
  protected ant f;
  protected boolean g;
  protected final Handler h;
  protected Dialog i;
  protected int j;
  protected int k;
  protected int l;
  private IntentFilter m;

  public ans(Context paramContext)
  {
    this(paramContext, null);
  }

  public ans(Context paramContext, ant paramant)
  {
    this.e = paramContext;
    this.f = paramant;
    this.h = new Handler(this);
    y();
  }

  public abstract int a(Context paramContext);

  public abstract int a(boolean paramBoolean);

  public Intent a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setClassName(paramString1, paramString2);
    return localIntent;
  }

  protected TextView a(int paramInt, OnClickListener paramOnClickListener)
  {
    return a(this.e.getText(paramInt), paramOnClickListener);
  }

  protected TextView a(CharSequence paramCharSequence, OnClickListener paramOnClickListener)
  {
    TextView localTextView = new TextView(this.e);
    localTextView.setGravity(16);
    localTextView.setText(paramCharSequence);
    localTextView.setTextSize(14.0F);
    localTextView.setTextColor(this.e.getResources().getColor(2131689515));
    localTextView.setOnClickListener(paramOnClickListener);
    return localTextView;
  }

  public String a()
  {
    return null;
  }

  protected void a(Context paramContext, int paramInt)
  {
    boolean bool = l();
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      if ((bool) && (!l()) && (this.d))
        if ((this.c != null) && ((this.b == null) || (!this.c.equals(this.b))))
          a_(true);
      try
      {
        a(paramContext, this.c.booleanValue());
        this.d = false;
        return;
        a_(false);
        this.b = Boolean.valueOf(false);
        continue;
        a_(false);
        this.b = Boolean.valueOf(true);
        continue;
        a_(true);
        this.b = Boolean.valueOf(false);
        continue;
        a_(true);
        this.b = Boolean.valueOf(true);
      }
      catch (Exception paramContext)
      {
        while (true)
          Log.e("Swipe.Tile", "exception", paramContext);
      }
    }
  }

  public void a(Context paramContext, Intent paramIntent)
  {
  }

  public void a(ant paramant)
  {
    this.f = paramant;
  }

  public boolean a(int paramInt)
  {
    return j(this.e);
  }

  public boolean a(Context paramContext, boolean paramBoolean)
  {
    return false;
  }

  public void a_(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  public boolean a_(Context paramContext)
  {
    return true;
  }

  protected Intent b(Context paramContext)
  {
    return null;
  }

  public abstract String b();

  public abstract String b(boolean paramBoolean);

  public abstract int c();

  protected TextView c(int paramInt)
  {
    return null;
  }

  public abstract int d();

  protected void d(boolean paramBoolean)
  {
  }

  public boolean d(Context paramContext)
  {
    boolean bool2 = false;
    switch (h(paramContext))
    {
    case 2:
    case 3:
    case 4:
    default:
      bool1 = false;
      label46: this.c = Boolean.valueOf(bool1);
      if (l())
        this.d = true;
      break;
    case 1:
    case 0:
    case 5:
    }
    for (boolean bool1 = bool2; ; bool1 = a(paramContext, bool1))
    {
      v();
      d(this.c.booleanValue());
      return bool1;
      bool1 = false;
      break label46;
      bool1 = true;
      break label46;
      if (this.c == null)
        break;
      if (!this.c.booleanValue())
      {
        bool1 = true;
        break label46;
      }
      bool1 = false;
      break label46;
      a_(true);
    }
  }

  public int e(Context paramContext)
  {
    return a(j(paramContext));
  }

  public boolean e()
  {
    return true;
  }

  public boolean f()
  {
    return true;
  }

  public String g()
  {
    return this.e.getString(d());
  }

  public final int h(Context paramContext)
  {
    if (l())
      return 5;
    switch (a(paramContext))
    {
    default:
      return 5;
    case 0:
      return 0;
    case 1:
    }
    return 1;
  }

  public boolean h()
  {
    return true;
  }

  public boolean handleMessage(Message paramMessage)
  {
    if (asq.d(this.e));
    do
    {
      return true;
      switch (paramMessage.what)
      {
      default:
        return true;
      case 100:
      case 101:
      }
    }
    while ((!t()) || (this.c == null));
    if (!this.c.booleanValue());
    for (boolean bool = true; ; bool = false)
    {
      this.c = Boolean.valueOf(bool);
      return true;
    }
    y_();
    return true;
  }

  public String i(Context paramContext)
  {
    return b(j(paramContext));
  }

  public boolean i()
  {
    boolean bool1;
    if ((asq.r(this.e)) && (!f()))
    {
      aso.a(this.e, 2131231152, true);
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = d(this.e);
      Intent localIntent = new Intent(w_());
      if (this.c != null)
        localIntent.putExtra("extra.intend_state", this.c.booleanValue());
      this.e.sendBroadcast(localIntent);
      bool1 = bool2;
    }
    while (!bool2);
    asq.t(this.e);
    return bool2;
  }

  protected boolean j(Context paramContext)
  {
    switch (h(paramContext))
    {
    case 0:
    case 2:
    case 3:
    case 4:
    default:
      return false;
    case 1:
      return true;
    case 5:
    }
    return t();
  }

  public boolean k(Context paramContext)
  {
    Intent localIntent = b(paramContext);
    if (localIntent != null)
      try
      {
        if (localIntent.getAction() == null)
          localIntent.setAction("android.intent.action.MAIN");
        localIntent.addFlags(270532608);
        paramContext.startActivity(localIntent);
        asq.t(paramContext);
        return true;
      }
      catch (Exception paramContext)
      {
        Log.e("Swipe.Tile", "start activity error! intent:" + localIntent, paramContext);
      }
    return false;
  }

  public boolean l()
  {
    return this.a;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    while (true)
    {
      String str;
      try
      {
        str = paramIntent.getAction();
        if (asq.a(w_(), str))
        {
          this.c = Boolean.valueOf(paramIntent.getBooleanExtra("extra.intend_state", true));
          this.h.sendEmptyMessageDelayed(100, 10000L);
          this.h.sendEmptyMessage(101);
          return;
        }
        localObject = u();
        if (((List)localObject).size() > 0)
        {
          if (!((List)localObject).contains(str))
            continue;
          a(paramContext, paramIntent);
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        Log.e("Swipe.Tile", "Unexpected error occurs", paramContext);
        return;
      }
      Object localObject = a();
      if ((localObject != null) && (((String)localObject).equals(str)))
        a(paramContext, paramIntent);
    }
  }

  public boolean t()
  {
    return (this.c != null) && (this.c.booleanValue());
  }

  public List<String> u()
  {
    return Collections.EMPTY_LIST;
  }

  public void u_()
  {
    if (this.m == null)
    {
      this.m = new IntentFilter(w_());
      Object localObject = u();
      if (((List)localObject).size() > 0)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.m.addAction(str);
        }
      }
      localObject = a();
      if (localObject != null)
        this.m.addAction((String)localObject);
    }
    this.g = true;
    try
    {
      this.e.registerReceiver(this, this.m);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  public void v()
  {
    Context localContext;
    if (e())
    {
      localContext = this.e;
      if (!this.c.booleanValue())
        break label60;
    }
    label60: for (String str = this.e.getString(2131230992, new Object[] { this.e.getString(d()) }); ; str = this.e.getString(2131230991, new Object[] { this.e.getString(d()) }))
    {
      aso.a(localContext, str, 0, 17);
      return;
    }
  }

  public void v_()
  {
    try
    {
      this.e.unregisterReceiver(this);
      label8: if ((this.i != null) && (this.i.isShowing()))
        this.i.dismiss();
      return;
    }
    catch (Exception localException)
    {
      break label8;
    }
  }

  public boolean w()
  {
    return false;
  }

  protected String w_()
  {
    return getClass().getName() + ".REFRESH";
  }

  public boolean x()
  {
    if (this.i == null)
      return false;
    Object localObject = yb.getLastDownAt();
    yb localyb;
    if (localObject != null)
    {
      localyb = yb.getInstance();
      if (!localyb.n())
        break label106;
    }
    label106: for (int n = Math.min(localyb.getMeasuredWidth() - this.j, ((Point)localObject).x + this.l); ; n = Math.max(0, ((Point)localObject).x - this.l - this.j))
    {
      int i1 = Math.max(0, ((Point)localObject).y - this.k - this.l - this.l);
      localObject = this.i.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).x = n;
      ((WindowManager.LayoutParams)localObject).y = i1;
      this.i.show();
      return true;
    }
  }

  public boolean x_()
  {
    return false;
  }

  protected void y()
  {
    int i1 = z();
    if (i1 > 0)
    {
      this.l = asq.a(32.0F);
      int i2 = asq.a(16.0F);
      int i3 = i2 >> 1;
      int i4 = asq.a(144.0F);
      final LinearLayout localLinearLayout = new LinearLayout(this.e);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setPadding(0, i3, 0, i3);
      Rect localRect = new Rect();
      int i5 = asq.a(32.0F);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, i5);
      int n = 0;
      if (n < i1)
      {
        TextView localTextView = c(n);
        if (localTextView == null);
        while (true)
        {
          n += 1;
          break;
          localTextView.setPadding(i2, 0, i2, 0);
          localTextView.getPaint().getTextBounds(localTextView.getText().toString(), 0, localTextView.getText().length(), localRect);
          this.j = Math.max(localRect.width(), this.j);
          localLinearLayout.addView(localTextView, localLayoutParams);
        }
      }
      this.j += (i2 << 1);
      this.j = Math.max(this.j, i4);
      this.k = ((i3 << 1) + i1 * i5);
      localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(this.j, this.k));
      this.i = new avx(this.e)
      {
        public void a(Dialog paramAnonymousDialog)
        {
          super.a(paramAnonymousDialog);
          int i = 0;
          int j = localLinearLayout.getChildCount();
          while (i < j)
          {
            localLinearLayout.getChildAt(i).setBackgroundDrawable(f());
            i += 1;
          }
        }
      }
      .a(localLinearLayout).a(false).a(51).a();
    }
  }

  public void y_()
  {
    if (this.f != null)
      this.f.s();
  }

  protected int z()
  {
    return 0;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ans
 * JD-Core Version:    0.6.2
 */