package com.oppo.launcher;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FocusHelper
{
  private static View findIndexOfIcon(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i = paramArrayList.size();
    paramInt1 += paramInt2;
    while ((paramInt1 >= 0) && (paramInt1 < i))
    {
      View localView = (View)paramArrayList.get(paramInt1);
      if (((localView instanceof BubbleTextView)) || ((localView instanceof FolderIcon)))
        return localView;
      paramInt1 += paramInt2;
    }
    return null;
  }

  private static BaseCellLayout getCellLayoutChildrenForIndex(ViewGroup paramViewGroup, int paramInt)
  {
    return (BaseCellLayout)paramViewGroup.getChildAt(paramInt);
  }

  private static ArrayList<View> getCellLayoutChildrenSortedSpatially(BaseCellLayout paramBaseCellLayout, ViewGroup paramViewGroup)
  {
    int j = paramBaseCellLayout.getCellCountX();
    int k = paramViewGroup.getChildCount();
    paramBaseCellLayout = new ArrayList();
    int i = 0;
    while (i < k)
    {
      paramBaseCellLayout.add(paramViewGroup.getChildAt(i));
      i += 1;
    }
    Collections.sort(paramBaseCellLayout, new Comparator()
    {
      public int compare(View paramAnonymousView1, View paramAnonymousView2)
      {
        paramAnonymousView1 = (BaseCellLayout.LayoutParams)paramAnonymousView1.getLayoutParams();
        paramAnonymousView2 = (BaseCellLayout.LayoutParams)paramAnonymousView2.getLayoutParams();
        return paramAnonymousView1.cellY * this.val$cellCountX + paramAnonymousView1.cellX - (paramAnonymousView2.cellY * this.val$cellCountX + paramAnonymousView2.cellX);
      }
    });
    return paramBaseCellLayout;
  }

  private static View getClosestIconOnLine(BaseCellLayout paramBaseCellLayout, ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    paramViewGroup = getCellLayoutChildrenSortedSpatially(paramBaseCellLayout, paramViewGroup);
    BaseCellLayout.LayoutParams localLayoutParams = (BaseCellLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramBaseCellLayout.getCellCountY();
    int i1 = localLayoutParams.cellY;
    int j = i1 + paramInt;
    if ((j >= 0) && (j < i))
    {
      float f1 = 3.4028235E+38F;
      int m = -1;
      i = paramViewGroup.indexOf(paramView);
      int k;
      if (paramInt < 0)
        k = -1;
      while (i != k)
      {
        paramBaseCellLayout = (View)paramViewGroup.get(i);
        paramView = (BaseCellLayout.LayoutParams)paramBaseCellLayout.getLayoutParams();
        if (paramInt < 0)
          if (paramView.cellY < i1)
            j = 1;
        float f2;
        int n;
        while (true)
        {
          f2 = f1;
          n = m;
          if (j != 0)
            if (!(paramBaseCellLayout instanceof BubbleTextView))
            {
              f2 = f1;
              n = m;
              if (!(paramBaseCellLayout instanceof FolderIcon));
            }
            else
            {
              float f3 = (float)Math.sqrt(Math.pow(paramView.cellX - localLayoutParams.cellX, 2.0D) + Math.pow(paramView.cellY - localLayoutParams.cellY, 2.0D));
              f2 = f1;
              n = m;
              if (f3 < f1)
              {
                n = i;
                f2 = f3;
              }
            }
          if (i > k)
            break label268;
          i += 1;
          f1 = f2;
          m = n;
          break;
          k = paramViewGroup.size();
          break;
          j = 0;
          continue;
          if (paramView.cellY > i1)
            j = 1;
          else
            j = 0;
        }
        label268: i -= 1;
        f1 = f2;
        m = n;
      }
      if (m > -1)
        return (View)paramViewGroup.get(m);
    }
    return null;
  }

  private static View getIconInDirection(BaseCellLayout paramBaseCellLayout, ViewGroup paramViewGroup, int paramInt1, int paramInt2)
  {
    return findIndexOfIcon(getCellLayoutChildrenSortedSpatially(paramBaseCellLayout, paramViewGroup), paramInt1, paramInt2);
  }

  private static View getIconInDirection(BaseCellLayout paramBaseCellLayout, ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    paramBaseCellLayout = getCellLayoutChildrenSortedSpatially(paramBaseCellLayout, paramViewGroup);
    return findIndexOfIcon(paramBaseCellLayout, paramBaseCellLayout.indexOf(paramView), paramInt);
  }

  static boolean handleFolderKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    BaseCellLayout localBaseCellLayout = (BaseCellLayout)paramView.getParent();
    FolderEditText localFolderEditText = ((BaseFolder)localBaseCellLayout.getParent()).mFolderName;
    if (paramKeyEvent.getAction() != 1);
    for (int i = 1; ; i = 0)
      switch (paramInt)
      {
      default:
        return false;
      case 21:
      case 22:
      case 19:
      case 20:
      case 122:
      case 123:
      }
    if (i != 0)
    {
      paramView = getIconInDirection(localBaseCellLayout, localBaseCellLayout, paramView, -1);
      if (paramView != null)
        paramView.requestFocus();
    }
    return true;
    if (i != 0)
    {
      paramView = getIconInDirection(localBaseCellLayout, localBaseCellLayout, paramView, 1);
      if (paramView == null)
        break label152;
      paramView.requestFocus();
    }
    while (true)
    {
      return true;
      label152: localFolderEditText.requestFocus();
    }
    if (i != 0)
    {
      paramView = getClosestIconOnLine(localBaseCellLayout, localBaseCellLayout, paramView, -1);
      if (paramView != null)
        paramView.requestFocus();
    }
    return true;
    if (i != 0)
    {
      paramView = getClosestIconOnLine(localBaseCellLayout, localBaseCellLayout, paramView, 1);
      if (paramView == null)
        break label212;
      paramView.requestFocus();
    }
    while (true)
    {
      return true;
      label212: localFolderEditText.requestFocus();
    }
    if (i != 0)
    {
      paramView = getIconInDirection(localBaseCellLayout, localBaseCellLayout, -1, 1);
      if (paramView != null)
        paramView.requestFocus();
    }
    return true;
    if (i != 0)
    {
      paramView = getIconInDirection(localBaseCellLayout, localBaseCellLayout, localBaseCellLayout.getChildCount(), -1);
      if (paramView != null)
        paramView.requestFocus();
    }
    return true;
  }

  static boolean handleIconKeyEvent(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    BaseCellLayout localBaseCellLayout = (BaseCellLayout)paramView.getParent();
    Workspace localWorkspace = (Workspace)localBaseCellLayout.getParent();
    int j = localWorkspace.indexOfChild(localBaseCellLayout);
    int k = localWorkspace.getChildCount();
    int i;
    if (paramKeyEvent.getAction() != 1)
      i = 1;
    switch (paramInt)
    {
    default:
    case 21:
    case 22:
    case 19:
    case 20:
      do
      {
        do
        {
          do
          {
            do
            {
              return false;
              i = 0;
              break;
              if (i != 0)
              {
                paramView = getIconInDirection(localBaseCellLayout, localBaseCellLayout, paramView, -1);
                if (paramView == null)
                  break label154;
                paramView.requestFocus();
              }
              while (true)
              {
                return true;
                if (j > 0)
                {
                  paramView = getCellLayoutChildrenForIndex(localWorkspace, j - 1);
                  paramView = getIconInDirection(localBaseCellLayout, paramView, paramView.getChildCount(), -1);
                  if (paramView != null)
                    paramView.requestFocus();
                  else
                    localWorkspace.snapToPage(j - 1);
                }
              }
              if (i != 0)
              {
                paramView = getIconInDirection(localBaseCellLayout, localBaseCellLayout, paramView, 1);
                if (paramView == null)
                  break label229;
                paramView.requestFocus();
              }
              while (true)
              {
                return true;
                if (j < k - 1)
                {
                  paramView = getIconInDirection(localBaseCellLayout, getCellLayoutChildrenForIndex(localWorkspace, j + 1), -1, 1);
                  if (paramView != null)
                    paramView.requestFocus();
                  else
                    localWorkspace.snapToPage(j + 1);
                }
              }
            }
            while (i == 0);
            paramView = getClosestIconOnLine(localBaseCellLayout, localBaseCellLayout, paramView, -1);
          }
          while (paramView == null);
          paramView.requestFocus();
          return true;
        }
        while (i == 0);
        paramView = getClosestIconOnLine(localBaseCellLayout, localBaseCellLayout, paramView, 1);
      }
      while (paramView == null);
      paramView.requestFocus();
      return true;
    case 92:
      if (i != 0)
      {
        if (j <= 0)
          break label377;
        paramView = getIconInDirection(localBaseCellLayout, getCellLayoutChildrenForIndex(localWorkspace, j - 1), -1, 1);
        if (paramView == null)
          break label366;
        paramView.requestFocus();
      }
      while (true)
      {
        return true;
        localWorkspace.snapToPage(j - 1);
        continue;
        paramView = getIconInDirection(localBaseCellLayout, localBaseCellLayout, -1, 1);
        if (paramView != null)
          paramView.requestFocus();
      }
    case 93:
      if (i != 0)
      {
        if (j >= k - 1)
          break label451;
        paramView = getIconInDirection(localBaseCellLayout, getCellLayoutChildrenForIndex(localWorkspace, j + 1), -1, 1);
        if (paramView == null)
          break label440;
        paramView.requestFocus();
      }
      while (true)
      {
        return true;
        localWorkspace.snapToPage(j + 1);
        continue;
        paramView = getIconInDirection(localBaseCellLayout, localBaseCellLayout, localBaseCellLayout.getChildCount(), -1);
        if (paramView != null)
          paramView.requestFocus();
      }
    case 122:
      label154: label229: label366: label377: if (i != 0)
      {
        paramView = getIconInDirection(localBaseCellLayout, localBaseCellLayout, -1, 1);
        if (paramView != null)
          paramView.requestFocus();
      }
      label440: label451: return true;
    case 123:
    }
    if (i != 0)
    {
      paramView = getIconInDirection(localBaseCellLayout, localBaseCellLayout, localBaseCellLayout.getChildCount(), -1);
      if (paramView != null)
        paramView.requestFocus();
    }
    return true;
  }

  static boolean handleTabKeyEvent(AccessibleTabView paramAccessibleTabView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.FocusHelper
 * JD-Core Version:    0.6.2
 */