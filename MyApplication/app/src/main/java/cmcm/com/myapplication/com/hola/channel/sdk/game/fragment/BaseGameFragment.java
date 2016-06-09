package cmcm.com.myapplication.com.hola.channel.sdk.game.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.hola.channel.pub.GamesActivity;
import com.hola.channel.sdk.game.activity.BaseGameActivity;
import com.hola.channel.sdk.game.app.BaseFragment;
import com.hola.channel.sdk.game.widget.AdView;
import com.hola.channel.sdk.game.widget.OnlineLoadingView;
import pu;
import pv;
import px;
import qu;
import qx;

public abstract class BaseGameFragment extends BaseFragment
  implements pv
{
  private static final String c = "GameSDK." + BaseGameFragment.class.getSimpleName();
  protected OnlineLoadingView l;
  protected px m;
  protected boolean n;
  protected boolean o;
  protected int p;
  protected AdView q;
  protected FrameLayout r;

  private void d()
  {
    if ((qu.a(getActivity())) && (this.m == null))
    {
      this.m = new px(getActivity());
      this.m.a(this);
      this.m.a();
    }
  }

  public void a(Bundle paramBundle, int paramInt)
  {
    super.a(paramBundle, paramInt);
    if (paramBundle != null)
    {
      this.n = paramBundle.getBoolean("isAdLoaded", this.n);
      this.o = paramBundle.getBoolean("isAdBound", this.o);
      this.p = paramBundle.getInt("adHeight", 0);
    }
  }

  public void a(View paramView)
  {
    super.a(paramView);
    this.l = ((OnlineLoadingView)qx.a(paramView, 16908292));
  }

  public void a(pu parampu)
  {
  }

  public void a(px parampx)
  {
    if (this.m == parampx)
    {
      if (!this.n)
      {
        this.n = true;
        this.o = false;
      }
      ((GamesActivity)getActivity()).a(hashCode(), parampx);
      if ((this.q != null) && (this.q.getVisibility() != 0))
        this.q.setVisibility(0);
    }
  }

  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }

  public void b(px parampx)
  {
  }

  public void c(px parampx)
  {
    this.n = false;
    this.o = false;
    this.m.e();
    this.m = null;
    ((GamesActivity)getActivity()).a(hashCode(), null);
    this.q.a(new Runnable()
    {
      public void run()
      {
        BaseGameFragment.this.m();
      }
    });
  }

  protected boolean l()
  {
    return false;
  }

  protected void m()
  {
    this.q = null;
    this.r.removeAllViews();
    d();
  }

  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (!BaseGameActivity.class.isInstance(getActivity()))
      throw new RuntimeException("This fragment must be attached to GamesActivity!");
    if (l())
    {
      paramBundle = ((GamesActivity)getActivity()).a(hashCode());
      if (paramBundle != null)
      {
        this.m = paramBundle;
        a(paramBundle);
      }
    }
    else
    {
      return;
    }
    d();
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("isAdLoaded", this.n);
    paramBundle.putBoolean("isAdBound", this.o);
    paramBundle.putInt("adHeight", this.p);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.fragment.BaseGameFragment
 * JD-Core Version:    0.6.2
 */