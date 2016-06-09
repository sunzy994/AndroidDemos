package com.oppo.NearMeStatistics;

import android.app.WallpaperManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.oppo.launcher.ApplicationInfo;
import com.oppo.launcher.DockBar;
import com.oppo.launcher.FolderInfo;
import com.oppo.launcher.ItemInfo;
import com.oppo.launcher.LauncherAppWidgetInfo;
import com.oppo.launcher.LauncherModel;
import com.oppo.launcher.PagedView.State;
import com.oppo.launcher.WorkspaceScreenData;
import com.oppo.launcher.settings.Setting;
import com.oppo.launcher.theme.ThemeUtil;
import com.oppo.statistics.NearMeStatistics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class LauncherStatistics
{
  public static final String ADD_APP_WIDGET_BY_CLICK_PREVIEW = "add_app_widget_by_click_preview";
  public static final String ADD_APP_WIDGET_BY_LONGCLICK_PREVIEW = "add_app_widget_by_longclick_preview";
  public static final String ADD_WEATHER_WIDGET_SUCCESS = "add_weather_widget_success";
  public static final String APPS_ON_DOCKBAR = "apps_on_dockbar";
  public static final int APP_CODE = 200580000;
  public static final String CANCEL_DROP_BY_TOPBAR_WHEN_ORDER_MORE = "cancel_drop_by_topbar_when_order_more";
  public static final String CANCEL_SELECTED_BY_BACK_KEY_WHEN_ORDER_MORE = "cancel_selected_by_back_key_when_order_more";
  public static final String CANCEL_UNINSTALL_APP_AT_NORMAL_MODE = "cancel_uninstall_app_at_normal_mode";
  public static final String CANCEL_UNINSTALL_APP_AT_SMALL_LAUNCHER = "cancel_uninstall_app_at_small_launcher";
  public static final String CLICK_ENTER_ORDER_MORE_MODE = "click_enter_order_more_mode";
  public static final String CLICK_PAGE_POINT = "click_page_point";
  public static final String CLICK_PREVIEW_CARD_DRAG_WHEN_ORDER_MORE = "click_preview_card_drag_when_order_more";
  public static final String CLICK_PREVIEW_CARD_DRAG_WHEN_ORDER_ONE = "click_preview_card_drag_when_order_one";
  public static final String CLICK_PREVIEW_CARD_NORMAL_WHEN_ORDER_MORE = "click_preview_card_normal_when_order_more";
  public static final String CLICK_PREVIEW_CARD_NORMAL_WHEN_ORDER_ONE = "click_preview_card_normal_when_order_one";
  public static final String CREATE_NEW_FOLDER = "create_new_folder";
  static final boolean DEBUG = false;
  public static final String DROP_FAIL_WHEN_ORDER_MORE = "drop_fail_when_order_more";
  public static final String DROP_FAIL_WHEN_ORDER_ONE = "drop_fail_when_order_one";
  public static final String DROP_ICON_ON_PREVIEW_CARD_WHEN_ORDER_ONE = "drop_icon_on_preview_card_when_order_one";
  public static final String DROP_ON_OLD_PAGE_WHEN_ORDER_MORE = "drop_on_old_page_when_order_more";
  public static final String DROP_ON_OTHER_PAGE_WHEN_ORDER_MORE = "drop_on_other_page_when_order_more";
  public static final String DROP_ON_PREVIEW_CARD_WHEN_ORDER_MORE = "drop_on_preview_card_when_order_more";
  public static final String DROP_WIDGET_ON_PREVIEW_CARD_WHEN_ORDER_ONE = "drop_widget_on_preview_card_when_order_one";
  public static final String ENTER_EDIT_MODE_BY_LONGCLICK_ITEM = "enter_edit_mode_by_longclick_item";
  public static final String FOLDER_COUNT = "folder_count";
  public static final String INTERCEPTED_SHORTCUT = "intercepted_shortcut";
  public static final String MOVE_ICON_FOLDER_IN_CURRENT_PAGE_NORMAL_MODE = "move_icon_folder_in_current_page_normal_mode";
  public static final String MOVE_ICON_FOLDER_IN_CURRENT_PAGE_SMALL_LAUNCHER = "move_icon_folder_in_current_page_small_launcher";
  public static final String MOVE_ICON_FOLDER_TO_OTHER_PAGE_NORMAL_MODE = "move_icon_folder_to_other_page_normal_mode";
  public static final String MOVE_ICON_FOLDER_TO_OTHER_PAGE_SMALL_LAUNCHER = "move_icon_folder_to_other_page_small_launcher";
  public static final String MOVE_WIDGET_IN_CURRENT_PAGE_NORMAL_MODE = "move_widget_in_current_page_normal_mode";
  public static final String MOVE_WIDGET_IN_CURRENT_PAGE_SMALL_LAUNCHER = "move_widget_in_current_page_small_launcher";
  public static final String MOVE_WIDGET_TO_OTHER_PAGE_NORMAL_MODE = "move_widget_to_other_page_normal_mode";
  public static final String MOVE_WIDGET_TO_OTHER_PAGE_SMALL_LAUNCHER = "move_widget_to_other_page_small_launcher";
  public static final String NORMAL_PAGE_COUNTS = "normal_page_counts";
  public static final String NOT_INTERCEPTED_SHORTCUT = "not_intercepted_shortcut";
  public static final String REMOVE_COLOROS_WIDGET = "remove_ColorOS_widget";
  public static final String REMOVE_FOLDER = "remove_folder";
  public static final String REMOVE_WIDGET_NOMAL_MODE = "remove_widget_nomal_mode";
  public static final String REMOVE_WIDGET_SMALL_LAUNCHER = "remove_widget_small_launcher";
  public static final int RESULT_ALL_APPS_SCREENS_SIZE = 200580100;
  public static final int RESULT_APPS_NUM_IN_WORKSPACE = 200580102;
  public static final int RESULT_WORK_SPACE_SCREENS_SIZE = 200580101;
  public static final String SET_DEFAULT_THEME = "set_default_theme";
  public static final String SET_EFFECT_CUBE = "set_effect_cube";
  public static final String SET_EFFECT_NORMAL = "set_effect_normal";
  public static final String SET_EFFECT_ROTATION = "set_effect_rotation";
  public static final String SET_EFFECT_SLANT = "set_effect_slant";
  public static final String SET_EFFECT_STACK = "set_effect_stack";
  public static final String SET_INTERNAL_WALLPAPER = "set_internal_wallpaper";
  public static final String SET_LIVEWALLPAPER = "set_livewallpaper";
  public static final String SET_OTHER_THEME = "set_other_theme";
  public static final String SET_OTHER_WALLPAPER = "set_other_wallpaper";
  public static final String SHORTCUT_COUNT = "shortcut_count";
  private static final String TAG = "LauncherStatistics";
  public static final String UNINSTALL_APP_AT_NORMAL_MODE = "uninstall_app_at_normal_mode";
  public static final String UNINSTALL_APP_AT_SMALL_LAUNCHER = "uninstall_app_at_small_launcher";
  public static final String WEATHER_WIDGET_USER_COUNT = "weather_widget_user_count";
  public static final String WIDGET_COUNT = "widget_count";
  private static int mAllAppsScreenSize = 0;
  private static int mAppsNumInWorkspace = 0;
  private static LauncherStatistics mInstance = null;
  private Context mContext = null;
  private int mScreenHeight = 0;
  private int mScreenWidth = 0;
  private int mSubHeight = 5;
  private int mSubScreenHeight = 0;
  private int mSubScreenWidth = 0;
  private int mSubWidth = 4;

  private LauncherStatistics(Context paramContext)
  {
    this.mContext = paramContext;
    init();
  }

  public static LauncherStatistics getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null)
        mInstance = new LauncherStatistics(paramContext);
      paramContext = mInstance;
      return paramContext;
    }
    finally
    {
    }
    throw paramContext;
  }

  private void init()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    this.mScreenWidth = localDisplayMetrics.widthPixels;
    this.mScreenHeight = localDisplayMetrics.heightPixels;
    this.mSubScreenWidth = (this.mScreenWidth / this.mSubWidth);
    this.mSubScreenHeight = (this.mScreenHeight / this.mSubHeight);
  }

  private void launcherStatisticsDockbarApps()
  {
    WorkspaceScreenData localWorkspaceScreenData = DockBar.sScreenData;
    int j = localWorkspaceScreenData.mItems.size();
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < j)
    {
      if (3 == ((ItemInfo)localWorkspaceScreenData.mItems.get(i)).itemType);
      for (String str = (String)this.mContext.getText(2131427330); ; str = (String)((ItemInfo)localWorkspaceScreenData.mItems.get(i)).title)
      {
        localHashMap.put(String.valueOf(i), str);
        i += 1;
        break;
      }
    }
    if (this.mContext != null)
      NearMeStatistics.onKVEvent(this.mContext, "apps_on_dockbar", localHashMap);
  }

  private void launcherStatisticsFolderCount()
  {
    int i = 0;
    WorkspaceScreenData localWorkspaceScreenData = DockBar.sScreenData;
    Iterator localIterator = LauncherModel.mWorkspaceScreens.iterator();
    while (localIterator.hasNext())
      i += ((WorkspaceScreenData)localIterator.next()).mFolders.size();
    onEvent("folder_count", i + localWorkspaceScreenData.mFolders.size());
  }

  private void launcherStatisticsNormalPageCount()
  {
    onEvent("normal_page_counts", LauncherModel.mWorkspaceScreens.size());
  }

  private void launcherStatisticsSetEffcet()
  {
    String str = Setting.getWorkSpaceEffectClassName();
    if (str.equals(this.mContext.getString(2131427361)))
      onEvent("set_effect_normal");
    do
    {
      return;
      if (str.equals(this.mContext.getString(2131427367)))
      {
        onEvent("set_effect_cube");
        return;
      }
      if (str.equals(this.mContext.getString(2131427365)))
      {
        onEvent("set_effect_rotation");
        return;
      }
      if (str.equals(this.mContext.getString(2131427363)))
      {
        onEvent("set_effect_slant");
        return;
      }
    }
    while (!str.equals(this.mContext.getString(2131427360)));
    onEvent("set_effect_stack");
  }

  private void launcherStatisticsSetTheme()
  {
    if (ThemeUtil.isDefaultTheme())
    {
      onEvent("set_default_theme");
      return;
    }
    onEvent("set_other_theme");
  }

  private void launcherStatisticsSetWallpaper()
  {
    if (WallpaperManager.getInstance(this.mContext.getApplicationContext()).getWallpaperInfo() != null)
      onEvent("set_livewallpaper");
  }

  private void launcherStatisticsShortcutCount()
  {
    int i = 0;
    Object localObject1 = DockBar.sScreenData;
    Iterator localIterator1 = LauncherModel.mWorkspaceScreens.iterator();
    int j;
    while (localIterator1.hasNext())
    {
      Object localObject2 = (WorkspaceScreenData)localIterator1.next();
      Iterator localIterator2 = ((WorkspaceScreenData)localObject2).mItems.iterator();
      while (localIterator2.hasNext())
        if (1 == ((ItemInfo)localIterator2.next()).itemType)
          i += 1;
      localObject2 = ((WorkspaceScreenData)localObject2).mFolders.values().iterator();
      j = i;
      i = j;
      if (((Iterator)localObject2).hasNext())
      {
        localIterator2 = ((FolderInfo)((Iterator)localObject2).next()).contents.iterator();
        i = j;
        while (true)
        {
          j = i;
          if (!localIterator2.hasNext())
            break;
          if (1 == ((ApplicationInfo)localIterator2.next()).itemType)
            i += 1;
        }
      }
    }
    localIterator1 = ((WorkspaceScreenData)localObject1).mItems.iterator();
    while (localIterator1.hasNext())
      if (1 == ((ItemInfo)localIterator1.next()).itemType)
        i += 1;
    localObject1 = ((WorkspaceScreenData)localObject1).mFolders.values().iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localIterator1 = ((FolderInfo)((Iterator)localObject1).next()).contents.iterator();
      j = i;
      while (true)
      {
        i = j;
        if (!localIterator1.hasNext())
          break;
        if (1 == ((ApplicationInfo)localIterator1.next()).itemType)
          j += 1;
      }
    }
    onEvent("shortcut_count", i);
  }

  private void launcherStatisticsWidgetCount()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = LauncherModel.mWorkspaceScreens.iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((WorkspaceScreenData)localIterator1.next()).mAppWidgets.iterator();
      while (localIterator2.hasNext())
      {
        LauncherAppWidgetInfo localLauncherAppWidgetInfo = (LauncherAppWidgetInfo)localIterator2.next();
        if ((localLauncherAppWidgetInfo.getProvider() != null) && (localLauncherAppWidgetInfo.getProvider().provider != null))
          localHashSet.add(localLauncherAppWidgetInfo.getProvider().provider.getClassName());
      }
    }
    onEvent("widget_count", localHashSet.size());
  }

  public void launcherStatisticsCancleUninstallApp(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      onEvent("cancel_uninstall_app_at_normal_mode");
      return;
    }
    onEvent("cancel_uninstall_app_at_small_launcher");
  }

  public void launcherStatisticsClickPreviewCardWhenOrder(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      onEvent("click_preview_card_normal_when_order_more");
      return;
    }
    onEvent("click_preview_card_normal_when_order_one");
  }

  public void launcherStatisticsClickPreviewCardWhenOrderAndDragging(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      onEvent("click_preview_card_drag_when_order_more");
      return;
    }
    onEvent("click_preview_card_drag_when_order_one");
  }

  public void launcherStatisticsDropFailedWhenOrder(PagedView.State paramState)
  {
    if (paramState == PagedView.State.ORDER_ONE)
      onEvent("drop_fail_when_order_one");
    while (paramState != PagedView.State.ORDER_MORE)
      return;
    onEvent("drop_fail_when_order_more");
  }

  public void launcherStatisticsDropItemTypeWhenOrderOne(ItemInfo paramItemInfo)
  {
    if ((paramItemInfo.itemType == 0) || (paramItemInfo.itemType == 1) || (paramItemInfo.itemType == 3))
      onEvent("drop_icon_on_preview_card_when_order_one");
    while (paramItemInfo.itemType != 5)
      return;
    onEvent("drop_widget_on_preview_card_when_order_one");
  }

  public void launcherStatisticsDropPageOnColorRect(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      onEvent("drop_on_other_page_when_order_more");
      return;
    }
    onEvent("drop_on_old_page_when_order_more");
  }

  public void launcherStatisticsRegular()
  {
    launcherStatisticsNormalPageCount();
    launcherStatisticsDockbarApps();
    launcherStatisticsShortcutCount();
    launcherStatisticsFolderCount();
    launcherStatisticsWidgetCount();
    launcherStatisticsSetWallpaper();
    launcherStatisticsSetTheme();
    launcherStatisticsSetEffcet();
  }

  public void launcherStatisticsUninstallApp(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      onEvent("uninstall_app_at_normal_mode");
      return;
    }
    onEvent("uninstall_app_at_small_launcher");
  }

  public void launcherStatisticsWeatherWidgetCount()
  {
    AppWidgetProviderInfo localAppWidgetProviderInfo;
    do
    {
      Iterator localIterator1 = LauncherModel.mWorkspaceScreens.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext())
          break;
        localIterator2 = ((WorkspaceScreenData)localIterator1.next()).mAppWidgets.iterator();
      }
      localAppWidgetProviderInfo = ((LauncherAppWidgetInfo)localIterator2.next()).getProvider();
    }
    while ((localAppWidgetProviderInfo == null) || (localAppWidgetProviderInfo.provider == null) || (!"com.coloros.widget.smallweather".equals(localAppWidgetProviderInfo.provider.getPackageName())));
    onEvent("weather_widget_user_count", 1);
  }

  public void onEvent(String paramString)
  {
    if (this.mContext != null)
      NearMeStatistics.onEvent(this.mContext, paramString);
  }

  public void onEvent(String paramString, int paramInt)
  {
    if (this.mContext != null)
      NearMeStatistics.onEvent(this.mContext, paramString, paramInt);
  }

  public void onEvent(String paramString1, String paramString2)
  {
    if (this.mContext != null)
      NearMeStatistics.onEvent(this.mContext, paramString1, paramString2);
  }

  public void submitClickArea(MotionEvent paramMotionEvent)
  {
    int j = (int)paramMotionEvent.getX();
    int i = (int)paramMotionEvent.getY();
    j /= this.mSubScreenWidth;
    i /= this.mSubScreenHeight;
    onEvent("clickAreaOnLauncher", "(" + (j + 1) + ", " + (i + 1) + ")");
  }

  public void submitResult(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (paramInt1)
    {
    default:
      localObject1 = localObject2;
    case 200580101:
    case 200580100:
    case 200580102:
    }
    while (true)
    {
      if (localObject1 != null)
        onEvent((String)localObject1, paramInt2);
      do
      {
        do
          return;
        while (mAllAppsScreenSize == paramInt2);
        mAllAppsScreenSize = paramInt2;
        localObject1 = "all_apps_screens_size";
        break;
      }
      while (mAppsNumInWorkspace == paramInt2);
      mAppsNumInWorkspace = paramInt2;
      localObject1 = "apps_num_in_workspace";
    }
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.NearMeStatistics.LauncherStatistics
 * JD-Core Version:    0.6.2
 */