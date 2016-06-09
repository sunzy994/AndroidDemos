package com.oppo.launcher;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import com.oppo.launcher.settings.FeatureOption;
import com.oppo.launcher.settings.Setting;
import com.oppo.launcher.theme.ThemeUtil;
import com.oppo.shared_prefs.LauncherSharedPrefs;
import com.oppo.statistics.NearMeStatistics;
import com.oppo.unreaderloader.OPPOUnreadLoader;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class LauncherApplication extends Application
{
  public static final String ACTION_DAY_CHANGED = "com.oppo.launcher.action.DAY_CHANGED";
  static final String BACKUP_RESTORED_SUCCESS = "com.oppo.backuprestore.restore_launcher_success";
  private static final boolean DEBUG = LauncherUtil.LAUNCHER_QE_ASSERT_DEBUG;
  private static final int EXTERNALAPP_DELAY_TIMEOUT = 60000;
  public static final String OPPO_CALENDAR_DATE_CHANGED_ACTION = "android.intent.action.OPPO_CALENDAR_DATE_CHANGED_ACTION";
  public static final String RESTORE_APP_END = "com.oppo.backuprestore.restore_app_end";
  public static final String RESTORE_APP_START = "com.oppo.backuprestore.restore_app_start";
  static final String RESTORE_OPPONOTE_SUCCESS = "com.oppo.backuprestore.restore_opponote_success";
  static final String ROM_UPDATE_CONFIG_LIST = "ROM_UPDATE_CONFIG_LIST";
  static final String ROM_UPDATE_CONFIG_SUCCESS = "oppo.intent.action.ROM_UPDATE_CONFIG_SUCCESS";
  private static final String TAG = "LauncherApplication";
  private static boolean sIsScreenLarge;
  private static int sLongPressTimeout = 400;
  private static float sScreenDensity;
  AlarmManager am = null;
  private boolean mExternalAppTimeOut = false;
  private Timer mExternalAppTimer;
  private boolean mExternalAppTimerIsRunning = false;
  private final ContentObserver mFavoritesObserver = new ContentObserver(new Handler())
  {
    public void onChange(boolean paramAnonymousBoolean)
    {
      LauncherApplication.this.mModel.startLoader(LauncherApplication.this, false, false);
    }
  };
  private DeferredHandler mHandler = new DeferredHandler();
  public IconCache mIconCache;
  private Launcher mLauncher;
  WeakReference<LauncherProvider> mLauncherProvider;
  public LauncherModel mModel;
  private PackageUpdateHandler mPackageUpdateHandler;
  private OPPOUnreadLoader mUnreadLoader;
  public boolean mUnreadLoaderIsRegistered = false;
  PendingIntent sender = null;
  private final String unread_support = "unread_support_shortcuts.xml";

  public static int getLongPressTimeout()
  {
    return sLongPressTimeout;
  }

  public static float getScreenDensity()
  {
    return sScreenDensity;
  }

  private void initLauncherSetting()
  {
    if (FeatureOption.LAUNCHER_SPECIAL_EFFECT);
    for (String str = getString(2131427360); ; str = getString(2131427361))
    {
      Object localObject2 = LauncherSharedPrefs.getLauncherPrefs(this).getString("desk_effect", "");
      Object localObject1 = localObject2;
      if (((String)localObject2).equals(""))
      {
        localObject2 = LauncherSharedPrefs.getLauncherPrefs(this).edit();
        ((Editor)localObject2).putString("desk_effect", str);
        localObject1 = str;
        ((Editor)localObject2).commit();
      }
      Setting.setWorkspaceEffectClassName((String)localObject1);
      Setting.setWorkspaceDefaultEffectClassName(str);
      return;
    }
  }

  public static boolean isScreenLarge()
  {
    return sIsScreenLarge;
  }

  public static void setLongPressTimeout(int paramInt)
  {
    sLongPressTimeout = paramInt;
  }

  public void cancelDayChangeAlarm()
  {
    if (this.am == null)
      this.am = ((AlarmManager)getSystemService("alarm"));
    this.am.cancel(this.sender);
    if (DEBUG)
      Log.d("LauncherApplication", "cancelDayChangeAlarm");
  }

  public void cancelExternalAppTimer()
  {
    if (DEBUG)
      Log.d("LauncherApplication", "cancelExternalAppTimer --- begin");
    if (this.mExternalAppTimer != null)
    {
      this.mExternalAppTimer.cancel();
      this.mExternalAppTimer = null;
    }
    this.mExternalAppTimerIsRunning = false;
    this.mExternalAppTimeOut = false;
    if (DEBUG)
      Log.d("LauncherApplication", "cancelExternalAppTimer --- end");
  }

  public boolean getExternalAppTimerIsRunning()
  {
    return this.mExternalAppTimerIsRunning;
  }

  public boolean getExternalAppTimerTimeOut()
  {
    return this.mExternalAppTimeOut;
  }

  IconCache getIconCache()
  {
    return this.mIconCache;
  }

  public Launcher getLauncher()
  {
    return this.mLauncher;
  }

  LauncherProvider getLauncherProvider()
  {
    if (this.mLauncherProvider == null)
    {
      Log.w("LauncherApplication", "getLauncherProvider. mLauncherProvider is null!");
      return null;
    }
    return (LauncherProvider)this.mLauncherProvider.get();
  }

  public LauncherModel getModel()
  {
    return this.mModel;
  }

  public void initOrUpdateUnreadShortcuts()
  {
    if ((this.mUnreadLoader != null) && (this.mLauncher != null))
    {
      this.mUnreadLoader.initialize(this.mLauncher);
      new Thread()
      {
        public void run()
        {
          try
          {
            if (!LauncherApplication.this.mUnreadLoaderIsRegistered)
            {
              LauncherApplication.this.mUnreadLoader.loadAndInitUnreadShortcuts("unread_support_shortcuts.xml");
              LauncherApplication.this.mUnreadLoaderIsRegistered = true;
              return;
            }
            LauncherApplication.this.mUnreadLoader.updateAllUnreadShortcuts();
            return;
          }
          catch (Exception localException)
          {
            Log.e("LauncherApplication", "initOrUpdateUnreadShortcuts --- e = " + localException);
          }
        }
      }
      .start();
    }
  }

  public void onCreate()
  {
    super.onCreate();
    if (DEBUG)
      Log.d("LauncherApplication", this + " onCreate()");
    NearMeStatistics.onDebug(false);
    NearMeStatistics.onError(this);
    Utilities.setScreenWidth(this);
    Utilities.hasNavigationBar();
    sIsScreenLarge = false;
    sScreenDensity = getResources().getDisplayMetrics().density;
    this.mIconCache = new IconCache(this);
    this.mPackageUpdateHandler = new PackageUpdateHandler(this, this.mIconCache, this.mHandler);
    this.mModel = new LauncherModel(this, this.mIconCache, this.mHandler, this.mPackageUpdateHandler);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.oppo.backuprestore.restore_launcher_success");
    localIntentFilter.addAction("oppo.intent.action.ROM_UPDATE_CONFIG_SUCCESS");
    registerReceiver(this.mModel, localIntentFilter);
    localIntentFilter = new IntentFilter("android.intent.action.DATE_CHANGED");
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    localIntentFilter.addAction("android.intent.action.OPPO_CALENDAR_DATE_CHANGED_ACTION");
    localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
    localIntentFilter.addAction("com.oppo.launcher.action.DAY_CHANGED");
    registerReceiver(this.mModel, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.MEDIA_SHARED");
    localIntentFilter.addDataScheme("file");
    registerReceiver(this.mModel, localIntentFilter);
    localIntentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
    localIntentFilter.addDataScheme("package");
    registerReceiver(this.mPackageUpdateHandler, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE");
    localIntentFilter.addAction("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE");
    localIntentFilter.addAction("com.oppo.backuprestore.restore_app_start");
    localIntentFilter.addAction("com.oppo.backuprestore.restore_app_end");
    localIntentFilter.addAction("com.oppo.backuprestore.restore_opponote_success");
    registerReceiver(this.mPackageUpdateHandler, localIntentFilter);
    localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
    localIntentFilter.addDataScheme("package");
    registerReceiver(this.mPackageUpdateHandler, localIntentFilter);
    getContentResolver().registerContentObserver(LauncherSettings.SingleDeskTopItems.CONTENT_URI, true, this.mFavoritesObserver);
    FeatureOption.initFeatureForLoadLauncher(getPackageManager());
    initLauncherSetting();
    this.mUnreadLoader = OPPOUnreadLoader.getInstance(getApplicationContext());
    this.sender = PendingIntent.getBroadcast(this, 0, new Intent("com.oppo.launcher.action.DAY_CHANGED"), 134217728);
    this.am = ((AlarmManager)getSystemService("alarm"));
    ThemeUtil.checkInitColorUIEngine(getApplicationContext());
    ThemeUtil.setApplicationChecked();
  }

  public void onTerminate()
  {
    super.onTerminate();
    if (DEBUG)
      Log.d("LauncherApplication", this + " onTerminate()");
    unregisterReceiver(this.mModel);
    unregisterReceiver(this.mPackageUpdateHandler);
    this.mUnreadLoader.unRegisterUnreadNumberContentObserver();
    this.mUnreadLoader.recycle();
    this.mUnreadLoader = null;
    LauncherAssetManager.getInstance(this).recycle();
    getContentResolver().unregisterContentObserver(this.mFavoritesObserver);
    cancelExternalAppTimer();
  }

  public void resetDayChangeAlarm()
  {
    cancelDayChangeAlarm();
    setDayChangeAlarm();
    if (DEBUG)
      Log.d("LauncherApplication", "setThemeChanged -- ThemeUtil.isDefaultTheme() =" + ThemeUtil.isDefaultTheme());
  }

  public void setDayChangeAlarm()
  {
    if (this.am == null)
      this.am = ((AlarmManager)getSystemService("alarm"));
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis());
    if (DEBUG)
    {
      Log.d("LauncherApplication", "setDayChangeAlarm -- Calendar day = " + localCalendar.get(6));
      Log.d("LauncherApplication", "setDayChangeAlarm -- Calendar hour = " + localCalendar.get(11));
    }
    localCalendar.add(6, 1);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    long l1 = 0L;
    try
    {
      long l2 = localCalendar.getTimeInMillis();
      l1 = l2;
      this.am.set(1, l2, this.sender);
      l1 = l2;
      if (DEBUG)
        Log.d("LauncherApplication", "setDayChangeAlarm -- triggerAtTime =" + l1);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (true)
        Log.e("LauncherApplication", "setDayChangeAlarm " + localIllegalArgumentException);
    }
  }

  LauncherModel setLauncher(Launcher paramLauncher)
  {
    if (DEBUG)
      Log.d("LauncherApplication", this + " setLancher() --> launcher = " + paramLauncher);
    this.mLauncher = paramLauncher;
    this.mModel.initialize(paramLauncher);
    this.mPackageUpdateHandler.setCallBacks(paramLauncher);
    return this.mModel;
  }

  void setLauncherProvider(LauncherProvider paramLauncherProvider)
  {
    this.mLauncherProvider = new WeakReference(paramLauncherProvider);
  }

  public void startExternalAppTimer()
  {
    if (DEBUG)
      Log.d("LauncherApplication", "startExternalAppTimer --- begin");
    if (this.mExternalAppTimer == null);
    for (this.mExternalAppTimer = new Timer(); ; this.mExternalAppTimer = new Timer())
    {
      this.mExternalAppTimerIsRunning = true;
      this.mExternalAppTimer.schedule(new ExternalAppTask(), 60000L);
      if (DEBUG)
        Log.d("LauncherApplication", "startExternalAppTimer --- end");
      return;
      this.mExternalAppTimer.cancel();
    }
  }

  class ExternalAppTask extends TimerTask
  {
    ExternalAppTask()
    {
    }

    public void run()
    {
      LauncherApplication.access$002(LauncherApplication.this, false);
      LauncherApplication.access$102(LauncherApplication.this, true);
      LauncherModel.setExternalAppAvailableForToast(true);
      if (LauncherApplication.DEBUG)
        Log.d("LauncherApplication", "ExternalAppTask --- mExternalAppTimeOut = " + LauncherApplication.this.mExternalAppTimeOut);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.LauncherApplication
 * JD-Core Version:    0.6.2
 */