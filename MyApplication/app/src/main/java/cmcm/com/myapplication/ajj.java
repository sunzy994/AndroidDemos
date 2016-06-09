package cmcm.com.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.lazyswipe.ui.MainActivity;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

public class ajj
{
  private static final String b = "Swipe." + ajj.class.getSimpleName();
  final Handler a = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      int j = 2131230910;
      Activity localActivity = (Activity)ajj.b(ajj.this).get();
      if (localActivity == null);
      do
      {
        do
        {
          return;
          switch (paramAnonymousMessage.what)
          {
          default:
            return;
          case 6:
            if (ajj.c(ajj.this) != null)
            {
              aqt.a(ajj.c(ajj.this), localActivity);
              ajj.a(ajj.this, null);
            }
            paramAnonymousMessage = ajj.a(ajj.this);
          case 7:
          case 8:
          }
        }
        while (paramAnonymousMessage == null);
        if (paramAnonymousMessage.f())
        {
          asq.g(localActivity, "com.lazyswipe");
          return;
        }
        Intent localIntent = ajm.a(localActivity, MainActivity.class);
        ajj.a(ajj.this, ajj.a(localActivity, paramAnonymousMessage, null, ajj.a(ajj.this, localActivity), localIntent, ajj.a(ajj.this, localActivity, localIntent), ajj.d(ajj.this)));
        return;
        if (ajj.c(ajj.this) != null)
        {
          aqt.a(ajj.c(ajj.this), localActivity);
          ajj.a(ajj.this, null);
        }
        ajj.a(ajj.this, true);
        aqt.a(localActivity, localActivity.getString(2131231171), localActivity.getString(2131231170), localActivity.getString(17039370), new OnClickListener() {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
            paramAnonymous2DialogInterface.dismiss();
          }
        });
        return;
        if (ajj.c(ajj.this) != null)
        {
          aqt.a(ajj.c(ajj.this), localActivity);
          ajj.a(ajj.this, null);
        }
        ajj.a(ajj.this, true);
        paramAnonymousMessage = paramAnonymousMessage.getData();
      }
      while ((paramAnonymousMessage == null) || (!paramAnonymousMessage.containsKey("checkUpgradeError")));
      int i = j;
      switch (paramAnonymousMessage.getInt("checkUpgradeError"))
      {
      default:
        i = j;
      case 3:
      case 1:
      case 2:
      }
      while (true)
      {
        aqt.a(localActivity, localActivity.getString(2131231171), localActivity.getString(i), localActivity.getString(17039370), new OnClickListener() {
          public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {
            paramAnonymous2DialogInterface.dismiss();
          }
        });
        return;
        i = 2131230908;
        continue;
        i = 2131230909;
      }
    }
  };
  private ProgressDialog c;
  private Dialog d;
  private boolean e = true;
  private ajl f = null;
  private final WeakReference<Activity> g;

  public ajj(Activity paramActivity)
  {
    this.g = new WeakReference(paramActivity);
  }

  public static Dialog a(Context paramContext, final ajl paramajl, final OnClickListener paramOnClickListener1, OnClickListener paramOnClickListener2, final Intent paramIntent, final atd paramatd, final ajn paramajn)
  {
    if (paramajl == null)
      return null;
    tk localtk = new tk(paramContext);
    localtk.b(paramajl.d()).a(paramajl.c()).b(true).f(-1).a(paramContext.getString(2131231160), new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        if ((ajm.a(ajj.this, paramajl, paramIntent, paramatd, paramajn, paramajl)) && (paramOnClickListener1 != null))
          paramOnClickListener1.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
      }
    }).b(paramContext.getString(2131231095), new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        if (ajj.this != null)
          ajj.this.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
      }
    }).a(new OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        if (ajj.this != null)
          ajj.this.onClick(paramAnonymousDialogInterface, 0);
      }
    });
    paramContext = localtk.a();
    paramContext.show();
    return paramContext;
  }

  private OnClickListener a(Context paramContext)
  {
    return new OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.dismiss();
        ajj.a(ajj.this, true);
      }
    };
  }

  private atd a(final Activity paramActivity, final Intent paramIntent)
  {
    return new atd()
    {
      public void a(int paramAnonymousInt)
      {
        ajm.b(this.a.g);
        int i;
        switch (paramAnonymousInt)
        {
        case 4:
        case 6:
        default:
          Log.e(ajj.c(), "Error no is :" + paramAnonymousInt);
          i = 2131230917;
        case 2:
        case 3:
        case 1:
        case 5:
        case 7:
        }
        while ((paramAnonymousInt == 7) && (!paramActivity.isFinishing()))
        {
          ajj.b(paramActivity, this.a, null, ajj.a(ajj.this, paramActivity), paramIntent, ajj.a(ajj.this, paramActivity, paramIntent), ajj.d(ajj.this));
          return;
          i = 2131230918;
          continue;
          i = 2131230921;
          continue;
          i = 2131230922;
        }
        aso.a(paramActivity, i);
        ajj.a(ajj.this, true);
      }

      public void b()
      {
        ajm.b(this.a.g);
        ajj.a(ajj.this, true);
        asq.a(paramActivity, this.a.b());
      }

      public void r_()
      {
        ajm.a(this.a.g);
        ajj.a(ajj.this, false);
      }
    };
  }

  public static void b(Context paramContext, final ajl paramajl, final OnClickListener paramOnClickListener1, OnClickListener paramOnClickListener2, final Intent paramIntent, final atd paramatd, final ajn paramajn)
  {
    if (paramajl == null)
      return;
    aqt.a(paramContext, paramajl.a + paramContext.getResources().getString(2131230925), paramContext.getString(2131230924), paramContext.getString(2131230906), new OnClickListener() {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
        ajm.a(ajj.this, paramajl, paramIntent, paramatd, paramajn);
        if (paramOnClickListener1 != null)
          paramOnClickListener1.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
      }
    }
            , paramContext.getString(2131230911), new OnClickListener() {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
        paramAnonymousDialogInterface.dismiss();
        if (ajj.this != null)
          ajj.this.onClick(paramAnonymousDialogInterface, paramAnonymousInt);
      }
    });
  }

  private ajn d()
  {
    return new ajn()
    {
      public void a(int paramAnonymousInt)
      {
        if ((paramAnonymousInt == -1) || (paramAnonymousInt == 1000))
          ajj.a(ajj.this, true);
      }
    };
  }

  public void a()
  {
    if (!this.e);
    final Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.g.get();
    }
    while ((localActivity == null) || ((this.c != null) && (this.c.isShowing())));
    this.e = false;
    if (!arl.i(localActivity))
    {
      aqt.a(localActivity, localActivity.getString(2131230917), localActivity.getString(2131230919), localActivity.getString(17039370), new OnClickListener() {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {
          ajj.a(ajj.this, true);
          paramAnonymousDialogInterface.dismiss();
        }
      });
      this.e = false;
      return;
    }
    ajm.a(localActivity, System.currentTimeMillis());
    final Thread local5 = new Thread()
    {
      private void a(Handler paramAnonymousHandler, int paramAnonymousInt)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("checkUpgradeError", paramAnonymousInt);
        paramAnonymousHandler.sendMessage(asq.a(paramAnonymousHandler, 8, localBundle, null));
      }

      public void run()
      {
        try
        {
          ajl localajl = ajm.a(localActivity, "manual");
          if (!isInterrupted())
          {
            if (localajl == null)
            {
              ajj.this.a.sendEmptyMessage(7);
              return;
            }
            ajj.a(ajj.this, localajl);
            ajj.a(ajj.this).j();
            ajj.this.a.sendEmptyMessage(6);
            return;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
        }
        catch (JSONException localJSONException)
        {
          a(ajj.this.a, 2);
          return;
        }
        catch (IOException localIOException)
        {
          a(ajj.this.a, 1);
          return;
        }
        catch (Exception localException)
        {
          a(ajj.this.a, 3);
          return;
        }
        catch (ClientProtocolException localClientProtocolException)
        {
          label72: break label72;
        }
      }
    };
    local5.start();
    this.c = aqt.a(localActivity, localActivity.getString(2131230907), true, new OnCancelListener() {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {
        ajj.a(ajj.this, true);
        try {
          if (local5.isAlive())
            local5.interrupt();
          return;
        } catch (Exception paramAnonymousDialogInterface) {
          Log.e(ajj.c(), "close background thread", paramAnonymousDialogInterface);
        }
      }
    });
  }

  public void b()
  {
    Activity localActivity = (Activity)this.g.get();
    if (localActivity == null)
      return;
    aqt.a(this.d);
    aqt.a(this.c, localActivity);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ajj
 * JD-Core Version:    0.6.2
 */