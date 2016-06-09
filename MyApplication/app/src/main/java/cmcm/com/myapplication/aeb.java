package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import com.lazyswipe.features.leap.card.CardFlow;

public class aeb extends adp
  implements OnClickListener
{
  private View h;

  public aeb(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(-2236963);
    int i = paramContext.getResources().getDimensionPixelOffset(2131296372);
    int j = paramContext.getResources().getDimensionPixelOffset(2131296371);
    this.h = LayoutInflater.from(paramContext).inflate(2130968598, null);
    addView(this.h, new FrameLayout.LayoutParams(i, j));
    this.h.setVisibility(8);
    this.h.setOnClickListener(this);
  }

  public void a(Object paramObject)
  {
    super.a(paramObject);
    this.h.setVisibility(0);
  }

  public void b()
  {
  }

  public adt getCardHolder()
  {
    return new aec(this);
  }

  public void onClick(View paramView)
  {
    if (this.d != null)
    {
      this.h.setVisibility(8);
      this.d.c();
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aeb
 * JD-Core Version:    0.6.2
 */