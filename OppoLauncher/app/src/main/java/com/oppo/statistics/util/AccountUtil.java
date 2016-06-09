package com.oppo.statistics.util;

import android.content.Context;
import com.oppo.statistics.storage.PreferenceHandler;

public class AccountUtil
{
  public static final String SSOID_DEFAULT = "0";

  public static String getSsoId(Context paramContext)
  {
    paramContext = PreferenceHandler.getSsoID(paramContext);
    if (paramContext.equals("0"))
      LogUtil.e("NearMeStatistics", "ssoid not set.");
    return paramContext;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.util.AccountUtil
 * JD-Core Version:    0.6.2
 */