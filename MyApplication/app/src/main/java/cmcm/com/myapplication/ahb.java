package cmcm.com.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

class ahb
{
  private final View b;
  private final View c;
  private final View d;
  private final ImageView e;
  private final ImageView f;
  private final TextView g;

  public ahb(aha paramaha, View paramView)
  {
    this.b = paramView;
    this.c = paramView.findViewById(2131755469);
    this.d = paramView.findViewById(2131755470);
    this.e = ((ImageView)paramView.findViewById(2131755064));
    this.f = ((ImageView)paramView.findViewById(2131755471));
    this.g = ((TextView)paramView.findViewById(2131755248));
  }

  public void a(ahk paramahk)
  {
    if (paramahk.f)
    {
      this.e.setImageResource(2130837781);
      this.f.setImageResource(2130837783);
    }
    while (true)
    {
      this.d.setTag(paramahk);
      this.d.setOnClickListener(this.a);
      this.g.setText(paramahk.d());
      this.b.setTag(paramahk);
      this.b.setOnClickListener(this.a);
      return;
      this.e.setImageResource(2130837785);
      this.f.setImageResource(2130837784);
    }
  }
}

/* Location:           classes-dex2jar.jar
 * Qualified Name:     ahb
 * JD-Core Version:    0.6.2
 */