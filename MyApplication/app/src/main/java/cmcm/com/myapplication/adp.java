package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.features.leap.card.CardFlow;

public abstract class adp extends FrameLayout
  implements OnTouchListener
{
  protected static final String a = "Swipe." + adp.class.getSimpleName();
  public static final int b = SwipeApplication.c().getResources().getDimensionPixelOffset(2131296372);
  public static final int c = SwipeApplication.c().getResources().getDimensionPixelOffset(2131296371);
  protected CardFlow d;
  public Object e;
  public int f;
  public int g;
  private boolean h = true;
  private int i;
  private Paint j;
  private Rect k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private float q;
  private int r;
  private int s;
  private View t;
  private GestureDetector u;

  public adp(Context paramContext)
  {
    this(paramContext, null);
  }

  public adp(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public adp(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    h();
  }

  @TargetApi(21)
  public adp(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    h();
  }

  private void a(Canvas paramCanvas)
  {
    if ((this.j != null) && ((this.f > 0) || (this.g > 0)))
    {
      this.l += this.o;
      this.r -= this.s;
      this.j.setAlpha(this.r);
      paramCanvas.drawCircle(this.f, this.g, this.l, this.j);
    }
    if (k())
    {
      n();
      return;
    }
    m();
  }

  private void h()
  {
    setOnTouchListener(this);
    if (!g())
      return;
    if (Build.VERSION.SDK_INT >= 21)
    {
      setClickable(true);
      setFocusable(true);
      setForeground(getResources().getDrawable(2130837515));
      setBackgroundColor(-1);
      setElevation(asq.a(0.7F));
      return;
    }
    i();
  }

  private void i()
  {
    this.l = 10;
    this.q = 1.0F;
    this.i = getResources().getInteger(17694720);
    this.n = getResources().getColor(2131689472);
    this.r = Color.alpha(this.n);
    j();
    setWillNotDraw(false);
    setDrawingCacheEnabled(true);
    this.k = new Rect(0, 0, b, c);
    this.t = new View(getContext());
    addView(this.t, -1, -1);
    this.u = new GestureDetector(getContext(), new OnGestureListener()
    {
      public boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }

      public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }

      public void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
      }

      public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }

      public void onShowPress(MotionEvent paramAnonymousMotionEvent)
      {
        adp.this.a(paramAnonymousMotionEvent);
      }

      public boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        adp.this.a(paramAnonymousMotionEvent);
        return false;
      }
    });
  }

  private void j()
  {
    this.j = new Paint();
    this.j.setAntiAlias(true);
    this.j.setStyle(Style.FILL);
    this.j.setColor(this.n);
    this.j.setAlpha(this.r);
    this.p = this.r;
  }

  private boolean k()
  {
    return this.l >= this.m;
  }

  private void l()
  {
    int i1 = Math.max(this.f, this.k.width() - this.f);
    int i2 = Math.max(this.g, this.k.height() - this.g);
    double d1 = Math.pow(i1, 2.0D);
    this.m = ((int)(Math.sqrt(Math.pow(i2, 2.0D) + d1) * this.q));
    i1 = this.i / 10;
    this.o = ((this.m - this.l) / i1);
    this.s = (this.r / i1);
  }

  private void m()
  {
    postDelayed(new Runnable()
    {
      public void run()
      {
        adp.this.invalidate();
      }
    }
    , 10L);
  }

  private void n()
  {
    this.g = 0;
    this.f = 0;
    this.l = 10;
    this.r = this.p;
    invalidate();
  }

  public void a()
  {
    if (this.h)
      c();
    this.h = false;
  }

  public void a(Bitmap paramBitmap)
  {
    if (getBitmapView() != null)
      asv.a(getBitmapView(), paramBitmap);
  }

  void a(MotionEvent paramMotionEvent)
  {
    this.t.bringToFront();
    this.f = ((int)paramMotionEvent.getX());
    this.g = ((int)paramMotionEvent.getY());
    l();
    invalidate();
  }

  public void a(Object paramObject)
  {
    this.e = paramObject;
    setTag(2131755008, getBitmapUrl());
  }

  public void b()
  {
  }

  public void c()
  {
  }

  public void d()
  {
    if (this.d != null)
    {
      String str = getBitmapUrl();
      if (str != null)
        this.d.getBitmapLoader().a(str);
    }
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (Build.VERSION.SDK_INT < 21)
      a(paramCanvas);
  }

  public void e()
  {
    Object localObject = getBitmapUrl();
    if (TextUtils.isEmpty((CharSequence)localObject))
      return;
    try
    {
      localObject = new adr(this, (String)localObject);
      ((adr)localObject).a(getBitmapReqWidth(), getBitmapReqHeight());
      this.d.getBitmapLoader().c((atr)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void f()
  {
    if (getBitmapView() != null)
      getBitmapView().setImageDrawable(null);
  }

  public boolean g()
  {
    return false;
  }

  public int getBitmapReqHeight()
  {
    return 0;
  }

  public int getBitmapReqWidth()
  {
    return 0;
  }

  public String getBitmapUrl()
  {
    return "";
  }

  public ImageView getBitmapView()
  {
    return null;
  }

  public abstract adt getCardHolder();

  public String getCardTag()
  {
    return getClass().getSimpleName();
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
    b();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(b, c);
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.u != null)
      return this.u.onTouchEvent(paramMotionEvent);
    if (paramMotionEvent.getAction() == 0)
    {
      this.f = ((int)getX());
      this.g = ((int)getY());
    }
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     adp
 * JD-Core Version:    0.6.2
 */