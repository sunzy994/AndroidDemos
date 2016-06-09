package cmcm.com.myapplication;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class agp extends LinearLayout
{
  private agq a;

  public agp(Context paramContext)
  {
    super(paramContext);
  }

  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null)
      this.a.a(paramMotionEvent);
    return super.dispatchTouchEvent(paramMotionEvent);
  }

  public void setOnTouchCallback(agq paramagq)
  {
    this.a = paramagq;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     agp
 * JD-Core Version:    0.6.2
 */