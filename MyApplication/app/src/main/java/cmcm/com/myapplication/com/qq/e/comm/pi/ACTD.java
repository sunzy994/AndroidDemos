package cmcm.com.myapplication.com.qq.e.comm.pi;

import android.content.res.Configuration;
import android.os.Bundle;

public abstract interface ACTD
{
  public static final String APPID_KEY = "appid";
  public static final String DELEGATE_NAME_KEY = "gdt_activity_delegate_name";

  public abstract void onAfterCreate(Bundle paramBundle);

  public abstract void onBackPressed();

  public abstract void onBeforeCreate(Bundle paramBundle);

  public abstract void onConfigurationChanged(Configuration paramConfiguration);

  public abstract void onDestroy();

  public abstract void onResume();

  public abstract void onStop();
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.qq.e.comm.pi.ACTD
 * JD-Core Version:    0.6.2
 */