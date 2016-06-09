package cmcm.com.myapplication;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.lazyswipe.ui.BaseFragment;
import com.lazyswipe.widget.FragmentTabIndicator;
import com.lazyswipe.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public abstract class aoq extends aph
  implements awg
{
  private static final String m = "Swipe." + aoq.class.getSimpleName();
  protected ViewPager i;
  public FragmentTabIndicator j;
  protected aos k;
  public Toolbar l;
  private Handler n = new Handler();

  public boolean a(awp paramawp)
  {
    return false;
  }

  public abstract List<aor<BaseFragment>> g();

  public void h()
  {
    this.l = ((Toolbar)b(2131755045));
    this.l.setCallback(this);
    this.l.setTitle(k());
    this.l.setIcon(atw.a(this, 2130837512));
    asr.a(this.l, 2131755063).setBackgroundResource(2130837745);
  }

  public void i()
  {
    setContentView(m());
    this.j = ((FragmentTabIndicator)findViewById(2131755057));
    this.i = ((ViewPager)findViewById(2131755061));
    this.j.a(getResources().getColor(2131689551), getResources().getColor(2131689552));
    this.k = new aos(this, this, f(), g());
    int i2 = this.k.getCount();
    ArrayList localArrayList = new ArrayList(i2);
    int i1 = 0;
    while (i1 < i2)
    {
      localArrayList.add(this.k.getPageTitle(i1));
      i1 += 1;
    }
    this.j.a(new avi()
    {
      public void a(int paramAnonymousInt)
      {
        aoq.this.i.setCurrentItem(paramAnonymousInt);
      }
    }
    , localArrayList);
    this.i.setAdapter(this.k);
    this.i.setOnPageChangeListener(this.k);
  }

  public int j()
  {
    return 0;
  }

  protected CharSequence k()
  {
    return getTitle();
  }

  protected void l()
  {
    if (this.i != null)
      this.i.post(new Runnable()
      {
        public void run()
        {
          aoq.this.i.setCurrentItem(aoq.this.j(), false);
        }
      });
  }

  protected int m()
  {
    return 2130968584;
  }

  public void onActionClick(View paramView)
  {
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i();
    l();
    h();
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.k != null)
      this.k.a();
  }

  protected void onResume()
  {
    super.onResume();
    this.n.post(new Runnable()
    {
      public void run()
      {
        if (aoq.this.i != null)
          aoq.this.i.post(new Runnable()
          {
            public void run()
            {
              aoq.this.k.e(aoq.this.i.getCurrentItem());
            }
          });
      }
    });
  }

  public void onTitleClick(View paramView)
  {
    onBackPressed();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aoq
 * JD-Core Version:    0.6.2
 */