package cmcm.com.myapplication.com.lazyswipe.ui;

import android.app.Fragment;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import aou;
import aow;
import asr;
import atw;
import com.lazyswipe.widget.Toolbar;

public class ToucherPositionSettingActivity extends aow
{
  private Bitmap k;
  private ToucherPositionSettingFragment l;

  protected void a(Fragment paramFragment)
  {
    super.a(paramFragment);
    if ((paramFragment instanceof ToucherPositionSettingFragment))
    {
      this.l = ((ToucherPositionSettingFragment)paramFragment);
      this.i.setTitle(i());
      this.i.setIcon(this.k);
      this.i.setTitleColor(getResources().getColor(2131689569));
      int i = aou.b();
      this.i.setBackgroundColor(i);
      asr.a(this.i, 2131755063).setBackgroundResource(2130837745);
    }
  }

  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.l != null)
      this.l.l();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.k = atw.a(this, 2130837512);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.ToucherPositionSettingActivity
 * JD-Core Version:    0.6.2
 */