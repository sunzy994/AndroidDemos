package cmcm.com.myapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import java.io.File;

public class aid
{
  private static final Rect a = new Rect();
  private static final Rect b = new Rect();
  private static final Rect c = new Rect();
  private static final Rect d = new Rect();
  private static final Paint e = new Paint();
  private static final PaintFlagsDrawFilter f = new PaintFlagsDrawFilter(4, 3);
  private static final Object g = new Object();
  private static Paint h = new Paint();
  private static Bitmap i;

  private static float a(Context paramContext)
  {
    return 1.0F;
  }

  private static int a(Context paramContext, int paramInt)
  {
    return paramContext.getResources().getDimensionPixelSize(2131296335);
  }

  private static Bitmap a(int paramInt1, int paramInt2)
  {
    if (i != null)
    {
      if ((i.getWidth() == paramInt1) && (i.getHeight() == paramInt2))
      {
        Bitmap localBitmap = i;
        i = null;
        localBitmap.eraseColor(0);
        return localBitmap;
      }
      atw.a(i);
      i = null;
      return atw.a(paramInt1, paramInt2, Config.ARGB_8888);
    }
    return atw.a(paramInt1, paramInt2, Config.ARGB_8888);
  }

  private static Bitmap a(Drawable paramDrawable1, Context paramContext, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4, boolean paramBoolean)
  {
    if (paramDrawable1 == null)
      return null;
    label91: label879: 
    while (true)
    {
      Object localObject4;
      Object localObject2;
      Object localObject1;
      int i2;
      int i1;
      int m;
      int j;
      int n;
      float f1;
      synchronized (g)
      {
        if (!(paramDrawable1 instanceof BitmapDrawable))
          break label840;
        localObject4 = (BitmapDrawable)paramDrawable1;
        localObject2 = ((BitmapDrawable)localObject4).getBitmap();
        if (localObject2 == null)
          break label840;
        localObject1 = localObject2;
        if (((Bitmap)localObject2).getDensity() == 0)
        {
          ((BitmapDrawable)localObject4).setTargetDensity(paramContext.getResources().getDisplayMetrics());
          localObject1 = localObject2;
        }
        i2 = paramDrawable1.getIntrinsicWidth();
        i1 = paramDrawable1.getIntrinsicHeight();
        if (paramDrawable2 != null)
          break label846;
        if (paramDrawable4 != null)
        {
          break label846;
          m = a(paramContext, -1);
          j = b(paramContext, -1);
          if (k == 0)
            break label634;
          k = j;
          if ((paramDrawable2 == null) || (!aif.d(paramContext)))
            break label965;
          n = 1;
          if (!(paramDrawable1 instanceof PaintDrawable))
            break label852;
          localObject2 = (PaintDrawable)paramDrawable1;
          ((PaintDrawable)localObject2).setIntrinsicWidth(k);
          ((PaintDrawable)localObject2).setIntrinsicHeight(j);
          break label852;
          f1 = i2 / i1;
          if (i2 <= i1)
            break label971;
          j = (int)(k / f1);
          break label879;
          i1 = (m - m) / 2;
          i2 = (m - m) / 2;
          int i3 = i1 + m;
          int i4 = i2 + m;
          c.set(i1, i2, i3, i4);
          int i5 = (m - k) / 2;
          int i6 = (m - j) / 2;
          b.set(i5, i6, i5 + k, i6 + j);
          paramBoolean = false;
          if ((n == 0) || (localObject1 == null) || (localObject1.getWidth() > k) || (localObject1.getHeight() > j))
            break label825;
          paramBoolean = aih.a(paramContext, localObject1);
          j = 1;
          localObject2 = a(m, m);
          localObject4 = new Canvas((Bitmap)localObject2);
          ((Canvas)localObject4).setDrawFilter(f);
          if ((paramDrawable3 != null) || (paramDrawable2 == null) || ((n != 0) && (j == 0)))
            break label910;
          paramDrawable2.setBounds(c);
          paramDrawable2.draw((Canvas)localObject4);
          break label910;
          label376: a.set(paramDrawable1.getBounds());
          paramDrawable1.setBounds(b);
          paramDrawable1.draw((Canvas)localObject4);
          paramDrawable1.setBounds(a);
          if ((n == 0) || (j != 0))
            break label990;
          paramBoolean = aih.a(paramContext, (Bitmap) localObject2, b.left - c.left, b.top - c.top, c.right - b.right, c.bottom - b.bottom);
          localObject1 = localObject2;
          if (paramDrawable3 == null)
            break label928;
          d.set(i1, i2, i3, i4);
          paramDrawable1 = e;
          paramDrawable1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
          ((Canvas)localObject4).drawBitmap(((BitmapDrawable)paramDrawable3).getBitmap(), null, d, paramDrawable1);
          paramDrawable1.reset();
          break label928;
          paramDrawable1 = Bitmap.createBitmap(((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), Config.ARGB_8888);
          ((Canvas)localObject4).setBitmap(paramDrawable1);
          paramDrawable2.setBounds(c);
          paramDrawable2.draw((Canvas)localObject4);
          if (paramBoolean)
            break label769;
          ((Canvas)localObject4).drawBitmap((Bitmap)localObject2, 0.0F, 0.0F, null);
          i = (Bitmap)localObject2;
          if (paramDrawable4 != null)
          {
            paramDrawable4.setBounds(c);
            paramDrawable4.draw((Canvas)localObject4);
          }
          return paramDrawable1;
        }
      }
      int k = 0;
      continue;
      label634: if (!paramBoolean)
      {
        f1 = m;
        j = (int)(f1 * a(paramContext));
        k = j;
        continue;
        if ((i2 < k) && (i1 < j))
        {
          f1 = Math.min(k * 1.0F / i2, j * 1.0F / i1);
          k = (int)(i2 * f1);
          j = (int)(f1 * i1);
          break label879;
          paramDrawable1 = e;
          paramDrawable1.setAntiAlias(true);
          paramDrawable1.setFilterBitmap(true);
          paramDrawable1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          ((Canvas)localObject4).drawBitmap(localObject1, aih.a, c, paramDrawable1);
          paramDrawable1.reset();
          break label990;
          paramContext = e;
          paramContext.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          paramContext.setAntiAlias(true);
          paramContext.setFilterBitmap(true);
          ((Canvas)localObject4).drawBitmap(localObject1, aih.a, c, paramContext);
          paramContext.reset();
          continue;
          paramDrawable1 = (Drawable)localObject2;
          continue;
          j = 0;
          continue;
        }
      }
      else
      {
        while (true)
        {
          break label893;
          while (true)
          {
            break label879;
            localObject1 = null;
            break;
            k = 1;
            break label91;
            if ((i2 > 0) && (i1 > 0))
            {
              if (k < i2)
                break label158;
              if (j >= i1)
                break label661;
              break label158;
            }
          }
          while (true)
          {
            if (k % 2 != 1)
              break label988;
            k -= 1;
            label893: if (j % 2 != 1)
              break label831;
            j -= 1;
            break label186;
            if ((n == 0) || (j == 0))
              break label376;
            if (paramBoolean)
              break label719;
            break label376;
            if (paramDrawable2 == null)
              break label819;
            if (paramDrawable3 != null)
              break label541;
            if ((n == 0) || (j != 0) || (localObject1 == null))
              break label819;
            break label541;
            j = m;
            k = m;
            break;
            n = 0;
            break label128;
            if (i1 <= i2)
              break label837;
            k = (int)(f1 * j);
          }
        }
      }
    }
  }

  private static Bitmap a(Drawable paramDrawable, Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = null;
    Drawable localDrawable1;
    Drawable localDrawable2;
    if (paramBoolean1)
    {
      localObject = atx.a();
      localDrawable1 = ((atx)localObject).c();
      localDrawable2 = ((atx)localObject).d();
      localObject = ((atx)localObject).e();
    }
    while (true)
    {
      return a(paramDrawable, paramContext, localDrawable1, localDrawable2, (Drawable)localObject, paramBoolean2);
      localDrawable2 = null;
      localDrawable1 = null;
    }
  }

  private static Drawable a(Context paramContext, Resources paramResources, int paramInt, boolean paramBoolean)
  {
    return a(paramContext, paramResources, paramInt, paramBoolean, 0);
  }

  private static Drawable a(Context paramContext, Resources paramResources, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    float f2 = paramResources.getDisplayMetrics().density;
    while (true)
    {
      try
      {
        Object localObject = paramResources.getDrawable(paramInt1);
        if ((paramBoolean) && (!(localObject instanceof NinePatchDrawable)))
        {
          j = vj.d;
          if (j == 160);
        }
        else
        {
          return localObject;
        }
        int j = paramContext.getResources().getConfiguration().screenLayout;
        j &= 15;
        if (j >= 4)
        {
          f1 = 2.0F;
          if (f1 <= 1.0F)
            return localObject;
        }
        else
        {
          if (j < 3)
            break label402;
          f1 = 1.5F;
          continue;
        }
        if (paramInt2 > 0)
        {
          localObject = atw.a(null);
          ((Options)localObject).inTargetDensity = ((int)(160.0F * f1));
          paramResources.getDisplayMetrics().density = f1;
          paramResources.updateConfiguration(paramResources.getConfiguration(), paramResources.getDisplayMetrics());
          localObject = BitmapFactory.decodeResource(paramResources, paramInt1, (Options)localObject);
          if (localObject != null)
          {
            localObject = new BitmapDrawable(paramResources, (Bitmap)localObject);
            ((BitmapDrawable)localObject).setTargetDensity(240);
            return localObject;
          }
        }
        else
        {
          localObject = new Options();
          continue;
        }
      }
      catch (NotFoundException paramContext)
      {
        return null;
        return null;
      }
      catch (Throwable localThrowable)
      {
        Log.e(aif.b, "Failed to decode the bitmap.", localThrowable);
        if (paramInt2 < 2)
        {
          paramContext = a(paramContext, paramResources, paramInt1, paramBoolean, paramInt2 + 1);
          return paramContext;
        }
        paramResources.getDisplayMetrics().density = f2;
        paramResources.updateConfiguration(paramResources.getConfiguration(), paramResources.getDisplayMetrics());
        continue;
      }
      finally
      {
        paramResources.getDisplayMetrics().density = f2;
        paramResources.updateConfiguration(paramResources.getConfiguration(), paramResources.getDisplayMetrics());
      }
      label402: float f1 = 1.0F;
    }
  }

  public static Drawable a(Context paramContext, String paramString)
  {
    paramString = asq.f(paramContext, paramString);
    if (ahy.d(paramContext))
      return ahy.a(paramContext, paramString);
    return new apd(a(paramString, paramContext, true, true));
  }

  public static Drawable a(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject1 = ahx.b(paramContext).O();
      if (TextUtils.isEmpty((CharSequence)localObject1))
        return null;
      Object localObject2 = new File(aif.d, (String)localObject1);
      if (((File)localObject2).exists())
      {
        localObject1 = new File((File)localObject2, "res/drawable-hdpi");
        localObject2 = new File((File)localObject1, paramString + ".png");
        if (((File)localObject2).exists())
          return b(paramContext, ((File)localObject2).getPath(), paramBoolean);
        localObject1 = new File((File)localObject1, paramString + ".jpg");
        if (((File)localObject1).exists())
          return b(paramContext, ((File)localObject1).getPath(), paramBoolean);
      }
      else
      {
        localObject2 = paramContext.createPackageContext((String)localObject1, 0);
        int j = ((Context)localObject2).getResources().getIdentifier(paramString, "drawable", (String)localObject1);
        if (j != 0)
        {
          localObject1 = a(paramContext, ((Context)localObject2).getResources(), j, paramBoolean);
          return localObject1;
        }
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e(aif.b, "Package not found.");
      File localFile = new File(aif.f, paramString + ".png");
      if (localFile.exists())
        return b(paramContext, localFile.getPath(), paramBoolean);
      paramString = new File(aif.f, paramString + ".jpg");
      if (paramString.exists())
      {
        paramContext = b(paramContext, paramString.getPath(), paramBoolean);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
    }
    return null;
  }

  public static apd a(Context paramContext, ComponentName paramComponentName, ResolveInfo paramResolveInfo)
  {
    boolean bool = false;
    if (ahy.d(paramContext))
      paramComponentName = new apd(ahy.b(atx.a().a(paramComponentName, paramResolveInfo)));
    Object localObject3;
    Object localObject2;
    do
    {
      return paramComponentName;
      if (aif.b(paramContext) != null)
        break label110;
      localObject3 = atx.a();
      localObject1 = ((atx)localObject3).c();
      localObject2 = ((atx)localObject3).d();
      localObject3 = ((atx)localObject3).e();
      paramResolveInfo = new apd(atx.a().a(paramComponentName, paramResolveInfo));
      if ((localObject1 != null) || (localObject2 != null))
        break;
      paramComponentName = paramResolveInfo;
    }
    while (localObject3 == null);
    return new apd(a(paramResolveInfo, paramContext, true, true));
    label110: Object localObject1 = aig.a(paramContext).a(paramComponentName, null);
    int j;
    if (localObject1 != null)
    {
      localObject1 = a(paramContext, (String)localObject1, true);
      if (localObject1 != null)
        j = 1;
    }
    while (true)
    {
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        paramComponentName = atx.a().a(paramComponentName, paramResolveInfo);
        localObject2 = localObject1;
        if (paramComponentName != null)
          localObject2 = new apd(paramComponentName);
      }
      if (localObject2 == null)
        return null;
      if (j == 0)
        bool = true;
      return new apd(a((Drawable)localObject2, paramContext, bool, true));
      j = 0;
      continue;
      j = 0;
      localObject1 = null;
    }
  }

  private static int b(Context paramContext, int paramInt)
  {
    return (int)(a(paramContext, paramInt) * 0.88F);
  }

  private static Drawable b(Context paramContext, String paramString, boolean paramBoolean)
  {
    Options localOptions = new Options();
    localOptions.inDensity = aif.c(paramContext);
    if ((localOptions.inDensity != 120) && (localOptions.inDensity != 160) && (localOptions.inDensity != 240) && (localOptions.inDensity != 320))
      localOptions.inDensity = 240;
    if ((paramBoolean) && (aqs.t(paramContext)))
      localOptions.inTargetDensity = 240;
    try
    {
      while (true)
      {
        paramString = BitmapFactory.decodeFile(paramString, localOptions);
        if (paramString == null)
          break;
        paramContext = new BitmapDrawable(paramContext.getResources(), paramString);
        return paramContext;
        localOptions.inTargetDensity = vj.d;
      }
    }
    catch (Throwable paramContext)
    {
      Log.e(aif.b, "Failed to decode the bitmap.", paramContext);
    }
    return null;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aid
 * JD-Core Version:    0.6.2
 */