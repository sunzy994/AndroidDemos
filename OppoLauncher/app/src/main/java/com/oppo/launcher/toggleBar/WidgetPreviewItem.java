package com.oppo.launcher.toggleBar;

import android.appwidget.AppWidgetProviderInfo;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.oppo.NearMeStatistics.LauncherStatistics;
import com.oppo.launcher.Launcher;
import com.oppo.launcher.OppoPendingAddWidgetInfo;
import com.oppo.launcher.PendingAddWidgetInfo;
import com.oppo.launcher.Workspace;
import java.util.ArrayList;

public class WidgetPreviewItem extends ToggleBarPreviewItem
{
  private static final String TAG = "WidgetPreviewItem";
  public ArrayList<AppWidgetProviderInfo> mProviderInfos = null;
  public OppoPendingAddWidgetInfo mWidgetInfo;

  public WidgetPreviewItem()
  {
    super(null, null);
  }

  public WidgetPreviewItem(String paramString, Drawable paramDrawable)
  {
    super(paramString, paramDrawable);
  }

  public WidgetPreviewItem(String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    super(paramString, paramDrawable, paramBoolean);
  }

  public WidgetPreviewItem(ArrayList<AppWidgetProviderInfo> paramArrayList)
  {
    super(null, null);
    this.mProviderInfos = paramArrayList;
  }

  private int findFirstScreenIndexForWidget()
  {
    if ((this.mWidgetInfo == null) || (this.mLauncher == null))
    {
      Log.w("WidgetPreviewItem", "getAlreadyAddedScreenIndex -return -1. -- mWidgetInfo = " + this.mWidgetInfo + ", mLauncher = " + this.mLauncher);
      return -1;
    }
    return this.mLauncher.findFirstScreenIndexForWidget(this.mWidgetInfo.componentName);
  }

  public void dealWithWhenAdded()
  {
    LauncherStatistics.getInstance(this.mLauncher).onEvent("add_app_widget_by_click_preview");
    int i = findFirstScreenIndexForWidget();
    if (i > -1)
    {
      this.mLauncher.showToastAndSnapToPageForClickWidget(i);
      Log.v("WidgetPreviewItem", "handleOnClick, this widget already add to the workspace, provider = " + this.mWidgetInfo.componentName + ", screenIndex = " + i);
    }
  }

  public boolean getInUsing()
  {
    if (findFirstScreenIndexForWidget() > -1);
    for (boolean bool = true; ; bool = false)
    {
      this.mInUsing = bool;
      return this.mInUsing;
    }
  }

  public Object getTag()
  {
    if (this.mWidgetInfo != null)
      this.mWidgetInfo.mDrawable = getThumbnail();
    return this.mWidgetInfo;
  }

  public Drawable getThumbnail()
  {
    if (this.mThumbnail != null)
      return this.mThumbnail;
    if (this.mWidgetInfo == null)
      return this.mThumbnail;
    this.mThumbnail = ToggleBarPreviewUtils.getWidgetPreviewDrawable(this.mLauncher, this.mWidgetInfo.componentName, this.mWidgetInfo.icon);
    return this.mThumbnail;
  }

  public void handleOnClick()
  {
    if (this.mLauncher != null)
      if (!this.mLauncher.isDragging());
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.mLauncher.getWorkspace();
        if ((localObject != null) && (((Workspace)localObject).isPageMoving()))
        {
          Log.w("WidgetPreviewItem", "Page is moving,stop add widget!");
          return;
        }
        if (this.mWidgetInfo != null)
          break;
        localObject = this.mLauncher.getToggleBarManager();
      }
      while (localObject == null);
      ((ToggleBarManager)localObject).handleOnClick(ToggleBarManager.ToggleType.WIDGET_SPECIFIC, this);
      return;
      localObject = this.mWidgetInfo;
    }
    while (localObject == null);
    Workspace localWorkspace = this.mLauncher.getWorkspace();
    if (localWorkspace != null)
    {
      localWorkspace.setWidgetPosition(this.mId);
      localWorkspace.setWidgetInfo(this.mWidgetInfo);
    }
    this.mLauncher.addAppWidgetFromDrop((PendingAddWidgetInfo)localObject, -100L, this.mLauncher.getCurrentWorkspaceScreen(), null, null, true);
    LauncherStatistics.getInstance(this.mLauncher).onEvent("add_app_widget_by_click_preview");
  }

  public void initState()
  {
    if (this.mWidgetInfo != null)
    {
      this.mIsCanLongClick = true;
      this.mIsNeedShowLabel = true;
      return;
    }
    this.mIsCanLongClick = false;
    this.mIsNeedShowLabel = false;
  }

  public void recycle()
  {
    super.recycle();
    this.mWidgetInfo = null;
  }

  public void setWidgetInfo(OppoPendingAddWidgetInfo paramOppoPendingAddWidgetInfo)
  {
    this.mWidgetInfo = paramOppoPendingAddWidgetInfo;
    initState();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.WidgetPreviewItem
 * JD-Core Version:    0.6.2
 */