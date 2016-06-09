package com.oppo.launcher.backup;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;
import android.util.Log;
import com.coloros.backup.sdk.BackupAgentInfo;
import com.coloros.backup.sdk.TargetDirInfo;
import com.coloros.backup.sdk.restore.RestoreAgentService;
import com.coloros.backup.sdk.utils.FileUtils;
import com.coloros.backup.sdk.utils.TarToolUtils;
import com.coloros.backup.sdk.utils.Utils;
import java.io.File;
import java.io.IOException;

public class LayoutRestoreAgentService extends RestoreAgentService
{
  private static final String RESTORE_LAUNCHER_SUCCESS = "com.oppo.backuprestore.restore_launcher_success";
  protected static final String TAG = "BackupTAG LayoutRestoreComposer";
  private static String sLauncherPackageName = "com.oppo.launcher";
  private BackupAgentInfo backupAgentInfo = new BackupAgentInfo(352);
  private boolean hasOppoLauncher = true;
  private int index = 0;
  private ServiceConnection mConn = new ServiceConnection()
  {
    public void onServiceConnected(ComponentName arg1, IBinder paramAnonymousIBinder)
    {
      Log.d("BackupTAG LayoutRestoreComposer", "onServiceConnected" + ???);
      synchronized (LayoutRestoreAgentService.this.mLock)
      {
        LayoutRestoreAgentService.access$102(LayoutRestoreAgentService.this, true);
        LayoutRestoreAgentService.this.mLock.notifyAll();
        return;
      }
    }

    public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      Log.d("BackupTAG LayoutRestoreComposer", "onServiceDisconnected" + paramAnonymousComponentName);
      LayoutRestoreAgentService.access$102(LayoutRestoreAgentService.this, false);
    }
  };
  String mFolderPath = null;
  private boolean mIsAidlServiceConnected;
  private Object mLock = new Object();

  private boolean canRestoreAppData()
  {
    String str1;
    while (true)
    {
      try
      {
        Object localObject = this.mContext.getDir(sLauncherPackageName + "_for_get_db", 0);
        String str2 = this.mFolderPath + File.separator + sLauncherPackageName + ".tar";
        localObject = ((File)localObject).getAbsolutePath();
        Log.d("BackupTAG LayoutRestoreComposer", "appDataTar " + str2);
        Log.d("BackupTAG LayoutRestoreComposer", "unTarPath " + (String)localObject);
        File localFile1 = new File((String)localObject);
        if (!localFile1.exists())
          localFile1.mkdirs();
        if (new File(str2).exists())
          Log.d("BackupTAG LayoutRestoreComposer", "File(appDataTar)!= null");
        try
        {
          TarToolUtils.dearchive(str2, (String)localObject);
          new File((String)localObject + "/data/data/com.oppo.launcher/databases/launcher.db");
          if (localFile1.exists())
          {
            localObject = (String)localObject + "/data/data/com.oppo.launcher/databases/launcher.db";
            Log.d("BackupTAG LayoutRestoreComposer", "canRestoreAppData launcher_database = " + (String)localObject);
            localObject = SQLiteDatabase.openDatabase((String)localObject, null, 0);
            if (localObject == null)
              break label389;
            Log.d("BackupTAG LayoutRestoreComposer", "canRestoreAppData getVersion = " + ((SQLiteDatabase)localObject).getVersion());
            if (((SQLiteDatabase)localObject).getVersion() <= 20)
              break;
            return true;
          }
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          File localFile2 = new File((String)localObject);
          if (localFile2.exists())
            FileUtils.deleteFileOrFolder(localFile2);
          Log.d("BackupTAG LayoutRestoreComposer", "dearchive failed");
          continue;
        }
      }
      catch (Exception localException)
      {
        Log.d("BackupTAG LayoutRestoreComposer", "canRestoreAppData Exception = " + localException);
        return false;
      }
      str1 = localException + "/data/data/com.oppo.launcher/databases/launcher_4x4.db";
    }
    str1.close();
    label389: return false;
  }

  private void sendSuccesssBroadcast()
  {
    Intent localIntent = new Intent("com.oppo.backuprestore.restore_launcher_success");
    this.mContext.sendBroadcast(localIntent);
  }

  public BackupAgentInfo getBackupAgentInfo()
  {
    return this.backupAgentInfo;
  }

  public int getMaxCount()
  {
    if (this.hasOppoLauncher)
      return 1;
    return 0;
  }

  public boolean onEnd()
  {
    try
    {
      this.mContext.unbindService(this.mConn);
      sendSuccesssBroadcast();
      return true;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public boolean onInit()
  {
    Object localObject2 = this.mContext.getPackageManager();
    Object localObject1 = null;
    try
    {
      localObject2 = ((PackageManager)localObject2).getPackageInfo(sLauncherPackageName, 0);
      localObject1 = localObject2;
      if (localObject1 == null)
      {
        this.hasOppoLauncher = false;
        this.mFolderPath = getTargetDirInfo().folder;
        if (this.hasOppoLauncher)
        {
          localObject1 = new File(this.mFolderPath + File.separator + sLauncherPackageName + ".tar");
          if ((localObject1 == null) || (!((File)localObject1).exists()))
            this.hasOppoLauncher = false;
        }
        Log.d("BackupTAG LayoutRestoreComposer", "---init---");
        return true;
      }
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
      while (true)
      {
        localNameNotFoundException.printStackTrace();
        continue;
        this.hasOppoLauncher = true;
      }
    }
  }

  public int onRestoreAndIncProgress()
  {
    Log.d("BackupTAG LayoutRestoreComposer", "---implementComposeOneEntity");
    if (!this.hasOppoLauncher)
      return -1;
    synchronized (this.mLock)
    {
      while (true)
      {
        bool1 = this.mIsAidlServiceConnected;
        if (!bool1)
          try
          {
            this.mLock.wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
      }
    }
    boolean bool1 = false;
    try
    {
      Log.d("BackupTAG LayoutRestoreComposer", "disableApp()");
      boolean bool2;
      if (canRestoreAppData())
        bool2 = FileUtils.restoreAppData(this.mFolderPath, sLauncherPackageName, this.mContext);
      for (bool1 = bool2; ; bool1 = true)
      {
        Log.d("BackupTAG LayoutRestoreComposer", "---implementComposeOneEntity---end");
        if (!bool1)
          break;
        return 1;
      }
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
    return 0;
  }

  public boolean onStart()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    Intent localIntent;
    if (this.hasOppoLauncher)
      localIntent = Utils.buildAidlServiceIntent();
    try
    {
      this.mContext.bindService(localIntent, this.mConn, 1);
      bool1 = bool2;
      Log.d("BackupTAG LayoutRestoreComposer", "---onStart---hasOppoLauncher = " + this.hasOppoLauncher);
      return bool1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.mIsAidlServiceConnected = true;
        bool1 = false;
      }
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.backup.LayoutRestoreAgentService
 * JD-Core Version:    0.6.2
 */