package cmcm.com.myapplication.com.hola.channel.sdk.game.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import ez;
import qs;
import qx;
import rz;
import sb;
import sd;
import td;

public abstract class BaseGameActivity extends Activity
  implements OnClickListener, rz
{
  private static final String a = "GameSDK." + GameListActivity.class.getSimpleName();
  private sd b;

  private void b()
  {
    this.b = new sd(this, qs.a(this, 66.699997F), ".game_sdk", 52428800, 0.2F);
    this.b.a(td.hola_game_ic_placeholder);
  }

  public abstract int a();

  public sd d()
  {
    return this.b;
  }

  public void onClick(View paramView)
  {
    if (16908294 == paramView.getId())
      finish();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(a());
    paramBundle = (ImageView)qx.a(this, 16908294);
    if (1 == ez.h(getWindow().findViewById(16908290)))
    {
      Bitmap localBitmap = sb.a(this, td.hola_common_ic_back);
      if (localBitmap != null)
        paramBundle.setImageBitmap(localBitmap);
    }
    paramBundle.setOnClickListener(this);
    b();
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.b.f();
    this.b.e();
  }

  protected void onPause()
  {
    super.onPause();
    this.b.b(true);
    this.b.g();
  }

  public void onResume()
  {
    super.onResume();
    this.b.b(false);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.activity.BaseGameActivity
 * JD-Core Version:    0.6.2
 */