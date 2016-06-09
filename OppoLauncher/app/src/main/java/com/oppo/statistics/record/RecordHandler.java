package com.oppo.statistics.record;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.oppo.statistics.data.AppLogBean;
import com.oppo.statistics.data.AppStartBean;
import com.oppo.statistics.data.CommonBean;
import com.oppo.statistics.data.DebugBean;
import com.oppo.statistics.data.DynamicEventBean;
import com.oppo.statistics.data.ExceptionBean;
import com.oppo.statistics.data.PageVisitBean;
import com.oppo.statistics.data.SpecialAppStartBean;
import com.oppo.statistics.data.StaticEventBean;
import com.oppo.statistics.data.StatisticBean;
import com.oppo.statistics.data.UserActionBean;
import com.oppo.statistics.util.AccountUtil;
import com.oppo.statistics.util.ApkInfoUtil;
import com.oppo.statistics.util.LogUtil;

public class RecordHandler
{
  private static final String ACTION_AMOUNT = "actionAmount";
  private static final String ACTION_CODE = "actionCode";
  private static final String ACTION_TIME = "actionTime";
  private static final String APP_ID = "appId";
  private static final String APP_NAME = "appName";
  private static final String APP_PACKAGE = "appPackage";
  private static final String APP_VERSION = "appVersion";
  private static final String DATA_TYPE = "dataType";
  private static final String DEBUG = "debug";
  private static final String EVENT_BODY = "eventBody";
  private static final String EVENT_TYPE = "eventType";
  private static final String EXCEPTION = "exception";
  private static final String EXCEPTION_COUNT = "count";
  private static final String EXCEPTION_TIME = "time";
  private static final String LOGIN_TIME = "loginTime";
  private static final String LOG_MAP = "logMap";
  private static final String LOG_TAG = "logTag";
  private static final String PAGE_VISIT_ACTIVIES = "activities";
  private static final String PAGE_VISIT_DURATION = "duration";
  private static final String PAGE_VISIT_TIME = "time";
  private static final String SSOID = "ssoid";
  private static final String TAG = RecordHandler.class.getSimpleName();
  private static final String UPLOAD_MODE = "uploadMode";
  private static final String UPLOAD_NOW = "uploadNow";
  private static Context mContext;

