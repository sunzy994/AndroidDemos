package cmcm.com.myapplication.com.lazyswipe.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.Window;
import asq;

public class DismissKeyguardActivity extends Activity
  implements Callback
{
  private static boolean a;
  private Handler b;

  public static void a(Context paramContext)
  {
    asq.d(paramContext, new Intent(paramContext, DismissKeyguardActivity.class));
  }

  public static void b(Context paramContext)
  {
    if (a)
      asq.d(paramContext, new Intent(paramContext, DismissKeyguardActivity.class).putExtra("extra.FINISH", true));
  }

  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      if (!isFinishing())
        finish();
      return true;
    }
    return false;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a = true;
    getWindow().addFlags(4718592);
    this.b = new Handler(this);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.b.removeMessages(0);
    a = false;
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
  }

  protected void onResume()
  {
    super.onResume();
    if (getIntent().getBooleanExtra("extra.FINISH", false))
    {
      finish();
      return;
    }
    this.b.sendEmptyMessageDelayed(0, 2000L);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.DismissKeyguardActivity
 * JD-Core Version:    0.6.2
 */