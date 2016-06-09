package cmcm.com.myapplication.com.hola.channel.pub;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import com.hola.channel.sdk.game.activity.BaseGameActivity;
import com.hola.channel.sdk.game.widget.OnlineLoadingView;
import com.hola.channel.sdk.game.widget.TabLayout;
import java.lang.ref.WeakReference;
import pf;
import px;
import qf;
import qr;
import qu;
import qx;
import rf;
import rn;
import rs;
import sr;
import su;
import sx;
import tb;
import tc;
import te;
import tf;

public class GamesActivity extends BaseGameActivity
  implements rs, sr
{
  private static final String c = "GameSDK." + GamesActivity.class.getSimpleName();
  public OnlineLoadingView a;
  public WeakReference<rs> b;
  private int d;
  private ViewPager e;
  private TabLayout f;
  private boolean g;
  private SparseArray<px> h = new SparseArray(4);

  protected int a()
  {
    return tf.hola_game_activity_games;
  }

  public px a(int paramInt)
  {
    return (px)this.h.get(paramInt);
  }

  public void a(int paramInt, px parampx)
  {
    this.h.put(paramInt, parampx);
  }

  public void a(Fragment paramFragment)
  {
    if (this.b != null)
    {
      rs localrs = (sr)this.b.get();
      if (localrs != null)
        localrs.a(paramFragment);
    }
  }

  public void b()
  {
    this.e.setAdapter(new pf(this));
    this.a.a();
  }

  public void onClick(View paramView)
  {
    paramView.getId();
    super.onClick(paramView);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!qu.a())
      return;
    this.a = ((OnlineLoadingView)qx.a(this, 16908292));
    paramBundle = getResources();
    this.a.a(paramBundle.getDimension(tc.hola_game_button_round_rect_radius), paramBundle.getColor(tb.hola_game_solid_button_background_color_normal), paramBundle.getColor(tb.hola_game_solid_button_background_color_pressed));
    this.a.setActionClickListener(this);
    this.e = ((ViewPager)qx.a(this, te.hg_view_pager));
    this.e.setAdapter(new pf(this));
    this.e.setOffscreenPageLimit(2);
    this.f = ((TabLayout)qx.a(this, te.hg_tab_layout));
    this.f.setupWithViewPager(this.e);
    this.f.setOnTabSelectedListener(new sx(this.e)
    {
      public void a(su paramAnonymoussu)
      {
        super.a(paramAnonymoussu);
        qf.a(GamesActivity.this, "GC0", String.valueOf(paramAnonymoussu.c()));
      }
    });
    paramBundle = getIntent();
    this.g = paramBundle.getBooleanExtra("hola_games_extra.SHORTCUT_LAUNCH", false);
    if (this.g);
    for (int i = 0; ; i = paramBundle.getIntExtra("hola_games_extra.ENTRY_INDEX", 1))
    {
      qf.a(this, "GC3", String.valueOf(i));
      if ((rf.a) || (!qr.c(this)))
        break;
      new rf(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
    }
  }

  protected void onDestroy()
  {
    super.onDestroy();
    final rn localrn = rn.a(this);
    localrn.b(new Runnable()
    {
      public void run()
      {
        localrn.a(new Runnable()
        {
          public void run()
          {
            GamesActivity.2.this.a.g();
          }
        });
      }
    });
    int j = this.h.size();
    int i = 0;
    while (true)
    {
      if (i < j);
      try
      {
        ((px)this.h.valueAt(i)).e();
        label51: i += 1;
        continue;
        this.h.clear();
        return;
      }
      catch (Throwable localThrowable)
      {
        break label51;
      }
    }
  }

  protected void onStart()
  {
    super.onStart();
    this.d = 5;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     com.hola.channel.pub.GamesActivity
 * JD-Core Version:    0.6.2
 */