  public static void addTask(Context paramContext, StatisticBean paramStatisticBean)
  {
    mContext = paramContext.getApplicationContext();
    if (mContext == null)
      mContext = paramContext;
    if (paramStatisticBean == null)
      return;
    try
    {
      switch (paramStatisticBean.getDataType())
      {
      case 1:
        paramContext = (AppStartBean)paramStatisticBean;
        paramStatisticBean = getStartServiceIntent();
        paramStatisticBean.putExtra("loginTime", paramContext.getTime());
        paramStatisticBean.putExtra("dataType", 1000);
        mContext.startService(paramStatisticBean);
        return;
      case 4:
      case 7:
      case 3:
      case 2:
      case 5:
      case 9:
      case 10:
      case 11:
      case 12:
      case 6:
      case 8:
      }
    }
    catch (Exception paramContext)
    {
      LogUtil.e(TAG, paramContext);
      return;
    }
    paramContext = (AppLogBean)paramStatisticBean;
    paramStatisticBean = getStartServiceIntent();
    paramStatisticBean.putExtra("eventBody", paramContext.getBody());
    paramStatisticBean.putExtra("eventType", paramContext.getType());
    paramStatisticBean.putExtra("dataType", 1002);
    mContext.startService(paramStatisticBean);
    return;
    paramContext = (SpecialAppStartBean)paramStatisticBean;
    paramStatisticBean = getSpecialStartServiceIntent(paramContext.getAppId());
    paramStatisticBean.putExtra("loginTime", paramContext.getTime());
    paramStatisticBean.putExtra("dataType", 1000);
    mContext.startService(paramStatisticBean);
    return;
    paramContext = (PageVisitBean)paramStatisticBean;
    paramStatisticBean = getStartServiceIntent();
    paramStatisticBean.putExtra("time", paramContext.getTime());
    paramStatisticBean.putExtra("duration", paramContext.getDuration());
    paramStatisticBean.putExtra("activities", paramContext.getActivities());
    paramStatisticBean.putExtra("dataType", 1003);
    mContext.startService(paramStatisticBean);
    return;
    paramContext = (UserActionBean)paramStatisticBean;
    paramStatisticBean = getStartServiceIntent();
    paramStatisticBean.putExtra("actionAmount", paramContext.getActionAmount());
    paramStatisticBean.putExtra("actionCode", paramContext.getActionCode());
    paramStatisticBean.putExtra("actionTime", paramContext.getActionDate());
    paramStatisticBean.putExtra("dataType", 1001);
    mContext.startService(paramStatisticBean);
    return;
    paramContext = (ExceptionBean)paramStatisticBean;
    paramStatisticBean = getStartServiceIntent();
    paramStatisticBean.putExtra("exception", paramContext.getException());
    paramStatisticBean.putExtra("count", paramContext.getCount());
    paramStatisticBean.putExtra("time", paramContext.getEventTime());
    paramStatisticBean.putExtra("dataType", 1004);
    mContext.startService(paramStatisticBean);
    return;
    int i = ApkInfoUtil.getVersionCode(mContext, "com.nearme.statistics.rom");
    LogUtil.d("NearMeStatistics", "versionCode:" + i);
    if (i < 400)
    {
      LogUtil.d("NearMeStatistics", "versionCode:" + i + " is old version,break!");
      return;
    }
    paramContext = (CommonBean)paramStatisticBean;
    LogUtil.d("NearMeStatistics", "bean:" + paramStatisticBean.toString());
    paramStatisticBean = getCommonStartServiceIntent();
    paramStatisticBean.putExtra("uploadNow", paramContext.getUploadNow());
    paramStatisticBean.putExtra("logTag", paramContext.getLogTag());
    paramStatisticBean.putExtra("logMap", paramContext.getLogMap());
    paramStatisticBean.putExtra("dataType", 1006);
    mContext.startService(paramStatisticBean);
    return;
    paramContext = (DynamicEventBean)paramStatisticBean;
    paramStatisticBean = getStartServiceIntent();
    paramStatisticBean.putExtra("eventBody", paramContext.getBody());
    paramStatisticBean.putExtra("uploadMode", paramContext.getUploadMode());
    paramStatisticBean.putExtra("dataType", 1007);
    mContext.startService(paramStatisticBean);
    return;
    paramContext = (StaticEventBean)paramStatisticBean;
    paramStatisticBean = getStartServiceIntent();
    paramStatisticBean.putExtra("eventBody", paramContext.getBody());
    paramStatisticBean.putExtra("uploadMode", paramContext.getUploadMode());
    paramStatisticBean.putExtra("dataType", 1008);
    mContext.startService(paramStatisticBean);
    return;
    paramContext = (DebugBean)paramStatisticBean;
    paramStatisticBean = getStartServiceIntent();
    paramStatisticBean.putExtra("dataType", 1009);
    paramStatisticBean.putExtra("debug", paramContext.getFlag());
    mContext.startService(paramStatisticBean);
    return;
  }

  private static Intent getCommonStartServiceIntent()
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.nearme.statistics.rom", "com.nearme.statistics.rom.service.ReceiverService"));
    localIntent.putExtra("appId", ApkInfoUtil.getAppCode(mContext));
    localIntent.putExtra("appVersion", ApkInfoUtil.getVersionName(mContext));
    localIntent.putExtra("appPackage", ApkInfoUtil.getPackageName(mContext));
    localIntent.putExtra("appName", ApkInfoUtil.getAppName(mContext));
    localIntent.putExtra("ssoid", AccountUtil.getSsoId(mContext));
    return localIntent;
  }

  private static Intent getSpecialStartServiceIntent(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.nearme.statistics.rom", "com.nearme.statistics.rom.service.ReceiverService"));
    localIntent.putExtra("appId", paramInt);
    localIntent.putExtra("appVersion", ApkInfoUtil.getVersionName(mContext));
    localIntent.putExtra("appPackage", ApkInfoUtil.getPackageName(mContext));
    localIntent.putExtra("ssoid", AccountUtil.getSsoId(mContext));
    return localIntent;
  }

  private static Intent getStartServiceIntent()
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.nearme.statistics.rom", "com.nearme.statistics.rom.service.ReceiverService"));
    localIntent.putExtra("appId", ApkInfoUtil.getAppCode(mContext));
    localIntent.putExtra("appVersion", ApkInfoUtil.getVersionName(mContext));
    localIntent.putExtra("appPackage", ApkInfoUtil.getPackageName(mContext));
    localIntent.putExtra("ssoid", AccountUtil.getSsoId(mContext));
    return localIntent;
  }
}

/* Location:           OppoLauncher-dex2jar.jar
 * Qualified Name:     com.oppo.statistics.record.RecordHandler
 * JD-Core Version:    0.6.2
 */