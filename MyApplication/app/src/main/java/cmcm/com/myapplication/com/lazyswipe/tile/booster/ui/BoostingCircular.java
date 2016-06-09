package cmcm.com.myapplication.com.lazyswipe.tile.booster.ui;

import ahu;
import ahw;
import ahx;
import ahy;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import aod;
import aoe;
import aof;
import apd;
import asq;
import asv;
import atw;
import com.lazyswipe.fan.ItemSectorBg;
import java.lang.ref.WeakReference;
import yb;

public class BoostingCircular extends FrameLayout
  implements Callback
{
  private static final String c = "Swipe." + BoostingCircular.class.getSimpleName();
  private int A;
  private int B;
  protected yb a;
  public long b;
  private ImageView d;
  private ImageView e;
  private ImageView f;
  private WeakReference<View> g;
  private WeakReference<Bitmap> h;
  private WeakReference<Bitmap> i;
  private WeakReference<Bitmap> j;
  private boolean k;
  private boolean l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private int r;
  private int s;
  private boolean t;
  private boolean u;
  private boolean v;
  private float w;
  private boolean x;
  private Handler y;
  private int z;

  public BoostingCircular(Context paramContext)
  {
    super(paramContext);
  }

  public BoostingCircular(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private int a(int paramInt, float paramFloat)
  {
    float f1 = 1.0F;
    float f2 = 0.0F;
    if (paramFloat < 0.0F)
      paramFloat = f2;
    while (true)
    {
      if (paramFloat > 1.0F)
        paramFloat = f1;
      while (true)
        return (int)(paramFloat * 255.0F) << 24 | 0xFFFFFF & paramInt;
    }
  }

  private Bitmap a(Drawable paramDrawable)
  {
    Bitmap localBitmap = null;
    if ((paramDrawable instanceof BitmapDrawable))
      localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
    while (!(paramDrawable instanceof apd))
      return localBitmap;
    return ((apd)paramDrawable).a();
  }

  public static BoostingCircular a(Context paramContext, View paramView, yb paramyb, boolean paramBoolean, long paramLong)
  {
    if (!(paramView instanceof aof))
      return null;
    paramContext = (BoostingCircular)LayoutInflater.from(paramContext).inflate(2130968612, null);
    paramContext.b = paramLong;
    paramContext.a(paramView, paramyb, paramBoolean);
    paramContext.b();
    return paramContext;
  }

  private void a(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, RectF paramRectF)
  {
    a(paramCanvas, paramPaint, paramRectF, paramInt1, paramInt2, 0.1F, 0, 20.0F, -90, 90);
    a(paramCanvas, paramPaint, paramRectF, paramInt1, paramInt2, 0.15F, 5, 3.0F, -80, 50);
    a(paramCanvas, paramPaint, paramRectF, paramInt1, paramInt3, 0.07F, 0, 6.0F, -30, 15);
    a(paramCanvas, paramPaint, paramRectF, paramInt1, paramInt2, 0.12F, 7, 2.0F, -80, 50);
    a(paramCanvas, paramPaint, paramRectF, paramInt1, paramInt2, 0.12F, 18, 2.0F, -80, 50);
    a(paramCanvas, paramPaint, paramRectF, paramInt1, paramInt3, 0.08F, 18, 8.0F, -80, 60);
    a(paramCanvas, paramPaint, paramRectF, paramInt1, paramInt2, 0.07F, 16, 6.0F, -60, 18);
    a(paramCanvas, paramPaint, paramRectF, paramInt1, paramInt3, 0.08F, 5, 10.0F, -80, 60);
    a(paramCanvas, paramPaint, paramRectF, paramInt1, paramInt3, 0.12F, 15, 2.5F, -80, 70);
    a(paramCanvas, paramPaint, paramRectF, paramInt1, paramInt3, 0.12F, 1, 2.5F, -70, 70);
    a(paramCanvas, paramPaint, paramRectF, paramInt1, paramInt4, 0.12F, 12, 2.5F, -70, 70);
    a(paramCanvas, paramPaint, paramRectF, paramInt1, paramInt3, 0.12F, 24, 2.0F, -80, 80);
  }

  private void a(Canvas paramCanvas, Paint paramPaint, RectF paramRectF, int paramInt1, float paramFloat1, int paramInt2, float paramFloat2, int paramInt3, int paramInt4)
  {
    int i1 = this.o / 2;
    paramPaint.setColor(a(paramInt1, paramFloat1));
    paramPaint.setStrokeWidth(asq.a(paramFloat2));
    paramPaint.setStyle(Style.STROKE);
    paramRectF.set(i1 - paramInt2, i1 - paramInt2, i1 + paramInt2, i1 + paramInt2);
    paramCanvas.drawArc(paramRectF, paramInt3, paramInt4, false, paramPaint);
    paramCanvas.drawArc(paramRectF, paramInt3 + 180, paramInt4, false, paramPaint);
  }

  private void a(Canvas paramCanvas, Paint paramPaint, RectF paramRectF, int paramInt1, int paramInt2, float paramFloat1, int paramInt3, float paramFloat2, int paramInt4, int paramInt5)
  {
    a(paramCanvas, paramPaint, paramRectF, paramInt2, paramFloat1, paramInt1 + asq.a(paramInt3), paramFloat2, paramInt4, paramInt5);
  }

  private void a(Canvas paramCanvas, View paramView)
  {
    int i2 = this.p / 2;
    int i1 = 0;
    while (i1 < 360)
    {
      paramCanvas.rotate(i1, i2, i2);
      b(paramCanvas, paramView);
      paramCanvas.rotate(-i1, i2, i2);
      i1 += 90;
    }
  }

  private void a(View paramView, yb paramyb, boolean paramBoolean)
  {
    this.g = new WeakReference(paramView);
    this.a = paramyb;
    this.k = paramyb.n();
    this.l = paramBoolean;
    this.n = paramView.getWidth();
    int i1;
    if (this.l)
      i1 = paramyb.getItemSectorOuterSize() << 1;
    while (true)
    {
      this.o = i1;
      this.o -= asq.a(4.5F);
      this.m = (this.n * 2);
      this.p = (this.n / 1);
      this.q = MeasureSpec.makeMeasureSpec(this.m, 1073741824);
      this.r = MeasureSpec.makeMeasureSpec(this.o, 1073741824);
      if (aoe.d() == 2)
      {
        paramBoolean = true;
        label128: this.v = paramBoolean;
        this.z = ((paramyb.getItemSectorInnerSize() + paramyb.getTabSectorOuterSize()) / 2);
        this.A = ((paramyb.getItemSectorInnerSize() + paramyb.getItemSectorOuterSize()) / 2);
        this.B = paramyb.getTabSectorInnerSize();
        if (!f())
          break label326;
        i1 = this.m;
        label184: this.s = MeasureSpec.makeMeasureSpec(i1, 1073741824);
        paramView = new LayoutParams(this.m, this.m);
        if (!this.k)
          break label337;
        i1 = 3;
        label221: paramView.gravity = (i1 | 0x50);
        paramView.bottomMargin = (-this.n);
        if (!this.k)
          break label343;
        paramView.leftMargin = (-this.n);
      }
      try
      {
        label255: this.a.addView(this, paramView);
        this.a.setClipChildren(false);
        if (this.v)
        {
          this.e.setLayerType(2, null);
          this.f.setLayerType(2, null);
          this.d.setLayerType(2, null);
        }
        while (true)
        {
          aoe.a();
          return;
          i1 = paramyb.getTabSectorOuterSize() << 1;
          break;
          paramBoolean = false;
          break label128;
          label326: i1 = getCircularRadius() * 2;
          break label184;
          label337: i1 = 5;
          break label221;
          label343: paramView.rightMargin = (-this.n);
          break label255;
          setLayerType(aoe.d(), null);
        }
      }
      catch (Exception paramView)
      {
      }
    }
  }

  private void b()
  {
    g();
    h();
  }

  private void b(Canvas paramCanvas, View paramView)
  {
    float f1 = 0.0F;
    int i1 = paramCanvas.save();
    int i2 = paramView.getWidth();
    int i3 = paramView.getHeight();
    float f2 = this.p / 2 / i2;
    paramCanvas.scale(f2, f2, 0.0F, 0.0F);
    if (this.k)
      f1 = i2;
    paramCanvas.translate(f1, i2 + -i3);
    ((aof)paramView).a(paramCanvas);
    paramCanvas.restoreToCount(i1);
  }

  private void c()
  {
    View localView = getBaseBgView();
    if (localView != null)
      localView.setVisibility(0);
    localView = (View)this.g.get();
    if (localView != null)
      localView.setVisibility(0);
  }

  private void d()
  {
    Object localObject = e();
    this.d.setImageDrawable((Drawable)localObject);
    localObject = getBaseBgView();
    if (localObject != null)
    {
      ((View)localObject).clearAnimation();
      ((View)localObject).setVisibility(8);
    }
    localObject = (View)this.g.get();
    if (localObject != null)
    {
      ((View)localObject).clearAnimation();
      ((View)localObject).setVisibility(8);
    }
  }

  // ERROR //
  private Drawable e()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 277	com/lazyswipe/tile/booster/ui/BoostingCircular:f	()Z
    //   4: ifeq +155 -> 159
    //   7: aload_0
    //   8: invokevirtual 381	com/lazyswipe/tile/booster/ui/BoostingCircular:getContext	()Landroid/content/Context;
    //   11: astore_2
    //   12: aload_0
    //   13: getfield 220	com/lazyswipe/tile/booster/ui/BoostingCircular:a	Lyb;
    //   16: astore_3
    //   17: getstatic 385	com/lazyswipe/fan/ItemSectorBg:a	Z
    //   20: ifeq +578 -> 598
    //   23: ldc_w 387
    //   26: astore_1
    //   27: aload_2
    //   28: aload_3
    //   29: aload_1
    //   30: invokestatic 392	ahu:a	(Landroid/content/Context;Lyb;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   33: astore_2
    //   34: aload_2
    //   35: invokestatic 397	atw:b	(Landroid/graphics/Bitmap;)Z
    //   38: ifeq +121 -> 159
    //   41: aload_0
    //   42: getfield 243	com/lazyswipe/tile/booster/ui/BoostingCircular:m	I
    //   45: aload_0
    //   46: getfield 243	com/lazyswipe/tile/booster/ui/BoostingCircular:m	I
    //   49: getstatic 403	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   52: invokestatic 409	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   55: astore_3
    //   56: new 194	android/graphics/Canvas
    //   59: dup
    //   60: aload_3
    //   61: invokespecial 412	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   64: astore 4
    //   66: aload_0
    //   67: getfield 227	com/lazyswipe/tile/booster/ui/BoostingCircular:k	Z
    //   70: ifeq +67 -> 137
    //   73: new 414	android/graphics/Rect
    //   76: dup
    //   77: aload_0
    //   78: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   81: iconst_0
    //   82: aload_0
    //   83: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   86: iconst_2
    //   87: imul
    //   88: aload_0
    //   89: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   92: invokespecial 417	android/graphics/Rect:<init>	(IIII)V
    //   95: astore_1
    //   96: aload 4
    //   98: aload_2
    //   99: aconst_null
    //   100: aload_1
    //   101: aconst_null
    //   102: invokevirtual 421	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   105: aload_0
    //   106: new 213	java/lang/ref/WeakReference
    //   109: dup
    //   110: aload_3
    //   111: invokespecial 216	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   114: putfield 423	com/lazyswipe/tile/booster/ui/BoostingCircular:j	Ljava/lang/ref/WeakReference;
    //   117: aload_2
    //   118: invokestatic 425	atw:a	(Landroid/graphics/Bitmap;)V
    //   121: new 109	android/graphics/drawable/BitmapDrawable
    //   124: dup
    //   125: aload_0
    //   126: invokevirtual 381	com/lazyswipe/tile/booster/ui/BoostingCircular:getContext	()Landroid/content/Context;
    //   129: invokevirtual 431	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   132: aload_3
    //   133: invokespecial 434	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   136: areturn
    //   137: new 414	android/graphics/Rect
    //   140: dup
    //   141: iconst_0
    //   142: iconst_0
    //   143: aload_0
    //   144: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   147: aload_0
    //   148: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   151: invokespecial 417	android/graphics/Rect:<init>	(IIII)V
    //   154: astore_1
    //   155: goto -59 -> 96
    //   158: astore_1
    //   159: aload_0
    //   160: invokevirtual 381	com/lazyswipe/tile/booster/ui/BoostingCircular:getContext	()Landroid/content/Context;
    //   163: invokestatic 439	ahx:b	(Landroid/content/Context;)Lahw;
    //   166: instanceof 441
    //   169: ifeq +241 -> 410
    //   172: aload_0
    //   173: invokevirtual 381	com/lazyswipe/tile/booster/ui/BoostingCircular:getContext	()Landroid/content/Context;
    //   176: invokestatic 439	ahx:b	(Landroid/content/Context;)Lahw;
    //   179: checkcast 441	ahr
    //   182: astore_3
    //   183: aload_0
    //   184: getfield 229	com/lazyswipe/tile/booster/ui/BoostingCircular:l	Z
    //   187: ifne +276 -> 463
    //   190: aload_3
    //   191: aload_0
    //   192: invokevirtual 381	com/lazyswipe/tile/booster/ui/BoostingCircular:getContext	()Landroid/content/Context;
    //   195: aload_0
    //   196: getfield 220	com/lazyswipe/tile/booster/ui/BoostingCircular:a	Lyb;
    //   199: aconst_null
    //   200: invokevirtual 444	ahr:a	(Landroid/content/Context;Lyb;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   203: astore_1
    //   204: aload_0
    //   205: aload_1
    //   206: invokespecial 446	com/lazyswipe/tile/booster/ui/BoostingCircular:a	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   209: astore 5
    //   211: aload 5
    //   213: invokestatic 397	atw:b	(Landroid/graphics/Bitmap;)Z
    //   216: ifeq +194 -> 410
    //   219: aload_0
    //   220: getfield 243	com/lazyswipe/tile/booster/ui/BoostingCircular:m	I
    //   223: aload_0
    //   224: getfield 243	com/lazyswipe/tile/booster/ui/BoostingCircular:m	I
    //   227: getstatic 403	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   230: invokestatic 409	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   233: astore_2
    //   234: new 194	android/graphics/Canvas
    //   237: dup
    //   238: aload_2
    //   239: invokespecial 412	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   242: astore 4
    //   244: aload_0
    //   245: getfield 227	com/lazyswipe/tile/booster/ui/BoostingCircular:k	Z
    //   248: ifeq +253 -> 501
    //   251: new 414	android/graphics/Rect
    //   254: dup
    //   255: aload_0
    //   256: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   259: iconst_0
    //   260: aload_0
    //   261: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   264: iconst_2
    //   265: imul
    //   266: aload_0
    //   267: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   270: invokespecial 417	android/graphics/Rect:<init>	(IIII)V
    //   273: astore_1
    //   274: aload 4
    //   276: aload 5
    //   278: aconst_null
    //   279: aload_1
    //   280: aconst_null
    //   281: invokevirtual 421	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   284: aload_0
    //   285: getfield 229	com/lazyswipe/tile/booster/ui/BoostingCircular:l	Z
    //   288: istore 7
    //   290: iload 7
    //   292: ifne +87 -> 379
    //   295: aload_0
    //   296: aload_3
    //   297: aload_0
    //   298: invokevirtual 381	com/lazyswipe/tile/booster/ui/BoostingCircular:getContext	()Landroid/content/Context;
    //   301: aload_0
    //   302: getfield 220	com/lazyswipe/tile/booster/ui/BoostingCircular:a	Lyb;
    //   305: invokevirtual 449	ahr:d	(Landroid/content/Context;Lyb;)Landroid/graphics/drawable/Drawable;
    //   308: invokespecial 446	com/lazyswipe/tile/booster/ui/BoostingCircular:a	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   311: astore_3
    //   312: aload_0
    //   313: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   316: i2f
    //   317: aload 5
    //   319: invokevirtual 450	android/graphics/Bitmap:getWidth	()I
    //   322: i2f
    //   323: fdiv
    //   324: aload_3
    //   325: invokevirtual 450	android/graphics/Bitmap:getWidth	()I
    //   328: i2f
    //   329: fmul
    //   330: f2i
    //   331: istore 6
    //   333: aload_0
    //   334: getfield 227	com/lazyswipe/tile/booster/ui/BoostingCircular:k	Z
    //   337: ifeq +185 -> 522
    //   340: new 414	android/graphics/Rect
    //   343: dup
    //   344: aload_0
    //   345: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   348: aload_0
    //   349: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   352: iload 6
    //   354: isub
    //   355: iload 6
    //   357: aload_0
    //   358: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   361: iadd
    //   362: aload_0
    //   363: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   366: invokespecial 417	android/graphics/Rect:<init>	(IIII)V
    //   369: astore_1
    //   370: aload 4
    //   372: aload_3
    //   373: aconst_null
    //   374: aload_1
    //   375: aconst_null
    //   376: invokevirtual 421	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   379: aload_0
    //   380: new 213	java/lang/ref/WeakReference
    //   383: dup
    //   384: aload_2
    //   385: invokespecial 216	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   388: putfield 423	com/lazyswipe/tile/booster/ui/BoostingCircular:j	Ljava/lang/ref/WeakReference;
    //   391: new 109	android/graphics/drawable/BitmapDrawable
    //   394: dup
    //   395: aload_0
    //   396: invokevirtual 381	com/lazyswipe/tile/booster/ui/BoostingCircular:getContext	()Landroid/content/Context;
    //   399: invokevirtual 431	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   402: aload_2
    //   403: invokespecial 434	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   406: astore_1
    //   407: aload_1
    //   408: areturn
    //   409: astore_1
    //   410: aload_0
    //   411: invokevirtual 451	com/lazyswipe/tile/booster/ui/BoostingCircular:getResources	()Landroid/content/res/Resources;
    //   414: ldc_w 452
    //   417: invokevirtual 458	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   420: astore_1
    //   421: aload_1
    //   422: instanceof 460
    //   425: ifeq +171 -> 596
    //   428: aload_0
    //   429: invokevirtual 381	com/lazyswipe/tile/booster/ui/BoostingCircular:getContext	()Landroid/content/Context;
    //   432: invokestatic 463	ahu:d	(Landroid/content/Context;)Z
    //   435: ifeq +124 -> 559
    //   438: aload_0
    //   439: getfield 229	com/lazyswipe/tile/booster/ui/BoostingCircular:l	Z
    //   442: ifeq +117 -> 559
    //   445: getstatic 466	ahu:b	[I
    //   448: iconst_0
    //   449: iaload
    //   450: istore 6
    //   452: aload_1
    //   453: checkcast 460	android/graphics/drawable/GradientDrawable
    //   456: iload 6
    //   458: invokevirtual 467	android/graphics/drawable/GradientDrawable:setColor	(I)V
    //   461: aload_1
    //   462: areturn
    //   463: getstatic 385	com/lazyswipe/fan/ItemSectorBg:a	Z
    //   466: ifeq +19 -> 485
    //   469: aload_3
    //   470: aload_0
    //   471: invokevirtual 381	com/lazyswipe/tile/booster/ui/BoostingCircular:getContext	()Landroid/content/Context;
    //   474: aload_0
    //   475: getfield 220	com/lazyswipe/tile/booster/ui/BoostingCircular:a	Lyb;
    //   478: invokevirtual 469	ahr:a	(Landroid/content/Context;Lyb;)Landroid/graphics/drawable/Drawable;
    //   481: astore_1
    //   482: goto -278 -> 204
    //   485: aload_3
    //   486: aload_0
    //   487: invokevirtual 381	com/lazyswipe/tile/booster/ui/BoostingCircular:getContext	()Landroid/content/Context;
    //   490: aload_0
    //   491: getfield 220	com/lazyswipe/tile/booster/ui/BoostingCircular:a	Lyb;
    //   494: invokevirtual 471	ahr:b	(Landroid/content/Context;Lyb;)Landroid/graphics/drawable/Drawable;
    //   497: astore_1
    //   498: goto -294 -> 204
    //   501: new 414	android/graphics/Rect
    //   504: dup
    //   505: iconst_0
    //   506: iconst_0
    //   507: aload_0
    //   508: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   511: aload_0
    //   512: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   515: invokespecial 417	android/graphics/Rect:<init>	(IIII)V
    //   518: astore_1
    //   519: goto -245 -> 274
    //   522: new 414	android/graphics/Rect
    //   525: dup
    //   526: aload_0
    //   527: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   530: iload 6
    //   532: isub
    //   533: aload_0
    //   534: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   537: iload 6
    //   539: isub
    //   540: aload_0
    //   541: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   544: aload_0
    //   545: getfield 237	com/lazyswipe/tile/booster/ui/BoostingCircular:n	I
    //   548: invokespecial 417	android/graphics/Rect:<init>	(IIII)V
    //   551: astore_1
    //   552: goto -182 -> 370
    //   555: astore_1
    //   556: goto -177 -> 379
    //   559: aload_0
    //   560: getfield 229	com/lazyswipe/tile/booster/ui/BoostingCircular:l	Z
    //   563: ifeq +18 -> 581
    //   566: aload_0
    //   567: invokevirtual 381	com/lazyswipe/tile/booster/ui/BoostingCircular:getContext	()Landroid/content/Context;
    //   570: invokestatic 439	ahx:b	(Landroid/content/Context;)Lahw;
    //   573: invokevirtual 475	ahw:t	()I
    //   576: istore 6
    //   578: goto -126 -> 452
    //   581: aload_0
    //   582: invokevirtual 381	com/lazyswipe/tile/booster/ui/BoostingCircular:getContext	()Landroid/content/Context;
    //   585: invokestatic 439	ahx:b	(Landroid/content/Context;)Lahw;
    //   588: invokevirtual 477	ahw:o	()I
    //   591: istore 6
    //   593: goto -141 -> 452
    //   596: aload_1
    //   597: areturn
    //   598: ldc_w 479
    //   601: astore_1
    //   602: goto -575 -> 27
    //
    // Exception table:
    //   from	to	target	type
    //   7	23	158	java/lang/Throwable
    //   27	96	158	java/lang/Throwable
    //   96	137	158	java/lang/Throwable
    //   137	155	158	java/lang/Throwable
    //   172	204	409	java/lang/Throwable
    //   204	274	409	java/lang/Throwable
    //   274	290	409	java/lang/Throwable
    //   295	370	409	java/lang/Throwable
    //   370	379	409	java/lang/Throwable
    //   379	407	409	java/lang/Throwable
    //   463	482	409	java/lang/Throwable
    //   485	498	409	java/lang/Throwable
    //   501	519	409	java/lang/Throwable
    //   522	552	409	java/lang/Throwable
    //   295	370	555	java/lang/Exception
    //   370	379	555	java/lang/Exception
    //   522	552	555	java/lang/Exception
  }

  private boolean f()
  {
    return (this.l) && (this.v) && (ahu.d(getContext()));
  }

  private void g()
  {
    try
    {
      this.t = false;
      Bitmap localBitmap = i();
      if (atw.b(localBitmap))
      {
        this.y.obtainMessage(0, localBitmap).sendToTarget();
        return;
      }
      this.y.sendEmptyMessage(2);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.y.sendEmptyMessage(2);
    }
  }

  private void h()
  {
    try
    {
      this.u = false;
      Bitmap localBitmap = j();
      if (atw.b(localBitmap))
      {
        this.y.obtainMessage(1, localBitmap).sendToTarget();
        return;
      }
      this.y.sendEmptyMessage(3);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e(c, "prepareFastImage failed.", localThrowable);
      this.y.sendEmptyMessage(3);
    }
  }

  private Bitmap i()
  {
    View localView = (View)this.g.get();
    if (localView == null)
      return null;
    Bitmap localBitmap = Bitmap.createBitmap(this.p, this.p, Config.ARGB_8888);
    a(new Canvas(localBitmap), localView);
    return localBitmap;
  }

  private Bitmap j()
  {
    if (this.l)
      return k();
    return l();
  }

  private Bitmap k()
  {
    System.currentTimeMillis();
    Bitmap localBitmap = Bitmap.createBitmap(this.o, this.o, Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    int i1 = ahx.b(getContext()).p();
    int i2 = ahx.b(getContext()).q();
    RectF localRectF = new RectF();
    a(localCanvas, localPaint, this.z, i1, i2, -1, localRectF);
    if (ItemSectorBg.a)
      a(localCanvas, localPaint, this.A, i1, i2, -1, localRectF);
    while (!ahy.d(getContext()))
      return localBitmap;
    a(localCanvas, localPaint, this.A, i1, i2, -1, localRectF);
    a(localCanvas, localPaint, (this.z + this.A) / 2, i1, i2, -1, localRectF);
    return localBitmap;
  }

  private Bitmap l()
  {
    Object localObject = getContext();
    System.currentTimeMillis();
    Bitmap localBitmap = Bitmap.createBitmap(this.o, this.o, Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    int i1 = ahx.b((Context)localObject).m();
    if (i1 == 0)
      i1 = ahx.b((Context)localObject).m();
    while (true)
    {
      int i3 = ahx.b(getContext()).l();
      int i2 = i3;
      if (i3 == 0)
        i2 = ahx.b((Context)localObject).n();
      localObject = new RectF();
      i3 = asq.a(this.o / 2 - this.B);
      int i5 = this.B;
      int i6 = (this.o / 2 - this.B) / 2;
      int i4 = asq.a(20.0F);
      a(localCanvas, localPaint, (RectF)localObject, i2, 0.05F, i6 + i5, i3, -90, 90);
      i3 = this.B + i4;
      while (i3 < this.o / 2 - i4)
      {
        a(localCanvas, localPaint, (RectF)localObject, i1, 0.025F, i3, asq.a(8.0F), -90, 90);
        a(localCanvas, localPaint, (RectF)localObject, i2, 0.025F, i3 + asq.a(10.0F), asq.a(8.0F), -90, 90);
        i3 += i4;
      }
      return localBitmap;
    }
  }

  private void m()
  {
    this.t = false;
    this.u = false;
    this.y.removeMessages(0);
    this.y.removeMessages(1);
    this.y.removeMessages(2);
    this.y.removeMessages(3);
    this.y.post(new Runnable()
    {
      public void run()
      {
        BoostingCircular.c(BoostingCircular.this);
        BoostingCircular.this.a();
      }
    });
  }

  private void n()
  {
    if ((!this.t) || (!this.u))
      return;
    d();
    if ((this.l ^ this.k));
    for (float f1 = -getTargetDegreeDiff(); ; f1 = getTargetDegreeDiff())
    {
      ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 1.0F, f1 });
      localValueAnimator1.setInterpolator(new TimeInterpolator()
      {
        public float getInterpolation(float paramAnonymousFloat)
        {
          if (paramAnonymousFloat < 0.1111111F)
          {
            BoostingCircular.a(BoostingCircular.this, true);
            return paramAnonymousFloat * paramAnonymousFloat * 81.0F;
          }
          BoostingCircular.a(BoostingCircular.this, false);
          return 1.0F;
        }
      });
      localValueAnimator1.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (BoostingCircular.d(BoostingCircular.this))
          {
            paramAnonymousValueAnimator = BoostingCircular.e(BoostingCircular.this);
            f = paramAnonymousValueAnimator.getRotation() + f;
            if (!BoostingCircular.d(BoostingCircular.this))
              break label96;
            BoostingCircular.e(BoostingCircular.this).setRotation(f);
            BoostingCircular.f(BoostingCircular.this).setRotation(f);
          }
          while (true)
          {
            if (BoostingCircular.g(BoostingCircular.this))
              BoostingCircular.a(BoostingCircular.this, f);
            return;
            paramAnonymousValueAnimator = BoostingCircular.this;
            break;
            label96: BoostingCircular.this.setRotation(f);
          }
        }
      });
      localValueAnimator1.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          if (BoostingCircular.d(BoostingCircular.this));
          for (paramAnonymousAnimator = BoostingCircular.e(BoostingCircular.this); ; paramAnonymousAnimator = BoostingCircular.this)
          {
            int i = (int)(paramAnonymousAnimator.getRotation() + BoostingCircular.h(BoostingCircular.this) * 250.0F / 250.0F) / 90;
            paramAnonymousAnimator = ValueAnimator.ofFloat(new float[] { paramAnonymousAnimator.getRotation(), i * 90 });
            paramAnonymousAnimator.setInterpolator(new DecelerateInterpolator(2.0F));
            paramAnonymousAnimator.addUpdateListener(new AnimatorUpdateListener()
            {
              public void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
              {
                float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
                if (BoostingCircular.d(BoostingCircular.this))
                {
                  BoostingCircular.e(BoostingCircular.this).setRotation(f);
                  BoostingCircular.f(BoostingCircular.this).setRotation(f);
                  return;
                }
                BoostingCircular.this.setRotation(f);
              }
            });
            paramAnonymousAnimator.setDuration(250L);
            paramAnonymousAnimator.start();
            return;
          }
        }
      });
      localValueAnimator1.setDuration(2250L);
      ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 1.0F, getTargetScale() });
      localValueAnimator2.setInterpolator(new aod(null));
      localValueAnimator2.setDuration(2500L);
      localValueAnimator2.addUpdateListener(new AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (BoostingCircular.d(BoostingCircular.this))
          {
            BoostingCircular.e(BoostingCircular.this).setScaleX(f);
            BoostingCircular.e(BoostingCircular.this).setScaleY(f);
            BoostingCircular.f(BoostingCircular.this).setScaleX(f);
            BoostingCircular.f(BoostingCircular.this).setScaleY(f);
            BoostingCircular.i(BoostingCircular.this).setScaleX(f);
            BoostingCircular.i(BoostingCircular.this).setScaleY(f);
            return;
          }
          BoostingCircular.this.setScaleX(f);
          BoostingCircular.this.setScaleY(f);
        }
      });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localValueAnimator1, localValueAnimator2 });
      localAnimatorSet.addListener(new AnimatorListenerAdapter()
      {
        public void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BoostingCircular.j(BoostingCircular.this);
        }
      });
      localAnimatorSet.start();
      this.y.postDelayed(new Runnable()
      {
        public void run()
        {
          ViewPropertyAnimator localViewPropertyAnimator = BoostingCircular.e(BoostingCircular.this).animate().alpha(0.0F).setDuration(250L);
          asv.b(localViewPropertyAnimator, new Runnable()
          {
            public void run()
            {
              BoostingCircular.e(BoostingCircular.this).setVisibility(8);
            }
          });
          localViewPropertyAnimator.start();
          BoostingCircular.f(BoostingCircular.this).animate().alpha(1.0F).setDuration(250L).start();
        }
      }
      , 100L);
      this.y.postDelayed(new Runnable()
      {
        public void run()
        {
          BoostingCircular.e(BoostingCircular.this).setVisibility(0);
          BoostingCircular.e(BoostingCircular.this).animate().alpha(1.0F).setDuration(250L).start();
          BoostingCircular.f(BoostingCircular.this).animate().alpha(0.0F).setDuration(250L).start();
        }
      }
      , 2250L);
      return;
    }
  }

  private void o()
  {
    this.a.setClipChildren(true);
    if (this.v)
    {
      this.d.setLayerType(0, null);
      this.e.setLayerType(0, null);
      this.f.setLayerType(0, null);
    }
    while (true)
    {
      this.d.setImageBitmap(null);
      this.e.setImageBitmap(null);
      this.f.setImageBitmap(null);
      if (this.h != null)
      {
        atw.a((Bitmap)this.h.get());
        this.h.clear();
      }
      if (this.i != null)
      {
        atw.a((Bitmap)this.i.get());
        this.i.clear();
      }
      if (this.j != null)
      {
        atw.a((Bitmap)this.j.get());
        this.j.clear();
      }
      return;
      setLayerType(0, null);
    }
  }

  public void a()
  {
    try
    {
      this.y.post(new Runnable()
      {
        public void run()
        {
          BoostingCircular.b(BoostingCircular.this);
          BoostingCircular.this.a.removeView(BoostingCircular.this);
          aoe.a(BoostingCircular.this, BoostingCircular.this.b);
        }
      });
      return;
    }
    catch (Exception localException)
    {
    }
  }

  protected void dispatchDraw(Canvas paramCanvas)
  {
    try
    {
      super.dispatchDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
    }
  }

  protected View getBaseBgView()
  {
    if (this.l)
      return this.a.getItemSectorBg();
    return this.a.getTabSectorBg();
  }

  protected int getCircularRadius()
  {
    if (!ahy.d(getContext()))
    {
      if (this.l)
        return this.a.getRealRadius();
      return this.a.getTabSectorOuterSize();
    }
    if (this.l)
      return this.a.getItemSectorOuterSize();
    return this.a.getTabSectorOuterSize();
  }

  protected int getTargetDegreeDiff()
  {
    if (this.l)
      return 53;
    return 45;
  }

  protected float getTargetScale()
  {
    if (this.l)
      return 0.6F;
    return 1.2F;
  }

  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return false;
      paramMessage = (Bitmap)paramMessage.obj;
      this.i = new WeakReference(paramMessage);
      this.e.setImageBitmap(paramMessage);
      this.t = true;
      n();
      continue;
      paramMessage = (Bitmap)paramMessage.obj;
      this.h = new WeakReference(paramMessage);
      this.f.setImageBitmap(paramMessage);
      this.u = true;
      n();
      continue;
      m();
    }
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.y.postDelayed(new Runnable()
    {
      public void run()
      {
        BoostingCircular.a(BoostingCircular.this).removeCallbacksAndMessages(null);
      }
    }
    , 100L);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.y = new Handler(this);
    this.e = ((ImageView)findViewById(2131755161));
    this.f = ((ImageView)findViewById(2131755162));
    this.d = ((ImageView)findViewById(2131755160));
    this.e.setAlpha(1.0F);
    this.f.setAlpha(0.0F);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.d.layout((this.m - this.d.getMeasuredWidth()) / 2, (this.m - this.d.getMeasuredWidth()) / 2, (this.m + this.d.getMeasuredWidth()) / 2, (this.m + this.d.getMeasuredWidth()) / 2);
    this.f.layout((this.m - this.f.getMeasuredWidth()) / 2, (this.m - this.f.getMeasuredWidth()) / 2, (this.m + this.f.getMeasuredWidth()) / 2, (this.m + this.f.getMeasuredWidth()) / 2);
    this.e.layout((this.m - this.e.getMeasuredWidth()) / 2, (this.m - this.e.getMeasuredWidth()) / 2, (this.m + this.e.getMeasuredWidth()) / 2, (this.m + this.e.getMeasuredWidth()) / 2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(this.m, this.m);
    this.e.measure(this.q, this.q);
    this.f.measure(this.r, this.r);
    this.d.measure(this.s, this.s);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.tile.booster.ui.BoostingCircular
 * JD-Core Version:    0.6.2
 */