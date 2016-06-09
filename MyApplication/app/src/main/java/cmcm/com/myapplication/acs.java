package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.fan.FanItem;
import com.lazyswipe.features.search.SearchWebActivity;

public class acs extends aux
  implements OnClickListener, Runnable
{
  static volatile acs a;
  protected static final int c = asq.a(115.0F);
  protected static final int d = asq.a(31.6F);
  protected static final int e = asq.a(3.0F);
  protected static final int f = asq.a(3.0F);
  private static final String h = "Swipe." + act.class.getSimpleName();
  private String B;
  private PopupWindow.OnDismissListener C;
  private final Paint D = new Paint(7);
  private final RectF E;
  private Uri F;
  private View G;
  private final Runnable H = new Runnable()
  {
    public void run()
    {
      acs.this.d();
    }
  };
  private final Handler I = new Handler();
  private int J;
  private ValueAnimator K;
  protected int b;
  protected View g;
  private TextView i;

  public acs(Context paramContext)
  {
    super(paramContext);
    this.D.setColor(-2147483648);
    this.D.setStyle(Style.FILL_AND_STROKE);
    this.E = new RectF();
  }

  private void a(Canvas paramCanvas)
  {
    float f4 = getHeight();
    float f3 = f4 / 2.0F;
    Object localObject;
    int j;
    float f1;
    if (3 == this.b)
      if (this.E.isEmpty())
      {
        localObject = new Rect();
        getDrawingRect((Rect)localObject);
        this.E.set((Rect)localObject);
        if (this.A)
        {
          localObject = this.E;
          ((RectF)localObject).right -= e * 5;
        }
      }
      else if (this.K != null)
      {
        j = ((Integer)this.K.getAnimatedValue()).intValue();
        if (!this.A)
          break label168;
        f1 = -j;
        label119: paramCanvas.translate(f1, 0.0F);
      }
    while (true)
    {
      paramCanvas.drawRoundRect(this.E, f3, f3, this.D);
      label168: 
      do
      {
        return;
        localObject = this.E;
        ((RectF)localObject).left += e * 5;
        break;
        f1 = j;
        break label119;
      }
      while ((this.i == null) || ((2 == this.b) && (this.G == null)));
      if (2 == this.b)
      {
        f1 = this.G.getLeft();
        label214: if (2 != this.b)
          break label268;
      }
      label268: for (float f2 = this.G.getRight(); ; f2 = this.i.getRight())
      {
        if (!u())
          break label280;
        this.E.set(f1 - f3, 0.0F, f2, f4);
        break;
        f1 = this.i.getLeft();
        break label214;
      }
      label280: this.E.set(f1, 0.0F, f2 + f3, f4);
    }
  }

  public static void a(Uri paramUri)
  {
    if (a == null)
      a = new act(SwipeApplication.c());
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    a.setKeyword(a.getResources().getString(2131231009));
    a.setMode(2);
    a.setData(paramUri);
    a.g();
    a.C = new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (acs.this != null)
          acw.c(acs.this, false);
      }
    };
  }

  public static void a(View paramView, String paramString)
  {
    SwipeApplication localSwipeApplication = SwipeApplication.c();
    acw.e(localSwipeApplication, false);
    if (a == null)
      a = new act(localSwipeApplication);
    a.b(paramView, paramString);
    a.g();
    a.C = new PopupWindow.OnDismissListener()
    {
      public void onDismiss()
      {
        if (yb.getInstance() != null)
          return;
        acw.c(acs.this, false);
      }
    };
    vy.b(localSwipeApplication, "B27");
  }

  public static void a(String paramString, PopupWindow.OnDismissListener paramOnDismissListener)
  {
    if (a == null)
      a = new act(SwipeApplication.c());
    a.setKeyword(paramString);
    a.b();
    a.C = paramOnDismissListener;
  }

  private void b(View paramView, String paramString)
  {
    this.g = paramView;
    this.b = 3;
    this.i.setText(paramString);
  }

  public static void c()
  {
    if (a != null)
      a.o();
    a = null;
  }

  private boolean g()
  {
    if (3 == this.b)
      m();
    boolean bool = super.b();
    n();
    if (3 != this.b)
      m();
    removeCallbacks(this);
    long l;
    if (3 == this.b)
    {
      l = 7000L;
      postDelayed(this, l);
      if (this.b != 1)
        break label85;
      vy.b(getContext(), "B17");
    }
    label85: 
    while (this.b != 2)
    {
      return bool;
      l = 4000L;
      break;
    }
    vy.b(getContext(), "B15");
    return bool;
  }

  private int getIconRes()
  {
    if (this.b == 0)
      return 2130837554;
    return 2130837556;
  }

  private void m()
  {
    if (2 == this.b)
      if (this.F != null);
    int j;
    while (this.g == null)
    {
      return;
      k = (int)(this.k.width * this.o * 1.0F / this.n);
      localObject = this.j.getContext();
      if (this.G != null)
        ast.a((Context) localObject, this.G);
      LinearLayout localLinearLayout = new LinearLayout((Context)localObject);
      this.G = localLinearLayout;
      localLinearLayout.setOrientation(1);
      j = asq.a(2.0F);
      localLinearLayout.setPadding(j, j, j, j);
      ImageView localImageView = new ImageView((Context)localObject);
      localImageView.setScaleType(ScaleType.CENTER_CROP);
      localImageView.setOnClickListener(this);
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
      localLayoutParams.copyFrom(this.k);
      localLayoutParams.height = k;
      if (this.k.y < k);
      for (j = this.k.y + this.k.height; ; j = this.k.y - k)
      {
        localLayoutParams.y = j;
        asv.b(localImageView.animate().alpha(1.0F).setInterpolator(new AccelerateInterpolator()), null);
        localLinearLayout.addView(localImageView, new LinearLayout.LayoutParams(-1, -1));
        ast.a((Context) localObject, this.G, localLayoutParams);
        FanItem.g.a(((Context)localObject).getResources(), localImageView, this.F.toString().substring(7), "null", 2130837743, this.k.width, k, new auc()
        {
          public void a(Drawable paramAnonymousDrawable)
          {
            acs.b(acs.this).postDelayed(acs.a(acs.this), 2000L);
          }
        });
        return;
      }
    }
    int k = getWindowHeight() - (f << 2);
    Object localObject = ((ImageView)this.g).getDrawable();
    int m = (int)(((Drawable)localObject).getIntrinsicWidth() * 1.0F * k / ((Drawable)localObject).getIntrinsicHeight());
    localObject = (FrameLayout.LayoutParams)this.i.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = -2;
    if (this.A)
    {
      ((FrameLayout.LayoutParams)localObject).gravity = 3;
      this.i.setPadding(e * 3, 0, e, 0);
      this.i.setGravity(16);
      j = (int)this.i.getPaint().measureText(this.i.getText().toString()) + e * 4;
      this.J = (j + m + e * 4);
      j();
      setOnClickListener(this);
      this.K = ValueAnimator.ofInt(new int[] { this.J - e - e, 0 });
      this.K.setDuration(1000L);
      this.K.setInterpolator(new OvershootInterpolator());
      this.K.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          acs.this.invalidate();
        }
      });
      this.K.addListener(new asx()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          acs.a(acs.this, null);
        }
      });
      this.K.start();
      this.g.setAlpha(0.0F);
      localObject = new FrameLayout.LayoutParams(m, k, ((FrameLayout.LayoutParams)localObject).gravity | 0x10);
      addView(this.g, (ViewGroup.LayoutParams)localObject);
      if (!this.A)
        break label710;
      label587: localObject = this.g;
      if (j <= 0)
        break label718;
    }
    label710: label718: for (k = 1; ; k = -1)
    {
      ((View)localObject).setTranslationX(k * (m >> 1));
      this.g.animate().alpha(1.0F).translationX(j).setInterpolator(new OvershootInterpolator()).setDuration(1000L).setStartDelay(750L);
      this.i.setAlpha(0.0F);
      this.i.animate().alpha(1.0F).setDuration(400L).setStartDelay(1500L);
      return;
      ((FrameLayout.LayoutParams)localObject).gravity = 5;
      this.i.setPadding(e, 0, e * 3, 0);
      break;
      j = -j;
      break label587;
    }
  }

  private void n()
  {
    if ((this.i == null) || (3 == this.b))
      return;
    if (1 == this.b)
      this.i.setGravity(vj.a | 0x10);
    this.i.setCompoundDrawablesWithIntrinsicBounds(getIconRes(), 0, 0, 0);
  }

  private void setData(Uri paramUri)
  {
    this.F = paramUri;
  }

  private void setKeyword(String paramString)
  {
    this.B = paramString;
    if (this.i != null)
      this.i.setText(paramString);
  }

  private void setMode(int paramInt)
  {
    this.b = paramInt;
    this.i.setGravity(17);
    this.i.setCompoundDrawablePadding(e << 1);
  }

  protected View a()
  {
    this.i = new TextView(getContext());
    this.i.setTextSize(1, 12.0F);
    this.i.setTextColor(-65794);
    this.i.setGravity(17);
    this.i.setSingleLine(true);
    this.i.setMaxEms(10);
    this.i.setEllipsize(TextUtils.TruncateAt.END);
    this.i.setText(this.B);
    this.i.setPadding(e * 2, 0, e * 2, 0);
    this.i.setCompoundDrawablePadding(e);
    return this.i;
  }

  protected void a(int paramInt1, int paramInt2)
  {
    super.a(paramInt1, paramInt2);
    if (this.b == 0)
      vy.a(getContext(), "CX", String.valueOf(2));
    c();
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    onClick(null);
    return true;
  }

  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }

  public boolean b()
  {
    String str = wq.g();
    if (wj.a().d(str));
    for (int j = 1; ; j = 0)
    {
      this.b = j;
      return g();
    }
  }

  public boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.A)
    {
      c();
      return true;
    }
    return false;
  }

  public boolean c(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.A)
    {
      c();
      return true;
    }
    return false;
  }

  void d()
  {
    this.I.removeCallbacksAndMessages(null);
    if (this.G != null)
      asv.b(((ViewGroup) this.G).getChildAt(0).animate().alpha(0.0F).setInterpolator(new AccelerateInterpolator()), new Runnable() {
        public void run() {
          ast.a(acs.c(acs.this).getContext(), acs.c(acs.this));
          acs.a(acs.this, null);
        }
      });
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    a(paramCanvas);
    super.dispatchDraw(paramCanvas);
  }

  protected boolean e()
  {
    return true;
  }

  protected int getDefaultPosition()
  {
    return -40;
  }

  protected int getPaddingX()
  {
    return 0;
  }

  protected String getPositionKey()
  {
    return "key_memory_tip_pos";
  }

  protected int getWindowHeight()
  {
    if (3 == this.b)
      return d;
    return d + f + f;
  }

  protected int getWindowWidth()
  {
    if (3 == this.b);
    for (int j = this.J + e * 4; ; j = c)
      return j + e;
  }

  public void onClick(View paramView)
  {
    if (2 == this.b)
      if (paramView != null)
      {
        vy.a(getContext(), "B16", String.valueOf(3));
        asq.d(getContext(), asq.a(this.F, "image/*"));
      }
    while (true)
    {
      c();
      return;
      vy.a(getContext(), "B16", String.valueOf(2));
      paramView = new Intent("android.intent.action.SEND");
      paramView.putExtra("android.intent.extra.SUBJECT", "");
      paramView.setType("image/*");
      paramView.putExtra("android.intent.extra.STREAM", this.F);
      asq.d(getContext(), paramView);
      continue;
      if (this.b == 0)
      {
        SearchWebActivity.a(getContext(), this.B, 6);
        vy.a(getContext(), "CX", String.valueOf(1));
      }
      else
      {
        vy.a(getContext(), "B18", String.valueOf(2));
        paramView = new Intent("android.intent.action.SEND");
        paramView.putExtra("android.intent.extra.SUBJECT", "");
        paramView.putExtra("android.intent.extra.TEXT", this.B);
        paramView.putExtra("sms_body", this.B);
        paramView.putExtra("desc", this.B);
        paramView.putExtra("Kdescription", this.B);
        paramView.setType("text/plain");
        asq.d(getContext(), paramView);
      }
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this);
    if (this.C != null)
    {
      this.C.onDismiss();
      this.C = null;
    }
    d();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams;
    if (this.g == null)
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.i.getLayoutParams();
      localLayoutParams.width = -2;
      if (2 == this.b)
        localLayoutParams.gravity = 17;
    }
    else
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    if (u());
    for (int j = vj.a; ; j = vj.b)
    {
      localLayoutParams.gravity = j;
      break;
    }
  }

  public void run()
  {
    if (this.b == 0)
      vy.a(getContext(), "CX", String.valueOf(0));
    while (true)
    {
      c();
      return;
      if (this.b == 1)
        vy.a(getContext(), "B18", String.valueOf(1));
      else if (this.b == 2)
        vy.a(getContext(), "B16", String.valueOf(1));
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     acs
 * JD-Core Version:    0.6.2
 */