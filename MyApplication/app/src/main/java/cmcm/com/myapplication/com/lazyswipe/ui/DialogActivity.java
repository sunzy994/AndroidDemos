package cmcm.com.myapplication.com.lazyswipe.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import aph;
import ase;
import asq;
import asr;
import atw;
import com.lazyswipe.notification.SwipeAccessibilityService;
import tk;
import vs;
import vv;

public class DialogActivity extends aph
  implements OnCancelListener, DialogInterface.OnClickListener, OnDismissListener
{
  private static Dialog j;
  private int i;

  public static void a(Context paramContext)
  {
    a(paramContext, 3);
  }

  private static void a(Context paramContext, int paramInt)
  {
    a(paramContext, new Intent(paramContext, DialogActivity.class).putExtra("extra.dialog_id", paramInt));
  }

  private static void a(Context paramContext, Intent paramIntent)
  {
    paramIntent.addFlags(268435456);
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (Exception paramContext)
    {
    }
  }

  public static void a(Context paramContext, Bitmap paramBitmap)
  {
    a(paramContext, paramBitmap, false);
  }

  private static void a(final Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2130968596, null);
    ((ImageView)asr.a((View)localObject, 2131755094)).setImageBitmap(paramBitmap);
    asr.a((View)localObject, 2131755095).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        vv localvv = vv.a();
        if (!this.a);
        for (paramAnonymousView = "HolaLauncher下载-Theme"; ; paramAnonymousView = "HolaLauncher下载-Fan")
        {
          localvv.a(paramAnonymousView);
          if (DialogActivity.g() != null)
            DialogActivity.g().dismiss();
          asq.g(paramContext, "com.hola.launcher&referrer=aq_tranid%3d0RWlnwbEN226OotMDF7l8IWSeoPaxvAeL%26pid%3dha_lazy_int%26c%3dlazyswipe_gp_theme");
          return;
        }
      }
    });
    localObject = new tk(paramContext).a((View)localObject).c(true);
    if (paramBoolean)
    {
      paramBitmap = (OnDismissListener)paramContext;
      localObject = ((tk)localObject).a(paramBitmap);
      if (!paramBoolean)
        break label131;
    }
    label131: for (paramBitmap = (OnDismissListener)paramContext; ; paramBitmap = new OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        DialogActivity.a(null);
      }
    })
    {
      j = ((tk)localObject).a(paramBitmap).b();
      j.getWindow().setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(17170445)));
      return;
      paramBitmap = new OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          DialogActivity.a(null);
        }
      };
      break;
    }
  }

  public static void b(Context paramContext)
  {
    a(paramContext, 2);
  }

  public static void c(Context paramContext)
  {
    a(paramContext, 0);
  }

  public static void d(Context paramContext)
  {
    a(paramContext, 1);
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    finish();
    j = null;
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    switch (this.i)
    {
    default:
      return;
    case 0:
      asq.g(this, "com.hola.screenlock&referrer=aq_tranid%3d0OBV7rbnknKGmMtXRSrNfpJt00La0EJyA%26pid%3dha_lazy_int%26c%3dlazyswipe_gp");
      return;
    case 1:
      if (asq.c(this, "com.hola.screenlock"))
      {
        asq.d(this, new Intent("com.hola.screenlock.action.main").setPackage("com.hola.screenlock").addFlags(32));
        return;
      }
      asq.g(this);
      return;
    case 2:
      SwipeAccessibilityService.a(this, false);
      return;
    case 3:
    }
    vs.c(this, ase.a());
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    this.i = paramBundle.getIntExtra("extra.dialog_id", -1);
    int k;
    switch (this.i)
    {
    default:
      finish();
      return;
    case 4:
      try
      {
        a(this, atw.a(paramBundle.getStringExtra("extra.param_1"), 2560, 2560), true);
        return;
      }
      catch (Throwable paramBundle)
      {
        return;
      }
    case 0:
      k = 2131230983;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      new tk(this).g(k).b(17039369, null).a(17039379, this).f(-1).a(this).b();
      return;
      k = 2131230973;
      continue;
      k = 2131230975;
      continue;
      k = 2131231258;
    }
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    finish();
    j = null;
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.DialogActivity
 * JD-Core Version:    0.6.2
 */