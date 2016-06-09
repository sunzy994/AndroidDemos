package cmcm.com.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import com.lazyswipe.ui.FragmentContainer;
import com.lazyswipe.widget.Toolbar;

@SuppressLint({"Registered"})
public class aow extends FragmentContainer
  implements awg
{
  private static final String k = "Swipe." + aow.class.getSimpleName();
  public Toolbar i;

  public boolean a(awp paramawp)
  {
    return false;
  }

  protected int g()
  {
    return 2130968577;
  }

  protected void h()
  {
    this.i = ((Toolbar)b(2131755045));
    this.i.setCallback(this);
    this.i.setTitle(i());
    this.i.setIcon(atw.a(this, 2130837512));
  }

  public CharSequence i()
  {
    return getTitle();
  }

  protected boolean j()
  {
    return true;
  }

  public void onActionClick(View paramView)
  {
  }

  public void onBackPressed()
  {
    super.onBackPressed();
    if (isFinishing())
      return;
    a(k());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (j())
      h();
  }

  public void onTitleClick(View paramView)
  {
    onBackPressed();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aow
 * JD-Core Version:    0.6.2
 */