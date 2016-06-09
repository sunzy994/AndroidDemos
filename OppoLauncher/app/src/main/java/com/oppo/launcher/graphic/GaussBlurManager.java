package com.oppo.launcher.graphic;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.oppo.launcher.DockBar;
import com.oppo.launcher.DragLayer;
import com.oppo.launcher.DragLayer.LayoutParams;
import com.oppo.launcher.Launcher;
import com.oppo.launcher.LauncherUtil;
import com.oppo.launcher.Utilities;
import com.oppo.launcher.Workspace;
import com.oppo.launcher.theme.ThemeUtil;

public class GaussBlurManager
{
  private static final String ACTION_NAVIGATION_MODE = "com.nav.color";
  private static final int BRIGHT_WALLPAPER_BRIGHTNESS = 180;
  private static final boolean DEBUG_ENABLE = true;
  private static final String EXTRA_NAVIGATION_MODE = "NAVIGATION_MODE";
  public static final int FOLDER_BLURBG_DURATION = 250;
  private static final float GAUSS_BLUR_BRIGHTNESS = 0.7F;
  private static final String TAG = "GaussBlurManager";
  private DockBar mDockBar;
  private DragLayer mDragLayer;
  private ValueAnimator mFolderBgAlphaAnimator;
  private ImageView mFolderBlurBgImg;
  private Thread mFolderBlurThread;
  private Drawable mGaussWallpaperDrawable;
  private GaussianBlur mGaussianBlur;
  private Handler mHandler;
  private boolean mIsNavBarWallpaperBright = false;
  private boolean mIsStatusBarWallpaperBright = false;
  private boolean mIsWholeWallpaperBright = false;
  private Launcher mLauncher;
  private Workspace mWorkspace;

  public GaussBlurManager(Launcher paramLauncher)
  {
    this.mLauncher = paramLauncher;
    init();
  }

