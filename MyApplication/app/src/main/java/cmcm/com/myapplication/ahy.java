package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.lazyswipe.SwipeApplication;
import java.lang.ref.WeakReference;

public class ahy extends ahq
{
  public static boolean b = true;
  private static WeakReference<BitmapDrawable> c;

  ahy(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext, paramString1, paramString2, paramInt);
  }

  public static float a(float paramFloat)
  {
    return a(paramFloat, 360);
  }

  private static float a(float paramFloat, int paramInt)
  {
    if (b)
    {
      paramFloat = 10800.0F + paramFloat;
      int i = (int)paramFloat;
      return (float)(paramFloat - Math.ceil(paramFloat)) + i % paramInt;
    }
    return ((int)paramFloat + 10800) % paramInt;
  }

  public static float a(boolean paramBoolean, float paramFloat)
  {
    if (paramBoolean)
      return paramFloat;
    paramFloat = a(paramFloat);
    if ((paramFloat >= 0.0F) && (paramFloat < 180.0F));
    for (paramFloat = 180.0F - paramFloat; ; paramFloat = 540.0F - paramFloat)
      return paramFloat;
  }

  public static Drawable a(Context paramContext, Drawable paramDrawable)
  {
    if (paramDrawable == null)
      localObject = null;
    int j;
    do
    {
      return localObject;
      j = paramDrawable.getIntrinsicWidth();
      localObject = paramDrawable;
    }
    while (j <= 0);
    Object localObject = Bitmap.createBitmap(j, j, Config.ARGB_8888);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    Paint localPaint = new Paint();
    localPaint.setFlags(7);
    localCanvas.setDrawFilter(atw.a);
    int i = 1728053247;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      Bitmap localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      i = zp.a(SwipeApplication.c(), localBitmap);
    }
    localPaint.setColor(i);
    localCanvas.drawCircle(j / 2, j / 2, j / 2, localPaint);
    i = (j - (int)(j / 1.414D)) / 2;
    paramDrawable.setBounds(i, i, j - i, j - i);
    paramDrawable.draw(localCanvas);
    return new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject);
  }

  public static float b(float paramFloat)
  {
    return a(paramFloat, 270);
  }

  public static Bitmap b(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    Bitmap localBitmap = Bitmap.createBitmap(i, i, Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setFlags(7);
    localCanvas.setDrawFilter(atw.a);
    localPaint.setColor(zp.a(SwipeApplication.c(), paramBitmap));
    localCanvas.drawCircle(i / 2, i / 2, i / 2, localPaint);
    int j = (i - (int)(i / 1.414D)) / 2;
    localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, i, i), new Rect(j, j, i - j, i - j), new Paint());
    return localBitmap;
  }

  public static float c(float paramFloat)
  {
    return a(paramFloat, 1080);
  }

  public static float d(float paramFloat)
  {
    return a(paramFloat, 10800);
  }

  public static boolean d(Context paramContext)
  {
    return "iwatch".equals(ahx.a(paramContext));
  }

  public static BitmapDrawable x()
  {
    try
    {
      if ((c != null) && (c.get() != null) && (atw.b(((BitmapDrawable) c.get()).getBitmap())))
      {
        BitmapDrawable localBitmapDrawable = (BitmapDrawable)c.get();
        return localBitmapDrawable;
      }
    }
    catch (Throwable localThrowable)
    {
      SwipeApplication localSwipeApplication = SwipeApplication.c();
      int i = localSwipeApplication.getResources().getDimensionPixelSize(2131296279);
      Bitmap localBitmap = Bitmap.createBitmap(i, i, Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      localPaint.setFlags(7);
      localCanvas.setDrawFilter(atw.a);
      localPaint.setColor(1728053247);
      localCanvas.drawCircle(i / 2, i / 2, i / 2, localPaint);
      c = new WeakReference(new BitmapDrawable(localSwipeApplication.getResources(), localBitmap));
    }
    return (BitmapDrawable)c.get();
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
      localCanvas.drawCircle(i / 2, i / 2, i / 2, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
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

  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((c != null) && (c.get() != null));
    try
    {
      atw.a(((BitmapDrawable) c.get()).getBitmap());
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public boolean l_()
  {
    return false;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahy
 * JD-Core Version:    0.6.2
 */