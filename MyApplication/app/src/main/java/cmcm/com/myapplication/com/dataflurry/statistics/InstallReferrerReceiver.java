package cmcm.com.myapplication.com.dataflurry.statistics;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.net.URLEncoder;
import ke;
import kl;
import kx;

public class InstallReferrerReceiver extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    while (true)
    {
      int i;
      try
      {
        if (!paramIntent.hasExtra("referrer"))
          break;
        kx.c("DF_Receiver", "onReceive encode Referrers: " + paramIntent.getStringExtra("referrer"));
        String str = URLDecoder.decode(paramIntent.getStringExtra("referrer"), "UTF-8");
        paramIntent = "";
        localObject1 = "";
        String[] arrayOfString = str.split("&");
        int j = arrayOfString.length;
        i = 0;
        Object localObject3 = "";
        if (i < j)
        {
          localObject2 = arrayOfString[i].split("=");
          if (localObject2.length == 2)
          {
            Object localObject4 = localObject2[0];
            localObject2 = localObject2[1];
            if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
            {
              if (((String)localObject4).toString().trim().equals("pid".toString().trim()))
              {
                paramIntent = (Intent)localObject1;
                localObject1 = localObject2;
                break label343;
              }
              if (((String)localObject4).toString().trim().equals("c".toString().trim()))
              {
                localObject1 = paramIntent;
                paramIntent = (Intent)localObject2;
                break label343;
              }
              if (((String)localObject4).toString().trim().equals("clickid".toString().trim()))
              {
                localObject4 = paramIntent;
                localObject3 = localObject2;
                paramIntent = (Intent)localObject1;
                localObject1 = localObject4;
                break label343;
              }
            }
          }
        }
        else
        {
          localObject2 = paramIntent;
          if (TextUtils.isEmpty(paramIntent))
            localObject2 = "unkown";
          paramIntent = (String)localObject2 + "," + (String)localObject1 + "," + (String)localObject3;
          try
          {
            kl.a().a(paramContext, "referrer", URLEncoder.encode(str));
            kl.a().a(paramContext, "pid_c", URLEncoder.encode(paramIntent));
            paramContext.getContentResolver().call(ke.a, String.valueOf(500), null, null);
            return;
          }
          catch (Throwable paramIntent)
          {
            paramIntent.printStackTrace();
            continue;
          }
        }
      }
      catch (Exception paramContext)
      {
        return;
      }
      Object localObject2 = localObject1;
      Object localObject1 = paramIntent;
      paramIntent = (Intent)localObject2;
      label343: i += 1;
      localObject2 = localObject1;
      localObject1 = paramIntent;
      paramIntent = (Intent)localObject2;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.dataflurry.statistics.InstallReferrerReceiver
 * JD-Core Version:    0.6.2
 */