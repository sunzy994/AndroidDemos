package cmcm.com.myapplication.com.lazyswipe.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import aou;
import asr;
import atw;
import awg;
import awp;
import com.lazyswipe.widget.Toolbar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public abstract class BasePreferenceLikeFragment extends Fragment
  implements OnClickListener, awg
{
  protected Toolbar a;
  protected TextView b;
  protected SimpleDateFormat c;

  public abstract int a();

  public final <T extends View> T a(View paramView, int paramInt)
  {
    return asr.a(paramView, paramInt);
  }

  public void a(View paramView)
  {
  }

  public boolean a(awp paramawp)
  {
    return false;
  }

  protected void b()
  {
    this.a.setCallback(this);
    d();
    this.a.setTitle(e());
    this.a.setMenu(f());
    this.a.setButtonBackground(2130837745);
    this.a.setTitleColor(-1);
  }

  public void b(View paramView)
  {
  }

  protected boolean c()
  {
    return true;
  }

  protected void d()
  {
    this.a.setIcon(atw.a(getActivity(), 2130837512));
  }

  protected CharSequence e()
  {
    return getActivity().getTitle();
  }

  protected int f()
  {
    return 0;
  }

  public void onActionClick(View paramView)
  {
    b(paramView);
  }

  public void onClick(View paramView)
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

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramViewGroup == null)
      return null;
    paramLayoutInflater = paramLayoutInflater.inflate(a(), paramViewGroup, false);
    this.a = ((Toolbar)a(paramLayoutInflater, 2131755045));
    if (c())
      b();
    while (true)
    {
      this.c = new SimpleDateFormat("HH:mm", Locale.US);
      this.b = ((TextView)a(paramLayoutInflater, 2131755047));
      this.b.setText(this.c.format(new Date()));
      a(paramLayoutInflater);
      paramLayoutInflater.setBackgroundDrawable(aou.a());
      return paramLayoutInflater;
      this.a.setVisibility(8);
      this.a = null;
    }
  }

  public void onResume()
  {
    super.onResume();
    if (this.b != null)
      this.b.setText(this.c.format(new Date()));
  }

  public void onStop()
  {
    super.onStop();
    this.a.b();
  }

  public void onTitleClick(View paramView)
  {
    onClick(paramView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.lazyswipe.ui.BasePreferenceLikeFragment
 * JD-Core Version:    0.6.2
 */