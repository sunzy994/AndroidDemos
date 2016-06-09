package cmcm.com.myapplication.com.lazyswipe.ui;

import add;
import afx;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import awp;

public class SettingsFragment extends BaseSettingsFragment
{
  public boolean a(awp paramawp)
  {
    if (2131755575 == paramawp.a())
    {
      startActivity(new Intent(getActivity(), afx.class));
      return true;
    }
    return super.a(paramawp);
  }

  protected void b()
  {
    super.b();
  }

  public void onActionClick(View paramView)
  {
    startActivity(new Intent(getActivity(), afx.class));
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    add.a(getActivity());
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.SettingsFragment
 * JD-Core Version:    0.6.2
 */