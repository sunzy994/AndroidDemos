package cmcm.com.myapplication;

import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class aad
{
  View a;
  TextView b;
  TextView c;
  TextView d;
  ImageView e;
  public TextView f;
  public LinearLayout g;

  public void a()
  {
    if (this.g != null)
    {
      int i = this.g.getChildCount() - 1;
      if (i > 0)
        this.g.removeViews(1, i);
    }
  }

  void a(View paramView, OnClickListener paramOnClickListener)
  {
    this.a = paramView;
    this.c = ((TextView) asr.a(paramView, 2131755381));
    this.d = ((TextView) asr.a(paramView, 2131755047));
    this.b = ((TextView) asr.a(paramView, 2131755050));
    this.e = ((ImageView) asr.a(paramView, 2131755380));
    this.f = ((TextView) asr.a(paramView, 2131755383));
    this.g = ((LinearLayout) asr.a(paramView, 2131755382));
    if (this.f != null)
    {
      this.f.setOnClickListener(paramOnClickListener);
      this.f.setTextColor(Color.parseColor("#ff737373"));
      this.f.setTextSize(1, 15.0F);
    }
    paramView.setTag(this);
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     aad
 * JD-Core Version:    0.6.2
 */