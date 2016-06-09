package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.SwipeService;
import com.lazyswipe.notification.NotificationData;
import com.lazyswipe.ui.NotificationSettingsFragment;

public class alx extends auv
  implements Callback, vo, wr
{
  private static final String h = "Swipe." + alx.class.getSimpleName();
  private static volatile alx i;
  private Handler A;
  private NotificationData B;
  private ValueAnimator C;
  private Interpolator D;
  private TextView E;
  private final Runnable F = new Runnable()
  {
    public void run()
    {
      Context localContext = alx.this.getContext();
      if (alx.this.a)
      {
        alo.a(localContext, 0L, alx.a(alx.this).q);
        return;
      }
      alo.a(localContext, alx.a(alx.this));
    }
  };
  boolean a;
  volatile long b;
  volatile String c;
  volatile boolean d;
  volatile boolean e;
  volatile boolean f;
  boolean g;
  private int y;
  private int z;

  public alx(Context paramContext)
  {
    super(paramContext);
    t();
  }

  public static alx a(Context paramContext)
  {
    try
    {
      if (i == null)
        a(paramContext, vs.b(paramContext));
      paramContext = i;
      return paramContext;
    }
    finally
    {
    }
    throw paramContext;
  }

  public static alx a(Context paramContext, int paramInt)
  {
    boolean bool = true;
    try
    {
      if ((i == null) && (paramInt != 3))
      {
        i = new alx(paramContext);
        paramContext = wq.b();
        if (paramContext != null)
          paramContext.a(i);
        paramContext = SwipeService.e();
        if (paramContext != null)
          paramContext.b(i);
      }
      if (i != null)
      {
        paramContext = i;
        if (1 != paramInt)
          break label86;
      }
      while (true)
      {
        paramContext.g = bool;
        paramContext = i;
        return paramContext;
        label86: bool = false;
      }
    }
    finally
    {
    }
    throw paramContext;
  }

  public static void a(NotificationData paramNotificationData)
  {
    if ((i == null) || (amk.b(SwipeApplication.c())))
      return;
    i.c(paramNotificationData);
  }

  public static void c()
  {
    try
    {
      Object localObject1 = i;
      if (localObject1 == null);
      while (true)
      {
        return;
        localObject1 = wq.b();
        if (localObject1 != null)
          ((wq)localObject1).b(i);
        localObject1 = SwipeService.e();
        if (localObject1 != null)
          ((vm)localObject1).a(i);
        i.m();
        i = null;
      }
    }
    finally
    {
    }
  }

  private void d(NotificationData paramNotificationData)
  {
    boolean bool = true;
    if (paramNotificationData != null);
    try
    {
      this.B = paramNotificationData;
      if (this.B.l.length() <= 1);
      while (true)
      {
        this.a = bool;
        if ((this.B.l.equals(this.c)) || ((this.a) && (asl.g(getContext()).equals(this.c))))
        {
          this.b = this.B.e;
          return;
        }
        if (this.f)
        {
          this.e = true;
          return;
        }
        if (!aft.e(this.c))
        {
          this.b = this.B.e;
          b(this.B);
          return;
        }
        this.d = true;
        return;
        m();
        return;
        bool = false;
      }
    }
    catch (Throwable paramNotificationData)
    {
    }
  }

  public static void g()
  {
    if ((i == null) || (!i.isShown()))
      return;
    i.n();
  }

  public static alx getInstance()
  {
    return i;
  }

  private void t()
  {
    this.A = new Handler(this);
    this.b = 0L;
    this.D = new AccelerateInterpolator();
  }

  private void u()
  {
    this.A.removeMessages(1);
  }

  private void v()
  {
    a(0, new Runnable()
    {
      public void run()
      {
        try
        {
          if (alx.this.a);
          for (String str = asl.g(alx.this.getContext()); ; str = alx.a(alx.this).l)
          {
            SwipeService.a(str, true);
            return;
          }
        }
        catch (Throwable localThrowable)
        {
        }
      }
    });
  }

  protected View a()
  {
    Resources localResources = getResources();
    setBackgroundDrawable(auh.a(localResources.getColor(2131689533), localResources.getDimensionPixelSize(2131296378)));
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setGravity(16);
    localLinearLayout.setOrientation(0);
    this.E = new TextView(getContext());
    this.E.setMaxLines(2);
    this.E.setGravity(vj.a | 0x10);
    this.z = localResources.getDimensionPixelSize(2131296384);
    int j = localResources.getDimensionPixelSize(2131296383);
    int k = this.k.height - this.z >> 1;
    this.E.setPadding(j, k, j, k);
    this.E.setCompoundDrawablePadding(localResources.getDimensionPixelSize(2131296380));
    this.E.setTextColor(localResources.getColor(2131689534));
    this.E.setTextSize(0, localResources.getDimensionPixelSize(2131296386));
    localLinearLayout.addView(this.E, new LinearLayout.LayoutParams(0, -2, 1.0F));
    ImageView localImageView = new ImageView(getContext());
    localImageView.setImageResource(2130837676);
    localImageView.setOnClickListener(new OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        alx.this.m();
        NotificationSettingsFragment.a(alx.this.getContext().getApplicationContext());
      }
    });
    j = localResources.getDimensionPixelSize(2131296385);
    localImageView.setPadding(j, j, j, j);
    localLinearLayout.addView(localImageView, -2, -2);
    return localLinearLayout;
  }

  void a(int paramInt)
  {
    a(paramInt, null);
  }

  void a(int paramInt, final Runnable paramRunnable)
  {
    this.A.removeCallbacksAndMessages(null);
    if (!isShown())
      return;
    Object localObject;
    if (paramInt == 0)
    {
      localObject = SwipeService.i();
      if ((localObject != null) && (((SwipeService)localObject).e != null) && (((SwipeService)localObject).e.j()))
        paramInt = 3;
    }
    while (true)
    {
      switch (paramInt)
      {
      default:
        localObject = PropertyValuesHolder.ofInt("y", new int[] { this.k.y, this.k.y + this.k.height });
      case 3:
      case 4:
      }
      while (true)
      {
        if (this.C != null)
        {
          this.C.removeAllUpdateListeners();
          this.C.removeAllListeners();
          if (this.C.isRunning())
            this.C.end();
        }
        this.C = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject, PropertyValuesHolder.ofFloat("alpha", new float[] { getAlpha(), 0.0F }) });
        this.C.setInterpolator(this.D);
        this.C.addUpdateListener(new AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue("alpha")).floatValue();
            alx.e(alx.this).alpha = f;
            Object localObject = paramAnonymousValueAnimator.getAnimatedValue("x");
            if (localObject != null)
              alx.f(alx.this).x = ((Integer)localObject).intValue();
            paramAnonymousValueAnimator = paramAnonymousValueAnimator.getAnimatedValue("y");
            if (paramAnonymousValueAnimator != null)
              alx.g(alx.this).y = ((Integer)paramAnonymousValueAnimator).intValue();
            alx.h(alx.this);
          }
        });
        this.C.addListener(new AnimatorListener()
        {
          public void onAnimationCancel(Animator paramAnonymousAnimator)
          {
          }

          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            if (paramRunnable != null)
              paramRunnable.run();
            alx.this.o();
          }

          public void onAnimationRepeat(Animator paramAnonymousAnimator)
          {
          }

          public void onAnimationStart(Animator paramAnonymousAnimator)
          {
          }
        });
        this.C.start();
        return;
        paramInt = 4;
        break;
        localObject = PropertyValuesHolder.ofInt("x", new int[] { this.k.x, this.k.x - this.k.width });
        continue;
        localObject = PropertyValuesHolder.ofInt("x", new int[] { this.k.x, this.k.x + this.k.width });
      }
    }
  }

  public void a(ComponentName paramComponentName)
  {
    this.c = paramComponentName.getPackageName();
    if ((this.d) && (!aft.e(this.c)))
    {
      this.d = false;
      d(alo.o);
    }
  }

  void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.E == null)
      return;
    paramString1 = this.E;
    int j;
    if ((this.g) && (!TextUtils.isEmpty(paramString3)))
    {
      paramString1.setText(paramString3);
      paramString1 = arm.a(getContext(), this.B);
      if (paramString1 != null)
        paramString1.setBounds(0, 0, this.z, this.z);
      if (Build.VERSION.SDK_INT < 17)
        break label314;
      if (1 != getLayoutDirection())
        break label133;
      j = 1;
      label81: if (j == 0)
        break label314;
      paramString2 = null;
    }
    while (true)
    {
      this.E.setCompoundDrawables(paramString2, null, paramString1, null);
      if (isShown())
      {
        n();
        return;
        paramString3 = getContext().getString(2131230972, new Object[] { paramString2 });
        break;
        label133: j = 0;
        break label81;
      }
      this.k.alpha = 0.0F;
      j();
      b();
      if (this.C != null)
      {
        this.C.removeAllUpdateListeners();
        this.C.removeAllListeners();
        if (this.C.isRunning())
          this.C.end();
      }
      this.C = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("y", new int[] { this.k.y, this.k.y - this.k.height }), PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 1.0F }) });
      this.C.setInterpolator(this.D);
      this.C.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue("alpha")).floatValue();
          alx.b(alx.this).alpha = f;
          alx.c(alx.this).y = ((Integer)paramAnonymousValueAnimator.getAnimatedValue("y")).intValue();
          alx.d(alx.this);
        }
      });
      this.C.addListener(new AnimatorListener()
      {
        public void onAnimationCancel(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          alx.this.n();
        }

        public void onAnimationRepeat(Animator paramAnonymousAnimator)
        {
        }

        public void onAnimationStart(Animator paramAnonymousAnimator)
        {
        }
      });
      this.C.start();
      return;
      label314: paramString2 = paramString1;
      paramString1 = null;
    }
  }

  public void a(boolean paramBoolean, int paramInt)
  {
    this.f = paramBoolean;
    if ((!paramBoolean) && (this.e))
    {
      this.e = false;
      d(alo.o);
    }
  }

  public boolean a(MotionEvent paramMotionEvent)
  {
    vy.b(getContext(), "CT", 3);
    m();
    if (this.B != null)
    {
      paramMotionEvent = getContext();
      if (!this.a)
        break label74;
      String str = this.B.i;
      alo.a(paramMotionEvent, 0L, this.B.q);
      if (str == null)
        break label67;
      asl.a(paramMotionEvent, str);
    }
    while (true)
    {
      return true;
      label67: asl.h(paramMotionEvent);
      continue;
      label74: alo.a(paramMotionEvent, this.B);
      arm.b(paramMotionEvent, this.B);
    }
  }

  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return super.a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }

  public void b(ComponentName paramComponentName)
  {
  }

  protected void b(MotionEvent paramMotionEvent)
  {
    n();
  }

  void b(NotificationData paramNotificationData)
  {
    this.B = paramNotificationData;
    if (this.a)
    {
      a(asl.g(getContext()), paramNotificationData.g, paramNotificationData.h);
      return;
    }
    String str1 = paramNotificationData.l;
    String str2 = paramNotificationData.g;
    if (TextUtils.isEmpty(paramNotificationData.i));
    for (paramNotificationData = paramNotificationData.h; ; paramNotificationData = paramNotificationData.i)
    {
      a(str1, str2, paramNotificationData);
      return;
    }
  }

  public boolean b(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.B == null)
      return false;
    vy.b(getContext(), "CT", 2);
    a(4, this.F);
    return true;
  }

  void c(NotificationData paramNotificationData)
  {
    while (true)
    {
      try
      {
        if (this.f)
        {
          this.e = true;
          return;
        }
        if (!aft.e(this.c))
        {
          this.A.obtainMessage(2, paramNotificationData).sendToTarget();
          continue;
        }
      }
      finally
      {
      }
      this.d = true;
    }
  }

  public boolean c(MotionEvent paramMotionEvent)
  {
    u();
    return super.c(paramMotionEvent);
  }

  protected boolean c(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.B == null)
      return false;
    vy.b(getContext(), "CT", 2);
    a(3, this.F);
    return true;
  }

  public void d(MotionEvent paramMotionEvent)
  {
    n();
    super.d(paramMotionEvent);
  }

  protected boolean e()
  {
    return true;
  }

  public boolean e(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (this.B == null)
      return false;
    vy.b(getContext(), "CT", 4);
    a(2);
    return true;
  }

  public void f()
  {
    if (i.isShown())
      return;
    NotificationData localNotificationData = new NotificationData();
    localNotificationData.g = getResources().getString(2131231231);
    localNotificationData.h = getResources().getString(2131231230);
    localNotificationData.i = getResources().getString(2131231230);
    localNotificationData.f = System.currentTimeMillis();
    localNotificationData.l = "com.lazyswipe";
    b(localNotificationData);
  }

  protected boolean g_()
  {
    WindowManager.LayoutParams localLayoutParams = this.k;
    int k = this.n;
    int m = this.y;
    if (1 == this.w);
    for (int j = 1; ; j = 4)
    {
      localLayoutParams.width = (k - (m << j));
      j();
      return true;
    }
  }

  protected boolean h_()
  {
    return true;
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return false;
    case 1:
      if (!asq.q(getContext()))
        return true;
      if (this.B != null)
      {
        vy.b(getContext(), "CT", 1);
        v();
      }
      while (true)
      {
        return true;
        m();
      }
    case 2:
    }
    d((NotificationData)paramMessage.obj);
    return true;
  }

  protected void i()
  {
    int j = 1;
    super.i();
    WindowManager.LayoutParams localLayoutParams = this.k;
    localLayoutParams.flags |= 768;
    this.y = getResources().getDimensionPixelSize(2131296382);
    localLayoutParams = this.k;
    int k = this.n;
    int m = this.y;
    if (1 == this.w);
    while (true)
    {
      localLayoutParams.width = (k - (m << j));
      this.k.height = getResources().getDimensionPixelSize(2131296381);
      this.k.gravity = 3;
      return;
      j = 4;
    }
  }

  protected void j()
  {
    WindowManager.LayoutParams localLayoutParams = this.k;
    if (1 == this.w);
    for (int j = this.y; ; j = this.y << 3)
    {
      localLayoutParams.x = j;
      this.k.y = ((this.o + this.k.height >> 1) - getResources().getDimensionPixelSize(2131296379));
      if (aqs.a())
      {
        j = aqs.ak();
        if (j > 0)
        {
          localLayoutParams = this.k;
          localLayoutParams.y -= j;
        }
      }
      return;
    }
  }

  protected void l()
  {
    vy.b(getContext(), "CT", 1);
    v();
  }

  void m()
  {
    a(2, null);
  }

  void n()
  {
    this.A.removeMessages(1);
    this.A.sendEmptyMessageDelayed(1, 4000L);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     alx
 * JD-Core Version:    0.6.2
 */