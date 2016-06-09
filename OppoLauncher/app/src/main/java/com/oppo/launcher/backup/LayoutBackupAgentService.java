package com.oppo.launcher.backup;

import android.os.Environment;
import android.util.Log;
import com.coloros.backup.sdk.BackupAgentInfo;
import com.coloros.backup.sdk.TargetDirInfo;
import com.coloros.backup.sdk.backup.BackupAgentService;
import com.coloros.backup.sdk.utils.BackupRestoreSrv;
import com.coloros.backup.sdk.utils.FileUtils;
import java.io.File;

public class LayoutBackupAgentService extends BackupAgentService
{
  private static final String TAG = "BackupTAG LayoutBackupAgentService";
  private static String sLauncherDataDir = Environment.getDataDirectory().getPath() + File.separator + "data" + File.separator + sLauncherPackageName;
  private static String sLauncherPackageName = "com.oppo.launcher";
  private BackupAgentInfo backupAgentInfo = new BackupAgentInfo(352);

  public BackupAgentInfo getBackupAgentInfo()
  {
    return this.backupAgentInfo;
  }

  public int getMaxCount()
  {
    if (!new File(sLauncherDataDir).exists())
      return 0;
    return 1;
  }

  public int onBackupAndIncProgress()
  {
    if (FileUtils.backupAppData(getTargetDirInfo().folder, sLauncherDataDir, sLauncherPackageName, this.mContext))
      return 1;
    return 0;
  }

  public final boolean onEnd()
  {
    new BackupRestoreSrv().disconnect();
    Log.d("BackupTAG LayoutBackupAgentService", "onEnd()");
    return true;
  }

  public boolean onInit()
  {
    return true;
  }

  public boolean onStart()
  {
    if (getMaxCount() > 0)
    {
      File localFile = new File(getTargetDirInfo().folder);
      if (!localFile.exists())
        localFile.mkdirs();
    }
    return true;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.backup.LayoutBackupAgentService
 * JD-Core Version:    0.6.2
 */