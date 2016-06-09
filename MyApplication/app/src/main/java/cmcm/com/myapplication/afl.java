package cmcm.com.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.lazyswipe.features.weather.bean.City;

public class afl
{
  final TextView a;
  final TextView b;
  final TextView c;
  public City d;
  private boolean e;

  public afl(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131755190));
    this.b = ((TextView)paramView.findViewById(2131755192));
    this.c = ((TextView)paramView.findViewById(2131755191));
  }

  public void a()
  {
    this.e = true;
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.d = null;
    Drawable localDrawable = this.a.getContext().getResources().getDrawable(2130837563);
    localDrawable.setColorFilter(-13355980, PorterDuff.Mode.SRC_IN);
    this.a.setCompoundDrawablesWithIntrinsicBounds(localDrawable, null, null, null);
    this.a.setCompoundDrawablePadding(asq.a(3.0F));
    this.a.setText(2131230810);
  }

  public void a(City paramCity, boolean paramBoolean)
  {
    this.e = false;
    this.d = paramCity;
    this.a.setCompoundDrawablePadding(0);
    this.a.setCompoundDrawables(null, null, null, null);
    if (paramBoolean)
    {
      this.a.setVisibility(0);
      this.b.setVisibility(8);
      this.c.setVisibility(8);
      if (!TextUtils.isEmpty(paramCity.a))
        this.a.setText(paramCity.a);
      while (true)
      {
        this.c.setText(null);
        return;
        this.a.setText(paramCity.a());
      }
    }
    this.a.setVisibility(0);
    this.b.setVisibility(0);
    this.c.setVisibility(0);
    this.a.setText(paramCity.a());
    this.b.setText(paramCity.c());
    this.c.setText("-");
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     afl
 * JD-Core Version:    0.6.2
 */