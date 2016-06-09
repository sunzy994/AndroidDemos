package com.oppo.launcher.effect;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.View;
import com.oppo.launcher.PagedView;
import com.oppo.launcher.settings.Setting;
import com.oppo.shared_prefs.LauncherSharedPrefs;

public class EffectController
{
  private static final boolean DEBUG = false;
  private static final String TAG = "EffectController";
  private Context mContext;
  private EffectAgent mEffectAgent = null;
  private PagedView mPagedView = null;

  public EffectController(PagedView paramPagedView, Context paramContext)
  {
    this.mPagedView = paramPagedView;
    this.mContext = paramContext;
    initEffect();
  }

  public boolean canDrawChild(View paramView)
  {
    if (this.mEffectAgent != null)
      return this.mEffectAgent.applyDrawChild(paramView);
    return true;
  }

  public void doScreenScrolled(int paramInt)
  {
    if (this.mEffectAgent != null)
      if (this.mEffectAgent.getEffectClassName().equals(Setting.getWorkSpaceEffectClassName()))
        break label49;
    label49: for (int i = 1; ; i = 0)
    {
      if (i != 0)
        initEffect();
      if (this.mEffectAgent != null)
        this.mEffectAgent.applyEffect(paramInt);
      return;
    }
  }

  public EffectAgent getEffectAgent()
  {
    return this.mEffectAgent;
  }

  public void initEffect()
  {
    if (this.mEffectAgent != null)
    {
      this.mEffectAgent.recycle();
      this.mEffectAgent = null;
    }
    Object localObject = Setting.getWorkSpaceEffectClassName();
    boolean bool = false;
    if (this.mContext != null)
      bool = LauncherEffect.getLauncherEffect(this.mContext).isEffectAvailable((String)localObject);
    if (!bool)
    {
      String str = Setting.getWorkspaceDefaultEffectClassName();
      Setting.setWorkspaceEffectClassName(str);
      localObject = str;
      if (this.mContext != null)
      {
        localObject = str;
        if (str != null)
        {
          localObject = LauncherSharedPrefs.getLauncherPrefs(this.mContext).edit();
          ((Editor)localObject).putString("desk_effect", str);
          Setting.setWorkspaceEffectClassName(str);
          ((Editor)localObject).commit();
          localObject = str;
        }
      }
    }
    try
    {
      this.mEffectAgent = ((EffectAgent)Class.forName((String)localObject).newInstance());
      this.mEffectAgent.setPagedView(this.mPagedView);
      return;
    }
    catch (Exception localException)
    {
      Log.w("EffectController", "init " + localException);
    }
  }

  public boolean isAnimating()
  {
    if (this.mEffectAgent == null)
      return false;
    return this.mEffectAgent.isAnimating();
  }

  public void resetEffect()
  {
    if (this.mEffectAgent != null)
      this.mEffectAgent.restoreParameters();
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.launcher.effect.EffectController
 * JD-Core Version:    0.6.2
 */