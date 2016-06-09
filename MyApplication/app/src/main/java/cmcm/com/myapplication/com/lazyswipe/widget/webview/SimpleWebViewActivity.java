package cmcm.com.myapplication.com.lazyswipe.widget.webview;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import asq;
import atw;
import awf;
import azr;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.widget.Toolbar;

public class SimpleWebViewActivity extends azr
{
  private Toolbar i;

  public static void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(SwipeApplication.c(), SimpleWebViewActivity.class);
    localIntent.putExtra("extra_url", paramString1);
    localIntent.putExtra("extra_title", paramString2);
    asq.d(SwipeApplication.c(), localIntent);
  }

  protected int g()
  {
    return 2130968583;
  }

  protected int h()
  {
    return 2131755031;
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.i = ((Toolbar)findViewById(2131755045));
    paramBundle = getIntent().getStringExtra("extra_title");
    if (TextUtils.isEmpty(paramBundle))
    {
      this.i.setVisibility(8);
      return;
    }
    this.i.setVisibility(0);
    this.i.setTitle(paramBundle);
    this.i.setCallback(new awf()
    {
      public void onTitleClick(View paramAnonymousView)
      {
        SimpleWebViewActivity.this.q();
      }
    });
    this.i.setIcon(atw.a(this, 2130837513));
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.widget.webview.SimpleWebViewActivity
 * JD-Core Version:    0.6.2
 */