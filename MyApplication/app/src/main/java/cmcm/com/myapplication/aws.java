package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;

public class aws
  implements OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, PopupWindow.OnDismissListener, awu
{
  private final Context a;
  private final LayoutInflater b;
  private awl c;
  private final awo d;
  private final int e;
  private View f;
  private final boolean g;
  private ViewTreeObserver h;
  private awt i;
  private awv j;
  private ViewGroup k;
  private final Handler l = new Handler();

  public aws(Context paramContext, awo paramawo, View paramView, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.d = paramawo;
    this.g = paramBoolean;
    this.e = (paramContext.getResources().getDisplayMetrics().widthPixels * 2 / 3);
    this.f = paramView;
    paramawo.a(this);
  }

  private int a(ListAdapter paramListAdapter)
  {
    int i3 = MeasureSpec.makeMeasureSpec(0, 0);
    int i4 = MeasureSpec.makeMeasureSpec(0, 0);
    int i5 = paramListAdapter.getCount();
    int n = 0;
    int m = 0;
    View localView = null;
    int i1 = 0;
    if (n < i5)
    {
      int i2 = paramListAdapter.getItemViewType(n);
      if (i2 == m)
        break label127;
      localView = null;
      m = i2;
    }
    label127: 
    while (true)
    {
      if (this.k == null)
        this.k = new FrameLayout(this.a);
      localView = paramListAdapter.getView(n, localView, this.k);
      localView.measure(i3, i4);
      i1 = Math.max(i1, localView.getMeasuredWidth());
      n += 1;
      break;
      return i1;
    }
  }

  public void a(Context paramContext, awo paramawo)
  {
  }

  public void a(awo paramawo, boolean paramBoolean)
  {
    if (paramawo != this.d);
    do
    {
      return;
      b();
    }
    while (this.j == null);
    this.j.a(paramawo, paramBoolean);
  }

  public void a(boolean paramBoolean)
  {
    if (this.i != null)
      this.i.notifyDataSetChanged();
  }

  public boolean a()
  {
    int m = 0;
    this.c = new awl(this.a, null, 16843520);
    this.c.a(this);
    this.c.a(this);
    this.i = new awt(this, this.d);
    this.c.a(this.i);
    View localView = this.f;
    if (localView != null)
    {
      if (this.h == null)
        m = 1;
      this.h = localView.getViewTreeObserver();
      if (m != 0)
        this.h.addOnGlobalLayoutListener(this);
      this.c.a(localView);
      this.c.a(Math.min(a(this.i), this.e));
      this.c.a();
      this.c.d().setOnKeyListener(this);
      return true;
    }
    return false;
  }

  public void b()
  {
    if (c())
      this.c.b();
  }

  public boolean c()
  {
    return (this.c != null) && (this.c.c());
  }

  public boolean d()
  {
    return false;
  }

  public void onDismiss()
  {
    this.c = null;
    this.d.d();
    if (this.h != null)
    {
      if (!this.h.isAlive())
        this.h = this.f.getViewTreeObserver();
      this.h.removeGlobalOnLayoutListener(this);
      this.h = null;
    }
  }

  public void onGlobalLayout()
  {
    if (c())
    {
      View localView = this.f;
      if ((localView != null) && (localView.isShown()))
        break label28;
      b();
    }
    label28: 
    while (!c())
      return;
    this.c.a();
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.i;
    awt.a(paramAdapterView).a(paramAdapterView.a(paramInt), 0);
    this.l.post(new Runnable()
    {
      public void run()
      {
        aws.this.b();
      }
    });
  }

  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 1) && (paramInt == 82))
    {
      b();
      return true;
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aws
 * JD-Core Version:    0.6.2
 */