package com.oppo.launcher;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.oppo.launcher.screenGrid.ScreenGridUtils;
import java.util.List;

public class InstallWidgetReceiver
{
  public static final String ACTION_INSTALL_WIDGET = "com.oppo.launcher.action.INSTALL_WIDGET";
  public static final String ACTION_SUPPORTS_CLIPDATA_MIMETYPE = "com.oppo.launcher.action.SUPPORTS_CLIPDATA_MIMETYPE";
  public static final String EXTRA_APPWIDGET_COMPONENT = "com.oppo.launcher.extra.widget.COMPONENT";
  public static final String EXTRA_APPWIDGET_CONFIGURATION_DATA = "com.oppo.launcher.extra.widget.CONFIGURATION_DATA";
  public static final String EXTRA_APPWIDGET_CONFIGURATION_DATA_MIME_TYPE = "com.oppo.launcher.extra.widget.CONFIGURATION_DATA_MIME_TYPE";

  public static class WidgetListAdapter
    implements ListAdapter, OnClickListener
  {
    private List<WidgetMimeTypeHandlerData> mActivities;
    private ClipData mClipData;
    private LayoutInflater mInflater;
    private Launcher mLauncher;
    private String mMimeType;
    private CellLayout mTargetLayout;
    private int[] mTargetLayoutPos;
    private int mTargetLayoutScreen;

    public WidgetListAdapter(Launcher paramLauncher, String paramString, ClipData paramClipData, List<WidgetMimeTypeHandlerData> paramList, CellLayout paramCellLayout, int paramInt, int[] paramArrayOfInt)
    {
      this.mLauncher = paramLauncher;
      this.mMimeType = paramString;
      this.mClipData = paramClipData;
      this.mActivities = paramList;
      this.mTargetLayout = paramCellLayout;
      this.mTargetLayoutScreen = paramInt;
      this.mTargetLayoutPos = paramArrayOfInt;
    }

    public boolean areAllItemsEnabled()
    {
      return false;
    }

    public int getCount()
    {
      return this.mActivities.size();
    }

    public Object getItem(int paramInt)
    {
      return null;
    }

    public long getItemId(int paramInt)
    {
      return paramInt;
    }

    public int getItemViewType(int paramInt)
    {
      return 0;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Context localContext = paramViewGroup.getContext();
      Object localObject = localContext.getPackageManager();
      if (this.mInflater == null)
        this.mInflater = LayoutInflater.from(localContext);
      View localView = paramView;
      if (paramView == null)
        localView = this.mInflater.inflate(2130968584, paramViewGroup, false);
      paramView = (WidgetMimeTypeHandlerData)this.mActivities.get(paramInt);
      paramViewGroup = paramView.resolveInfo;
      paramView = paramView.widgetInfo;
      Drawable localDrawable = paramViewGroup.loadIcon((PackageManager)localObject);
      ((ImageView)localView.findViewById(2131492884)).setImageDrawable(localDrawable);
      paramViewGroup = paramViewGroup.loadLabel((PackageManager)localObject);
      localObject = new int[2];
      this.mTargetLayout.rectToCell(paramView.minWidth, paramView.minHeight, (int[])localObject, ScreenGridUtils.isSpecialWidget(paramView.configure));
      ((TextView)localView.findViewById(2131492885)).setText(localContext.getString(2131427332, new Object[] { paramViewGroup, Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) }));
      return localView;
    }

    public int getViewTypeCount()
    {
      return 1;
    }

    public boolean hasStableIds()
    {
      return true;
    }

    public boolean isEmpty()
    {
      return this.mActivities.isEmpty();
    }

    public boolean isEnabled(int paramInt)
    {
      return true;
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      paramDialogInterface = new PendingAddWidgetInfo(((WidgetMimeTypeHandlerData)this.mActivities.get(paramInt)).widgetInfo, this.mMimeType, this.mClipData);
      this.mLauncher.addAppWidgetFromDrop(paramDialogInterface, -100L, this.mTargetLayoutScreen, null, this.mTargetLayoutPos);
    }

    public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
    {
    }

    public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
    {
    }
  }

  public static class WidgetMimeTypeHandlerData
  {
    public ResolveInfo resolveInfo;
    public AppWidgetProviderInfo widgetInfo;

    public WidgetMimeTypeHandlerData(ResolveInfo paramResolveInfo, AppWidgetProviderInfo paramAppWidgetProviderInfo)
    {
      this.resolveInfo = paramResolveInfo;
      this.widgetInfo = paramAppWidgetProviderInfo;
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.InstallWidgetReceiver
 * JD-Core Version:    0.6.2
 */