package cmcm.com.myapplication;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.opengl.GLES10;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import com.hola.channel.sdk.game.graphics.ImageCache;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.util.Arrays;

public class sb
{
  static final int a;
  private static final String b = "GameSDK." + sb.class.getSimpleName();

  static
  {
    int[] arrayOfInt = new int[1];
    GLES10.glGetIntegerv(3379, arrayOfInt, 0);
    a = arrayOfInt[0];
    Log.i(b, "Max texture size: " + a);
  }

  public static int a(Config paramConfig)
  {
    int j = 2;
    int i;
    if (paramConfig == Config.ARGB_8888)
      i = 4;
    do
    {
      do
      {
        return i;
        i = j;
      }
      while (paramConfig == Config.RGB_565);
      i = j;
    }
    while (paramConfig == Config.ARGB_4444);
    if (paramConfig == Config.ALPHA_8)
      return 1;
    return 1;
  }

  public static int a(Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if ((k > paramInt2) || (m > paramInt1))
    {
      j = k / 2;
      int n = m / 2;
      while ((j / i > paramInt2) && (n / i > paramInt1))
        i *= 2;
      j = i;
      if (a > 0)
      {
        paramInt1 = Math.max(k, m);
        j = i;
        if (paramInt1 > a)
        {
          Log.w(b, "Ensuring the long side be shorter than the max texture size...");
          while (true)
          {
            j = i;
            if (paramInt1 / i <= a)
              break;
            i *= 2;
          }
        }
      }
    }
    return j;
  }

  public static int a(BitmapDrawable paramBitmapDrawable)
  {
    if (paramBitmapDrawable == null)
      return 0;
    return b(paramBitmapDrawable.getBitmap());
  }

