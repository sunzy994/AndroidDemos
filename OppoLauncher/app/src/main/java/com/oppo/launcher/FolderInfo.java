package com.oppo.launcher;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

public class FolderInfo extends ItemInfo
{
  private static final boolean DEBUG = false;
  private static final String TAG = "FolderInfo";
  public ArrayList<ApplicationInfo> contents = new ArrayList();
  ArrayList<FolderListener> listeners = new ArrayList();
  boolean opened;

  FolderInfo()
  {
    this.itemType = 3;
  }

  public void add(ApplicationInfo paramApplicationInfo)
  {
    this.contents.add(paramApplicationInfo);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
      ((FolderListener)localIterator.next()).onAdd(paramApplicationInfo);
    itemsChanged();
  }

  void addListener(FolderListener paramFolderListener)
  {
    this.listeners.add(paramFolderListener);
  }

  void clearListener()
  {
    this.listeners.clear();
  }

  public boolean findInfoForPackage(String paramString)
  {
    Iterator localIterator = this.contents.iterator();
    while (localIterator.hasNext())
    {
      ComponentName localComponentName = ((ApplicationInfo)localIterator.next()).intent.getComponent();
      if ((localComponentName != null) && (localComponentName.getPackageName().equals(paramString)))
        return true;
    }
    return false;
  }

  void itemsChanged()
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
      ((FolderListener)localIterator.next()).onItemsChanged();
  }

  public void justAdd(ApplicationInfo paramApplicationInfo)
  {
    this.contents.add(paramApplicationInfo);
  }

  public void justNoticeChange(ApplicationInfo paramApplicationInfo)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
      ((FolderListener)localIterator.next()).onAdd(paramApplicationInfo);
    itemsChanged();
  }

  void onAddToDatabase(ContentValues paramContentValues)
  {
    super.onAddToDatabase(paramContentValues);
    paramContentValues.put("title", this.title.toString());
  }

  public void remove(ApplicationInfo paramApplicationInfo)
  {
    this.contents.remove(paramApplicationInfo);
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
      ((FolderListener)localIterator.next()).onRemove(paramApplicationInfo);
    itemsChanged();
  }

  void removeListener(FolderListener paramFolderListener)
  {
    if (this.listeners.contains(paramFolderListener))
      this.listeners.remove(paramFolderListener);
  }

  public void setTitle(CharSequence paramCharSequence)
  {
    this.title = paramCharSequence;
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
      ((FolderListener)localIterator.next()).onTitleChanged(paramCharSequence);
  }

  void unbind()
  {
    super.unbind();
    this.listeners.clear();
  }

  static abstract interface FolderListener
  {
    public abstract void onAdd(ApplicationInfo paramApplicationInfo);

    public abstract void onItemsChanged();

    public abstract void onRemove(ApplicationInfo paramApplicationInfo);

    public abstract void onTitleChanged(CharSequence paramCharSequence);
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.FolderInfo
 * JD-Core Version:    0.6.2
 */