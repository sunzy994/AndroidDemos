package cmcm.com.myapplication.com.lazyswipe.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import aqs;
import asq;
import ci;
import yb;

public class EmptyActivity extends Activity
{
  private static final String a = "Swipe." + EmptyActivity.class.getSimpleName();
  private static boolean c;
  private BroadcastReceiver b;

  public static void a(Context paramContext)
  {
    if (!c)
      return;
    c = false;
    ci.a(paramContext).a(new Intent("com.lazyswipe.action.close_empty_activity"));
  }

  public static void a(Context paramContext, int paramInt)
  {
    if ((paramInt == 0) && ((aqs.f()) || (!aqs.Q())));
    while (c)
      return;
    c = true;
    Intent localIntent = new Intent(paramContext, EmptyActivity.class);
    localIntent.putExtra("EXTRA_ROUTE", paramInt);
    asq.d(paramContext, localIntent);
  }

  public static boolean a()
  {
    return c;
  }

  @TargetApi(21)
  private void b()
  {
    if (aqs.R());
    try
    {
      getWindow().addFlags(-2147483648);
      getWindow().getDecorView().setSystemUiVisibility(512);
      getWindow().setStatusBarColor(0);
      getWindow().setNavigationBarColor(-16777216);
      do
        return;
      while (!aqs.Q());
      getWindow().addFlags(67108864);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  private void c()
  {
    if (getRequestedOrientation() != 1)
      setRequestedOrientation(1);
  }

  private void d()
  {
    if (this.b == null)
    {
      this.b = new BroadcastReceiver()
      {
        public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          EmptyActivity.a(EmptyActivity.this);
        }
      };
      ci.a(this).a(this.b, new IntentFilter("com.lazyswipe.action.close_empty_activity"));
    }
  }

  private void e()
  {
    try
    {
      if (this.b != null)
      {
        ci.a(this).a(this.b);
        this.b = null;
        finish();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void onBackPressed()
  {
    super.onBackPressed();
    e();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("EXTRA_ROUTE", 0);
    if (i == 0)
      b();
    while (true)
    {
      d();
      if ((i == 0) && (!yb.o()))
        ci.a(this).a(new Intent("com.lazyswipe.action.close_empty_activity"));
      return;
      if ((i == 1) || (i == 2) || (i == 3))
        c();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.EmptyActivity
 * JD-Core Version:    0.6.2
 */