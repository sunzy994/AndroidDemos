package cmcm.com.myapplication;

import android.view.View;
import com.lazyswipe.widget.OnlineLoadingView;

public abstract class aox extends apb
{
  protected OnlineLoadingView aa;
  private boolean ab;

  public void L()
  {
    if (!this.ab)
    {
      this.ab = true;
      Q();
    }
    if ((this.aa != null) && (this.aa.c()) && (arl.i(d())))
      Q();
  }

  public void M()
  {
  }

  protected void P()
  {
    this.aa.b();
  }

  protected abstract void Q();

  protected void a(View paramView)
  {
    super.a(paramView);
    this.aa = ((OnlineLoadingView)a(paramView, 2131755504));
    this.aa.a();
    this.aa.setButtonClickListener(new avv()
    {
      public void a()
      {
        aox.this.Q();
      }
    });
  }

  public void o()
  {
    super.o();
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aox
 * JD-Core Version:    0.6.2
 */