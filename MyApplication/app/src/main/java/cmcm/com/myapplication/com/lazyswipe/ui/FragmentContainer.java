package cmcm.com.myapplication.com.lazyswipe.ui;

import amd;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import aph;
import asp;

@SuppressLint({"Registered"})
public class FragmentContainer extends aph
{
  private static final String i = "Swipe." + FragmentContainer.class.getSimpleName();
  protected String j;

  private void h()
  {
    try
    {
      ActivityInfo localActivityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
      if (localActivityInfo != null)
      {
        if (localActivityInfo.metaData == null)
          return;
        this.j = localActivityInfo.metaData.getString("com.lazyswipe.FRAGMENT_CLASS");
        return;
      }
    }
    catch (NameNotFoundException localNameNotFoundException)
    {
    }
  }

  public int a(Fragment paramFragment, String paramString)
  {
    return getFragmentManager().beginTransaction().add(2131755254, paramFragment, paramString).commit();
  }

  public void a(Fragment paramFragment)
  {
  }

  public int b(Fragment paramFragment)
  {
    return a(paramFragment, "def_fragment_tag");
  }

  public int g()
  {
    return 2130968639;
  }

  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    if (paramString.startsWith("com.lazyswipe"))
      return amd.a(this);
    return super.getSharedPreferences(paramString, paramInt);
  }

  public Fragment k()
  {
    return getFragmentManager().findFragmentById(2131755254);
  }

  protected View l()
  {
    return null;
  }

  protected Fragment m()
  {
    h();
    if (TextUtils.isEmpty(this.j))
      return null;
    try
    {
      Fragment localFragment = (Fragment)Class.forName(this.j).newInstance();
      return localFragment;
    }
    catch (Throwable localThrowable)
    {
      asp.a(i, "Could not instantiate fragment " + this.j, localThrowable);
    }
    return null;
  }

  public void onAttachFragment(Fragment paramFragment)
  {
    super.onAttachFragment(paramFragment);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int k = g();
    if (k > 0)
      setContentView(k);
    while (true)
    {
      if (paramBundle == null)
      {
        paramBundle = m();
        if (paramBundle != null)
          break;
        finish();
      }
      return;
      setContentView(l());
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
      paramBundle.setArguments(localBundle);
    b(paramBundle);
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    a(k());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.FragmentContainer
 * JD-Core Version:    0.6.2
 */