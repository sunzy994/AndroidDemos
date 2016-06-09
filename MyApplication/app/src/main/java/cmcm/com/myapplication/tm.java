package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class tm extends tk
{
  private long o;
  private int p;
  private int q;

  public tm(Context paramContext)
  {
    super(paramContext);
  }

  public tm(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }

  protected tj d()
  {
    return new tl(this.a, this.n);
  }

  protected View e()
  {
    if (this.o > 0L)
      ((tl)this.b).c = this.o;
    View localView = this.c.inflate(tu.hola_custom_dialog_progress, null, false);
    Object localObject = (TextView)localView.findViewById(ts.msg);
    ((TextView)localObject).setTextColor(this.i);
    ((TextView)localObject).setText(this.g);
    this.g = null;
    localObject = (ProgressBar)localView.findViewById(ts.progress);
    tn localtn = new tn(this.a, this.q, this.p);
    ((ProgressBar)localObject).setProgressDrawable(localtn);
    ((ProgressBar)localObject).setIndeterminateDrawable(localtn);
    a(localView);
    return super.e();
  }

  public tm j(int paramInt)
  {
    return k(this.a.getResources().getColor(paramInt));
  }

  public tm k(int paramInt)
  {
    this.p = paramInt;
    return this;
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     tm
 * JD-Core Version:    0.6.2
 */