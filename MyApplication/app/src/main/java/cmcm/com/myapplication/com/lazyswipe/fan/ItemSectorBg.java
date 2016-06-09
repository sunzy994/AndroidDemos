package cmcm.com.myapplication.com.lazyswipe.fan;

import ahw;
import ahx;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import aqs;
import atw;
import com.lazyswipe.features.guide.NewGuide;
import yb;
import yj;
import yk;

public class ItemSectorBg extends ImageView
{
  public static boolean a = false;
  private static int d = -1;
  private yb b;
  private TransitionDrawable c;
  private final Handler e = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default:
      case 0:
        do
          return;
        while (ItemSectorBg.this.getLayerType() == ItemSectorBg.this.getSuggestLayerType());
        ItemSectorBg.this.setLayerType(ItemSectorBg.this.getSuggestLayerType(), null);
        return;
      case 1:
      }
      if (ItemSectorBg.this.getLayerType() != 0)
        ItemSectorBg.this.setLayerType(0, null);
      ItemSectorBg.this.e();
    }
  };

  public ItemSectorBg(Context paramContext)
  {
    super(paramContext);
  }

  public ItemSectorBg(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ItemSectorBg(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public static boolean d()
  {
    return (Build.VERSION.SDK_INT < 16) || (aqs.l());
  }

  public void a()
  {
    if (this.c != null)
      this.c.resetTransition();
    a = false;
  }

  public void a(int paramInt)
  {
    if (this.c != null)
      this.c.startTransition(paramInt);
    a = true;
  }

  void b()
  {
    this.e.removeMessages(1);
    this.e.sendEmptyMessageDelayed(0, 200L);
  }

  public void b(int paramInt)
  {
    if (this.c != null)
      this.c.reverseTransition(paramInt);
    a = false;
  }

  void c()
  {
    this.e.removeMessages(0);
    this.e.sendEmptyMessageDelayed(1, 200L);
  }

  void e()
  {
    if ((getBackground() instanceof BitmapDrawable))
      atw.a(((BitmapDrawable)getBackground()).getBitmap());
  }

  public void f()
  {
    float f = this.b.getHandTrackRatio();
    setScaleX(f);
    setScaleY(f);
  }

  public void g()
  {
    setScaleX(1.0F);
    setScaleY(1.0F);
    if (this.b.getHandTracker().d())
      b();
  }

  int getSuggestLayerType()
  {
    if (d == -1)
      if (!d())
        break label23;
    label23: for (int i = 1; ; i = 2)
    {
      d = i;
      return d;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.b.n());
    for (float f = 0.0F; ; f = getMeasuredWidth())
    {
      setPivotX(f);
      setPivotY(getMeasuredHeight());
      return;
    }
  }

  void setDirection(boolean paramBoolean)
  {
    while (true)
    {
      int i;
      try
      {
        Object localObject = new Drawable[2];
        ahw localahw = ahx.b(getContext());
        localObject[0] = localahw.b(getContext(), this.b);
        localObject[1] = localahw.a(getContext(), this.b);
        this.c = new TransitionDrawable((Drawable[])localObject);
        if (paramBoolean)
        {
          this.c.setLayerInset(0, 0, localObject[1].getIntrinsicHeight() - localObject[0].getIntrinsicHeight(), localObject[1].getIntrinsicWidth() - localObject[0].getIntrinsicWidth(), 0);
          this.c.setCrossFadeEnabled(true);
          i = localObject[1].getIntrinsicWidth();
          localObject = getLayoutParams();
          if (!(localObject instanceof FrameLayout.LayoutParams))
          {
            setLayoutParams(new FrameLayout.LayoutParams(i, -2));
            localObject = (FrameLayout.LayoutParams)localObject;
            if (!paramBoolean)
              break label296;
            i = 3;
            ((FrameLayout.LayoutParams)localObject).gravity = (i | 0x50);
            setBackgroundDrawable(this.c);
            if (yb.y())
            {
              float f = aqs.ad() / this.c.getIntrinsicWidth();
              if (f < 1.0F)
                yk.a(f);
            }
            if (!NewGuide.j())
              break label302;
            i = 4;
            setVisibility(i);
          }
        }
        else
        {
          this.c.setLayerInset(0, localObject[1].getIntrinsicWidth() - localObject[0].getIntrinsicWidth(), localObject[1].getIntrinsicHeight() - localObject[0].getIntrinsicHeight(), 0, 0);
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.w("Swipe.ItemSectorBg", "Failed to set direction of item sector background", localThrowable);
        return;
      }
      if (i > getContext().getResources().getDisplayMetrics().widthPixels)
      {
        ((FrameLayout.LayoutParams)localThrowable).width = i;
        continue;
        label296: i = 5;
        continue;
        label302: i = 0;
      }
    }
  }

  void setFan(yb paramyb)
  {
    this.b = paramyb;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.fan.ItemSectorBg
 * JD-Core Version:    0.6.2
 */