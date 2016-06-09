package cmcm.com.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.lazyswipe.widget.Toolbar;

public abstract class apb extends k
  implements OnClickListener, apg, awg
{
  protected final String ae = "Swipe." + getClass().getSimpleName();
  protected Toolbar af;
  protected int ag;
  protected boolean ah;

  protected abstract int J();

  protected boolean K()
  {
    return true;
  }

  protected void U()
  {
    this.af.setCallback(this);
    V();
    this.af.setTitle(W());
    this.af.setMenu(X());
  }

  protected void V()
  {
    this.af.setIcon(atw.a(d(), 2130837513));
  }

  protected CharSequence W()
  {
    return d().getTitle();
  }

  protected int X()
  {
    return 0;
  }

  protected View Y()
  {
    return null;
  }

  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (paramViewGroup == null)
      return null;
    if (d().isFinishing())
      return null;
    if (this.ag <= 0)
      this.ag = J();
    if (this.ag > 0)
    {
      paramLayoutInflater = paramLayoutInflater.inflate(this.ag, paramViewGroup, false);
      this.af = ((Toolbar)a(paramLayoutInflater, 2131755045));
      if (this.af != null)
      {
        if (!K())
          break label98;
        U();
      }
    }
    while (true)
    {
      a(paramLayoutInflater);
      return paramLayoutInflater;
      paramLayoutInflater = Y();
      break;
      label98: this.af.setVisibility(8);
      this.af = null;
    }
  }

  public final <T extends View> T a(View paramView, int paramInt)
  {
    return asr.a(paramView, paramInt);
  }

  protected void a(View paramView)
  {
  }

  public boolean a(awp paramawp)
  {
    return false;
  }

  protected void b(View paramView)
  {
  }

  public void c(Bundle paramBundle)
  {
    super.c(paramBundle);
    if (paramBundle != null)
    {
      this.ah = true;
      j(paramBundle);
      return;
    }
    this.ah = false;
    j(b());
  }

  public void f(Bundle paramBundle)
  {
    super.f(paramBundle);
    paramBundle.putInt("layoutResId", this.ag);
  }

  protected void j(Bundle paramBundle)
  {
    if (paramBundle != null)
      this.ag = paramBundle.getInt("layoutResId");
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
    d().finish();
  }

  public void onTitleClick(View paramView)
  {
    onClick(paramView);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     apb
 * JD-Core Version:    0.6.2
 */