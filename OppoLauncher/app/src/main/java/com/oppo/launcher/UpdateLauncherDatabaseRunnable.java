package com.oppo.launcher;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;

public class UpdateLauncherDatabaseRunnable
  implements Runnable
{
  private static final boolean DEBUG = false;
  private static final int NO_ID = -1;
  private static final String TAG = "UpdateWorkspaceDataBaseRunnable";
  private long mContainer = -1L;
  private ContentResolver mContentResolver;
  private Context mContext = null;
  private ArrayList<ItemInfo> mDeleteItemInfoList = null;
  private ArrayList<ItemInfo> mInsertItemInfoList = null;
  private LauncherApplication mLauncherApplication;
  private boolean mNeedUpdateIcon = false;
  private Runnable mRunOnUIThreadCallback;
  private int mScreenId = -1;
  private ArrayList<ItemInfo> mUpdateItemInfoList = null;

  public UpdateLauncherDatabaseRunnable(Context paramContext)
  {
    this(paramContext, -1L, -1);
  }

  public UpdateLauncherDatabaseRunnable(Context paramContext, long paramLong, int paramInt)
  {
    this(paramContext, paramLong, paramInt, null);
  }

  public UpdateLauncherDatabaseRunnable(Context paramContext, long paramLong, int paramInt, Runnable paramRunnable)
  {
    this.mContext = paramContext;
    this.mContentResolver = paramContext.getContentResolver();
    this.mLauncherApplication = ((LauncherApplication)paramContext.getApplicationContext());
    this.mContainer = paramLong;
    this.mScreenId = paramInt;
    this.mRunOnUIThreadCallback = paramRunnable;
  }

  private void deleteItems()
  {
    if ((this.mDeleteItemInfoList == null) || (this.mDeleteItemInfoList.size() <= 0))
      return;
    Object localObject3 = null;
    Object localObject1 = null;
    int j = 0;
    try
    {
      SQLiteDatabase localSQLiteDatabase = SQLiteDatabase.openDatabase(LauncherProvider.DATABASE_PATH, null, 0);
      localObject1 = localSQLiteDatabase;
      localObject3 = localSQLiteDatabase;
      localSQLiteDatabase.beginTransaction();
      int i = 0;
      while (true)
      {
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        if (i >= this.mDeleteItemInfoList.size())
          break;
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        j += localSQLiteDatabase.delete("singledesktopitems", "_id=?", new String[] { String.valueOf(((ItemInfo)this.mDeleteItemInfoList.get(i)).id) });
        i += 1;
      }
      localObject1 = localSQLiteDatabase;
      localObject3 = localSQLiteDatabase;
      localSQLiteDatabase.setTransactionSuccessful();
      LauncherModelDataHelper.endAndCloseDB(localSQLiteDatabase);
      this.mDeleteItemInfoList.clear();
      this.mDeleteItemInfoList = null;
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localObject3 = localObject1;
        Log.e("UpdateWorkspaceDataBaseRunnable", "deleteItems --- e = " + localException);
        LauncherModelDataHelper.endAndCloseDB(localObject1);
      }
    }
    finally
    {
      LauncherModelDataHelper.endAndCloseDB(localObject3);
    }
  }

  private void insertItems()
  {
    if ((this.mInsertItemInfoList == null) || (this.mInsertItemInfoList.size() <= 0))
    {
      Log.w("UpdateWorkspaceDataBaseRunnable", "mInsertItemInfoList == null || mInsertItemInfoList.size() <= 0 ");
      return;
    }
    SystemClock.uptimeMillis();
    int j = this.mInsertItemInfoList.size();
    ContentValues[] arrayOfContentValues = new ContentValues[j];
    int i = 0;
    if (i < j)
    {
      ContentValues localContentValues = new ContentValues();
      ItemInfo localItemInfo = (ItemInfo)this.mInsertItemInfoList.get(i);
      if (localItemInfo.id == -1L)
      {
        if ((this.mLauncherApplication != null) && (this.mLauncherApplication.getLauncherProvider() != null))
          localItemInfo.id = this.mLauncherApplication.getLauncherProvider().generateNewId();
      }
      else
      {
        if (!(localItemInfo instanceof FolderInfo))
          break label294;
        localContentValues.put("title", ((FolderInfo)localItemInfo).title.toString());
        localContentValues.put("modelState", Integer.valueOf(0));
        label161: localContentValues.put("_id", Long.valueOf(localItemInfo.id));
        localContentValues.put("itemType", Integer.valueOf(localItemInfo.itemType));
        if (this.mContainer == -1L)
          break label437;
        localContentValues.put("container", Long.valueOf(this.mContainer));
        label216: if (this.mScreenId == -1)
          break label455;
        localContentValues.put("screenId", Integer.valueOf(this.mScreenId));
      }
      while (true)
      {
        while (true)
        {
          localContentValues.put("cellX", Integer.valueOf(localItemInfo.cellX));
          localContentValues.put("cellY", Integer.valueOf(localItemInfo.cellY));
          arrayOfContentValues[i] = localContentValues;
          while (true)
          {
            i += 1;
            break;
            Log.w("UpdateWorkspaceDataBaseRunnable", "mLauncherApplication == null || mLauncherApplication.getLauncherProvider() == null. can not generateNewId, just return");
          }
          label294: if (!(localItemInfo instanceof ApplicationInfo))
            break label161;
          Object localObject3 = (ApplicationInfo)localItemInfo;
          ((ApplicationInfo)localObject3).onAddToDatabase(localContentValues);
          if ((!((ApplicationInfo)localObject3).isShortcut()) || (((ApplicationInfo)localObject3).packageName != null))
            break label161;
          Object localObject1 = null;
          String str = null;
          localObject3 = ((ApplicationInfo)localObject3).getIntent();
          if (localObject3 != null)
          {
            if (((Intent)localObject3).getComponent() != null)
              str = ((Intent)localObject3).getComponent().getPackageName();
            localObject1 = str;
            if (str != null);
          }
          try
          {
            localObject1 = this.mContext.getPackageManager().resolveActivity((Intent)localObject3, 65536).activityInfo.packageName;
            localContentValues.put("packageName", (String)localObject1);
          }
          catch (Exception localException)
          {
            while (true)
            {
              Log.w("UpdateWorkspaceDataBaseRunnable", "insertItems -- shortcutInfo e = " + localException);
              Object localObject2 = str;
            }
          }
        }
        label437: localContentValues.put("container", Long.valueOf(localItemInfo.container));
        break label216;
        label455: localContentValues.put("screenId", Integer.valueOf(localItemInfo.screenId));
      }
    }
    this.mInsertItemInfoList.clear();
    this.mInsertItemInfoList = null;
    this.mContentResolver.bulkInsert(LauncherSettings.SingleDeskTopItems.CONTENT_URI_NO_NOTIFICATION, arrayOfContentValues);
  }

  private void updateItems()
  {
    if ((this.mUpdateItemInfoList == null) || (this.mUpdateItemInfoList.size() <= 0))
      return;
    Object localObject3 = null;
    Object localObject1 = null;
    int k = this.mUpdateItemInfoList.size();
    ContentValues[] arrayOfContentValues = new ContentValues[k];
    int i = 0;
    Object localObject4;
    Object localObject5;
    if (i < k)
    {
      localObject4 = new ContentValues();
      localObject5 = (ItemInfo)this.mUpdateItemInfoList.get(i);
      if ((localObject5 instanceof FolderInfo))
      {
        ((ContentValues)localObject4).put("title", ((FolderInfo)localObject5).title.toString());
        ((ContentValues)localObject4).put("modelState", Integer.valueOf(0));
        label107: ((ContentValues)localObject4).put("_id", Long.valueOf(((ItemInfo)localObject5).id));
        ((ContentValues)localObject4).put("itemType", Integer.valueOf(((ItemInfo)localObject5).itemType));
        if (this.mContainer == -1L)
          break label340;
        ((ContentValues)localObject4).put("container", Long.valueOf(this.mContainer));
        label159: if (this.mScreenId == -1)
          break label357;
        ((ContentValues)localObject4).put("screenId", Integer.valueOf(this.mScreenId));
      }
      while (true)
      {
        ((ContentValues)localObject4).put("cellX", Integer.valueOf(((ItemInfo)localObject5).cellX));
        ((ContentValues)localObject4).put("cellY", Integer.valueOf(((ItemInfo)localObject5).cellY));
        if (this.mNeedUpdateIcon)
          ((ContentValues)localObject4).put("icon", ItemInfo.flattenBitmap(((ItemInfo)localObject5).getIconBitmap()));
        arrayOfContentValues[i] = localObject4;
        i += 1;
        break;
        if (!(localObject5 instanceof ApplicationInfo))
          break label107;
        ApplicationInfo localApplicationInfo = (ApplicationInfo)localObject5;
        if (localApplicationInfo.isApplication())
        {
          ComponentName localComponentName = localApplicationInfo.componentName;
          ((ContentValues)localObject4).put("packageName", localComponentName.getPackageName());
          ((ContentValues)localObject4).put("className", localComponentName.getClassName());
        }
        if (localApplicationInfo.title != null)
          ((ContentValues)localObject4).put("title", localApplicationInfo.title.toString());
        ((ContentValues)localObject4).put("modelState", Integer.valueOf(localApplicationInfo.installedLocation));
        break label107;
        label340: ((ContentValues)localObject4).put("container", Long.valueOf(((ItemInfo)localObject5).container));
        break label159;
        label357: ((ContentValues)localObject4).put("screenId", Integer.valueOf(((ItemInfo)localObject5).screenId));
      }
    }
    this.mUpdateItemInfoList.clear();
    this.mUpdateItemInfoList = null;
    this.mNeedUpdateIcon = false;
    int j = 0;
    try
    {
      localObject4 = SQLiteDatabase.openDatabase(LauncherProvider.DATABASE_PATH, null, 0);
      localObject1 = localObject4;
      localObject3 = localObject4;
      ((SQLiteDatabase)localObject4).beginTransaction();
      i = 0;
      while (i < k)
      {
        localObject1 = localObject4;
        localObject3 = localObject4;
        localObject5 = String.valueOf(arrayOfContentValues[i].get("_id"));
        localObject1 = localObject4;
        localObject3 = localObject4;
        j += ((SQLiteDatabase)localObject4).update("singledesktopitems", arrayOfContentValues[i], "_id=?", new String[] { localObject5 });
        i += 1;
      }
      localObject1 = localObject4;
      localObject3 = localObject4;
      ((SQLiteDatabase)localObject4).setTransactionSuccessful();
      LauncherModelDataHelper.endAndCloseDB((SQLiteDatabase)localObject4);
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      Log.e("UpdateWorkspaceDataBaseRunnable", "updateItems --- e = " + localException);
      return;
    }
    finally
    {
      LauncherModelDataHelper.endAndCloseDB(localObject3);
    }
  }

  public void run()
  {
    deleteItems();
    updateItems();
    insertItems();
    if (this.mRunOnUIThreadCallback != null)
    {
      if ((this.mContext instanceof Launcher))
        ((Launcher)this.mContext).runOnUiThread(this.mRunOnUIThreadCallback);
      this.mRunOnUIThreadCallback = null;
    }
  }

  public void setDeleteList(ArrayList<ItemInfo> paramArrayList)
  {
    this.mDeleteItemInfoList = paramArrayList;
  }

  public void setInsertList(ArrayList<ItemInfo> paramArrayList)
  {
    this.mInsertItemInfoList = paramArrayList;
  }

  public void setNeedUpdateIcon(boolean paramBoolean)
  {
    this.mNeedUpdateIcon = paramBoolean;
  }

  public void setRunOnUIThreadCallback(Runnable paramRunnable)
  {
    this.mRunOnUIThreadCallback = paramRunnable;
  }

  public void setUpdateList(ArrayList<ItemInfo> paramArrayList)
  {
    this.mUpdateItemInfoList = paramArrayList;
  }

  public void setUpdateOrInsertList(ArrayList<ItemInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
      return;
    int i = 0;
    label14: ItemInfo localItemInfo;
    if (i < paramArrayList.size())
    {
      localItemInfo = (ItemInfo)paramArrayList.get(i);
      if (localItemInfo.container != -1L)
        break label76;
      if (this.mInsertItemInfoList == null)
        this.mInsertItemInfoList = new ArrayList();
      this.mInsertItemInfoList.add(localItemInfo);
    }
    while (true)
    {
      i += 1;
      break label14;
      break;
      label76: if (this.mUpdateItemInfoList == null)
        this.mUpdateItemInfoList = new ArrayList();
      this.mUpdateItemInfoList.add(localItemInfo);
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.UpdateLauncherDatabaseRunnable
 * JD-Core Version:    0.6.2
 */