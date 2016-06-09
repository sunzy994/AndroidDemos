package cmcm.com.myapplication.com.lazyswipe.ui.chooser;

import android.content.Intent;
import android.os.Bundle;
import aph;
import app;
import apr;
import com.lazyswipe.SwipeApplication;
import com.lazyswipe.ui.TutorialService;

public class MultiChooserActivity extends aph
  implements apr
{
  protected app i;
  protected boolean j;

  public static Intent c(boolean paramBoolean)
  {
    Intent localIntent = new Intent(SwipeApplication.c(), MultiChooserActivity.class);
    localIntent.putExtra("EXTRA_CHOOSE_APP", paramBoolean);
    return localIntent;
  }

  public void b(boolean paramBoolean)
  {
    if (this.j)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra.result_chosen_count", this.i.getChosenCount());
      setResult(-1, localIntent);
      if (this.i.getOkAction() != null)
        TutorialService.b(this, -1);
    }
    while (true)
    {
      finish();
      return;
      setResult(-1);
    }
  }

  protected int g()
  {
    return app.c(this.j);
  }

  public void h()
  {
    if (this.j)
    {
      setResult(0);
      finish();
      if (this.i.getCancelAction() != null)
        TutorialService.b(this, 0);
      return;
    }
    setResult(0);
    finish();
  }

  public void i()
  {
    finish();
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.j = getIntent().getBooleanExtra("EXTRA_CHOOSE_APP", true);
    setContentView(g());
    this.i = ((app)b(2131755053));
    this.i.setMultiChooserCallBack(this);
    this.i.setIntent(getIntent());
    this.i.a();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.i.b();
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.i.setIntent(paramIntent);
  }

  protected void onPause()
  {
    super.onPause();
    this.i.i();
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    this.i.f();
  }

  protected void onResume()
  {
    super.onResume();
    this.i.h();
  }

  protected void onStart()
  {
    super.onStart();
    this.i.g();
  }

  protected void onStop()
  {
    super.onStop();
    this.i.j();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.chooser.MultiChooserActivity
 * JD-Core Version:    0.6.2
 */