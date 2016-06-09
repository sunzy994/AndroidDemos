package com.oppo.launcher;

import android.annotation.OppoHook;
import android.annotation.OppoHook.OppoHookType;
import android.annotation.OppoHook.OppoRomType;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.oppo.launcher.widget.OppoEnvironment;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ItemInfo
{
  static final int APP_INSTALLED_ON_SDCARD = 1;
  static final int APP_INSTALLED_ON_SYSTEM = 0;
  static final String CALENDAR_CLASS_NAME = "com.android.calendar.LaunchActivity";
  static final String CALENDAR_PACKAGE_NAME = "com.android.calendar";
  static final int NO_ID = -1;
  private static final String TAG = "ItemInfo";
  public int cellX = -1;
  int cellY = -1;
  public String className = null;
  public long container = -1L;
  int[] dropPos = null;

  @OppoHook(level=OppoHook.OppoHookType.CHANGE_ACCESS, note="Jifeng.Tan@EXP.MidWare.MidWare Change access for EXP requirement", property=OppoHook.OppoRomType.ROM)
  public long id = -1L;
  int installedLocation;
  boolean isGesture = false;
  private boolean isUnavailable = false;
  public int itemType;
  public boolean mIsOrderModeSelected = false;
  public int minSpanX = 1;
  public int minSpanY = 1;
  public int newinstalled = 0;
  public String packageName;
  int screenId = -1;
  public int spanX = 1;
  public int spanY = 1;
  public CharSequence title;
  boolean uninstallable = false;
  int unreadNum;

  ItemInfo()
  {
  }

  ItemInfo(ItemInfo paramItemInfo)
  {
    this.id = paramItemInfo.id;
    this.cellX = paramItemInfo.cellX;
    this.cellY = paramItemInfo.cellY;
    this.spanX = paramItemInfo.spanX;
    this.spanY = paramItemInfo.spanY;
    this.screenId = paramItemInfo.screenId;
    this.itemType = paramItemInfo.itemType;
    this.container = paramItemInfo.container;
    this.unreadNum = paramItemInfo.unreadNum;
  }

  static byte[] flattenBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
      return null;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramBitmap.getWidth() * paramBitmap.getHeight() * 4);
    try
    {
      paramBitmap.compress(CompressFormat.PNG, 100, localByteArrayOutputStream);
      localByteArrayOutputStream.flush();
      localByteArrayOutputStream.close();
      paramBitmap = localByteArrayOutputStream.toByteArray();
      return paramBitmap;
    }
    catch (IOException paramBitmap)
    {
      Log.w("ItemInfo", "Could not write icon");
    }
    return null;
  }

  static void writeBitmap(ContentValues paramContentValues, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
      paramContentValues.put("icon", flattenBitmap(paramBitmap));
  }

  public Drawable getIcon()
  {
    return null;
  }

  public Bitmap getIconBitmap()
  {
    Drawable localDrawable = getIcon();
    if ((localDrawable != null) && ((localDrawable instanceof BitmapDrawable)))
      return ((BitmapDrawable)localDrawable).getBitmap();
    return null;
  }

  public CharSequence getTitle()
  {
    return this.title;
  }

  public boolean isAppUnavailable()
  {
    return this.isUnavailable;
  }

  void onAddToDatabase(ContentValues paramContentValues)
  {
    paramContentValues.put("itemType", Integer.valueOf(this.itemType));
    if (this.title != null);
    for (String str = this.title.toString(); ; str = null)
    {
      paramContentValues.put("title", str);
      paramContentValues.put("className", this.className);
      paramContentValues.put("packageName", this.packageName);
      if (!this.isGesture)
      {
        paramContentValues.put("container", Long.valueOf(this.container));
        paramContentValues.put("screenId", Integer.valueOf(this.screenId));
        paramContentValues.put("cellX", Integer.valueOf(this.cellX));
        paramContentValues.put("cellY", Integer.valueOf(this.cellY));
        paramContentValues.put("spanX", Integer.valueOf(this.spanX));
        paramContentValues.put("spanY", Integer.valueOf(this.spanY));
      }
      return;
    }
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    this.title = paramCharSequence;
  }

  public String toString()
  {
    return "Item(id=" + this.id + " title=" + this.title + " type=" + this.itemType + " container=" + this.container + " screenId=" + this.screenId + " cellX=" + this.cellX + " cellY=" + this.cellY + " spanX=" + this.spanX + " spanY=" + this.spanY + " isGesture=" + this.isGesture + " dropPos=" + this.dropPos + " minSpanX=" + this.minSpanX + " minSpanY=" + this.minSpanY + ")";
  }

  void unbind()
  {
  }

  public void updateAppUnavailableFlag(Context paramContext)
  {
    if ((this.installedLocation == 1) && (!OppoEnvironment.isSDCardInside(paramContext)) && (OppoEnvironment.isExternalSDRemoved(paramContext)))
    {
      this.isUnavailable = true;
      return;
    }
    this.isUnavailable = false;
  }

  void updateValuesWithCoordinates(ContentValues paramContentValues, int paramInt1, int paramInt2)
  {
    paramContentValues.put("cellX", Integer.valueOf(paramInt1));
    paramContentValues.put("cellY", Integer.valueOf(paramInt2));
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.ItemInfo
 * JD-Core Version:    0.6.2
 */