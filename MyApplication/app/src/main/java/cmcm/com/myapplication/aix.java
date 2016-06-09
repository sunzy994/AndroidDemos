package cmcm.com.myapplication;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.lazyswipe.features.theme.preview.BaseThemeDetailFragment;
import com.lazyswipe.ui.DialogActivity;
import com.lazyswipe.ui.FragmentContainer;

public abstract class aix<T extends ahv, S extends BaseThemeDetailFragment<T>> extends FragmentContainer
  implements OnClickListener
{
  private Bitmap i;
  private T k;
  private S l;
  private Bitmap m;

  private void i()
  {
    vv.a().a("HolaTheme点击");
    if (asq.c(this, "com.hola.launcher"))
    {
      asq.d(this, new Intent("com.hola.launcher.component.themes.action_store").putExtra("ROUTE", 1));
      return;
    }
    if (!atw.b(this.m))
      this.m = agi.d(this);
    if (atw.b(this.m))
    {
      DialogActivity.a(this, this.m);
      return;
    }
    asq.g(this, "com.hola.launcher&referrer=aq_tranid%3d0RWlnwbEN226OotMDF7l8IWSeoPaxvAeL%26pid%3dha_lazy_int%26c%3dlazyswipe_gp_theme");
  }

  protected void a(Fragment paramFragment)
  {
    super.a(paramFragment);
    if (!(paramFragment instanceof BaseThemeDetailFragment))
      return;
    this.l = ((BaseThemeDetailFragment)paramFragment);
    this.l.a(this.k);
    ((TextView)b(2131755050)).setText(this.k.K());
    ((ImageView)b(2131755064)).setImageBitmap(this.i);
    int j = this.k.i();
    b(2131755062).setBackgroundColor(j);
    b(2131755063).setOnClickListener(this);
    paramFragment = b(2131755065);
    if ((this.k.g()) && (agi.c(this)))
    {
      paramFragment.setVisibility(0);
      paramFragment.setOnClickListener(this);
      return;
    }
    paramFragment.setVisibility(8);
    paramFragment.setOnClickListener(null);
  }

  protected int g()
  {
    return 2130968585;
  }

  public abstract T h();

  public void onBackPressed()
  {
    super.onBackPressed();
    if (isFinishing());
    do
    {
      return;
      a(k());
    }
    while (this.l == null);
    this.l.l();
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131755064:
    default:
      return;
    case 2131755063:
      onBackPressed();
      return;
    case 2131755065:
    }
    i();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.i = atw.a(this, 2130837512);
    this.k = h();
    if (this.k == null)
      finish();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    atw.a(this.i);
    atw.a(this.m);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aix
 * JD-Core Version:    0.6.2
 */