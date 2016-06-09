package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import com.lazyswipe.SwipeApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ahq extends ahw
{
  private static Theme b;
  private static List<ahw> c = new ArrayList();
  private static Map<String, ahq> d = new HashMap();
  public final int a;
  private ShapeDrawable e;
  private ShapeDrawable n;
  private Map<Integer, Integer> o = new HashMap();

  ahq(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext, paramString1, paramString2);
    this.a = paramInt;
  }

  // ERROR //
  private int a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 40	ahq:o	Ljava/util/Map;
    //   7: iload_1
    //   8: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11: invokeinterface 57 2 0
    //   16: ifeq +25 -> 41
    //   19: aload_0
    //   20: getfield 40	ahq:o	Ljava/util/Map;
    //   23: iload_1
    //   24: invokestatic 51	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: invokeinterface 61 2 0
    //   32: checkcast 47	java/lang/Integer
    //   35: invokevirtual 65	java/lang/Integer:intValue	()I
    //   38: istore_1
    //   39: iload_1
    //   40: ireturn
    //   41: invokestatic 70	com/lazyswipe/SwipeApplication:c	()Lcom/lazyswipe/SwipeApplication;
    //   44: astore_3
    //   45: aload_3
    //   46: aconst_null
    //   47: getstatic 76	vl:Fan	[I
    //   50: iconst_0
    //   51: aload_0
    //   52: getfield 42	ahq:a	I
    //   55: invokevirtual 82	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   58: astore_3
    //   59: aload_3
    //   60: astore 4
    //   62: aload_3
    //   63: iload_1
    //   64: iload_2
    //   65: invokevirtual 87	android/content/res/TypedArray:getColor	(II)I
    //   68: istore_1
    //   69: iload_1
    //   70: istore_2
    //   71: iload_2
    //   72: istore_1
    //   73: aload_3
    //   74: ifnull -35 -> 39
    //   77: aload_3
    //   78: invokevirtual 90	android/content/res/TypedArray:recycle	()V
    //   81: iload_2
    //   82: ireturn
    //   83: astore_3
    //   84: iload_2
    //   85: istore_1
    //   86: aload 4
    //   88: ifnull -49 -> 39
    //   91: aload 4
    //   93: invokevirtual 90	android/content/res/TypedArray:recycle	()V
    //   96: iload_2
    //   97: ireturn
    //   98: astore_3
    //   99: aconst_null
    //   100: astore 5
    //   102: aload_3
    //   103: astore 4
    //   105: aload 5
    //   107: ifnull +8 -> 115
    //   110: aload 5
    //   112: invokevirtual 90	android/content/res/TypedArray:recycle	()V
    //   115: aload 4
    //   117: athrow
    //   118: astore 4
    //   120: aload_3
    //   121: astore 5
    //   123: goto -18 -> 105
    //
    // Exception table:
    //   from	to	target	type
    //   45	59	83	java/lang/Exception
    //   62	69	83	java/lang/Exception
    //   45	59	98	finally
    //   62	69	118	finally
  }

  public static ahq a(Context paramContext, String paramString)
  {
    d(paramContext);
    return (ahq)d.get(paramString);
  }

  public static List<ahw> a(Context paramContext)
  {
    d(paramContext);
    return c;
  }

  private static void a(ahq paramahq)
  {
    c.add(paramahq);
    d.put(paramahq.g, paramahq);
  }

  private static void d(Context paramContext)
  {
    try
    {
      if (c.isEmpty())
      {
        d.clear();
        a(new ahu(paramContext, "technical", paramContext.getString(2131231080), 2131427376));
        a(new aht(paramContext, "white", paramContext.getString(2131231086), 2131427382));
        a(new aht(paramContext, "yellow", paramContext.getString(2131231084), 2131427383));
        a(new aht(paramContext, "red", paramContext.getString(2131231085), 2131427381));
        a(new aht(paramContext, "blue", paramContext.getString(2131231079), 2131427375));
        a(new aht(paramContext, "green", paramContext.getString(2131231082), 2131427378));
        a(new ahy(paramContext, "iwatch", paramContext.getString(2131231083), 2131427379));
        a(new aht(paramContext, "black", paramContext.getString(2131231081), 2131427377));
        a(new aht(paramContext, "purple", paramContext.getString(2131230937), 2131427380));
      }
      return;
    }
    finally
    {
      paramContext = finally;
    }
    throw paramContext;
  }

  public int a(yb paramyb)
  {
    return 0;
  }

  public Bitmap a()
  {
    Object localObject = SwipeApplication.c();
    Bitmap localBitmap = ((BitmapDrawable)((Context)localObject).getResources().getDrawable(2130903040)).getBitmap();
    try
    {
      int i = ((Context)localObject).getResources().getDimensionPixelSize(2131296279);
      localObject = Bitmap.createBitmap(i, i, Config.ARGB_8888);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      Paint localPaint = new Paint();
      localPaint.setFlags(7);
      localCanvas.setDrawFilter(atw.a);
      ColorMatrix localColorMatrix = new ColorMatrix();
      localColorMatrix.setSaturation(0.0F);
      localPaint.setColorFilter(new ColorMatrixColorFilter(localColorMatrix));
      localPaint.setAlpha(75);
      localCanvas.drawBitmap(localBitmap, null, new Rect(0, 0, i, i), localPaint);
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return localBitmap;
  }

  public Drawable a(Context paramContext, ans paramans)
  {
    return this.i.getResources().getDrawable(paramans.e(this.i));
  }

  public Drawable a(Context paramContext, yb paramyb, Drawable paramDrawable)
  {
    int j;
    if (a(3, 0) != 0)
    {
      i = 1;
      j = paramyb.getCenterOffset();
      if (i == 0)
        break label62;
    }
    label62: for (int i = 0; ; i = paramyb.getTabSectorInnerSize() - j)
    {
      return new yn(i, paramyb.getTabSectorOuterSize() - j, j, a(5, 0), paramyb.n(), paramDrawable);
      i = 0;
      break;
    }
  }

  public void a(Bitmap paramBitmap)
  {
    if (!atw.b(paramBitmap));
    File localFile;
    do
    {
      return;
      localFile = new File(aro.d() + "/files/themes/builtin", "preview_" + this.g + ".jpg");
    }
    while (localFile.exists());
    if (!localFile.getParentFile().exists())
      localFile.getParentFile().mkdirs();
    atw.a(paramBitmap, localFile, CompressFormat.JPEG);
  }

  protected void a(Runnable paramRunnable)
  {
    super.a(paramRunnable);
    if (b == null)
      b = this.i.getApplicationContext().getTheme();
    b.applyStyle(this.a, true);
  }

  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      this.e = null;
      this.n = null;
    }
  }

  public Drawable b(Context paramContext)
  {
    if (this.e == null)
      this.e = zf.a(paramContext, a(9, 0));
    return this.e;
  }

  public boolean b()
  {
    return true;
  }

  public Bitmap c()
  {
    File localFile = new File(aro.d() + "/files/themes/builtin", "preview_" + this.g + ".jpg");
    if (localFile.exists())
      return atw.a(localFile.getAbsolutePath(), j, k, false);
    return null;
  }

  public Drawable c(Context paramContext)
  {
    if (this.n == null)
      this.n = zf.a(paramContext, a(10, 0));
    return this.n;
  }

  public List<Bitmap> d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = new File(aro.d() + "/files/themes/builtin", "preview_" + this.g + ".jpg");
    if (((File)localObject).exists())
    {
      localObject = atw.a(((File) localObject).getAbsolutePath(), l, m, false);
      if (atw.b((Bitmap) localObject))
        localArrayList.add(localObject);
    }
    return localArrayList;
  }

  public boolean e()
  {
    return true;
  }

  public long f()
  {
    if ("purple".equals(this.g))
      return System.currentTimeMillis();
    return aic.b(this.g);
  }

  public int i()
  {
    return a(0, this.i.getResources().getColor(2131689532));
  }

  public int j()
  {
    return a(2, this.i.getResources().getColor(2131689502));
  }

  public int k()
  {
    return a(4, this.i.getResources().getColor(2131689561));
  }

  public int l()
  {
    return a(15, i());
  }

  public boolean l_()
  {
    return true;
  }

  public int m()
  {
    return a(6, this.i.getResources().getColor(2131689561));
  }

  public int n()
  {
    return a(7, this.i.getResources().getColor(2131689561));
  }

  public int o()
  {
    return a(5, this.i.getResources().getColor(2131689504));
  }

  public int p()
  {
    return a(9, this.i.getResources().getColor(2131689505));
  }

  public int q()
  {
    return a(10, i());
  }

  public int r()
  {
    return a(12, 0);
  }

  public int s()
  {
    return a(1, 0);
  }

  public int t()
  {
    return a(3, 0);
  }

  public int u()
  {
    return a(8, 0);
  }

  public int v()
  {
    return a(11, 0);
  }

  public int w()
  {
    return a(13, i());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahq
 * JD-Core Version:    0.6.2
 */