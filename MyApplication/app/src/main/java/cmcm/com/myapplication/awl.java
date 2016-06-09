package cmcm.com.myapplication;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class awl
{
  private final Context a;
  private final PopupWindow b;
  private ListAdapter c;
  private awm d;
  private int e = -2;
  private int f = -2;
  private int g;
  private int h;
  private boolean i;
  private DataSetObserver j;
  private View k;
  private AdapterView.OnItemClickListener l;
  private final Rect m = new Rect();

  public awl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this.a = paramContext;
    this.b = new PopupWindow(paramContext, paramAttributeSet, paramInt);
    this.b.setInputMethodMode(2);
    this.b.setFocusable(true);
  }

  private int e()
  {
    Object localObject;
    if (this.d == null)
    {
      this.d = new awm(this.a);
      this.d.setAdapter(this.c);
      this.d.setOnItemClickListener(this.l);
      this.d.setFocusable(true);
      this.d.setFocusableInTouchMode(true);
      localObject = this.d;
      this.b.setContentView((View)localObject);
    }
    while (true)
    {
      int n = 0;
      localObject = this.b.getBackground();
      if (localObject != null)
      {
        ((Drawable)localObject).getPadding(this.m);
        int i1 = this.m.top + this.m.bottom;
        n = i1;
        if (!this.i)
        {
          this.h = (-this.m.top);
          n = i1;
        }
      }
      return n + this.b.getMaxAvailableHeight(this.k, this.h);
      localObject = (ViewGroup)this.b.getContentView();
    }
  }

  public void a()
  {
    int i1 = -1;
    int i2 = e();
    int n;
    if (this.b.isShowing())
    {
      if (this.f == -1)
      {
        n = -1;
        if (this.e != -1)
          break label121;
        PopupWindow localPopupWindow = this.b;
        if (this.f != -1)
          break label116;
        label49: localPopupWindow.setWindowLayoutMode(i1, 0);
        i1 = i2;
      }
      while (true)
      {
        this.b.setOutsideTouchable(true);
        this.b.update(this.k, this.g, this.h, n, i1);
        return;
        if (this.f == -2)
        {
          n = this.k.getWidth();
          break;
        }
        n = this.f;
        break;
        label116: i1 = 0;
        break label49;
        label121: if (this.e == -2)
          i1 = -2;
        else
          i1 = this.e;
      }
    }
    if (this.f == -1)
    {
      n = -1;
      if (this.e != -1)
        break label243;
    }
    while (true)
    {
      this.b.setWindowLayoutMode(n, i1);
      this.b.setOutsideTouchable(true);
      this.b.showAsDropDown(this.k, this.g, this.h);
      return;
      if (this.f == -2)
      {
        this.b.setWidth(this.k.getWidth());
        n = 0;
        break;
      }
      this.b.setWidth(this.f);
      n = 0;
      break;
      label243: if (this.e == -2)
      {
        i1 = -2;
      }
      else
      {
        this.b.setHeight(this.e);
        i1 = 0;
      }
    }
  }

  public void a(int paramInt)
  {
    Drawable localDrawable = this.b.getBackground();
    if (localDrawable != null)
    {
      localDrawable.getPadding(this.m);
      this.f = (this.m.left + this.m.right + paramInt);
      return;
    }
    this.f = paramInt;
  }

  public void a(View paramView)
  {
    this.k = paramView;
  }

  public void a(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.l = paramOnItemClickListener;
  }

  public void a(ListAdapter paramListAdapter)
  {
    if (this.j == null)
      this.j = new awn(this, null);
    while (true)
    {
      this.c = paramListAdapter;
      if (this.c != null)
        paramListAdapter.registerDataSetObserver(this.j);
      if (this.d != null)
        this.d.setAdapter(this.c);
      return;
      if (this.c != null)
        this.c.unregisterDataSetObserver(this.j);
    }
  }

  public void a(OnDismissListener paramOnDismissListener)
  {
    this.b.setOnDismissListener(paramOnDismissListener);
  }

  public void b()
  {
    this.b.dismiss();
  }

  public boolean c()
  {
    return this.b.isShowing();
  }

  public ListView d()
  {
    return this.d;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     awl
 * JD-Core Version:    0.6.2
 */