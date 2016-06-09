package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import com.lazyswipe.features.search.NativeSearchWebView;

public class ags extends azo
{
  private Integer b;
  private float c;

  public ags(NativeSearchWebView paramNativeSearchWebView, Context paramContext)
  {
    super(paramContext);
  }

  public void a()
  {
    this.b = null;
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((NativeSearchWebView.k(this.a)) && (!NativeSearchWebView.m(this.a)))
    {
      if (this.b == null)
      {
        this.b = Integer.valueOf(paramInt2);
        NativeSearchWebView.l(this.a).removeMessages(1);
        NativeSearchWebView.l(this.a).sendEmptyMessageDelayed(1, 500L);
      }
    }
    else
      return;
    if (paramInt2 >= this.b.intValue())
    {
      NativeSearchWebView.l(this.a).sendEmptyMessage(0);
      NativeSearchWebView.l(this.a).removeMessages(1);
    }
    while (true)
    {
      this.b = Integer.valueOf(paramInt2);
      return;
      NativeSearchWebView.l(this.a).sendEmptyMessage(0);
      NativeSearchWebView.l(this.a).removeMessages(1);
      NativeSearchWebView.l(this.a).sendEmptyMessageDelayed(1, 500L);
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    int i;
    if (NativeSearchWebView.k(this.a))
    {
      i = paramMotionEvent.getAction();
      if (i != 0)
        break label56;
      NativeSearchWebView.b(this.a, false);
      NativeSearchWebView.l(this.a).sendEmptyMessage(0);
      this.c = paramMotionEvent.getY();
    }
    label56: 
    do
    {
      do
      {
        return bool;
        if (i == 2)
        {
          NativeSearchWebView.b(this.a, true);
          return bool;
        }
      }
      while ((i != 1) && (i != 3));
      NativeSearchWebView.b(this.a, false);
    }
    while (paramMotionEvent.getY() <= this.c);
    NativeSearchWebView.l(this.a).sendEmptyMessageDelayed(1, 500L);
    return bool;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ags
 * JD-Core Version:    0.6.2
 */