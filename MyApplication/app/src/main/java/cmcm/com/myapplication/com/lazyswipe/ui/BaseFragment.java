package cmcm.com.myapplication.com.lazyswipe.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import asr;
import atw;
import awg;
import awp;
import com.lazyswipe.widget.Toolbar;

public abstract class BaseFragment extends Fragment
  implements OnClickListener, awg
{
  private static final String a = "Swipe." + BaseFragment.class.getSimpleName();
  protected Toolbar b;
  protected int c;
  protected boolean d;
  public View e;

  public abstract int a();

  public final <T extends View> T a(View paramView, int paramInt)
  {
    return asr.a(paramView, paramInt);
  }

  protected void a(Bundle paramBundle)
  {
    if (paramBundle != null)
      this.c = paramBundle.getInt("layoutResId");
  }

  public void a(View paramView)
  {
  }

  public boolean a(awp paramawp)
  {
    return false;
  }

  public void b(View paramView)
  {
  }

  public boolean c()
  {
    return true;
  }

  protected void g()
  {
    this.b.setCallback(this);
    h();
    this.b.setTitle(i());
    this.b.setMenu(j());
  }

  protected void h()
  {
    this.b.setIcon(atw.a(getActivity(), 2130837513));
  }

  protected CharSequence i()
  {
    return getActivity().getTitle();
  }

  protected int j()
  {
    return 0;
  }

  protected View k()
  {
    return null;
  }

  public boolean l()
  {
    return false;
  }

  public void onActionClick(View paramView)
  {
    b(paramView);
  }

  public final void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      b(paramView);
      return;
    case 2131755063:
    case 2131755064:
    }
    getActivity().finish();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.d = true;
      a(paramBundle);
      return;
    }
    this.d = false;
    a(getArguments());
  }

  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramViewGroup == null)
      return null;
    if (getActivity().isFinishing())
      return null;
    if (this.c <= 0)
      this.c = a();
    if (this.c > 0)
    {
      paramLayoutInflater = paramLayoutInflater.inflate(this.c, paramViewGroup, false);
      this.b = ((Toolbar)a(paramLayoutInflater, 2131755045));
      if (this.b != null)
      {
        if (!c())
          break label103;
        g();
      }
    }
    while (true)
    {
      a(paramLayoutInflater);
      this.e = paramLayoutInflater;
      return paramLayoutInflater;
      paramLayoutInflater = k();
      break;
      label103: this.b.setVisibility(8);
      this.b = null;
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("layoutResId", this.c);
  }

  public void onTitleClick(View paramView)
  {
    onClick(paramView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.BaseFragment
 * JD-Core Version:    0.6.2
 */