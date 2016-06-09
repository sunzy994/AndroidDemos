package cmcm.com.myapplication;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import com.lazyswipe.features.search.SearchWebView;

public class ahg extends azo
{
  private Integer b;
  private float c;

  public ahg(SearchWebView paramSearchWebView, Context paramContext)
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
    if ((SearchWebView.q(this.a)) && (!SearchWebView.s(this.a)))
    {
      if (this.b == null)
      {
        this.b = Integer.valueOf(paramInt2);
        SearchWebView.r(this.a).removeMessages(1);
        SearchWebView.r(this.a).sendEmptyMessageDelayed(1, 500L);
      }
    }
    else
      return;
    if (paramInt2 >= this.b.intValue())
    {
      SearchWebView.r(this.a).sendEmptyMessage(0);
      SearchWebView.r(this.a).removeMessages(1);
    }
    while (true)
    {
      this.b = Integer.valueOf(paramInt2);
      return;
      SearchWebView.r(this.a).sendEmptyMessage(0);
      SearchWebView.r(this.a).removeMessages(1);
      SearchWebView.r(this.a).sendEmptyMessageDelayed(1, 500L);
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if ((!SearchWebView.q(this.a)) || (SearchWebView.a(this.a, SearchWebView.c(this.a))));
    do
    {
      int i;
      do
      {
        return bool;
        i = paramMotionEvent.getAction();
        if (i == 0)
        {
          SearchWebView.b(this.a, false);
          SearchWebView.r(this.a).sendEmptyMessage(0);
          this.c = paramMotionEvent.getY();
          return bool;
        }
        if (i == 2)
        {
          SearchWebView.b(this.a, true);
          return bool;
        }
      }
      while ((i != 1) && (i != 3));
      SearchWebView.b(this.a, false);
    }
    while (paramMotionEvent.getY() <= this.c);
    SearchWebView.r(this.a).sendEmptyMessageDelayed(1, 500L);
    return bool;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahg
 * JD-Core Version:    0.6.2
 */