package cmcm.com.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class arv
{
  private static final String a = "Swipe." + arv.class.getSimpleName();
  private static ArrayList<String> b;

  public static Intent a(ComponentName paramComponentName, String paramString1, String paramString2, File paramFile)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.addFlags(50331648);
    localIntent.setComponent(paramComponentName);
    localIntent.putExtra("android.intent.extra.SUBJECT", paramString1);
    localIntent.putExtra("android.intent.extra.TEXT", paramString2);
    localIntent.putExtra("sms_body", paramString2);
    localIntent.putExtra("desc", paramString2);
    localIntent.putExtra("Kdescription", paramString2);
    if (paramFile != null)
    {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(paramFile));
      if (paramComponentName.getPackageName().contains("mail"))
      {
        localIntent.setType("application/octet-stream");
        return localIntent;
      }
      if ((paramComponentName.getPackageName().contains("kaixin")) || (paramComponentName.getPackageName().contains("com.qihoo360.contacts")))
      {
        localIntent.setType("text/plain");
        return localIntent;
      }
      localIntent.setType("image/*");
      return localIntent;
    }
    localIntent.setType("text/plain");
    return localIntent;
  }

  public static String a()
  {
    return "https://play.google.com/store/apps/details?id=com.lazyswipe";
  }

  private static String a(Context paramContext, asd paramasd, String paramString1, boolean paramBoolean, String paramString2)
  {
    paramasd = paramasd.a(paramContext, paramString1, paramString2, paramBoolean);
    paramContext = paramasd;
    if (paramasd == null)
      paramContext = "";
    return paramContext;
  }

  public static void a(Activity paramActivity, String paramString1, int paramInt, asd paramasd, String paramString2, asb paramasb, boolean paramBoolean, asa[] paramArrayOfasa)
  {
    a(paramActivity, paramString1, paramActivity.getString(paramInt), paramasd, paramString2, paramasb, paramBoolean, paramArrayOfasa);
  }

  private static void a(Activity paramActivity, String paramString1, String paramString2, asd paramasd, String paramString3, asb paramasb, boolean paramBoolean, asa[] paramArrayOfasa)
  {
    if (paramasb == null);
    for (Object localObject = "text/plain"; ; localObject = "image/*")
    {
      localObject = new arw(paramActivity, paramString1, "android.intent.action.SEND", (String)localObject, paramArrayOfasa);
      paramString1 = new asc(paramActivity, (arw)localObject, paramasd, paramString3, paramasb, paramBoolean, paramArrayOfasa);
      paramArrayOfasa = ((arw)localObject).a();
      if ((paramArrayOfasa.size() != 1) || (!(paramArrayOfasa.get(0) instanceof arx)))
        break;
      paramString1.a(paramActivity, paramString3, ((arx)paramArrayOfasa.get(0)).a, paramasd, paramasb, paramBoolean);
      return;
    }
    paramActivity = new tk(paramActivity);
    paramActivity.a(paramString2);
    paramActivity.a(asc.a(paramString1));
    try
    {
      paramActivity = paramActivity.a();
      asc.a(paramString1, paramActivity);
      paramActivity.show();
      return;
    }
    catch (Throwable paramActivity)
    {
      Log.e(a, "Show dialog failed and safe ignored.", paramActivity);
    }
  }

  private static void b(Activity paramActivity, ComponentName paramComponentName, asd paramasd, String paramString, asb paramasb)
  {
    if (paramasb == null)
      paramasb = null;
    while (true)
    {
      paramComponentName = a(paramComponentName, paramasd.a(paramActivity, paramComponentName.getPackageName()), a(paramActivity, paramasd, paramComponentName.getPackageName(), true, paramString), paramasb);
      try
      {
        paramActivity.startActivity(paramComponentName);
        return;
        paramasb = paramasb.e();
      }
      catch (Throwable paramActivity)
      {
        Log.e(a, "start activity failed and safe ignored.", paramActivity);
      }
    }
  }

  private static ArrayList<String> c()
  {
    if (b == null)
    {
      b = new ArrayList();
      b.add("com.tencent.mm/com.tencent.mm.ui.tools.ShareToTimeLineUI");
      b.add("com.tencent.mm/com.tencent.mm.ui.tools.ShareImgUI");
      b.add("com.sina.weibo");
      b.add("com.qzone");
      b.add("com.tencent.mobileqq/com.tencent.mobileqq.activity.JumpActivity");
      b.add("com.ucmobile");
      b.add("com.android.email");
      b.add("com.mt.mtxx.mtxx");
      b.add("com.facebook.katana");
      b.add("com.twitter.android");
      b.add("com.google.android.apps.plus");
      b.add("com.pinterest");
      b.add("com.path");
      b.add("com.instagram.android");
      b.add("com.google.android.talk");
      b.add("com.google.android.gm");
      b.add("com.android.mms");
      b.add("com.android.bluetooth");
      b.add("com.mediatek.bluetooth");
    }
    return b;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     arv
 * JD-Core Version:    0.6.2
 */