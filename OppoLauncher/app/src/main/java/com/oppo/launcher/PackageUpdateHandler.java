package com.oppo.launcher;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.oppo.unreaderloader.OPPOUnreadLoader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PackageUpdateHandler extends BroadcastReceiver
{
  public static final String ACITON_PRIVACY_LIST_CHANGED = "oppo.intent.action.ADDAPP_TO_VISTORMODE_OR_PRIVACYZONE";
  public static final String ACTION_TRIGGER_PACKAGE = "android.intent.action.TRIGGER_PACKAGE";
  public static final String BACKUPRETORE_PROCESSNAME = "com.coloros.backuprestore.remoteservice";
  private static boolean DEBUG = false;
  public static final String ENGINE_PACKNAME = "com.color.uiengine";
  public static final String LAUNCHER_PROCESSNAME = "com.oppo.launcher";
  private static final String LOG_TAG = "PackageUpdateHandler";
  public static final String NEARME_NOTE_PACKAGENAME = "com.nearme.note";
  public static final String PACKAGE_NOTIFICATION = "com.coloros.notificationmanager";
  private AllAppsList mAllAppsList;
  private LauncherApplication mApp;
  private WeakReference<Callbacks> mCallbacks;
  private boolean mExitFlag = true;
  private DeferredHandler mHandler;
  private IconCache mIconCache;
  private boolean mIsRestoreApp = false;
  private LauncherModel mLauncherModel;

  PackageUpdateHandler(LauncherApplication paramLauncherApplication, IconCache paramIconCache, DeferredHandler paramDeferredHandler)
  {
    this.mApp = paramLauncherApplication;
    this.mIconCache = paramIconCache;
    this.mHandler = paramDeferredHandler;
  }

  private void appChangeSdcard()
  {
    if (this.mCallbacks != null);
    for (final Callbacks localCallbacks = (Callbacks)this.mCallbacks.get(); ; localCallbacks = null)
    {
      this.mHandler.postWorkspaceRunnable(new Runnable()
      {
        public void run()
        {
          if (PackageUpdateHandler.this.mCallbacks != null);
          for (Callbacks localCallbacks = (Callbacks)PackageUpdateHandler.this.mCallbacks.get(); ; localCallbacks = null)
          {
            if ((localCallbacks == localCallbacks) && (localCallbacks != null))
              localCallbacks.bindSdcardStateChanged();
            return;
          }
        }
      });
      return;
    }
  }

  private String getProcessNameByPid(Context paramContext, int paramInt)
  {
    Object localObject = null;
    Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    do
    {
      paramContext = localObject;
      if (!localIterator.hasNext())
        break;
      paramContext = (RunningAppProcessInfo)localIterator.next();
    }
    while (paramContext.pid != paramInt);
    paramContext = paramContext.processName;
    if (DEBUG)
      Log.d("PackageUpdateHandler", "getProcessNameByPid -- processName = " + paramContext);
    return paramContext;
  }

  private void updateUnreadNumWhenClearData(final ComponentName paramComponentName)
  {
    final Callbacks localCallbacks;
    if (this.mCallbacks != null)
    {
      localCallbacks = (Callbacks)this.mCallbacks.get();
      if (localCallbacks != null)
        break label36;
      Log.w("PackageUpdateHandler", "updateUnreadNumWhenClearData ,Nobody to tell about the new app.  Launcher is probably loading.");
    }
    label36: 
    while (paramComponentName == null)
    {
      return;
      localCallbacks = null;
      break;
    }
    this.mHandler.postWorkspaceRunnable(new Runnable()
    {
      public void run()
      {
        if (PackageUpdateHandler.this.mCallbacks != null);
        for (Callbacks localCallbacks = (Callbacks)PackageUpdateHandler.this.mCallbacks.get(); ; localCallbacks = null)
        {
          if ((localCallbacks == localCallbacks) && (localCallbacks != null))
            localCallbacks.bindComponentUnreadChanged(paramComponentName, 0);
          return;
        }
      }
    });
  }

  public boolean checkChangedMsgFromPackage(Context paramContext, Intent paramIntent, String paramString)
  {
    paramContext = getPackagesNameFromUid(paramContext, paramIntent.getIntExtra("android.intent.action.TRIGGER_PACKAGE", -1));
    if (DEBUG)
      Log.d("PackageUpdateHandler", "sameUidPackageNames = " + paramContext);
    if (paramContext == null);
    do
    {
      return false;
      int i = 0;
      while (i < paramContext.length)
      {
        if (paramContext[i].equals(paramString))
        {
          if (DEBUG)
            Log.d("PackageUpdateHandler", "checkUpdateMsgFromLauncher return true");
          return true;
        }
        i += 1;
      }
    }
    while (!DEBUG);
    Log.d("PackageUpdateHandler", "checkUpdateMsgFromLauncher return false");
    return false;
  }

  public String[] getPackagesNameFromUid(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getPackageManager();
    if (paramContext != null)
      return paramContext.getPackagesForUid(paramInt);
    return null;
  }

  public void initialize(LauncherModel paramLauncherModel, AllAppsList paramAllAppsList)
  {
    this.mLauncherModel = paramLauncherModel;
    this.mAllAppsList = paramAllAppsList;
  }

  public void killSelfWhenUiEngineChanged(String paramString)
  {
    if ((this.mExitFlag) && ("com.color.uiengine".equals(paramString)))
    {
      this.mExitFlag = false;
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          System.exit(0);
        }
      }
      , 500L);
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (DEBUG)
      Log.d("PackageUpdateHandler", "onReceive intent=" + paramIntent);
    Object localObject = paramIntent.getAction();
    if ("android.intent.action.PACKAGE_DATA_CLEARED".equals(localObject))
    {
      paramIntent = paramIntent.getData();
      if (DEBUG)
        Log.d("PackageUpdateHandler", "onReceive uri= " + paramIntent);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getSchemeSpecificPart();
        if (!"com.coloros.notificationmanager".equals(paramIntent))
          break label119;
        if (this.mApp != null)
          OPPOUnreadLoader.getInstance(this.mApp).openAllAppsSwitch();
      }
    }
    while (true)
    {
      return;
      label119: localObject = AllAppsList.findActivitiesForPackage(paramContext, paramIntent);
      if (DEBUG)
        Log.d("PackageUpdateHandler", "onReceive ---> pkgName = " + paramIntent + ", matches.size() = " + ((List)localObject).size());
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramIntent = OPPOUnreadLoader.getAllSupportUnreadComponentsForPackage(((ResolveInfo)((List)localObject).get(0)).activityInfo.applicationInfo.packageName).iterator();
        while (paramIntent.hasNext())
        {
          localObject = (ComponentName)paramIntent.next();
          OPPOUnreadLoader.clearUnreadNumForComponentName(paramContext, (ComponentName)localObject);
          updateUnreadNumWhenClearData((ComponentName)localObject);
        }
        continue;
        if ("com.oppo.backuprestore.restore_app_start".equals(localObject))
        {
          this.mIsRestoreApp = true;
          return;
        }
        if ("com.oppo.backuprestore.restore_app_end".equals(localObject))
        {
          this.mIsRestoreApp = false;
          return;
        }
        if ("com.oppo.backuprestore.restore_opponote_success".equals(localObject))
        {
          this.mLauncherModel.enqueuePackageUpdated(new PackageUpdatedTask(9, new String[] { "com.nearme.note" }));
          return;
        }
        if (("android.intent.action.PACKAGE_CHANGED".equals(localObject)) || ("android.intent.action.PACKAGE_REMOVED".equals(localObject)) || ("android.intent.action.PACKAGE_ADDED".equals(localObject)))
        {
          String str = paramIntent.getData().getSchemeSpecificPart();
          killSelfWhenUiEngineChanged(str);
          boolean bool = paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
          paramContext = getProcessNameByPid(paramContext, paramIntent.getIntExtra("android.intent.action.TRIGGER_PACKAGE", -1));
          int i = 0;
          if ((str != null) && (str.length() != 0))
          {
            if ("android.intent.action.PACKAGE_CHANGED".equals(localObject))
              if ((paramContext != null) && (paramContext.equals("com.coloros.backuprestore.remoteservice")))
              {
                Log.d("PackageUpdateHandler", "ACTION_PACKAGE_CHANGED -- callProcessName = " + paramContext);
                i = 0;
              }
            while (i != 0)
            {
              this.mLauncherModel.enqueuePackageUpdated(new PackageUpdatedTask(i, new String[] { str }));
              return;
              i = 2;
              continue;
              if ("android.intent.action.PACKAGE_REMOVED".equals(localObject))
              {
                if (DEBUG)
                  Log.d("PackageUpdateHandler", "ACTION_PACKAGE_REMOVED -- callProcessName = " + paramContext + ". replacing = " + bool + ". packageName = " + str);
                if (!bool)
                  i = 3;
              }
              else if ("android.intent.action.PACKAGE_ADDED".equals(localObject))
              {
                if (!bool)
                  i = 1;
                else
                  i = 7;
              }
            }
          }
        }
        else if ("android.intent.action.EXTERNAL_APPLICATIONS_AVAILABLE".equals(localObject))
        {
          LauncherModel.setExternalAppAvailable(true);
          if ((this.mApp != null) && (this.mApp.getLauncher() != null))
            this.mApp.getLauncher().bindExternalAppAvailable();
          paramContext = paramIntent.getStringArrayExtra("android.intent.extra.changed_package_list");
          if (DEBUG)
            Log.d("PackageUpdateHandler", "onReceive ACTION_EXTERNAL_APPLICATIONS_AVAILABLE, packages.length = " + paramContext.length);
          if (this.mLauncherModel != null)
          {
            if ((paramContext != null) && (1 == paramContext.length))
            {
              this.mLauncherModel.updateInstalledLocation(paramContext[0]);
              this.mLauncherModel.enqueuePackageUpdated(new PackageUpdatedTask(10, paramContext));
              return;
            }
            Log.d("PackageUpdateHandler", "onReceive ACTION_EXTERNAL_APPLICATIONS_AVAILABLE, flush iconCache and forceReload now! ");
            this.mIconCache.flush();
            this.mLauncherModel.forceReload(false);
          }
        }
        else
        {
          if ("android.intent.action.EXTERNAL_APPLICATIONS_UNAVAILABLE".equals(localObject))
          {
            LauncherModel.setExternalAppAvailable(false);
            if ((this.mApp != null) && (this.mApp.getLauncher() != null))
              this.mApp.getLauncher().bindExternalAppUnavailable();
            paramContext = paramIntent.getStringArrayExtra("android.intent.extra.changed_package_list");
            this.mLauncherModel.enqueuePackageUpdated(new PackageUpdatedTask(4, paramContext));
            appChangeSdcard();
            return;
          }
          if ("oppo.intent.action.ADDAPP_TO_VISTORMODE_OR_PRIVACYZONE".equals(localObject))
          {
            paramContext = paramIntent.getStringExtra("packagename");
            if (paramContext != null)
            {
              if (DEBUG)
                Log.d("PackageUpdateHandler", "packageName = " + paramContext + " removed from privacy zone");
              this.mLauncherModel.enqueuePackageUpdated(new PackageUpdatedTask(1, new String[] { paramContext }));
              return;
            }
            paramContext = paramIntent.getStringArrayListExtra("pkgnames");
            if ((paramContext != null) && (paramContext.size() > 0))
            {
              this.mLauncherModel.enqueuePackageUpdated(new PackageUpdatedTask(3, (String[])paramContext.toArray(new String[0])));
              if (DEBUG)
              {
                paramContext = paramContext.iterator();
                while (paramContext.hasNext())
                {
                  paramIntent = (String)paramContext.next();
                  Log.d("PackageUpdateHandler", "packageName = " + paramIntent + "add into privacay zone");
                }
              }
            }
          }
        }
      }
    }
  }

  public void setCallBacks(Callbacks paramCallbacks)
  {
    this.mCallbacks = new WeakReference(paramCallbacks);
  }

  public static abstract interface Callbacks
  {
    public abstract void bindAppWidgetPackageRemoved(ArrayList<String> paramArrayList);

    public abstract void bindAppWidgetUpdated(ArrayList<ApplicationInfo> paramArrayList);

    public abstract void bindAppsAdded(ArrayList<ApplicationInfo> paramArrayList);

    public abstract void bindAppsRemoved(ArrayList<ApplicationInfo> paramArrayList, boolean paramBoolean);

    public abstract void bindAppsUpdated(ArrayList<ApplicationInfo> paramArrayList, boolean paramBoolean);

    public abstract void bindComponentUnreadChanged(ComponentName paramComponentName, int paramInt);

    public abstract void bindSdcardStateChanged();
  }

  class PackageUpdatedTask
    implements Runnable
  {
    public static final int OP_ADD = 1;
    public static final int OP_AVAILABLE = 10;
    public static final int OP_NONE = 0;
    public static final int OP_REMOVE = 3;
    public static final int OP_REPLACE = 7;
    public static final int OP_START_NEW_APP = 6;
    public static final int OP_UNAVAILABLE = 4;
    public static final int OP_UPDATE = 2;
    public static final int OP_UPDATE_CALENDAR_ICON = 8;
    public static final int OP_UPDATE_WIDGET = 9;
    int mOp;
    String[] mPackages;

    public PackageUpdatedTask(int paramArrayOfString, String[] arg3)
    {
      this.mOp = paramArrayOfString;
      Object localObject;
      this.mPackages = localObject;
    }

    public void run()
    {
      Object localObject1 = PackageUpdateHandler.this.mApp;
      Object localObject2 = this.mPackages;
      int i;
      if (localObject2 != null)
      {
        i = localObject2.length;
        if (PackageUpdateHandler.this.mAllAppsList != null)
          break label38;
      }
      label38: final ArrayList localArrayList1;
      final ArrayList localArrayList2;
      Object localObject3;
      do
      {
        return;
        i = 0;
        break;
        switch (this.mOp)
        {
        case 5:
        default:
        case 1:
        case 2:
        case 8:
        case 9:
        case 7:
        case 3:
        case 6:
        case 4:
        case 10:
        }
        while (true)
        {
          localObject1 = null;
          localObject2 = null;
          localArrayList1 = null;
          localArrayList2 = null;
          if (PackageUpdateHandler.this.mAllAppsList.added.size() > 0)
          {
            localObject1 = PackageUpdateHandler.this.mAllAppsList.added;
            PackageUpdateHandler.this.mAllAppsList.added = new ArrayList();
          }
          if (PackageUpdateHandler.this.mAllAppsList.removed.size() <= 0)
            break;
          localObject3 = PackageUpdateHandler.this.mAllAppsList.removed;
          PackageUpdateHandler.this.mAllAppsList.removed = new ArrayList();
          Iterator localIterator = ((ArrayList)localObject3).iterator();
          while (true)
          {
            localObject2 = localObject3;
            if (!localIterator.hasNext())
              break;
            localObject2 = (ApplicationInfo)localIterator.next();
            PackageUpdateHandler.this.mIconCache.remove(((ApplicationInfo)localObject2).intent.getComponent());
          }
          int j = 0;
          while (j < i)
          {
            if (PackageUpdateHandler.DEBUG)
              Log.d("PackageUpdateHandler", "mAllAppsList.addPackage " + localObject2[j]);
            PackageUpdateHandler.this.mAllAppsList.addPackage((Context)localObject1, localObject2[j], PackageUpdateHandler.this.mIsRestoreApp);
            j += 1;
          }
          j = 0;
          while (j < i)
          {
            if (PackageUpdateHandler.DEBUG)
              Log.d("PackageUpdateHandler", "mAllAppsList.updatePackage " + localObject2[j]);
            PackageUpdateHandler.this.mAllAppsList.updatePackage((Context)localObject1, localObject2[j], PackageUpdateHandler.this.mIsRestoreApp, false);
            j += 1;
          }
          j = 0;
          while (j < i)
          {
            if (PackageUpdateHandler.DEBUG)
              Log.d("PackageUpdateHandler", "mAllAppsList.updatePackage " + localObject2[j]);
            PackageUpdateHandler.this.mAllAppsList.updatePackage((Context)localObject1, localObject2[j], PackageUpdateHandler.this.mIsRestoreApp, true);
            j += 1;
          }
          j = 0;
          while (j < i)
          {
            if (PackageUpdateHandler.DEBUG)
              Log.d("PackageUpdateHandler", "PackageUpdatedTask run case OP_REMOVE. Call mAllAppsList.removePackage - " + localObject2[j]);
            PackageUpdateHandler.this.mAllAppsList.removePackage((Context)localObject1, localObject2[j]);
            j += 1;
          }
          j = 0;
          while (j < i)
          {
            if (PackageUpdateHandler.DEBUG)
              Log.d("PackageUpdateHandler", "mAllAppsList.updateAppNewInstallFlag -- packageName = " + localObject2[j]);
            PackageUpdateHandler.this.mAllAppsList.updateAppNewInstallFlag((Context)localObject1, localObject2[j]);
            j += 1;
          }
          if (PackageUpdateHandler.this.mAllAppsList.modified.size() <= 0)
          {
            return;
            j = 0;
            while (j < i)
            {
              if (PackageUpdateHandler.DEBUG)
                Log.d("PackageUpdateHandler", "mAllAppsList.updateAppUnavailableFlag -- packageName = " + localObject2[j]);
              PackageUpdateHandler.this.mAllAppsList.updateAppUnavailableFlag((Context)localObject1, localObject2[j]);
              j += 1;
            }
          }
        }
        if (PackageUpdateHandler.this.mAllAppsList.modified.size() > 0)
        {
          localArrayList1 = PackageUpdateHandler.this.mAllAppsList.modified;
          PackageUpdateHandler.this.mAllAppsList.modified = new ArrayList();
        }
        if (PackageUpdateHandler.this.mAllAppsList.appwidgetPackageList.size() > 0)
        {
          localArrayList2 = PackageUpdateHandler.this.mAllAppsList.appwidgetPackageList;
          PackageUpdateHandler.this.mAllAppsList.appwidgetPackageList = new ArrayList();
        }
        if (PackageUpdateHandler.this.mCallbacks != null);
        for (localObject3 = (Callbacks)PackageUpdateHandler.this.mCallbacks.get(); localObject3 == null; localObject3 = null)
        {
          Log.w("PackageUpdateHandler", "Nobody to tell about the new app.  Launcher is probably loading.");
          return;
        }
      }
      while (PackageUpdateHandler.this.mHandler == null);
      if (localObject2 != null)
        if (this.mOp == 4)
          break label988;
      label988: for (final boolean bool = true; ; bool = false)
      {
        PackageUpdateHandler.this.mHandler.postWorkspaceRunnable(new Runnable()
        {
          public void run()
          {
            if (PackageUpdateHandler.this.mCallbacks != null);
            for (Callbacks localCallbacks = (Callbacks)PackageUpdateHandler.this.mCallbacks.get(); ; localCallbacks = null)
            {
              if ((this.val$callbacks == localCallbacks) && (localCallbacks != null))
                this.val$callbacks.bindAppsRemoved(this.val$removedFinal, bool);
              return;
            }
          }
        });
        if (localObject1 != null)
          PackageUpdateHandler.this.mHandler.postWorkspaceRunnable(new Runnable()
          {
            public void run()
            {
              if (PackageUpdateHandler.this.mCallbacks != null);
              for (Callbacks localCallbacks = (Callbacks)PackageUpdateHandler.this.mCallbacks.get(); ; localCallbacks = null)
              {
                if ((this.val$callbacks == localCallbacks) && (localCallbacks != null))
                  this.val$callbacks.bindAppsAdded(this.val$addedFinal);
                return;
              }
            }
          });
        if (localArrayList1 != null)
          PackageUpdateHandler.this.mHandler.postWorkspaceRunnable(new Runnable()
          {
            public void run()
            {
              if (PackageUpdateHandler.this.mCallbacks != null);
              for (Callbacks localCallbacks = (Callbacks)PackageUpdateHandler.this.mCallbacks.get(); ; localCallbacks = null)
              {
                if ((this.val$callbacks == localCallbacks) && (localCallbacks != null))
                {
                  if (PackageUpdatedTask.this.mOp != 8)
                    break;
                  this.val$callbacks.bindAppsUpdated(localArrayList1, true);
                }
                return;
              }
              if (PackageUpdatedTask.this.mOp == 9)
              {
                this.val$callbacks.bindAppWidgetUpdated(localArrayList1);
                return;
              }
              this.val$callbacks.bindAppsUpdated(localArrayList1, false);
            }
          });
        if (localArrayList2 == null)
          break;
        if (PackageUpdateHandler.DEBUG)
          Log.d("PackageUpdateHandler", "PackageUpdatedTask running --- maybeWidgetFinal.size = " + localArrayList2.size());
        PackageUpdateHandler.this.mHandler.postWorkspaceRunnable(new Runnable()
        {
          public void run()
          {
            if (PackageUpdateHandler.this.mCallbacks != null);
            for (Callbacks localCallbacks = (Callbacks)PackageUpdateHandler.this.mCallbacks.get(); ; localCallbacks = null)
            {
              if ((this.val$callbacks == localCallbacks) && (localCallbacks != null))
                this.val$callbacks.bindAppWidgetPackageRemoved(localArrayList2);
              return;
            }
          }
        });
        return;
      }
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.PackageUpdateHandler
 * JD-Core Version:    0.6.2
 */