  // ERROR //
  public static Bitmap a(android.content.Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: invokevirtual 108	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   6: iload_1
    //   7: invokestatic 114	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   10: astore_0
    //   11: aload_0
    //   12: astore_2
    //   13: aload_0
    //   14: invokestatic 117	sb:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   17: astore_3
    //   18: aload_3
    //   19: astore_2
    //   20: aload_0
    //   21: ifnull +18 -> 39
    //   24: aload_3
    //   25: astore_2
    //   26: aload_0
    //   27: invokevirtual 123	android/graphics/Bitmap:isRecycled	()Z
    //   30: ifne +9 -> 39
    //   33: aload_0
    //   34: invokevirtual 126	android/graphics/Bitmap:recycle	()V
    //   37: aload_3
    //   38: astore_2
    //   39: aload_2
    //   40: areturn
    //   41: astore_2
    //   42: aconst_null
    //   43: astore_0
    //   44: getstatic 32	sb:b	Ljava/lang/String;
    //   47: ldc 128
    //   49: aload_2
    //   50: invokestatic 132	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   53: pop
    //   54: aload_0
    //   55: astore_2
    //   56: aload_0
    //   57: ifnull -18 -> 39
    //   60: aload_0
    //   61: astore_2
    //   62: aload_0
    //   63: invokevirtual 123	android/graphics/Bitmap:isRecycled	()Z
    //   66: ifne -27 -> 39
    //   69: aload_0
    //   70: invokevirtual 126	android/graphics/Bitmap:recycle	()V
    //   73: aload_0
    //   74: areturn
    //   75: astore_3
    //   76: aload_2
    //   77: astore_0
    //   78: aload_3
    //   79: astore_2
    //   80: aload_0
    //   81: ifnull +14 -> 95
    //   84: aload_0
    //   85: invokevirtual 123	android/graphics/Bitmap:isRecycled	()Z
    //   88: ifne +7 -> 95
    //   91: aload_0
    //   92: invokevirtual 126	android/graphics/Bitmap:recycle	()V
    //   95: aload_2
    //   96: athrow
    //   97: astore_2
    //   98: goto -18 -> 80
    //   101: astore_2
    //   102: goto -58 -> 44
    //
    // Exception table:
    //   from	to	target	type
    //   2	11	41	java/lang/Throwable
    //   2	11	75	finally
    //   13	18	75	finally
    //   44	54	97	finally
    //   13	18	101	java/lang/Throwable
  }

  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3, ImageCache paramImageCache, String paramString)
  {
    Options localOptions = new Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
    localOptions.inSampleSize = a(localOptions, paramInt2, paramInt3);
    a(localOptions, paramImageCache, paramString);
    localOptions.inJustDecodeBounds = false;
    return BitmapFactory.decodeResource(paramResources, paramInt1, localOptions);
  }

  public static Bitmap a(Bitmap paramBitmap)
  {
    if (Build.PRODUCT.toLowerCase().contains("meizu_mx"))
    {
      Object localObject2 = new BitmapShader(paramBitmap, TileMode.CLAMP, TileMode.CLAMP);
      localObject1 = new Paint();
      ((Paint)localObject1).setShader((Shader)localObject2);
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      int k = paramBitmap.getWidth();
      int m = paramBitmap.getHeight();
      if (paramBitmap.hasAlpha());
      for (paramBitmap = Config.ARGB_8888; ; paramBitmap = Config.RGB_565)
      {
        paramBitmap = Bitmap.createBitmap(k, m, paramBitmap);
        localObject2 = new Canvas(paramBitmap);
        ((Canvas)localObject2).translate(i, 0.0F);
        ((Canvas)localObject2).scale(-1.0F, 1.0F);
        ((Canvas)localObject2).drawRect(0.0F, 0.0F, i, j, (Paint)localObject1);
        return paramBitmap;
      }
    }
    Object localObject1 = new Matrix();
    ((Matrix)localObject1).preScale(-1.0F, 1.0F);
    return a(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject1, true);
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Matrix paramMatrix, boolean paramBoolean)
  {
    try
    {
      paramBitmap = Bitmap.createBitmap(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4, paramMatrix, paramBoolean);
      return paramBitmap;
    }
    catch (Throwable paramBitmap)
    {
    }
    return null;
  }

  public static Bitmap a(FileDescriptor paramFileDescriptor, int paramInt1, int paramInt2, ImageCache paramImageCache, String paramString)
  {
    Options localOptions = new Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
    localOptions.inSampleSize = a(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    a(localOptions, paramImageCache, paramString);
    return BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, localOptions);
  }

  public static Bitmap a(InputStream paramInputStream, int paramInt1, int paramInt2, ImageCache paramImageCache, String paramString)
  {
    boolean bool = paramInputStream.markSupported();
    if (bool)
      paramInputStream.mark(0);
    Options localOptions = new Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    localOptions.inSampleSize = a(localOptions, paramInt1, paramInt2);
    localOptions.inJustDecodeBounds = false;
    a(localOptions, paramImageCache, paramString);
    if (bool);
    try
    {
      paramInputStream.reset();
      label74: return BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    }
    catch (Throwable paramImageCache)
    {
      break label74;
    }
  }

  public static Drawable a(float paramFloat, int paramInt1, int paramInt2)
  {
    Drawable localDrawable2;
    if (paramFloat < 0.01F)
      localDrawable2 = a(paramInt1);
    for (Drawable localDrawable1 = a(paramInt2); ; localDrawable1 = a(paramInt2, paramFloat))
    {
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localDrawable1);
      localStateListDrawable.addState(new int[0], localDrawable2);
      return localStateListDrawable;
      localDrawable2 = a(paramInt1, paramFloat);
    }
  }

  public static Drawable a(int paramInt)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(new RectShape());
    localShapeDrawable.getPaint().setColor(paramInt);
    return localShapeDrawable;
  }

  public static Drawable a(int paramInt, float paramFloat)
  {
    return a(paramInt, paramFloat, 0, 0);
  }

  public static Drawable a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if (paramInt2 > 0)
    {
      localObject = new GradientDrawable();
      ((GradientDrawable)localObject).setColor(paramInt1);
      ((GradientDrawable)localObject).setCornerRadius(paramFloat);
      ((GradientDrawable)localObject).setStroke(paramInt2, paramInt3);
      return localObject;
    }
    Object localObject = new float[8];
    Arrays.fill((float[])localObject, paramFloat);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(new RoundRectShape((float[])localObject, null, null));
    localShapeDrawable.getPaint().setColor(paramInt1);
    return localShapeDrawable;
  }

  @TargetApi(11)
  private static void a(Options paramOptions, ImageCache paramImageCache, String paramString)
  {
    paramOptions.inMutable = true;
    if (paramImageCache != null)
    {
      paramImageCache = paramImageCache.a(paramString, paramOptions);
      if (paramImageCache != null)
        paramOptions.inBitmap = paramImageCache;
    }
  }

  @TargetApi(19)
  public static boolean a(Bitmap paramBitmap, Options paramOptions)
  {
    if (VERSION.SDK_INT < 19)
      if ((paramBitmap.getWidth() != paramOptions.outWidth) || (paramBitmap.getHeight() != paramOptions.outHeight) || (paramOptions.inSampleSize != 1));
    int i;
    do
      while (true)
      {
        return true;
        return false;
        i = paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * a(paramBitmap.getConfig());
        try
        {
          int j = paramBitmap.getAllocationByteCount();
          if (i > j)
            return false;
        }
        catch (Throwable paramOptions)
        {
        }
      }
    while (i <= paramBitmap.getByteCount());
    return false;
  }

  @TargetApi(19)
  public static int b(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      Log.w(b, "Trying to get the size of a null bitmap!");
      return 0;
    }
    if (VERSION.SDK_INT >= 19)
      try
      {
        int i = paramBitmap.getAllocationByteCount();
        return i;
      }
      catch (Throwable localThrowable)
      {
      }
    if (VERSION.SDK_INT >= 12)
      return paramBitmap.getByteCount();
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     sb
 * JD-Core Version:    0.6.2
 */