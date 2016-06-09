package cmcm.com.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.preference.Preference;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ama
{
  private static final String a = "Swipe." + ama.class.getSimpleName();
  private final Preference b;
  private Bitmap c;
  private ViewGroup d;
  private TextView e;
  private ViewGroup f;
  private ImageView g;
  private View h;
  private ImageView i;
  private int j;
  private boolean k;
  private Drawable l;
  private boolean m;
  private Drawable n;
  private boolean o;
  private ColorStateList p;

  // ERROR //
  public ama(Preference paramPreference, Context paramContext, android.util.AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 66	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: iconst_1
    //   6: putfield 68	ama:m	Z
    //   9: aload_0
    //   10: aload_1
    //   11: putfield 70	ama:b	Landroid/preference/Preference;
    //   14: aconst_null
    //   15: astore_1
    //   16: aload_2
    //   17: aload_3
    //   18: getstatic 76	vl:MyPreference	[I
    //   21: iload 4
    //   23: iconst_0
    //   24: invokevirtual 82	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   27: astore_3
    //   28: aload_3
    //   29: astore_1
    //   30: aload_3
    //   31: astore_2
    //   32: aload_0
    //   33: aload_3
    //   34: iconst_1
    //   35: iconst_3
    //   36: invokevirtual 88	android/content/res/TypedArray:getInt	(II)I
    //   39: putfield 90	ama:j	I
    //   42: aload_3
    //   43: astore_1
    //   44: aload_3
    //   45: astore_2
    //   46: aload_0
    //   47: aload_3
    //   48: iconst_2
    //   49: iconst_1
    //   50: invokevirtual 94	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   53: putfield 96	ama:k	Z
    //   56: aload_3
    //   57: astore_1
    //   58: aload_3
    //   59: astore_2
    //   60: aload_0
    //   61: aload_3
    //   62: iconst_0
    //   63: invokevirtual 100	android/content/res/TypedArray:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   66: putfield 102	ama:l	Landroid/graphics/drawable/Drawable;
    //   69: aload_3
    //   70: astore_1
    //   71: aload_3
    //   72: astore_2
    //   73: aload_0
    //   74: getfield 96	ama:k	Z
    //   77: istore 5
    //   79: iload 5
    //   81: ifeq +3 -> 84
    //   84: aload_3
    //   85: ifnull +7 -> 92
    //   88: aload_3
    //   89: invokevirtual 105	android/content/res/TypedArray:recycle	()V
    //   92: return
    //   93: astore_2
    //   94: aload_1
    //   95: astore_2
    //   96: aload_0
    //   97: iconst_3
    //   98: putfield 90	ama:j	I
    //   101: aload_1
    //   102: ifnull -10 -> 92
    //   105: aload_1
    //   106: invokevirtual 105	android/content/res/TypedArray:recycle	()V
    //   109: return
    //   110: astore_1
    //   111: aconst_null
    //   112: astore_2
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 105	android/content/res/TypedArray:recycle	()V
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: goto -11 -> 113
    //
    // Exception table:
    //   from	to	target	type
    //   16	28	93	java/lang/Throwable
    //   32	42	93	java/lang/Throwable
    //   46	56	93	java/lang/Throwable
    //   60	69	93	java/lang/Throwable
    //   73	79	93	java/lang/Throwable
    //   16	28	110	finally
    //   32	42	123	finally
    //   46	56	123	finally
    //   60	69	123	finally
    //   73	79	123	finally
    //   96	101	123	finally
  }

  public static Drawable a(Context paramContext)
  {
    return atw.a(Color.parseColor("#ff5a10"), (int) (8.333333F * paramContext.getResources().getDisplayMetrics().density));
  }

  private void c()
  {
    if (this.i == null);
    int i1;
    do
    {
      return;
      i1 = this.i.getVisibility();
      if (!this.m)
        break;
    }
    while (8 == i1);
    this.i.setVisibility(8);
    return;
    if (i1 != 0)
      this.i.setVisibility(0);
    ImageView localImageView = this.i;
    if (this.n == null);
    for (Drawable localDrawable = a(this.b.getContext()); ; localDrawable = this.n)
    {
      localImageView.setImageDrawable(localDrawable);
      return;
    }
  }

  private void d()
  {
    int i1 = this.g.getVisibility();
    if (this.l != null)
    {
      if (i1 != 0)
        this.g.setVisibility(0);
      this.g.setImageDrawable(this.l);
    }
    while (8 == i1)
      return;
    this.g.setVisibility(8);
  }

  private void e()
  {
    int i1 = this.j;
    this.h.setBackgroundResource(2130837745);
  }

  private void f()
  {
    if (!this.o)
      return;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 26 });
    localValueAnimator.setDuration(2000L);
    localValueAnimator.setInterpolator(new TimeInterpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        if ((0.0F <= paramAnonymousFloat) && (paramAnonymousFloat < 0.5D))
          return 1.0F - (paramAnonymousFloat - 0.5F) / 0.5F * ((paramAnonymousFloat - 0.5F) / 0.5F);
        return 1.0F - (paramAnonymousFloat - 1.0F) / 0.5F * ((paramAnonymousFloat - 1.0F) / 0.5F);
      }
    });
    localValueAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
        ama.a(ama.this).setBackgroundColor(Color.argb(i, 255, 255, 255));
      }
    });
    localValueAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ama.a(ama.this, false);
        ama.a(ama.this).setBackgroundColor(0);
        ama.b(ama.this);
      }
    });
    localValueAnimator.start();
  }

  private void g()
  {
    if ((this.e != null) && (this.p != null))
      this.e.setTextColor(this.p);
  }

  public void a(int paramInt)
  {
    this.l = this.b.getContext().getResources().getDrawable(paramInt);
  }

  public void a(ColorStateList paramColorStateList)
  {
    this.p = paramColorStateList;
    if (this.e != null)
      this.e.setTextColor(paramColorStateList);
  }

  public void a(View paramView)
  {
    this.d = ((ViewGroup)paramView.findViewById(2131755409));
    this.e = ((TextView)paramView.findViewById(16908310));
    this.f = ((ViewGroup)paramView.findViewById(16908312));
    this.g = ((ImageView)paramView.findViewById(2131755411));
    this.h = paramView.findViewById(2131755410);
    this.i = ((ImageView)paramView.findViewById(2131755413));
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.m == paramBoolean1);
    do
    {
      return;
      this.m = paramBoolean1;
    }
    while (!paramBoolean2);
    c();
  }

  public boolean a()
  {
    return this.m;
  }

  public void b()
  {
    this.o = true;
  }

  public void b(int paramInt)
  {
    a(ColorStateList.valueOf(paramInt));
  }

  public void b(View paramView)
  {
    paramView.setBackgroundDrawable(null);
    a(paramView);
    d();
    e();
    f();
    g();
    c();
    if (this.f != null)
    {
      paramView = (ImageView)this.f.findViewById(2131755196);
      if ((paramView != null) && (this.c != null))
      {
        paramView.setImageBitmap(this.c);
        paramView.setPadding(0, 0, 0, 0);
      }
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ama
 * JD-Core Version:    0.6.2
 */