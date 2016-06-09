package com.oppo.launcher;

import android.content.Context;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class WorkspaceScreenData
{
  public ArrayList<LauncherAppWidgetInfo> mAppWidgets = new ArrayList();
  public HashMap<Long, FolderInfo> mFolders = new HashMap();
  public ArrayList<ItemInfo> mItems = new ArrayList();
  private int mScreenId;

  protected void clear()
  {
    if (this.mItems != null)
      this.mItems.clear();
    if (this.mAppWidgets != null)
      this.mAppWidgets.clear();
    if (this.mFolders != null)
      this.mFolders.clear();
  }

  protected boolean containsItem(ItemInfo paramItemInfo)
  {
    return this.mItems.contains(paramItemInfo);
  }

  protected boolean findEmptyCell(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramArrayOfInt == null)
      arrayOfInt = new int[2];
    paramArrayOfInt = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { paramInt1, paramInt2 });
    Iterator localIterator = this.mItems.iterator();
    Object localObject;
    int k;
    int m;
    int n;
    int i1;
    int i;
    int j;
    while (localIterator.hasNext())
    {
      localObject = (ItemInfo)localIterator.next();
      k = ((ItemInfo)localObject).cellX;
      m = ((ItemInfo)localObject).cellY;
      n = ((ItemInfo)localObject).spanX;
      i1 = ((ItemInfo)localObject).spanY;
      i = k;
      while ((i < k + n) && (i < paramInt1))
      {
        j = m;
        while ((j < m + i1) && (j < paramInt2))
        {
          paramArrayOfInt[i][j] = 1;
          j += 1;
        }
        i += 1;
      }
    }
    localIterator = this.mAppWidgets.iterator();
    while (localIterator.hasNext())
    {
      localObject = (LauncherAppWidgetInfo)localIterator.next();
      k = ((LauncherAppWidgetInfo)localObject).cellX;
      m = ((LauncherAppWidgetInfo)localObject).cellY;
      n = ((LauncherAppWidgetInfo)localObject).spanX;
      i1 = ((LauncherAppWidgetInfo)localObject).spanY;
      i = k;
      while ((i < k + n) && (i < paramInt1))
      {
        j = m;
        while ((j < m + i1) && (j < paramInt2))
        {
          paramArrayOfInt[i][j] = 1;
          j += 1;
        }
        i += 1;
      }
    }
    return CellLayout.findVacantCell(arrayOfInt, 1, 1, paramInt1, paramInt2, paramArrayOfInt);
  }

  protected boolean findLastEmptyCell(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramArrayOfInt == null)
      arrayOfInt = new int[2];
    paramArrayOfInt = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { paramInt1, paramInt2 });
    Iterator localIterator = this.mItems.iterator();
    Object localObject;
    int k;
    int m;
    int n;
    int i1;
    int i;
    int j;
    while (localIterator.hasNext())
    {
      localObject = (ItemInfo)localIterator.next();
      k = ((ItemInfo)localObject).cellX;
      m = ((ItemInfo)localObject).cellY;
      n = ((ItemInfo)localObject).spanX;
      i1 = ((ItemInfo)localObject).spanY;
      i = k;
      while ((i < k + n) && (i < paramInt1))
      {
        j = m;
        while ((j < m + i1) && (j < paramInt2))
        {
          paramArrayOfInt[i][j] = 1;
          j += 1;
        }
        i += 1;
      }
    }
    localIterator = this.mAppWidgets.iterator();
    while (localIterator.hasNext())
    {
      localObject = (LauncherAppWidgetInfo)localIterator.next();
      k = ((LauncherAppWidgetInfo)localObject).cellX;
      m = ((LauncherAppWidgetInfo)localObject).cellY;
      n = ((LauncherAppWidgetInfo)localObject).spanX;
      i1 = ((LauncherAppWidgetInfo)localObject).spanY;
      i = k;
      while ((i < k + n) && (i < paramInt1))
      {
        j = m;
        while ((j < m + i1) && (j < paramInt2))
        {
          paramArrayOfInt[i][j] = 1;
          j += 1;
        }
        i += 1;
      }
    }
    paramInt2 -= 1;
    while (paramInt2 >= 0)
    {
      i = paramInt1 - 1;
      while (i >= 0)
      {
        if (paramArrayOfInt[i][paramInt2] == 0);
        for (j = 1; j != 0; j = 0)
        {
          arrayOfInt[0] = i;
          arrayOfInt[1] = paramInt2;
          return true;
        }
        i -= 1;
      }
      paramInt2 -= 1;
    }
    return false;
  }

  protected boolean findNextEmptyCell(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramArrayOfInt == null)
      arrayOfInt = new int[2];
    paramArrayOfInt = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { paramInt1, paramInt2 });
    Iterator localIterator = this.mItems.iterator();
    Object localObject;
    int k;
    int m;
    int n;
    int i1;
    int j;
    while (localIterator.hasNext())
    {
      localObject = (ItemInfo)localIterator.next();
      k = ((ItemInfo)localObject).cellX;
      m = ((ItemInfo)localObject).cellY;
      n = ((ItemInfo)localObject).spanX;
      i1 = ((ItemInfo)localObject).spanY;
      i = k;
      while ((i < k + n) && (i < paramInt1))
      {
        j = m;
        while ((j < m + i1) && (j < paramInt2))
        {
          paramArrayOfInt[i][j] = 1;
          j += 1;
        }
        i += 1;
      }
    }
    localIterator = this.mAppWidgets.iterator();
    while (localIterator.hasNext())
    {
      localObject = (LauncherAppWidgetInfo)localIterator.next();
      k = ((LauncherAppWidgetInfo)localObject).cellX;
      m = ((LauncherAppWidgetInfo)localObject).cellY;
      n = ((LauncherAppWidgetInfo)localObject).spanX;
      i1 = ((LauncherAppWidgetInfo)localObject).spanY;
      i = k;
      while ((i < k + n) && (i < paramInt1))
      {
        j = m;
        while ((j < m + i1) && (j < paramInt2))
        {
          paramArrayOfInt[i][j] = 1;
          j += 1;
        }
        i += 1;
      }
    }
    int i = 0;
    while (i < paramInt2)
    {
      j = 0;
      while (j < paramInt1)
      {
        if (paramArrayOfInt[j][i] == 0)
        {
          arrayOfInt[0] = j;
          arrayOfInt[1] = i;
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    return false;
  }

  protected int getScreenId()
  {
    return this.mScreenId;
  }

  public boolean isNull()
  {
    return (this.mAppWidgets.size() == 0) && (this.mItems.size() == 0);
  }

  public void removeNullFolder(Context paramContext)
  {
    Iterator localIterator = this.mFolders.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Long)localIterator.next();
      localObject = (FolderInfo)this.mFolders.get(localObject);
      if (((FolderInfo)localObject).contents.size() < 1)
      {
        this.mItems.remove(localObject);
        LauncherModel.deleteItemFromDatabase(paramContext, (ItemInfo)localObject);
        localIterator.remove();
      }
    }
  }

  protected void setScreenId(int paramInt)
  {
    this.mScreenId = paramInt;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.WorkspaceScreenData
 * JD-Core Version:    0.6.2
 */