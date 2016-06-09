package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.opengl.GLES10;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import com.lazyswipe.SwipeApplication;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Array;

public class atw
{
  public static final PaintFlagsDrawFilter a;
  public static final Paint b;
  public static final Paint c;
  static final int[] d;
  static int e;
  static final int f;
  private static final String g;
  private static int h;
  private static int i;
  private static int j;
  private static int k;
  private static final Paint l;
  private static final Paint m;
  private static final Paint n;
  private static final Paint o;
  private static final Rect p;
  private static final Canvas q;

  static
  {
    int i1 = 1;
    int i2 = -1;
    g = "Swipe." + atw.class.getSimpleName();
    a = new PaintFlagsDrawFilter(0, 7);
    b = new Paint(7);
    c = new Paint();
    h = -1;
    i = -1;
    j = -1;
    k = -1;
    l = new Paint();
    m = new Paint();
    n = new Paint();
    o = new Paint();
    p = new Rect();
    q = new Canvas();
    q.setDrawFilter(new PaintFlagsDrawFilter(4, 2));
    d = new int[] { -65536, -16711936, -16776961 };
    e = 0;
    int[] arrayOfInt = new int[1];
    try
    {
      GLES10.glGetIntegerv(3379, arrayOfInt, 0);
      if (i1 != 0)
        i2 = arrayOfInt[0];
      f = i2;
      asp.a(g, "Max texture size: " + f);
      return;
    }
    catch (Throwable localThrowable)
    {
      while (true)
        i1 = 0;
    }
  }

  public static float a(float paramFloat)
  {
    float f1;
    if (paramFloat < 0.0F)
      f1 = 0.0F;
    do
    {
      return f1;
      f1 = paramFloat;
    }
    while (paramFloat <= 1.0F);
    return 1.0F;
  }

  public static int a(Context paramContext)
  {
    synchronized (q)
    {
      if (h == -1)
        b(paramContext);
      int i1 = h;
      return i1;
    }
  }

  public static int a(Options paramOptions, int paramInt1, int paramInt2)
  {
    return a(paramOptions, paramInt1, paramInt2, true);
  }

  public static int a(Options paramOptions, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i5 = paramOptions.outHeight;
    int i6 = paramOptions.outWidth;
    int i4 = 1;
    int i3 = 1;
    int i1 = 1;
    if ((paramInt2 <= 0) && (paramInt1 <= 0))
    {
      paramInt2 = i1;
      return paramInt2;
    }
    int i2;
    if (paramInt2 <= 0)
    {
      i2 = (int)(paramInt1 * 1.0F / i6 * i5);
      i1 = paramInt1;
      label56: if (paramBoolean)
        break label154;
      paramInt1 = b(paramOptions, Math.min(i1, i2), i2 * i1);
    }
    label154: 
    do
    {
      paramInt2 = paramInt1;
      if (f <= 0)
        break;
      i1 = Math.max(i5, i6);
      paramInt2 = paramInt1;
      if (i1 <= f)
        break;
      while (true)
      {
        paramInt2 = paramInt1;
        if (i1 / paramInt1 <= f)
          break;
        paramInt1 *= 2;
      }
      i1 = paramInt1;
      i2 = paramInt2;
      if (paramInt1 > 0)
        break label56;
      i1 = (int)(paramInt2 * 1.0F / i5 * i6);
      i2 = paramInt2;
      break label56;
      if (i5 > i2)
        break label171;
      paramInt1 = i4;
    }
    while (i6 <= i1);
    label171: paramInt2 = i5 / 2;
    i4 = i6 / 2;
    paramInt1 = i3;
    while ((paramInt2 / paramInt1 > i2) && (i4 / paramInt1 > i1))
      paramInt1 *= 2;
    long l1 = i6 * i5 / paramInt1;
    long l2 = i1 * i2 * 2;
    paramInt2 = paramInt1;
    while (true)
    {
      paramInt1 = paramInt2;
      if (l1 <= l2)
        break;
      l1 /= 2L;
      paramInt2 *= 2;
    }
  }

