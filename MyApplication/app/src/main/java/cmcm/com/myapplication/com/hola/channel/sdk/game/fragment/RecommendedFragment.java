package cmcm.com.myapplication.com.hola.channel.sdk.game.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.hola.channel.sdk.game.widget.AdView;
import com.hola.channel.sdk.game.widget.OnlineLoadingView;
import qr;
import qx;
import rs;
import te;
import tf;

public class RecommendedFragment extends BaseGameFragment
  implements rs
{
  private static final String c = "GameSDK." + RecommendedFragment.class.getSimpleName();
  private int d;
  private ScrollView e;
  private OnlineLoadingView f;
  private FrameLayout g;
  private FrameLayout h;
  private FrameLayout i;
  private FrameLayout j;
  private Fragment k;
  private Fragment s;
  private Fragment t;
  private Fragment u;

  public static RecommendedFragment a()
  {
    return new RecommendedFragment();
  }

  public void a(Fragment paramFragment)
  {
    if ((paramFragment instanceof RecentGamesFragment))
    {
      if (this.g.getVisibility() != 0)
        this.g.setVisibility(0);
      this.d |= 1;
    }
    while (true)
    {
      if (this.d != 0)
        this.f.f();
      return;
      if ((paramFragment instanceof HotGamesFragment))
      {
        if (this.h.getVisibility() != 0)
          this.h.setVisibility(0);
        this.d |= 2;
      }
      else if ((paramFragment instanceof NewGamesFragment))
      {
        if (this.i.getVisibility() != 0)
          this.i.setVisibility(0);
        this.d |= 4;
      }
      else if ((paramFragment instanceof SubjectsFragment))
      {
        if (this.j.getVisibility() != 0)
          this.j.setVisibility(0);
        this.d |= 8;
      }
    }
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    this.e = ((ScrollView)paramView);
    this.f = ((OnlineLoadingView)qx.a(paramView, 16908292));
    this.f.setActionVisibility(4);
    this.g = ((FrameLayout)qx.a(paramView, te.hg_recommended_recents_container));
    this.h = ((FrameLayout)qx.a(paramView, te.hg_recommended_hot_container));
    this.i = ((FrameLayout)qx.a(paramView, te.hg_recommended_new_container));
    this.j = ((FrameLayout)qx.a(paramView, te.hg_recommended_subjects_container));
    this.r = ((FrameLayout)qx.a(paramView, te.hg_recommended_ad_container));
    if (qr.c(getActivity()))
      this.f.a(8000L);
    while (true)
    {
      if ((this.p > 0) && (this.o) && (this.q != null))
      {
        if (this.q.getParent() != null)
          ((ViewGroup)this.q.getParent()).removeView(this.q);
        this.r.addView(this.q);
      }
      this.k = new HotGamesFragment();
      this.s = new RecentGamesFragment();
      this.t = new NewGamesFragment();
      this.u = new SubjectsFragment();
      getFragmentManager().beginTransaction().add(te.hg_recommended_hot_container, this.k).add(te.hg_recommended_recents_container, this.s).add(te.hg_recommended_new_container, this.t).add(te.hg_recommended_subjects_container, this.u).commitAllowingStateLoss();
      return;
      this.f.b();
    }
  }

  protected void a(boolean paramBoolean)
  {
    if (this.n)
    {
      if (this.q == null)
      {
        this.q = ((AdView)qx.a(getActivity(), tf.hola_game_list_item_ad, this.r, false));
        this.p = this.q.getAdHeight();
      }
      if (paramBoolean)
      {
        if (this.q.getParent() != null)
          ((ViewGroup)this.q.getParent()).removeView(this.q);
        this.r.addView(this.q);
        if (!this.o)
        {
          this.q.a(this.m);
          this.q.a();
          this.o = true;
        }
      }
    }
  }

  protected int b()
  {
    return tf.hola_game_fragment_recommended;
  }

  protected boolean l()
  {
    return true;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    if (!getActivity().isFinishing())
    {
      getFragmentManager().beginTransaction().remove(this.k).remove(this.s).remove(this.t).remove(this.u).commitAllowingStateLoss();
      this.s = null;
      this.u = null;
      this.t = null;
      this.k = null;
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.sdk.game.fragment.RecommendedFragment
 * JD-Core Version:    0.6.2
 */