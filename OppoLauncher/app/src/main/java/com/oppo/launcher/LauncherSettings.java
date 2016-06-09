package com.oppo.launcher;

import android.annotation.OppoHook;
import android.annotation.OppoHook.OppoHookType;
import android.annotation.OppoHook.OppoRomType;
import android.net.Uri;
import android.provider.BaseColumns;

@OppoHook(level=OppoHook.OppoHookType.CHANGE_ACCESS, note="Jifeng.Tan@EXP.MidWare.MidWare Change access for EXP requirement", property=OppoHook.OppoRomType.ROM)
public class LauncherSettings
{
  public static abstract interface BaseLauncherColumns extends BaseColumns
  {
    public static final String CLASSNAME = "className";
    public static final String ICON = "icon";
    public static final String ICON_PACKAGE = "iconPackage";
    public static final String ICON_RESOURCE = "iconResource";
    public static final String ICON_SYSTEMT_RESOURCE_ID = "iconSystemResourceId";
    public static final String ICON_TYPE = "iconType";
    public static final int ICON_TYPE_BITMAP = 1;
    public static final int ICON_TYPE_RESOURCE = 0;
    public static final int ICON_TYPE_SYSTEMT_RESOURCE = 2;
    public static final String INTENT = "intent";
    public static final String IPHONE_STYLE_ICON_ID = "iphoneStyleIconId";
    public static final String ITEM_TYPE = "itemType";
    public static final int ITEM_TYPE_APPLICATION = 0;
    public static final int ITEM_TYPE_SHORTCUT = 1;
    public static final String TITLE = "title";
  }

  static final class NewInstallItems
    implements BaseLauncherColumns
  {
    static final Uri CONTENT_URI = Uri.parse("content://com.oppo.launcher.settings/newinstall?notify=true");
    static final Uri CONTENT_URI_NO_NOTIFICATION = Uri.parse("content://com.oppo.launcher.settings/newinstall?notify=false");
    static final String NEW_INSTALL_FLAG = "newinstallflag";
    static final String PACKAGE_NAME = "packagename";
  }

  public static final class SingleDeskTopItems
    implements BaseLauncherColumns
  {
    static final String APPWIDGET_ID = "appWidgetId";
    static final String CELLX = "cellX";
    static final String CELLY = "cellY";
    static final String CLASS_NAME = "className";
    static final String CONTAINER = "container";
    public static final int CONTAINER_DESKTOP = -100;
    static final int CONTAINER_HOTSEAT = -101;
    static final Uri CONTENT_URI = Uri.parse("content://com.oppo.launcher.settings/singledesktopitems?notify=true");
    static final Uri CONTENT_URI_NO_NOTIFICATION = Uri.parse("content://com.oppo.launcher.settings/singledesktopitems?notify=false");
    static final String DISPLAY_MODE = "displayMode";
    static final String INSTALLED_LOCATION = "modelState";
    static final int ITEM_TYPE_APPSFOLDER = 6;
    public static final int ITEM_TYPE_APPWIDGET = 5;
    public static final int ITEM_TYPE_FOLDER = 3;
    static final String MODEL_STATE = "modelState";
    static final String PACKAGE_NAME = "packageName";
    static final String SCREENID = "screenId";
    static final String SPANX = "spanX";
    static final String SPANY = "spanY";
    static final String URI = "uri";

    static Uri getContentUri(long paramLong, boolean paramBoolean)
    {
      return Uri.parse("content://com.oppo.launcher.settings/singledesktopitems/" + paramLong + "?" + "notify" + "=" + paramBoolean);
    }
  }

  static final class SingleDeskTopScreens
    implements BaseLauncherColumns
  {
    static final Uri CONTENT_URI = Uri.parse("content://com.oppo.launcher.settings/singledesktopscreens?notify=false");
    static final String HOME_PAGE = "homePage";
    static final int HOTSEAT_SCREEN_ID = 999;
    static final String SCREEN_ID = "screenId";
    static final int SCREEN_MAX_ID = 1026;
    static final int SCREEN_MIN_ID = 1000;
    static final String SCREEN_NUM = "screenNum";
    static final int START_SCREEN_ID = 1000;

    static Uri getContentUri(long paramLong, boolean paramBoolean)
    {
      return Uri.parse("content://com.oppo.launcher.settings/singledesktopscreens/" + paramLong + "?" + "notify" + "=" + paramBoolean);
    }
  }

  static final class SingleDeskTopShortcutWhiteList
    implements BaseLauncherColumns
  {
    static final Uri CONTENT_URI = Uri.parse("content://com.oppo.launcher.settings/shortcutwhitelist?notify=false");
    static final String ITEM_NAME = "itemName";
    static final String ITEM_TYPE = "itemType";
    static final int ITEM_TYPE_INTENT = 1;
    static final int ITEM_TYPE_PACKAGE = 0;
    static final int ITEM_TYPE_TITLE = 2;
    static final int ITEM_TYPE_TITLE_PACKAGE = 3;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.LauncherSettings
 * JD-Core Version:    0.6.2
 */