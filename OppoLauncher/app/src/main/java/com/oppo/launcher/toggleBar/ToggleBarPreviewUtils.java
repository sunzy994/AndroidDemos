package com.oppo.launcher.toggleBar;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.oppo.launcher.Launcher;
import com.oppo.launcher.LauncherUtil;
import com.oppo.launcher.OppoPendingAddWidgetInfo;
import com.oppo.launcher.Utilities;
import com.oppo.launcher.effect.EffectInfo;
import com.oppo.launcher.effect.LauncherEffect;
import com.oppo.launcher.settings.Setting;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToggleBarPreviewUtils
{
  private static final boolean DEBUG = false;
  public static final String PRIVATE_PAGE = "android.appwidget.action.PRIVATE_PAGE";
  public static final int SNAP_TO_PAGE = 700;
  private static final String TAG = "ToggleBarPreviewUtils";
  private static final String VENDING = "com.android.vending";
  public static Drawable mInUsingBg;

  public static Drawable createAppWidgetPreviewDrawable(OppoPendingAddWidgetInfo paramOppoPendingAddWidgetInfo, Launcher paramLauncher)
  {
    boolean bool = true;
    if (paramOppoPendingAddWidgetInfo.previewImage != 0)
      bool = false;
    int[] arrayOfInt = LauncherUtil.estimateItemSize(paramLauncher, paramOppoPendingAddWidgetInfo.spanX, paramOppoPendingAddWidgetInfo.spanY, paramOppoPendingAddWidgetInfo, bool);
    return Utilities.getWidgetPreviewDrawable(paramLauncher, paramOppoPendingAddWidgetInfo.componentName, paramOppoPendingAddWidgetInfo.previewImage, paramOppoPendingAddWidgetInfo.icon, paramOppoPendingAddWidgetInfo.spanX, paramOppoPendingAddWidgetInfo.spanY, arrayOfInt[0], arrayOfInt[1]);
  }

  private static String createTitleForWidget(Launcher paramLauncher, ComponentName paramComponentName, int paramInt)
  {
    if ((paramLauncher == null) || (paramComponentName == null))
      return null;
    Object localObject = paramLauncher.getPackageManager();
    paramLauncher = null;
    try
    {
      localObject = ((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(paramComponentName.getPackageName(), 128)).toString();
      paramLauncher = (Launcher)localObject;
      return paramLauncher + "(" + String.valueOf(paramInt) + ")";
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      while (true)
        Log.w("ToggleBarPreviewUtils", "getWidgetPreviewAppName -- packageName not found, package = " + paramComponentName.getPackageName());
    }
  }

  private static String createTitleForWidget(OppoPendingAddWidgetInfo paramOppoPendingAddWidgetInfo)
  {
    if (paramOppoPendingAddWidgetInfo == null)
      return null;
    return paramOppoPendingAddWidgetInfo.title.toString();
  }

  public static WidgetPreviewItem createWidgetItemFromAppWidgetInfo(OppoPendingAddWidgetInfo paramOppoPendingAddWidgetInfo, Launcher paramLauncher)
  {
    if (paramOppoPendingAddWidgetInfo == null)
      return null;
    WidgetPreviewItem localWidgetPreviewItem = new WidgetPreviewItem();
    localWidgetPreviewItem.setLauncher(paramLauncher);
    localWidgetPreviewItem.mThumbnail = getWidgetPreviewDrawable(paramLauncher, paramOppoPendingAddWidgetInfo.componentName, paramOppoPendingAddWidgetInfo.icon);
    localWidgetPreviewItem.mTitle = createTitleForWidget(paramOppoPendingAddWidgetInfo);
    localWidgetPreviewItem.setWidgetInfo(paramOppoPendingAddWidgetInfo);
    return localWidgetPreviewItem;
  }

  public static WidgetPreviewItem createWidgetItemFromAppWidgetInfo(ArrayList<AppWidgetProviderInfo> paramArrayList, Launcher paramLauncher)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
      return null;
    AppWidgetProviderInfo localAppWidgetProviderInfo = (AppWidgetProviderInfo)paramArrayList.get(0);
    WidgetPreviewItem localWidgetPreviewItem = new WidgetPreviewItem(paramArrayList);
    localWidgetPreviewItem.setLauncher(paramLauncher);
    localWidgetPreviewItem.mThumbnail = getWidgetPreviewDrawable(paramLauncher, localAppWidgetProviderInfo.provider, localAppWidgetProviderInfo.icon);
    localWidgetPreviewItem.mTitle = createTitleForWidget(paramLauncher, localAppWidgetProviderInfo.provider, paramArrayList.size());
    localWidgetPreviewItem.setWidgetInfo(null);
    return localWidgetPreviewItem;
  }

  static Bitmap generateBitmap(Bitmap paramBitmap, float paramFloat)
  {
    Bitmap localBitmap;
    if (paramBitmap == null)
      localBitmap = null;
    int k;
    int m;
    do
    {
      do
      {
        do
        {
          return localBitmap;
          k = paramBitmap.getWidth();
          m = paramBitmap.getHeight();
          localBitmap = paramBitmap;
        }
        while (k <= 0);
        localBitmap = paramBitmap;
      }
      while (m <= 0);
      localBitmap = paramBitmap;
    }
    while (0.0F >= paramFloat);
    int i = 0;
    int j = 0;
    float f = k / m;
    if (f > paramFloat)
      i = (int)(k * (1.0F - paramFloat / f) / 2.0F);
    try
    {
      while (true)
      {
        localBitmap = Bitmap.createBitmap(k - i * 2, m - j * 2, Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Rect localRect = new Rect();
        localRect.right = paramBitmap.getWidth();
        localRect.bottom = paramBitmap.getHeight();
        localRect.offset(-i, -j);
        Paint localPaint = new Paint();
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        localCanvas.drawBitmap(paramBitmap, null, localRect, localPaint);
        paramBitmap.recycle();
        localCanvas.setBitmap(null);
        return localBitmap;
        j = (int)(m * (1.0F - f / paramFloat) / 2.0F);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.w("ToggleBarPreviewUtils", "Can't generate default bitmap", localOutOfMemoryError);
    }
    return paramBitmap;
  }

  public static Bitmap generatePreview(Launcher paramLauncher, Bitmap paramBitmap)
  {
    if (paramLauncher == null)
      return paramBitmap;
    return generateBitmap(paramBitmap, paramLauncher.getResources().getInteger(2131296274) / 100.0F);
  }

  public static List<EffectInfo> getEffectInfo(Launcher paramLauncher)
  {
    return LauncherEffect.getLauncherEffect(paramLauncher).getWorkspaceEffects();
  }

  public static ArrayList<ToggleBarPreviewItem> getEffectPreviewItem(List<EffectInfo> paramList, Launcher paramLauncher)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      EffectInfo localEffectInfo = (EffectInfo)paramList.next();
      EffectPreviewItem localEffectPreviewItem = new EffectPreviewItem();
      localEffectPreviewItem.setLauncher(paramLauncher);
      localEffectPreviewItem.mEffectInfo = localEffectInfo;
      localEffectPreviewItem.mTitle = localEffectInfo.getName(paramLauncher);
      localEffectPreviewItem.mInUsing = isEffectUsing(localEffectInfo, paramLauncher);
      localEffectPreviewItem.mEffectClassName = localEffectInfo.getClassName(paramLauncher);
      localArrayList.add(localEffectPreviewItem);
    }
    return localArrayList;
  }

  public static ArrayList<ToggleBarPreviewItem> getEffectPreviews(Launcher paramLauncher)
  {
    return getEffectPreviewItem(getEffectInfo(paramLauncher), paramLauncher);
  }

  public static Drawable getInUsingDrawable(Context paramContext)
  {
    if (mInUsingBg == null)
      mInUsingBg = paramContext.getResources().getDrawable(2130837529);
    return mInUsingBg;
  }

  public static Resources getRemoteResources(Context paramContext)
  {
    Resources localResources = null;
    if (paramContext != null)
      localResources = paramContext.getResources();
    return localResources;
  }

  public static int getResourceIdByFileName(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext == null) || (paramString1 == null) || ("".equals(paramString1)) || (paramString2 == null) || ("".equals(paramString2)) || (paramString3 == null) || ("".equals(paramString3)));
    do
    {
      return -1;
      paramContext = getRemoteResources(paramContext);
    }
    while (paramContext == null);
    return paramContext.getIdentifier(paramString1, paramString2, paramString3);
  }

  public static Drawable getWidgetPreviewDrawable(Launcher paramLauncher, ComponentName paramComponentName, int paramInt)
  {
    paramComponentName = paramComponentName.getPackageName();
    if (paramComponentName == null)
      Log.w("ToggleBarPreviewUtils", "getWidgetPreviewDrawable -- packageName is null, return");
    while (true)
    {
      return null;
      paramLauncher = paramLauncher.getPackageManager();
      try
      {
        ApplicationInfo localApplicationInfo = paramLauncher.getApplicationInfo(paramComponentName, 8192);
        if (localApplicationInfo != null)
        {
          paramLauncher = localApplicationInfo.loadIcon(paramLauncher);
          return paramLauncher;
        }
      }
      catch (NameNotFoundException paramLauncher)
      {
        Log.w("ToggleBarPreviewUtils", "getWidgetPreviewDrawable -- can't find package " + paramComponentName);
      }
    }
    return null;
  }

  public static boolean isEffectUsing(EffectInfo paramEffectInfo, Context paramContext)
  {
    return (paramEffectInfo.getClassName(paramContext) != null) && (paramEffectInfo.getClassName(paramContext).equals(Setting.getWorkSpaceEffectClassName()));
  }

  public static boolean isEmtryString(String paramString)
  {
    return (paramString == null) || ("".equals(paramString));
  }

  public static void recycle()
  {
    if (mInUsingBg != null)
    {
      mInUsingBg.setCallback(null);
      mInUsingBg = null;
    }
  }

  public static void writeBitmapToSdcard(String paramString, Bitmap paramBitmap)
  {
    String str = paramString;
    if (paramString == null)
      str = "default";
    if ((paramBitmap == null) || (paramBitmap.getWidth() <= 0) || (paramBitmap.getHeight() <= 0))
    {
      Log.e("ToggleBarPreviewUtils", "writeBitmapToSdcard\t bitmap error");
      return;
    }
    try
    {
      paramString = new FileOutputStream(new File("/mnt/sdcard/" + str + ".png"));
      paramBitmap.compress(CompressFormat.PNG, 100, paramString);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("ToggleBarPreviewUtils", "writeBitmapToSdcard --- e = " + paramString);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.ToggleBarPreviewUtils
 * JD-Core Version:    0.6.2
 */