  private void animateFolderBlurBackground(final boolean paramBoolean)
  {
    if (this.mFolderBgAlphaAnimator != null)
    {
      this.mFolderBgAlphaAnimator.cancel();
      this.mFolderBgAlphaAnimator = null;
    }
    float f2 = 0.0F;
    float f3 = 0.0F;
    float f1 = 1.0F;
    if (!paramBoolean)
    {
      f1 = f3;
      if (this.mFolderBlurBgImg != null)
        f1 = this.mFolderBlurBgImg.getAlpha();
      f3 = 0.0F;
      f2 = f1;
      f1 = f3;
    }
    this.mFolderBgAlphaAnimator = ValueAnimator.ofFloat(new float[] { f2, f1 });
    this.mFolderBgAlphaAnimator.addUpdateListener(new AnimatorUpdateListener()
    {
      public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (GaussBlurManager.this.mFolderBlurBgImg != null)
          GaussBlurManager.this.mFolderBlurBgImg.setAlpha(f);
      }
    });
    this.mFolderBgAlphaAnimator.addListener(new AnimatorListenerAdapter()
    {
      public void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (!paramBoolean)
        {
          if (GaussBlurManager.this.mFolderBlurBgImg != null)
          {
            GaussBlurManager.this.mFolderBlurBgImg.setImageBitmap(null);
            GaussBlurManager.this.mFolderBlurBgImg.setVisibility(8);
            GaussBlurManager.this.mDragLayer.removeView(GaussBlurManager.this.mFolderBlurBgImg);
            GaussBlurManager.access$102(GaussBlurManager.this, null);
          }
          if ((GaussBlurManager.this.mWorkspace != null) && (GaussBlurManager.this.mWorkspace.isNormal()))
            GaussBlurManager.this.recycleGaussDrawableIfNeed();
        }
      }

      public void onAnimationStart(Animator paramAnonymousAnimator)
      {
        if (GaussBlurManager.this.mFolderBlurBgImg != null)
          GaussBlurManager.this.mFolderBlurBgImg.setVisibility(0);
      }
    });
    this.mFolderBgAlphaAnimator.setDuration('ú');
    this.mFolderBgAlphaAnimator.setStartDelay(0);
    this.mFolderBgAlphaAnimator.start();
  }

  private void calculateWallpaperBrightness(Bitmap paramBitmap)
  {
    int k = MaskBitmapUtilities.getInstance().getBitmapBrightnessValue(paramBitmap);
    Log.d("GaussBlurManager", "calculateWallpaperBrightness. wallpaperBitmap = " + paramBitmap + ", averageValue = " + k);
    int j = -1;
    final int i;
    if ((k >= 180) && (!this.mIsWholeWallpaperBright))
    {
      this.mIsWholeWallpaperBright = true;
      i = 1;
    }
    while (true)
    {
      if (i != -1)
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            GaussBlurManager.this.mWorkspace.updateTextColor(i);
            GaussBlurManager.this.mDockBar.updateTextColor(i);
          }
        });
      return;
      i = j;
      if (k < 180)
      {
        i = j;
        if (this.mIsWholeWallpaperBright)
        {
          this.mIsWholeWallpaperBright = false;
          i = 0;
        }
      }
    }
  }

  private void calculateWallpaperBrightnessForNavBar(Bitmap paramBitmap)
  {
    final int i = paramBitmap.getHeight() * Utilities.getScreenHeight() / Utilities.getRealScreenHeight();
    i = MaskBitmapUtilities.getInstance().getBitmapBrightnessValue(paramBitmap, 0, i, Utilities.getScreenWidth(), paramBitmap.getHeight());
    Log.d("GaussBlurManager", "calculateWallpaperBrightnessForNavBar. wallpaperBitmap = " + paramBitmap + " , navBarAverageValue = " + i);
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if ((i >= 180) && (!GaussBlurManager.this.mIsNavBarWallpaperBright))
        {
          GaussBlurManager.access$602(GaussBlurManager.this, true);
          if (GaussBlurManager.this.mLauncher.isVisible())
            GaussBlurManager.this.setNavBarColor(true);
        }
        while ((i >= 180) || (!GaussBlurManager.this.mIsNavBarWallpaperBright))
          return;
        GaussBlurManager.access$602(GaussBlurManager.this, false);
        GaussBlurManager.this.setNavBarColor(false);
      }
    });
  }

  private void calculateWallpaperBrightnessForStatusBar(Bitmap paramBitmap)
  {
    final int i = MaskBitmapUtilities.getInstance().getBitmapBrightnessValue(paramBitmap, 0, 0, Utilities.getScreenWidth(), LauncherUtil.getRealStatusBarHeight(this.mLauncher) / 4);
    Log.d("GaussBlurManager", "calculateWallpaperBrightnessForStatusBar. wallpaperBitmap = " + paramBitmap + " , statusBarAverageValue = " + i);
    this.mHandler.post(new Runnable()
    {
      public void run()
      {
        if ((i >= 180) && (!GaussBlurManager.this.mIsStatusBarWallpaperBright))
        {
          GaussBlurManager.access$402(GaussBlurManager.this, true);
          GaussBlurManager.this.setStatusBarColor(false);
        }
        while ((i >= 180) || (!GaussBlurManager.this.mIsStatusBarWallpaperBright))
          return;
        GaussBlurManager.access$402(GaussBlurManager.this, false);
        GaussBlurManager.this.setStatusBarColor(true);
      }
    });
  }

  private Bitmap getGaussBitmap()
  {
    if ((this.mGaussWallpaperDrawable != null) && ((this.mGaussWallpaperDrawable instanceof BitmapDrawable)))
      return ((BitmapDrawable)this.mGaussWallpaperDrawable).getBitmap();
    return null;
  }

  private GaussianBlur getGaussianBlur()
  {
    if (this.mGaussianBlur == null)
      this.mGaussianBlur = GaussianBlur.getInstance();
    return this.mGaussianBlur;
  }

  private void init()
  {
    this.mHandler = this.mLauncher.getHandler();
    this.mDragLayer = this.mLauncher.getDragLayer();
    this.mWorkspace = this.mLauncher.getWorkspace();
    this.mDockBar = this.mLauncher.getDockBar();
    this.mGaussianBlur = getGaussianBlur();
  }

  public static boolean isSingleScreenWallpaper(Context paramContext)
  {
    boolean bool = true;
    paramContext = WallpaperManager.getInstance(paramContext.getApplicationContext());
    if (paramContext.getDesiredMinimumWidth() > Utilities.mRealScreenWidth);
    for (int i = 1; ; i = 0)
    {
      if ((i != 0) || (paramContext.getWallpaperInfo() != null))
        bool = false;
      return bool;
    }
  }

  private void setStatusBarColor(boolean paramBoolean)
  {
    View localView = this.mLauncher.getWindow().getDecorView();
    if (localView == null)
    {
      Log.w("GaussBlurManager", "setStatusBarColor. The decorView is null.");
      return;
    }
    if (paramBoolean)
    {
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFFEF);
      return;
    }
    localView.setSystemUiVisibility(localView.getSystemUiVisibility() | 0x10);
  }

  public void clear()
  {
    recycleGaussWallpaperDrawable();
  }

  public BitmapDrawable generateGaussianWallpaper()
  {
    Bitmap localBitmap2;
    int k;
    int i;
    if (!this.mLauncher.isVisible())
    {
      localBitmap2 = LauncherUtil.getWallpaperBitmap(this.mLauncher);
      localBitmap1 = localBitmap2;
      if (!isSingleScreenWallpaper(this.mLauncher))
      {
        k = this.mLauncher.getCurrentWorkspaceScreen();
        int j = this.mLauncher.getNormalPageCount();
        i = j;
        if (this.mWorkspace != null)
        {
          i = j;
          if (!this.mWorkspace.isNormal())
            i = j - 1;
        }
      }
    }
    for (Bitmap localBitmap1 = LauncherUtil.cutWallpaper(this.mLauncher, localBitmap2, k, i); localBitmap1 != null; localBitmap1 = Utilities.captureFullScreen(0.25F, i, i))
    {
      return new BitmapDrawable(this.mGaussianBlur.generateGaussianBitmap(localBitmap1, 0.7F, true));
      i = Settings.System.getInt(this.mLauncher.getContentResolver(), "LAYER_WALLPAPER", -1);
    }
    return new BitmapDrawable(BitmapFactory.decodeResource(this.mLauncher.getResources(), 2130837515));
  }

  public ImageView getFolderBlurBg()
  {
    return this.mFolderBlurBgImg;
  }

  public Drawable getGaussWallpaperDrawable()
  {
    if (this.mGaussWallpaperDrawable == null)
      this.mGaussWallpaperDrawable = generateGaussianWallpaper();
    return this.mGaussWallpaperDrawable;
  }

  public void hideFolderBlurBg()
  {
    animateFolderBlurBackground(false);
  }

  public void initGaussWallpaper()
  {
    if ((this.mWorkspace != null) && (!this.mWorkspace.isNormal()))
    {
      Bitmap localBitmap1 = getGaussBitmap();
      this.mGaussWallpaperDrawable = null;
      this.mDragLayer.initMiniModeBg();
      this.mDragLayer.postInvalidate();
      final Bitmap localBitmap2 = ((BitmapDrawable)getGaussWallpaperDrawable()).getBitmap();
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          if ((GaussBlurManager.this.mWorkspace.getOpenFolder() != null) && (GaussBlurManager.this.mFolderBlurBgImg != null))
            GaussBlurManager.this.mFolderBlurBgImg.setImageBitmap(localBitmap2);
        }
      });
      if (localBitmap1 != null)
        localBitmap1.recycle();
      return;
    }
    recycleGaussWallpaperDrawable();
  }

  public void initWallpaperBright()
  {
    if (WallpaperManager.getInstance(this.mLauncher.getApplicationContext()).getWallpaperInfo() != null)
      if ((this.mHandler != null) && ((this.mIsWholeWallpaperBright) || (this.mIsStatusBarWallpaperBright) || (this.mIsNavBarWallpaperBright)))
        this.mHandler.post(new Runnable()
        {
          public void run()
          {
            if (GaussBlurManager.this.mIsWholeWallpaperBright)
            {
              GaussBlurManager.access$202(GaussBlurManager.this, false);
              GaussBlurManager.this.mWorkspace.updateTextColor(0);
              GaussBlurManager.this.mDockBar.updateTextColor(0);
            }
            if (GaussBlurManager.this.mIsStatusBarWallpaperBright)
            {
              GaussBlurManager.access$402(GaussBlurManager.this, false);
              GaussBlurManager.this.setStatusBarColor(true);
            }
            if (GaussBlurManager.this.mIsNavBarWallpaperBright)
            {
              GaussBlurManager.access$602(GaussBlurManager.this, false);
              GaussBlurManager.this.setNavBarColor(true);
            }
          }
        });
    Bitmap localBitmap;
    do
    {
      return;
      localBitmap = LauncherUtil.getWallpaperBitmap(this.mLauncher);
    }
    while (localBitmap == null);
    if (ThemeUtil.isDefaultTheme())
      calculateWallpaperBrightness(localBitmap);
    calculateWallpaperBrightnessForStatusBar(localBitmap);
    calculateWallpaperBrightnessForNavBar(localBitmap);
    localBitmap.recycle();
  }

  public boolean isWallpaperBright()
  {
    return this.mIsWholeWallpaperBright;
  }

  public void recycleGaussDrawableIfNeed()
  {
    if (!isSingleScreenWallpaper(this.mLauncher))
      recycleGaussWallpaperDrawable();
  }

  public void recycleGaussWallpaperDrawable()
  {
    if (this.mGaussWallpaperDrawable != null)
    {
      if ((this.mGaussWallpaperDrawable instanceof BitmapDrawable))
      {
        Bitmap localBitmap = ((BitmapDrawable)this.mGaussWallpaperDrawable).getBitmap();
        if (localBitmap != null)
          localBitmap.recycle();
      }
      this.mGaussWallpaperDrawable = null;
    }
  }

  public void setNavBarColor(boolean paramBoolean)
  {
    if (!this.mIsNavBarWallpaperBright)
      return;
    Intent localIntent = new Intent("com.nav.color");
    localIntent.putExtra("NAVIGATION_MODE", paramBoolean);
    this.mLauncher.sendBroadcast(localIntent);
  }

  public void showFolderBlurBg()
  {
    if (this.mFolderBgAlphaAnimator != null)
    {
      this.mFolderBgAlphaAnimator.cancel();
      this.mFolderBgAlphaAnimator = null;
    }
    if ((this.mFolderBlurThread != null) && (this.mFolderBlurThread.isAlive()))
      return;
    if (this.mFolderBlurBgImg == null)
    {
      this.mFolderBlurBgImg = new ImageView(this.mLauncher);
      this.mFolderBlurBgImg.setScaleType(ScaleType.FIT_XY);
      DragLayer.LayoutParams localLayoutParams = new DragLayer.LayoutParams(-1, -1);
      this.mDragLayer.addView(this.mFolderBlurBgImg, localLayoutParams);
      this.mFolderBlurBgImg.bringToFront();
    }
    this.mFolderBlurThread = new Thread()
    {
      public void run()
      {
        super.run();
        final Bitmap localBitmap = ((BitmapDrawable)GaussBlurManager.this.getGaussWallpaperDrawable()).getBitmap();
        GaussBlurManager.this.mLauncher.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if ((GaussBlurManager.this.mWorkspace != null) && (GaussBlurManager.this.mWorkspace.getOpenFolder() != null) && (GaussBlurManager.this.mFolderBlurBgImg != null))
            {
              GaussBlurManager.this.mFolderBlurBgImg.setImageBitmap(localBitmap);
              GaussBlurManager.this.mFolderBlurBgImg.setVisibility(0);
              GaussBlurManager.this.animateFolderBlurBackground(true);
            }
            while (true)
            {
              GaussBlurManager.access$1002(GaussBlurManager.this, null);
              return;
              if ((GaussBlurManager.this.mWorkspace != null) && (GaussBlurManager.this.mWorkspace.isNormal()))
                GaussBlurManager.this.recycleGaussDrawableIfNeed();
            }
          }
        });
      }
    };
    this.mFolderBlurThread.start();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.graphic.GaussBlurManager
 * JD-Core Version:    0.6.2
 */