  public static Bitmap a(int paramInt1, int paramInt2, Config paramConfig)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      a();
    }
    return Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
  }

  public static Bitmap a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, 0);
  }

  // ERROR //
  private static Bitmap a(Context paramContext, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iload_2
    //   4: iconst_2
    //   5: if_icmple +8 -> 13
    //   8: aload 5
    //   10: astore_0
    //   11: aload_0
    //   12: areturn
    //   13: aload_0
    //   14: invokevirtual 180	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   17: iload_1
    //   18: invokestatic 186	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   21: astore 4
    //   23: aload 4
    //   25: astore_3
    //   26: aload 4
    //   28: invokestatic 189	atw:c	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   31: astore 6
    //   33: aload 6
    //   35: astore_3
    //   36: aload_3
    //   37: astore_0
    //   38: aload 4
    //   40: ifnull -29 -> 11
    //   43: aload_3
    //   44: astore_0
    //   45: aload 4
    //   47: invokevirtual 193	android/graphics/Bitmap:isRecycled	()Z
    //   50: ifne -39 -> 11
    //   53: aload 4
    //   55: invokevirtual 196	android/graphics/Bitmap:recycle	()V
    //   58: aload_3
    //   59: areturn
    //   60: astore_0
    //   61: aconst_null
    //   62: astore 4
    //   64: aload 4
    //   66: astore_3
    //   67: getstatic 54	atw:g	Ljava/lang/String;
    //   70: ldc 198
    //   72: aload_0
    //   73: invokestatic 203	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   76: pop
    //   77: aload 5
    //   79: astore_0
    //   80: aload 4
    //   82: ifnull -71 -> 11
    //   85: aload 5
    //   87: astore_0
    //   88: aload 4
    //   90: invokevirtual 193	android/graphics/Bitmap:isRecycled	()Z
    //   93: ifne -82 -> 11
    //   96: aload 4
    //   98: invokevirtual 196	android/graphics/Bitmap:recycle	()V
    //   101: aconst_null
    //   102: areturn
    //   103: astore 5
    //   105: aconst_null
    //   106: astore 4
    //   108: aload 4
    //   110: astore_3
    //   111: invokestatic 206	asq:a	()V
    //   114: aload 4
    //   116: astore_3
    //   117: getstatic 54	atw:g	Ljava/lang/String;
    //   120: ldc 208
    //   122: aload 5
    //   124: invokestatic 203	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   127: pop
    //   128: aload 4
    //   130: astore_3
    //   131: aload_0
    //   132: iload_1
    //   133: iload_2
    //   134: iconst_1
    //   135: iadd
    //   136: invokestatic 172	atw:a	(Landroid/content/Context;II)Landroid/graphics/Bitmap;
    //   139: astore_0
    //   140: aload_0
    //   141: astore_3
    //   142: aload_3
    //   143: astore_0
    //   144: aload 4
    //   146: ifnull -135 -> 11
    //   149: aload_3
    //   150: astore_0
    //   151: aload 4
    //   153: invokevirtual 193	android/graphics/Bitmap:isRecycled	()Z
    //   156: ifne -145 -> 11
    //   159: aload 4
    //   161: invokevirtual 196	android/graphics/Bitmap:recycle	()V
    //   164: aload_3
    //   165: areturn
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_3
    //   169: aload_3
    //   170: ifnull +14 -> 184
    //   173: aload_3
    //   174: invokevirtual 193	android/graphics/Bitmap:isRecycled	()Z
    //   177: ifne +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 196	android/graphics/Bitmap:recycle	()V
    //   184: aload_0
    //   185: athrow
    //   186: astore_0
    //   187: goto -18 -> 169
    //   190: astore 5
    //   192: goto -84 -> 108
    //   195: astore_0
    //   196: goto -132 -> 64
    //
    // Exception table:
    //   from	to	target	type
    //   13	23	60	java/lang/Exception
    //   13	23	103	java/lang/OutOfMemoryError
    //   13	23	166	finally
    //   26	33	186	finally
    //   67	77	186	finally
    //   111	114	186	finally
    //   117	128	186	finally
    //   131	140	186	finally
    //   26	33	190	java/lang/OutOfMemoryError
    //   26	33	195	java/lang/Exception
  }

  public static Bitmap a(Context paramContext, Bitmap paramBitmap)
  {
    return a(paramContext, paramBitmap, true);
  }

  public static Bitmap a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    return paramBitmap;
  }

  public static Bitmap a(Context paramContext, InputStream paramInputStream)
  {
    return a(paramContext, paramInputStream, 0, 0);
  }

  public static Bitmap a(Context paramContext, InputStream paramInputStream, int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
      paramContext = new Options();
    while (true)
    {
      if (paramContext != null);
      try
      {
        paramContext.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(paramInputStream, null, paramContext);
        paramContext.inSampleSize = a(paramContext, paramInt1, paramInt2);
        paramContext.inJustDecodeBounds = false;
        paramContext = BitmapFactory.decodeStream(paramInputStream, null, paramContext);
        return paramContext;
        paramContext = null;
      }
      catch (Exception paramContext)
      {
        Log.w(g, "Failed to load bitmap from stream: " + paramContext.getMessage());
        return null;
      }
      catch (OutOfMemoryError paramContext)
      {
        Log.w(g, "System is low on memory. Please consider running garbage collection");
      }
    }
    return null;
  }

  public static Bitmap a(Resources paramResources, int paramInt)
  {
    return a(paramResources, paramInt, 0, 0);
  }

  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramResources, paramInt1, paramInt2, paramInt3, true);
  }

  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Options localOptions;
    if (paramInt2 > 0)
      localOptions = new Options();
    while (true)
    {
      if (localOptions != null);
      try
      {
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
        localOptions.inSampleSize = a(localOptions, paramInt2, paramInt3, paramBoolean);
        localOptions.inJustDecodeBounds = false;
        paramResources = BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
        return paramResources;
        localOptions = null;
      }
      catch (OutOfMemoryError paramResources)
      {
        Log.w(g, "System is low on memory. Please consider running garbage collection");
        return null;
      }
      catch (Exception paramResources)
      {
        Log.w(g, "Failed to load bitmap from resource [" + paramInt1 + "]: " + paramResources.getMessage());
      }
    }
    return null;
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i1 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    int i3;
    int i6;
    int i4;
    int i5;
    if (i1 > i2)
    {
      i3 = i2 >> 1;
      i6 = i1 - i2 >> 1;
      i4 = i2;
      i5 = i1 - i6;
      i1 = i2;
    }
    while (true)
    {
      return a(paramBitmap, new Rect(i6, 0, i5, i1), new Rect(0, 0, i4, i2), i3, paramInt1, paramInt2);
      int i7 = i1 >> 1;
      i2 = i1;
      i4 = i1;
      i3 = i1;
      i5 = i1;
      i6 = 0;
      i1 = i3;
      i3 = i7;
    }
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix, boolean paramBoolean)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramMatrix, paramBoolean);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      asq.a();
      return Bitmap.createBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramMatrix, paramBoolean);
    }
    catch (Throwable paramBitmap)
    {
    }
    return null;
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if ((paramInt < 1) || (paramBitmap == null))
      return null;
    if (paramBoolean);
    while (true)
    {
      int i1 = paramBitmap.getWidth();
      int i2 = paramBitmap.getHeight();
      int[] arrayOfInt = new int[i1 * i2];
      paramBitmap.getPixels(arrayOfInt, 0, i1, 0, 0, i1, i2);
      a(arrayOfInt, paramInt, i1, i2);
      paramBitmap.setPixels(arrayOfInt, 0, i1, 0, 0, i1, i2);
      return paramBitmap;
      paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    }
  }

  public static Bitmap a(Bitmap paramBitmap, Rect paramRect)
  {
    if (paramRect == null);
    try
    {
      return Bitmap.createBitmap(paramBitmap);
      paramBitmap = Bitmap.createBitmap(paramBitmap, paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), null, true);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
    }
    return null;
  }

  private static Bitmap a(Bitmap paramBitmap, Rect paramRect1, Rect paramRect2, int paramInt1, int paramInt2, int paramInt3)
  {
    RectF localRectF = new RectF(paramRect2);
    Bitmap localBitmap = Bitmap.createBitmap(paramRect2.width(), paramRect2.height(), Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    localCanvas.drawRoundRect(localRectF, paramInt1, paramInt1, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, paramRect1, paramRect2, localPaint);
    if (paramInt2 > 0)
    {
      paramBitmap = new Paint(7);
      paramBitmap.setStyle(Style.STROKE);
      paramBitmap.setColor(paramInt3);
      paramBitmap.setStrokeWidth(paramInt2);
      localCanvas.drawCircle(localRectF.centerX(), localRectF.centerY(), (localRectF.height() - paramInt2) / 2.0F, paramBitmap);
    }
    return localBitmap;
  }

  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
      return ((BitmapDrawable)paramDrawable).getBitmap();
    if (paramDrawable != null)
      return a(paramDrawable, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    return null;
  }

  public static Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    return a(paramDrawable, new Rect(0, 0, paramInt1, paramInt2));
  }

  public static Bitmap a(Drawable paramDrawable, Context paramContext)
  {
    label387: 
    while (true)
    {
      int i3;
      int i4;
      int i6;
      int i5;
      int i1;
      int i2;
      float f1;
      synchronized (q)
      {
        if (h == -1)
          b(paramContext);
        i3 = h;
        i4 = i;
        Object localObject;
        if ((paramDrawable instanceof PaintDrawable))
        {
          paramContext = (PaintDrawable)paramDrawable;
          paramContext.setIntrinsicWidth(i3);
          paramContext.setIntrinsicHeight(i4);
          i6 = paramDrawable.getIntrinsicWidth();
          i5 = paramDrawable.getIntrinsicHeight();
          i1 = i4;
          i2 = i3;
          if (i6 > 0)
          {
            i1 = i4;
            i2 = i3;
            if (i5 > 0)
            {
              if ((i3 >= i6) && (i4 >= i5))
                break label304;
              f1 = i6 / i5;
              if (i6 <= i5)
                break label282;
              i1 = (int)(i3 / f1);
              i2 = i3;
              break label387;
            }
          }
          i4 = j;
          i3 = k;
          paramContext = Bitmap.createBitmap(i4, i3, Config.ARGB_8888);
          localObject = q;
          ((Canvas)localObject).setBitmap(paramContext);
          i4 = (i4 - i2) / 2;
          i3 = (i3 - i1) / 2;
          p.set(paramDrawable.getBounds());
          paramDrawable.setBounds(i4, i3, i2 + i4, i1 + i3);
          paramDrawable.draw((Canvas)localObject);
          paramDrawable.setBounds(p);
          ((Canvas)localObject).setBitmap(null);
          return paramContext;
        }
        else
        {
          if (!(paramDrawable instanceof BitmapDrawable))
            continue;
          localObject = (BitmapDrawable)paramDrawable;
          if (((BitmapDrawable)localObject).getBitmap().getDensity() != 0)
            continue;
          ((BitmapDrawable)localObject).setTargetDensity(paramContext.getResources().getDisplayMetrics());
        }
      }
      label282: if (i5 > i6)
      {
        i2 = (int)(i4 * f1);
        i1 = i4;
        break label387;
        label304: i1 = i4;
        i2 = i3;
        if (i6 < i3)
        {
          i1 = i4;
          i2 = i3;
          if (i5 < i4)
          {
            f1 = i3 * 1.0F / i6;
            float f2 = i4 * 1.0F / i5;
            f1 = Math.min(f1, f2);
            i2 = (int)(i6 * f1);
            i1 = (int)(i5 * f1);
          }
        }
      }
      else
      {
        i1 = i4;
        i2 = i3;
      }
    }
  }

  public static Bitmap a(Drawable paramDrawable, Rect paramRect)
  {
    if (paramDrawable == null)
      return null;
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramRect.width(), paramRect.height(), Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Rect localRect = paramDrawable.getBounds();
      paramDrawable.setBounds(paramRect);
      paramDrawable.draw(localCanvas);
      paramDrawable.setBounds(localRect);
      return localBitmap;
    }
    catch (Throwable paramDrawable)
    {
    }
    return null;
  }

  public static Bitmap a(View paramView)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Config.ARGB_8888);
    paramView.draw(new Canvas(localBitmap));
    Rect localRect = null;
    if (paramView.getClass().getName().equals("com.android.internal.policy.impl.PhoneWindow$DecorView"))
    {
      localRect = new Rect();
      paramView.getWindowVisibleDisplayFrame(localRect);
    }
    return a(localBitmap, localRect);
  }

  private static Bitmap a(View paramView, int paramInt)
  {
    Object localObject = null;
    if (paramView == null);
    boolean bool;
    int i1;
    Bitmap localBitmap;
    do
    {
      return null;
      bool = paramView.willNotCacheDrawing();
      paramView.setWillNotCacheDrawing(false);
      i1 = paramView.getDrawingCacheBackgroundColor();
      paramView.setDrawingCacheBackgroundColor(0);
      if (i1 != 0)
        paramView.destroyDrawingCache();
      paramView.buildDrawingCache();
      localBitmap = paramView.getDrawingCache();
      if (localBitmap != null)
        break;
    }
    while (paramInt > 1);
    asq.a();
    return a(paramView, paramInt + 1);
    if (paramView.getClass().getName().equals("com.android.internal.policy.impl.PhoneWindow$DecorView"))
    {
      localObject = new Rect();
      paramView.getWindowVisibleDisplayFrame((Rect)localObject);
    }
    localObject = a(localBitmap, (Rect)localObject);
    paramView.destroyDrawingCache();
    paramView.setWillNotCacheDrawing(bool);
    paramView.setDrawingCacheBackgroundColor(i1);
    return localObject;
  }

  public static Bitmap a(InputStream paramInputStream, boolean paramBoolean, int paramInt)
  {
    Options localOptions2 = new Options();
    Options localOptions1 = localOptions2;
    if (paramBoolean)
      localOptions1 = a(localOptions2);
    localOptions1.inDensity = paramInt;
    localOptions1.inTargetDensity = vj.d;
    return BitmapFactory.decodeStream(paramInputStream, null, localOptions1);
  }

  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, true);
  }

  public static Bitmap a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject;
    if (paramInt1 > 0)
      localObject = new Options();
    while (true)
    {
      if (localObject != null);
      try
      {
        ((Options)localObject).inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, (Options)localObject);
        ((Options)localObject).inSampleSize = a((Options)localObject, paramInt1, paramInt2, paramBoolean);
        ((Options)localObject).inJustDecodeBounds = false;
        localObject = BitmapFactory.decodeFile(paramString, (Options)localObject);
        return localObject;
        localObject = null;
      }
      catch (Throwable localThrowable)
      {
        Log.w(g, "Failed to load bitmap from File [" + paramString + "]: " + localThrowable.getMessage());
      }
    }
    return null;
  }

  public static Bitmap a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (!new File(paramString).exists()))
      return null;
    Options localOptions2 = new Options();
    Options localOptions1 = localOptions2;
    if (paramBoolean)
      localOptions1 = a(localOptions2);
    return BitmapFactory.decodeFile(paramString, localOptions1);
  }

  public static Bitmap a(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramString == null) || (!new File(paramString).exists()))
      return null;
    Options localOptions2 = new Options();
    Options localOptions1 = localOptions2;
    if (paramBoolean)
      localOptions1 = a(localOptions2);
    localOptions1.inDensity = paramInt;
    return BitmapFactory.decodeFile(paramString, localOptions1);
  }

  public static Bitmap a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
    }
    return null;
  }

  public static Options a(Options paramOptions)
  {
    Options localOptions = paramOptions;
    if (paramOptions == null)
      localOptions = new Options();
    localOptions.inPurgeable = true;
    localOptions.inPreferredConfig = Config.RGB_565;
    localOptions.inDither = false;
    localOptions.inInputShareable = true;
    return localOptions;
  }

  public static ShapeDrawable a(float paramFloat, int paramInt)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat, paramFloat }, null, null));
    localShapeDrawable.getPaint().setColor(paramInt);
    return localShapeDrawable;
  }

  public static ShapeDrawable a(int paramInt)
  {
    return a(paramInt, 0);
  }

  public static ShapeDrawable a(int paramInt1, int paramInt2)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
    localShapeDrawable.getPaint().setColor(paramInt1);
    if (paramInt2 > 0)
    {
      localShapeDrawable.setIntrinsicWidth(paramInt2);
      localShapeDrawable.setIntrinsicHeight(paramInt2);
    }
    return localShapeDrawable;
  }

  public static void a()
  {
    Log.e(g, "OutOfMemory happens! GC next.");
    System.gc();
  }

  public static void a(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
      return;
    try
    {
      paramBitmap.recycle();
      return;
    }
    catch (Exception paramBitmap)
    {
    }
  }

  public static void a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i16 = paramInt2 - 1;
    int i17 = paramInt3 - 1;
    int i1 = paramInt2 * paramInt3;
    int i18 = paramInt1 + paramInt1 + 1;
    int[] arrayOfInt1 = new int[i1];
    int[] arrayOfInt2 = new int[i1];
    int[] arrayOfInt3 = new int[i1];
    int[] arrayOfInt4 = new int[Math.max(paramInt2, paramInt3)];
    i1 = i18 + 1 >> 1;
    int i2 = i1 * i1;
    int[] arrayOfInt5 = new int[i2 * 256];
    i1 = 0;
    while (i1 < i2 * 256)
    {
      arrayOfInt5[i1] = (i1 / i2);
      i1 += 1;
    }
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i18, 3 });
    int i19 = paramInt1 + 1;
    int i12 = 0;
    i1 = 0;
    int i11 = 0;
    int i13;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    int i9;
    int i10;
    int i3;
    int i14;
    int[] arrayOfInt6;
    int i15;
    int i20;
    while (i11 < paramInt3)
    {
      i2 = 0;
      i13 = -paramInt1;
      i4 = 0;
      i5 = 0;
      i6 = 0;
      i7 = 0;
      i8 = 0;
      i9 = 0;
      i10 = 0;
      i3 = 0;
      if (i13 <= paramInt1)
      {
        i14 = paramArrayOfInt[(Math.min(i16, Math.max(i13, 0)) + i1)];
        arrayOfInt6 = arrayOfInt[(i13 + paramInt1)];
        arrayOfInt6[0] = ((0xFF0000 & i14) >> 16);
        arrayOfInt6[1] = ((0xFF00 & i14) >> 8);
        arrayOfInt6[2] = (i14 & 0xFF);
        i14 = i19 - Math.abs(i13);
        i10 += arrayOfInt6[0] * i14;
        i9 += arrayOfInt6[1] * i14;
        i8 += i14 * arrayOfInt6[2];
        if (i13 > 0)
        {
          i4 += arrayOfInt6[0];
          i3 += arrayOfInt6[1];
          i2 += arrayOfInt6[2];
        }
        while (true)
        {
          i13 += 1;
          break;
          i7 += arrayOfInt6[0];
          i6 += arrayOfInt6[1];
          i5 += arrayOfInt6[2];
        }
      }
      i13 = i9;
      i15 = 0;
      i9 = paramInt1;
      i14 = i10;
      i10 = i8;
      i8 = i15;
      while (i8 < paramInt2)
      {
        arrayOfInt1[i1] = arrayOfInt5[i14];
        arrayOfInt2[i1] = arrayOfInt5[i13];
        arrayOfInt3[i1] = arrayOfInt5[i10];
        arrayOfInt6 = arrayOfInt[((i9 - paramInt1 + i18) % i18)];
        int i21 = arrayOfInt6[0];
        i20 = arrayOfInt6[1];
        i15 = arrayOfInt6[2];
        if (i11 == 0)
          arrayOfInt4[i8] = Math.min(i8 + paramInt1 + 1, i16);
        int i22 = paramArrayOfInt[(arrayOfInt4[i8] + i12)];
        arrayOfInt6[0] = ((0xFF0000 & i22) >> 16);
        arrayOfInt6[1] = ((0xFF00 & i22) >> 8);
        arrayOfInt6[2] = (i22 & 0xFF);
        i4 += arrayOfInt6[0];
        i3 += arrayOfInt6[1];
        i2 += arrayOfInt6[2];
        i14 = i14 - i7 + i4;
        i13 = i13 - i6 + i3;
        i10 = i10 - i5 + i2;
        i9 = (i9 + 1) % i18;
        arrayOfInt6 = arrayOfInt[(i9 % i18)];
        i7 = i7 - i21 + arrayOfInt6[0];
        i6 = i6 - i20 + arrayOfInt6[1];
        i5 = i5 - i15 + arrayOfInt6[2];
        i4 -= arrayOfInt6[0];
        i3 -= arrayOfInt6[1];
        i2 -= arrayOfInt6[2];
        i1 += 1;
        i8 += 1;
      }
      i12 += paramInt2;
      i11 += 1;
    }
    i1 = 0;
    while (i1 < paramInt2)
    {
      i10 = 0;
      i12 = -paramInt1 * paramInt2;
      i11 = -paramInt1;
      i8 = 0;
      i5 = 0;
      i6 = 0;
      i7 = 0;
      i2 = 0;
      i4 = 0;
      i3 = 0;
      i9 = 0;
      if (i11 <= paramInt1)
      {
        i13 = Math.max(0, i12) + i1;
        arrayOfInt6 = arrayOfInt[(i11 + paramInt1)];
        arrayOfInt6[0] = arrayOfInt1[i13];
        arrayOfInt6[1] = arrayOfInt2[i13];
        arrayOfInt6[2] = arrayOfInt3[i13];
        i14 = i19 - Math.abs(i11);
        i15 = arrayOfInt1[i13];
        i16 = arrayOfInt2[i13];
        i20 = arrayOfInt3[i13];
        if (i11 > 0)
        {
          i8 += arrayOfInt6[0];
          i9 += arrayOfInt6[1];
          i10 += arrayOfInt6[2];
        }
        while (true)
        {
          i13 = i12;
          if (i11 < i17)
            i13 = i12 + paramInt2;
          i11 += 1;
          i2 = i20 * i14 + i2;
          i4 = i16 * i14 + i4;
          i3 = i15 * i14 + i3;
          i12 = i13;
          break;
          i7 += arrayOfInt6[0];
          i6 += arrayOfInt6[1];
          i5 += arrayOfInt6[2];
        }
      }
      i14 = i4;
      i15 = i3;
      i16 = 0;
      i3 = i1;
      i11 = i10;
      i12 = i9;
      i13 = i8;
      i4 = i5;
      i5 = i6;
      i6 = i7;
      i7 = paramInt1;
      i10 = i15;
      i9 = i14;
      i8 = i2;
      i2 = i16;
      while (i2 < paramInt3)
      {
        paramArrayOfInt[i3] = (0xFF000000 & paramArrayOfInt[i3] | arrayOfInt5[i10] << 16 | arrayOfInt5[i9] << 8 | arrayOfInt5[i8]);
        arrayOfInt6 = arrayOfInt[((i7 - paramInt1 + i18) % i18)];
        i16 = arrayOfInt6[0];
        i15 = arrayOfInt6[1];
        i14 = arrayOfInt6[2];
        if (i1 == 0)
          arrayOfInt4[i2] = (Math.min(i2 + i19, i17) * paramInt2);
        i20 = arrayOfInt4[i2] + i1;
        arrayOfInt6[0] = arrayOfInt1[i20];
        arrayOfInt6[1] = arrayOfInt2[i20];
        arrayOfInt6[2] = arrayOfInt3[i20];
        i13 += arrayOfInt6[0];
        i12 += arrayOfInt6[1];
        i11 += arrayOfInt6[2];
        i10 = i10 - i6 + i13;
        i9 = i9 - i5 + i12;
        i8 = i8 - i4 + i11;
        i7 = (i7 + 1) % i18;
        arrayOfInt6 = arrayOfInt[i7];
        i6 = i6 - i16 + arrayOfInt6[0];
        i5 = i5 - i15 + arrayOfInt6[1];
        i4 = i4 - i14 + arrayOfInt6[2];
        i13 -= arrayOfInt6[0];
        i12 -= arrayOfInt6[1];
        i11 -= arrayOfInt6[2];
        i3 += paramInt2;
        i2 += 1;
      }
      i1 += 1;
    }
  }

  // ERROR //
  public static boolean a(Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_1
    //   11: invokevirtual 609	java/io/File:getParentFile	()Ljava/io/File;
    //   14: invokevirtual 529	java/io/File:exists	()Z
    //   17: ifne +11 -> 28
    //   20: aload_1
    //   21: invokevirtual 609	java/io/File:getParentFile	()Ljava/io/File;
    //   24: invokevirtual 612	java/io/File:mkdirs	()Z
    //   27: pop
    //   28: aload_1
    //   29: invokestatic 617	aqx:e	(Ljava/io/File;)Z
    //   32: pop
    //   33: new 619	java/io/FileOutputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 622	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   41: astore_2
    //   42: aload_2
    //   43: astore_1
    //   44: aload_0
    //   45: getstatic 628	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   48: bipush 100
    //   50: aload_2
    //   51: invokevirtual 632	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   54: istore 4
    //   56: aload_2
    //   57: astore_1
    //   58: aload_2
    //   59: invokevirtual 635	java/io/FileOutputStream:flush	()V
    //   62: aload_2
    //   63: invokestatic 640	arf:a	(Ljava/io/Closeable;)V
    //   66: iload 4
    //   68: ireturn
    //   69: astore_3
    //   70: aconst_null
    //   71: astore_0
    //   72: aload_0
    //   73: astore_1
    //   74: getstatic 54	atw:g	Ljava/lang/String;
    //   77: ldc_w 642
    //   80: aload_3
    //   81: invokestatic 644	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   84: pop
    //   85: aload_0
    //   86: invokestatic 640	arf:a	(Ljava/io/Closeable;)V
    //   89: iconst_0
    //   90: ireturn
    //   91: astore_0
    //   92: aconst_null
    //   93: astore_1
    //   94: aload_1
    //   95: invokestatic 640	arf:a	(Ljava/io/Closeable;)V
    //   98: aload_0
    //   99: athrow
    //   100: astore_0
    //   101: goto -7 -> 94
    //   104: astore_3
    //   105: aload_2
    //   106: astore_0
    //   107: goto -35 -> 72
    //
    // Exception table:
    //   from	to	target	type
    //   33	42	69	java/lang/Throwable
    //   33	42	91	finally
    //   44	56	100	finally
    //   58	62	100	finally
    //   74	85	100	finally
    //   44	56	104	java/lang/Throwable
    //   58	62	104	java/lang/Throwable
  }

  // ERROR //
  public static boolean a(Bitmap paramBitmap, File paramFile, CompressFormat paramCompressFormat)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: invokestatic 650	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   13: ldc_w 652
    //   16: invokevirtual 466	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifeq -11 -> 8
    //   22: aload_1
    //   23: invokevirtual 609	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 529	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 609	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 612	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: new 619	java/io/FileOutputStream
    //   43: dup
    //   44: aload_1
    //   45: invokespecial 622	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   48: astore_3
    //   49: aload_3
    //   50: astore_1
    //   51: aload_0
    //   52: aload_2
    //   53: bipush 90
    //   55: aload_3
    //   56: invokevirtual 632	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   59: istore 4
    //   61: aload_3
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 635	java/io/FileOutputStream:flush	()V
    //   67: aload_3
    //   68: invokestatic 640	arf:a	(Ljava/io/Closeable;)V
    //   71: iload 4
    //   73: ireturn
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_0
    //   77: aload_0
    //   78: astore_1
    //   79: getstatic 54	atw:g	Ljava/lang/String;
    //   82: ldc_w 642
    //   85: aload_2
    //   86: invokestatic 644	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   89: pop
    //   90: aload_0
    //   91: invokestatic 640	arf:a	(Ljava/io/Closeable;)V
    //   94: iconst_0
    //   95: ireturn
    //   96: astore_0
    //   97: aconst_null
    //   98: astore_1
    //   99: aload_1
    //   100: invokestatic 640	arf:a	(Ljava/io/Closeable;)V
    //   103: aload_0
    //   104: athrow
    //   105: astore_0
    //   106: goto -7 -> 99
    //   109: astore_2
    //   110: aload_3
    //   111: astore_0
    //   112: goto -35 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   40	49	74	java/lang/Throwable
    //   40	49	96	finally
    //   51	61	105	finally
    //   63	67	105	finally
    //   79	90	105	finally
    //   51	61	109	java/lang/Throwable
    //   63	67	109	java/lang/Throwable
  }

  public static boolean a(Bitmap paramBitmap, String paramString, CompressFormat paramCompressFormat)
  {
    if ((paramBitmap == null) || (paramString == null))
      return false;
    Object localObject = null;
    String str = null;
    while (true)
    {
      try
      {
        paramString = SwipeApplication.c().openFileOutput(paramString, 1);
        if (paramString != null)
        {
          str = paramString;
          localObject = paramString;
          bool = paramBitmap.compress(paramCompressFormat, 90, paramString);
          str = paramString;
          localObject = paramString;
          paramString.flush();
          arf.a(paramString);
          return bool;
        }
      }
      catch (Throwable paramBitmap)
      {
        localObject = str;
        Log.e(g, "fail to save pic", paramBitmap);
        arf.a(str);
        return false;
      }
      finally
      {
        arf.a((Closeable)localObject);
      }
      boolean bool = false;
    }
  }

  public static boolean a(File paramFile)
  {
    boolean bool = true;
    if ((paramFile == null) || (!paramFile.exists()))
      return false;
    Options localOptions = new Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
      if (localOptions.outWidth > 0)
      {
        int i1 = localOptions.outHeight;
        if (i1 <= 0);
      }
      while (true)
      {
        return bool;
        bool = false;
      }
    }
    catch (Throwable paramFile)
    {
    }
    return false;
  }

  public static int[] a(String paramString)
  {
    // Byte code:
    //   0: new 139	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 217	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: iconst_1
    //   10: putfield 221	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   13: aload_0
    //   14: aload_1
    //   15: invokestatic 517	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   18: pop
    //   19: aload_1
    //   20: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   23: istore_2
    //   24: aload_1
    //   25: getfield 142	android/graphics/BitmapFactory$Options:outHeight	I
    //   28: istore_3
    //   29: iconst_2
    //   30: newarray int
    //   32: dup
    //   33: iconst_0
    //   34: iload_2
    //   35: iastore
    //   36: dup
    //   37: iconst_1
    //   38: iload_3
    //   39: iastore
    //   40: areturn
    //   41: astore_1
    //   42: getstatic 54	atw:g	Ljava/lang/String;
    //   45: new 34	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 519
    //   55: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 254
    //   64: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 520	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   71: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 239	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   80: pop
    //   81: iconst_2
    //   82: newarray int
    //   84: dup
    //   85: iconst_0
    //   86: iconst_0
    //   87: iastore
    //   88: dup
    //   89: iconst_1
    //   90: iconst_0
    //   91: iastore
    //   92: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   13	29	41	java/lang/Throwable
  }

  public static int b(Options paramOptions, int paramInt1, int paramInt2)
  {
    int i1 = c(paramOptions, paramInt1, paramInt2);
    if (i1 <= 8)
    {
      paramInt1 = 1;
      while (true)
      {
        paramInt2 = paramInt1;
        if (paramInt1 >= i1)
          break;
        paramInt1 <<= 1;
      }
    }
    paramInt2 = (i1 + 7) / 8 * 8;
    return paramInt2;
  }

  // ERROR //
  public static Bitmap b(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 180	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: astore_0
    //   5: aload_0
    //   6: ldc_w 669
    //   9: invokestatic 186	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   12: astore_0
    //   13: iload_1
    //   14: iload_1
    //   15: getstatic 316	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   18: invokestatic 166	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   21: astore_2
    //   22: new 94	android/graphics/Canvas
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 319	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   30: astore_3
    //   31: new 63	android/graphics/Paint
    //   34: dup
    //   35: invokespecial 69	android/graphics/Paint:<init>	()V
    //   38: astore 4
    //   40: aload 4
    //   42: bipush 7
    //   44: invokevirtual 672	android/graphics/Paint:setFlags	(I)V
    //   47: aload_3
    //   48: getstatic 61	atw:a	Landroid/graphics/PaintFlagsDrawFilter;
    //   51: invokevirtual 101	android/graphics/Canvas:setDrawFilter	(Landroid/graphics/DrawFilter;)V
    //   54: new 674	android/graphics/ColorMatrix
    //   57: dup
    //   58: invokespecial 675	android/graphics/ColorMatrix:<init>	()V
    //   61: astore 5
    //   63: aload 5
    //   65: fconst_0
    //   66: invokevirtual 678	android/graphics/ColorMatrix:setSaturation	(F)V
    //   69: aload 4
    //   71: new 680	android/graphics/ColorMatrixColorFilter
    //   74: dup
    //   75: aload 5
    //   77: invokespecial 683	android/graphics/ColorMatrixColorFilter:<init>	(Landroid/graphics/ColorMatrix;)V
    //   80: invokevirtual 687	android/graphics/Paint:setColorFilter	(Landroid/graphics/ColorFilter;)Landroid/graphics/ColorFilter;
    //   83: pop
    //   84: aload 4
    //   86: bipush 75
    //   88: invokevirtual 690	android/graphics/Paint:setAlpha	(I)V
    //   91: aload_3
    //   92: aload_0
    //   93: aconst_null
    //   94: new 89	android/graphics/Rect
    //   97: dup
    //   98: iconst_0
    //   99: iconst_0
    //   100: iload_1
    //   101: iload_1
    //   102: invokespecial 265	android/graphics/Rect:<init>	(IIII)V
    //   105: aload 4
    //   107: invokevirtual 353	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   110: aload_0
    //   111: aload_2
    //   112: if_acmpeq +7 -> 119
    //   115: aload_0
    //   116: invokestatic 692	atw:a	(Landroid/graphics/Bitmap;)V
    //   119: aload_2
    //   120: areturn
    //   121: astore_0
    //   122: aconst_null
    //   123: areturn
    //   124: astore_2
    //   125: aload_0
    //   126: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   5	13	121	java/lang/Throwable
    //   13	110	124	java/lang/Throwable
    //   115	119	124	java/lang/Throwable
  }

  public static Bitmap b(View paramView)
  {
    return a(paramView, 1);
  }

  public static Bitmap b(String paramString)
  {
    return a(paramString, 0, 0);
  }

  private static void b(Context paramContext)
  {
    paramContext = paramContext.getResources();
    float f1 = paramContext.getDisplayMetrics().density;
    int i1 = (int)paramContext.getDimension(2131296335);
    i = i1;
    h = i1;
    i1 = h;
    k = i1;
    j = i1;
    l.setMaskFilter(new BlurMaskFilter(f1 * 5.0F, Blur.NORMAL));
    m.setColor(-15616);
    n.setColor(-29184);
    paramContext = new ColorMatrix();
    paramContext.setSaturation(0.2F);
    o.setColorFilter(new ColorMatrixColorFilter(paramContext));
    o.setAlpha(136);
  }

  public static boolean b(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }

  public static boolean b(Drawable paramDrawable)
  {
    return (paramDrawable == null) || (paramDrawable.getIntrinsicHeight() <= 0) || (paramDrawable.getIntrinsicWidth() <= 0) || (paramDrawable.getIntrinsicWidth() > paramDrawable.getIntrinsicHeight());
  }

  private static int c(Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i1;
    int i2;
    if (paramInt2 == -1)
    {
      i1 = 1;
      if (paramInt1 != -1)
        break label60;
      i2 = 128;
      label31: if (i2 >= i1)
        break label84;
    }
    label60: label84: 
    do
    {
      return i1;
      i1 = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      i2 = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label31;
      if ((paramInt2 == -1) && (paramInt1 == -1))
        return 1;
    }
    while (paramInt1 == -1);
    return i2;
  }

  public static Bitmap c(Bitmap paramBitmap)
  {
    if (aqs.b())
    {
      Object localObject2 = new BitmapShader(paramBitmap, TileMode.CLAMP, TileMode.CLAMP);
      localObject1 = new Paint();
      ((Paint)localObject1).setShader((Shader)localObject2);
      int i1 = paramBitmap.getWidth();
      int i2 = paramBitmap.getHeight();
      int i3 = paramBitmap.getWidth();
      int i4 = paramBitmap.getHeight();
      if (paramBitmap.hasAlpha());
      for (paramBitmap = Config.ARGB_8888; ; paramBitmap = Config.RGB_565)
      {
        paramBitmap = Bitmap.createBitmap(i3, i4, paramBitmap);
        localObject2 = new Canvas(paramBitmap);
        ((Canvas)localObject2).translate(i1, 0.0F);
        ((Canvas)localObject2).scale(-1.0F, 1.0F);
        ((Canvas)localObject2).drawRect(0.0F, 0.0F, i1, i2, (Paint)localObject1);
        return paramBitmap;
      }
    }
    Object localObject1 = new Matrix();
    ((Matrix)localObject1).preScale(-1.0F, 1.0F);
    return a(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);
  }

  public static boolean c(Drawable paramDrawable)
  {
    return (paramDrawable != null) && ((!(paramDrawable instanceof BitmapDrawable)) || (b(((BitmapDrawable)paramDrawable).getBitmap()))) && ((!(paramDrawable instanceof apd)) || (b(((apd)paramDrawable).a())));
  }

  public static byte[] d(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     atw
 * JD-Core Version:    0.6.2
 */