package cmcm.com.myapplication.com.facebook.ads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import ci;
import com.facebook.ads.internal.g;
import com.facebook.ads.internal.view.f;
import com.facebook.ads.internal.view.h;
import com.facebook.ads.internal.view.h.a;
import com.facebook.ads.internal.view.m;

public class InterstitialAdActivity extends Activity
{
  public static final String PREDEFINED_ORIENTATION_KEY = "predefinedOrientationKey";
  public static final String VIDEO_PLAY_REPORT_URL = "videoPlayReportURL";
  public static final String VIDEO_TIME_REPORT_URL = "videoTimeReportURL";
  public static final String VIDEO_URL = "videoURL";
  public static final String VIEW_TYPE = "viewType";
  private RelativeLayout a;
  private g b;
  private int c = -1;
  private String d;
  private h e;

  private void a(Intent paramIntent, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.c = paramBundle.getInt("predefinedOrientationKey", -1);
      this.d = paramBundle.getString("adInterstitialUniqueId");
      this.e.a(paramIntent, paramBundle);
      return;
    }
    this.c = paramIntent.getIntExtra("predefinedOrientationKey", -1);
    this.d = paramIntent.getStringExtra("adInterstitialUniqueId");
    this.e.a(paramIntent, paramBundle);
  }

  private void a(String paramString)
  {
    paramString = new Intent(paramString + ":" + this.d);
    ci.a(this).a(paramString);
  }

  public void finish()
  {
    this.a.removeAllViews();
    this.e.c();
    a("com.facebook.ads.interstitial.dismissed");
    super.finish();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    getWindow().setFlags(1024, 1024);
    this.a = new RelativeLayout(this);
    this.a.setBackgroundColor(-16777216);
    setContentView(this.a, new LayoutParams(-1, -1));
    Intent localIntent = getIntent();
    if (localIntent.getBooleanExtra("useNativeCloseButton", false))
    {
      this.b = new g(this);
      this.b.setId(100002);
      this.b.setOnClickListener(new OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          InterstitialAdActivity.this.finish();
        }
      });
    }
    InterstitialAdActivity.Type localType = (InterstitialAdActivity.Type)localIntent.getSerializableExtra("viewType");
    switch (4.a[localType.ordinal()])
    {
    default:
    case 1:
    }
    for (this.e = new f(this, new h.a()
    {
      public void a(View paramAnonymousView)
      {
        InterstitialAdActivity.a(InterstitialAdActivity.this).addView(paramAnonymousView);
        if (InterstitialAdActivity.b(InterstitialAdActivity.this) != null)
          InterstitialAdActivity.a(InterstitialAdActivity.this).addView(InterstitialAdActivity.b(InterstitialAdActivity.this));
      }

      public void a(String paramAnonymousString)
      {
        InterstitialAdActivity.a(InterstitialAdActivity.this, paramAnonymousString);
      }
    }); ; this.e = new m(this, new h.a()
    {
      public void a(View paramAnonymousView)
      {
        InterstitialAdActivity.a(InterstitialAdActivity.this).addView(paramAnonymousView);
        if (InterstitialAdActivity.b(InterstitialAdActivity.this) != null)
          InterstitialAdActivity.a(InterstitialAdActivity.this).addView(InterstitialAdActivity.b(InterstitialAdActivity.this));
      }

      public void a(String paramAnonymousString)
      {
        InterstitialAdActivity.a(InterstitialAdActivity.this, paramAnonymousString);
      }
    }))
    {
      a(localIntent, paramBundle);
      a("com.facebook.ads.interstitial.displayed");
      return;
    }
  }

  public void onPause()
  {
    super.onPause();
    this.e.a();
  }

  public void onRestart()
  {
    super.onRestart();
  }

  public void onResume()
  {
    super.onResume();
    this.e.b();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    this.e.a(paramBundle);
    paramBundle.putInt("predefinedOrientationKey", this.c);
    paramBundle.putString("adInterstitialUniqueId", this.d);
  }

  public void onStart()
  {
    super.onStart();
    if (this.c != -1)
      setRequestedOrientation(this.c);
  }

  public void setRequestedOrientation(int paramInt)
  {
    super.setRequestedOrientation(paramInt);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.facebook.ads.InterstitialAdActivity
 * JD-Core Version:    0.6.2
 */