package com.oppo.launcher;

import android.content.ComponentName;
import android.content.Intent;
import java.util.ArrayList;

public class ScreenCellInfo
{
  private static final boolean DEBUG_ENABLE = false;
  private static final String TAG = "ScreenCellInfo";
  long mId;
  private ArrayList<ItemInfo> mItemInfoList;
  int mScreenId;
  int mScreenNumUnounted;

  public ScreenCellInfo(long paramLong)
  {
    this.mId = paramLong;
    this.mItemInfoList = new ArrayList();
  }

  public ScreenCellInfo(long paramLong, ArrayList<ItemInfo> paramArrayList)
  {
    this.mId = paramLong;
    this.mItemInfoList = paramArrayList;
  }

  public boolean addCellInfo(int paramInt, ItemInfo paramItemInfo)
  {
    if (paramItemInfo == null)
      return false;
    synchronized (this.mItemInfoList)
    {
      int i = this.mItemInfoList.size();
      if ((paramInt < 0) || (paramInt > i))
      {
        this.mItemInfoList.add(paramItemInfo);
        return true;
      }
      this.mItemInfoList.add(paramInt, paramItemInfo);
    }
  }

  public boolean addCellInfo(ItemInfo paramItemInfo)
  {
    return addCellInfo(-1, paramItemInfo);
  }

  public void clear()
  {
    synchronized (this.mItemInfoList)
    {
      int j = this.mItemInfoList.size();
      int i = 0;
      while (i < j)
      {
        this.mItemInfoList.clear();
        i += 1;
      }
      return;
    }
  }

  public boolean findInfoForPackage(String paramString)
  {
    int j = this.mItemInfoList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (ItemInfo)this.mItemInfoList.get(i);
      if ((localObject instanceof ApplicationInfo))
      {
        localObject = ((ApplicationInfo)localObject).intent.getComponent();
        if ((localObject != null) && (((ComponentName)localObject).getPackageName().equals(paramString)))
          return true;
      }
      i += 1;
    }
    return false;
  }

  public ArrayList<ItemInfo> getCellInfoList()
  {
    return this.mItemInfoList;
  }

  public int getPagedId()
  {
    return this.mScreenId;
  }

  public boolean isNull()
  {
    return this.mItemInfoList.size() == 0;
  }

  public boolean removeAppInfo(ApplicationInfo paramApplicationInfo)
  {
    int j = this.mItemInfoList.size();
    int i = 0;
    while (i < j)
    {
      ItemInfo localItemInfo = (ItemInfo)this.mItemInfoList.get(i);
      if ((localItemInfo instanceof ApplicationInfo))
      {
        ApplicationInfo localApplicationInfo = (ApplicationInfo)localItemInfo;
        if ((localApplicationInfo != null) && (localApplicationInfo.componentName.equals(paramApplicationInfo.componentName)))
        {
          this.mItemInfoList.remove(localItemInfo);
          return true;
        }
      }
      i += 1;
    }
    return false;
  }

  public boolean removeCellInfo(ItemInfo paramItemInfo)
  {
    return this.mItemInfoList.remove(paramItemInfo);
  }

  public void setCellInfoList(ArrayList<ItemInfo> paramArrayList)
  {
    this.mItemInfoList = paramArrayList;
  }

  public void setPagedId(int paramInt)
  {
    this.mScreenId = paramInt;
  }

  public void setPagedNumUnmounted(int paramInt)
  {
    this.mScreenNumUnounted = paramInt;
  }

  public int size()
  {
    return this.mItemInfoList.size();
  }

  public boolean updateAppInfo(ApplicationInfo paramApplicationInfo)
  {
    if (paramApplicationInfo == null);
    while (true)
    {
      return false;
      int j = this.mItemInfoList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject = (ItemInfo)this.mItemInfoList.get(i);
        if ((localObject instanceof ApplicationInfo))
        {
          localObject = (ApplicationInfo)localObject;
          if ((localObject != null) && (((ApplicationInfo)localObject).componentName.equals(paramApplicationInfo.componentName)))
            return true;
        }
        i += 1;
      }
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ScreenCellInfo
 * JD-Core Version:    0.6.2
 */