package cmcm.com.myapplication.com.lazyswipe.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import arm;
import asl;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.ui.chooser.MultiChooserActivity;
import java.io.Serializable;
import java.util.ArrayList;
import wk;
import wm;

public class NotificationSettingsActivity extends FragmentContainer
{
  public static void a(Context paramContext, String[] paramArrayOfString)
  {
    a(paramContext, paramArrayOfString, null, null);
  }

  public static void a(Context paramContext, String[] paramArrayOfString, PendingIntent paramPendingIntent1, PendingIntent paramPendingIntent2)
  {
    Object localObject1 = ((SwipeApplication)paramContext.getApplicationContext()).a();
    ArrayList localArrayList = new ArrayList(3);
    Object localObject2 = asl.g(paramContext);
    if (!"com.textra".equals(localObject2))
    {
      localObject1 = ((wm)localObject1).a((String)localObject2);
      if (localObject1 != null)
        localArrayList.add(((wk)localObject1).i.getPackageName());
    }
    localArrayList.add("com.google.android.dialer");
    localArrayList.add(paramContext.getPackageName());
    localObject1 = new ArrayList(3);
    if (arm.b("com.whatsapp"))
      ((ArrayList)localObject1).add("com.whatsapp");
    if (arm.b("com.tencent.mm"))
      ((ArrayList)localObject1).add("com.tencent.mm");
    if (arm.b("com.google.android.gm"))
      ((ArrayList)localObject1).add("com.google.android.gm");
    if (arm.b("org.telegram.messenger"))
      ((ArrayList)localObject1).add("org.telegram.messenger");
    if (arm.b("com.viber.voip"))
      ((ArrayList)localObject1).add("com.viber.voip");
    localObject2 = MultiChooserActivity.c(true);
    ((Intent)localObject2).putExtra("extra.request_type", 2);
    ((Intent)localObject2).putExtra("extra.request_existing_list", paramArrayOfString);
    ((Intent)localObject2).putExtra("extra.request_exclude_existings", false);
    ((Intent)localObject2).putExtra("extra.request_exclude_list", localArrayList);
    ((Intent)localObject2).putExtra("extra.request_invisible_list", (Serializable)localObject1);
    if (paramPendingIntent2 != null)
      ((Intent)localObject2).putExtra("extra.ok_action", paramPendingIntent2);
    if (paramPendingIntent1 != null)
      ((Intent)localObject2).putExtra("extra.cancel_action", paramPendingIntent2);
    if (!(paramContext instanceof Activity))
      ((Intent)localObject2).addFlags(268468224);
    paramContext.startActivity((Intent)localObject2);
    localArrayList.clear();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.NotificationSettingsActivity
 * JD-Core Version:    0.6.2
 */