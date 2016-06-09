package com.oppo.launcher.toggleBar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.oppo.launcher.Launcher;
import com.oppo.launcher.Workspace;
import com.oppo.launcher.effect.EffectInfo;
import com.oppo.launcher.settings.Setting;
import com.oppo.shared_prefs.LauncherSharedPrefs;

public class EffectPreviewItem extends ToggleBarPreviewItem
{
  private static final String TAG = "EffectPreviewItem";
  public String mEffectClassName;
  public EffectInfo mEffectInfo;

  public EffectPreviewItem()
  {
    super(null, null);
  }

  public EffectPreviewItem(String paramString, Drawable paramDrawable)
  {
    super(paramString, paramDrawable);
  }

  public EffectPreviewItem(String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    super(paramString, paramDrawable, paramBoolean);
  }

  private void showEffectAutoPreview(String paramString)
  {
    if ((this.mLauncher != null) && (this.mLauncher.getWorkspace() != null))
      this.mLauncher.getWorkspace().showEffectPreview(paramString);
  }

  public void dealWithWhenAdded()
  {
    if (this.mLauncher == null)
      return;
    Resources localResources = this.mLauncher.getResources();
    if (localResources != null)
      this.mLauncher.showToastMsg(this.mLauncher, localResources.getString(2131427373), false);
    showEffectAutoPreview(Setting.getWorkSpaceEffectClassName());
  }

  public Drawable getThumbnail()
  {
    if (this.mThumbnail != null)
      return this.mThumbnail;
    if (this.mEffectInfo == null)
      return null;
    return this.mEffectInfo.getPreview(this.mLauncher);
  }

  public void handleOnClick()
  {
    String str = Setting.getWorkSpaceEffectClassName();
    if ((str != null) && (!str.equals(this.mEffectClassName)))
    {
      Editor localEditor = LauncherSharedPrefs.getLauncherPrefs(this.mLauncher).edit();
      localEditor.putString("desk_effect", this.mEffectClassName);
      Setting.setWorkspaceEffectClassName(this.mEffectClassName);
      localEditor.commit();
    }
    showEffectAutoPreview(str);
  }

  public void setEffectName(String paramString)
  {
    this.mEffectClassName = paramString;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.toggleBar.EffectPreviewItem
 * JD-Core Version:    0.6.2
 */